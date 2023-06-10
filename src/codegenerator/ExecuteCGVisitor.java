package codegenerator;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Expression;
import ast.expressions.FuncInvocation;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void>{

    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;
    private CodeGenerator codeGenerator;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        // writer
        this.codeGenerator = codeGenerator;
        // initialize visitors
        valueCGVisitor = new ValueCGVisitor(codeGenerator);
        addressCGVisitor = new AddressCGVisitor(codeGenerator);
        // set visitors references
        valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
        addressCGVisitor.setValueCGVisitor(valueCGVisitor);
    }

    /*
        execute[[Program: program -> definition*]]() =
        for (Definition definition : definition*) --> 1st the variable definitions
            if (definition instanceof VARDEF)
                execute[[definition]]()
        <call main>
        <halt>
        for (Definition definition: definition*) --> 2nd the function definitions
            if (definition instanceof FUNDEF)
                execute[[definition]]()
         */
    @Override
    public Void visit(Program program, Object param) {
        for (Definition definition : program.getBody()){
            if (definition instanceof VarDefinition)
                definition.accept(this, param);
        }
        codeGenerator.comment("' Invocation to the main function\n");
        codeGenerator.call("main");
        codeGenerator.halt();
        for (Definition definition : program.getBody()){
            if (definition instanceof FuncDefinition)
                definition.accept(this, param);
        }

        return null;
    }

    /*
        execute[[Input: statement -> expression]]() =
            address[[expression]]()
            <in> expression.type.suffix()
            <store> expression.type.suffix()
     */
    @Override
    public Void visit(Input input, Object param) {
        // write line and statement for each expression in the input statement
        for (Expression expression: input.getExpressionList()) {
            //write line
            codeGenerator.line(input.getLine());
            // write statement
            codeGenerator.comment("\t' * Read\n");
            expression.accept(this.addressCGVisitor, param);
            codeGenerator.in(expression.getType());
            codeGenerator.store(expression.getType());
        }
        return null;
    }

    /*
        execute[[Print: statement -> expression]]() =
            value[[expression]]()
            <out> expression.type.suffix()
     */
    @Override
    public Void visit(Print print, Object param) {
        for (Expression expression: print.getExpressionList()){
            // write line
            codeGenerator.line(print.getLine());
            // write statement
            codeGenerator.comment("\t' * Write\n");
            expression.accept(this.valueCGVisitor, param);
            codeGenerator.out(expression.getType());
        }
        return null;
    }

    /*
        execute[[Assignment: statement -> exp1 exp2]] =
            address[[exp1]]
            value[[exp2]]
            exp2.type.convertTo(exp1.type)
            <store> exp1.type.suffix()
     */
    @Override
    public Void visit(Assignment assignment, Object param) {
        // write line
        codeGenerator.line(assignment.getLine());
        // write statement
        codeGenerator.comment("\t' * Assignment\n");

        assignment.getLeft().accept(this.addressCGVisitor, param);
        assignment.getRight().accept(this.valueCGVisitor, param);
        codeGenerator.convertTo(assignment.getRight().getType(), assignment.getLeft().getType());
        codeGenerator.store(assignment.getLeft().getType());
        return null;
    }

    /*
        execute[[Return: statement -> exp]](bytesReturn, bytesLocals, bytesParams) =
            value[[exp]]
            <ret> bytesReturn <,> bytesLocals <,> bytesParams
     */
    @Override
    public Void visit(Return ret, Object param) {
        codeGenerator.line(ret.getLine());
        codeGenerator.comment("\t' * Return\n");
        // make a cast to get the DTO containing the bytes to return, locals and params
        ret.getRet().accept(valueCGVisitor, param);
        DTOReturn parameter = (DTOReturn) param;
        codeGenerator.ret(parameter.getBytesReturn(), parameter.getBytesLocals(), parameter.getBytesParams());
        return null;
    }

    /*
        execute[[FuncInvocation: statement -> exp1 exp2*]] =
            exp2*.forEach(exp -> value[[exp]])
            <call> exp1.name
            if (!exp1.definition.type.returntype instanceof VoidType)
                <pop> exp1.type.returnType.suffix()
     */
    @Override
    public Void visit(FuncInvocation funcInvocation, Object param) {
        codeGenerator.line(funcInvocation.getLine());

        for (Expression parameter : funcInvocation.getParameters()){
            parameter.accept(valueCGVisitor, param);
        }
        // funcInvocation.getName() returns a variable and the 2nd getName() returns the String
        codeGenerator.call(funcInvocation.getName().getName());
        // as the invocation is a statement, we have to clean the stack with pop and the suffix of the return type
        if (!(((FunctionType)funcInvocation.getFuncDefinition().getType()).getReturnType() instanceof VoidType))
            codeGenerator.pop(((FunctionType)funcInvocation.getFuncDefinition().getType()).getReturnType());

        return null;
    }

    // *********** DEFINITIONS *****************

    /*
        execute[[FuncDefinition: definition -> ID type definition* statement*]] =
            ID <:>
            int bytesLocals = definition*.isEmpty() ? 0 : -definition*.get(definition*.size()-1).offset
            <enter> bytesLocals
            int bytesParams = type.params.mapToInt(def -> def.type.numberOfBytes()).sum()
            int bytesReturn = type.returnType.numberOfBytes()
            statement*.forEach(st -> execute[[st]]);
            <ret> bytesReturn <,> bytesLocals <,> bytesParams
     */
    @Override
    public Void visit(FuncDefinition funcDefinition, Object param) {
        codeGenerator.line(funcDefinition.getLine());
        codeGenerator.comment(funcDefinition.getName() + ":\n");

        FunctionType functionType = ((FunctionType) funcDefinition.getType());

        // if there are not any locals, assign 0, else assign the offset of the last local variable
        int bytesLocals = funcDefinition.getDefinitionList().isEmpty() ? 0 :
                -funcDefinition.getDefinitionList().get(funcDefinition.getDefinitionList().size()-1).getOffset();

        // calculate the bytes of the parameters
        int bytesParams = 0;
        for (VarDefinition parameter : functionType.getArguments()){
            bytesParams += parameter.getType().numberOfBytes();
        }

        // calculate the bytes to return
        int bytesReturn = functionType.getReturnType().numberOfBytes();

        codeGenerator.comment("\t' * Parameters\n");
        for (VarDefinition parameter : functionType.getArguments()){
            parameter.accept(this, param);
        }

        codeGenerator.comment("\t' * Local variables\n");

        for (VarDefinition local : funcDefinition.getDefinitionList()){
            local.accept(this, param); // change param for a DTO
        }

        codeGenerator.comment("\tenter " + bytesLocals + "\n");
        // pass the bytes of locals, return and params just in case there is a return statement in the statements
        for (Statement st : funcDefinition.getStatementList()){
            st.accept(this, new DTOReturn(bytesLocals, bytesParams, bytesReturn));
        }
        // if it is void (nOB to return is 0), then we have to release the stack (there is no return statement in the list)
        if (bytesReturn == 0)
            codeGenerator.ret(bytesReturn, bytesLocals, bytesParams);

        return null;
    }

    /*
        execute[[VarDefinition: definition -> type ID]] =
            <' * > type.toString() ID <(offset > vardefinition.offset <)>
     */
    @Override
    public Void visit(VarDefinition varDefinition, Object param) {
        codeGenerator.comment("\t' * " + varDefinition.getType().toString() + " " + varDefinition.getName() +
                " (offset " + varDefinition.getOffset() + ")\n");
        return null;
    }


    // ************ CONTROL STRUCTURES ***********

    /*
        execute[[WhileStatement: statement -> expression statement*]](bytesReturn, bytesLocals, bytesParams) =
            String condLabel = cg.nextLabel()
            String exitLabel = cg.exitLabel()
            condLabel <:>
            value[[expression]]
            <jz> exitLabel
            statement*.forEach(st -> execute[[st]])
            <jmp> condLabel
            exitLabel <:>
     */
    @Override
    public Void visit(While whileSt, Object param) {
        String condLabel = codeGenerator.nextLabel();
        String exitLabel = codeGenerator.nextLabel();

        codeGenerator.line(whileSt.getLine());
        codeGenerator.comment("\t' * While\n");

        codeGenerator.comment(condLabel + ":\n");
        whileSt.getCondition().accept(valueCGVisitor, param);
        codeGenerator.jz(exitLabel);

        codeGenerator.comment("\t' * While body\n");
        for (Statement statement : whileSt.getBody()){
            statement.accept(this, param);
        }

        codeGenerator.jmp(condLabel);
        codeGenerator.comment(exitLabel + ":\n");

        return null;
    }

    /*
        execute[[IfStatement: statement -> expression statement2* statement3*]] (ret, locals, params) =
            value[[expression]]
            <jz> elseBody
            statement2*.forEach(st -> execute[[st]]
            <jmp> exit
            elseBody <:>
            statement3*.forEach(st -> execute[[st]])
            exit <:>
     */
    @Override
    public Void visit(IfStatement ifStatement, Object param) {
        String elseBody = codeGenerator.nextLabel();
        String exit = codeGenerator.nextLabel();

        codeGenerator.line(ifStatement.getLine());
        codeGenerator.comment("\t' * If\n");

        ifStatement.getExpression().accept(valueCGVisitor, param);
        codeGenerator.jz(elseBody);

        // execute if body
        for (Statement statement : ifStatement.getIfBody()){
            statement.accept(this, param);
        }
        codeGenerator.jmp(exit);
        codeGenerator.comment(elseBody + ":\n");
        for (Statement statement : ifStatement.getElseBody()){
            statement.accept(this, param);
        }
        codeGenerator.comment(exit + ":\n");
        return null;
    }
}
