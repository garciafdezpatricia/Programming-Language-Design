package semantic;

import ast.Program;
import ast.definitions.Definition;
import ast.types.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor to check if nodes are lvalues and type checking (infer the types of expressions and check the operations
 * that are requesting to be performed)
 */
public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    // ***************
    //   EXPRESSIONS
    // ***************

    @Override
    public Void visit(Arithmetic arithmetic, Type param) { //false
        arithmetic.getLeft().accept(this, param);
        arithmetic.getRight().accept(this, param);
        arithmetic.setLValue(false);

        arithmetic.setType(arithmetic.getLeft().getType().arithmetic(
                arithmetic.getRight().getType(), arithmetic));

        return null;
    }

    @Override
    public Void visit(ArithComparison arithComparison, Type param) { //false
        arithComparison.getLeft().accept(this, param);
        arithComparison.getRight().accept(this, param);
        arithComparison.setLValue(false);

        arithComparison.setType(arithComparison.getLeft().getType().arithComparison(
                arithComparison.getRight().getType(), arithComparison));
        return null;
    }

    @Override
    public Void visit(LogComparison logComparison, Type param) { //false
        logComparison.getLeft().accept(this, param);
        logComparison.getRight().accept(this,param);
        logComparison.setLValue(false);

        logComparison.setType(logComparison.getLeft().getType().logicComparison(
                logComparison.getRight().getType(), logComparison));
        return null;
    }

    @Override
    public Void visit(ArrayIndexer arrayIndexer, Type param) { //true
        arrayIndexer.getLeft().accept(this, param);
        arrayIndexer.getRight().accept(this,param);
        arrayIndexer.setLValue(true);

        arrayIndexer.setType(arrayIndexer.getLeft().getType().squareBrackets(
                arrayIndexer.getRight().getType(), arrayIndexer));
        return null;
    }

    @Override
    public Void visit(Cast cast, Type param) { //true
        cast.getExpression().accept(this, param);
        cast.getCastTo().accept(this, param);
        cast.setLValue(false);
        cast.setType(cast.getExpression().getType().canCastTo(cast.getCastTo(), cast));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Type param) {
        charLiteral.setLValue(false);
        charLiteral.setType(Char.getInstance());
        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Type param) {
        doubleLiteral.setLValue(false);
        doubleLiteral.setType(Real.getInstance());
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type param) {
        intLiteral.setLValue(false);
        intLiteral.setType(Int.getInstance());
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Type param) {
        fieldAccess.getExpression().accept(this, param);
        fieldAccess.setLValue(true);

        fieldAccess.setType(fieldAccess.getExpression().getType().fieldAccess(
                fieldAccess.getFieldName(), fieldAccess));
        return null;
    }

    @Override
    public Void visit(FuncInvocation funcInvocation, Type param) {
        funcInvocation.setLValue(false);
        funcInvocation.getFuncDefinition().accept(this, param);

        funcInvocation.getName().accept(this, param);
        for (Expression exp:funcInvocation.getParameters()) {
            exp.accept(this, param);
        }

        List<Type> paramsTypes = new ArrayList<Type>();

        for (Expression expression : funcInvocation.getParameters()){
            paramsTypes.add(expression.getType());
        }
        // if the definition of the function has any error, set the type of the function invocation to that error
        if (funcInvocation.getFuncDefinition().getType() instanceof ErrorType){
            funcInvocation.setType(funcInvocation.getFuncDefinition().getType());
        }
        // if the definition of the function has not any error, set the type to the return type of the function invocation
        else{
            funcInvocation.setType(funcInvocation.getFuncDefinition().getType().
                    parenthesis(paramsTypes, funcInvocation));
        }
        return null;
    }

    @Override
    public Void visit(Minus minus, Type param) {
        minus.getExp().accept(this, param);
        minus.setLValue(false);

        minus.setType(minus.getExp().getType().unaryMinus(minus));
        return null;
    }

    @Override
    public Void visit(Negation negation, Type param) {
        negation.getExp().accept(this, param);
        negation.setLValue(false);

        negation.setType(negation.getExp().getType().unaryNegation(negation));
        return null;
    }

    @Override
    public Void visit(Variable var, Type param){
        var.setLValue(true);
        var.setType(var.getDefinition().getType());
        return null;
    }


    // ***************
    //   DEFINITIONS
    // ***************
    @Override
    public Void visit(FuncDefinition definition, Type param) {
        definition.getType().accept(this, param);
        for (VarDefinition vd: definition.getDefinitionList()){
            vd.accept(this, param);
        }
        for (Statement st: definition.getStatementList()) {
            st.accept(this, definition.getType()); // pass the type of the function as param
        }
        return null;
    }

    /**
     * If the left part of the assignment is not lvalue, raise an error
     * @param assignment
     * @param param
     * @return
     */
    @Override
    public Void visit(Assignment assignment, Type param) {
        assignment.getLeft().accept(this, param);
        assignment.getRight().accept(this, param);
        if (!assignment.getLeft().getLValue()){
            new ErrorType(assignment.getLeft().getLine(), assignment.getLeft().getColumn(),
                    "Error in line: " + assignment.getLeft().getLine() + " column: " + assignment.getLeft().getColumn()
                            +". Invalid expression on left hand side of the assignment: expression must be Lvalue");
        }

        // if right is not of the type of left, error
        assignment.getLeft().setType(assignment.getRight().getType().
                canBeAssignedTo(assignment.getLeft().getType(), assignment));

        return null;
    }

    /**
     * Check the condition of the if statement is boolean
     * @param ifStatement
     * @param param
     * @return
     */
    @Override
    public Void visit(IfStatement ifStatement, Type param) {
        ifStatement.getExpression().accept(this, param);
        for (Statement st: ifStatement.getIfBody()) {
            st.accept(this, param);
        }
        for (Statement st: ifStatement.getElseBody()) {
            st.accept(this, param);
        }

        if (!ifStatement.getExpression().getType().isLogical()){
            new ErrorType(ifStatement.getLine(), ifStatement.getColumn(),
                    "Error in line: " + ifStatement.getExpression().getLine() + " column: "
                            + ifStatement.getExpression().getColumn()
                            +". Condition in IF statement is not boolean");
        }
        return null;
    }

    /**
     * If the expressions in the input are not lvalues or builtin, raise an error (they cannot store the entered value)
     * @param in
     * @param param
     * @return
     */
    @Override
    public Void visit(Input in, Type param) { // the expressions of the input must be lvalue
        for (int i = 0; i < in.getExpressionList().size(); i++) {
            Expression expression = in.getExpressionList().get(i);
            expression.accept(this, param);
            // if the expression already has an error do not overwrite it
            if (!expression.getType().isErrorType()) {
                if (!expression.getLValue()){
                    new ErrorType(expression.getLine(),
                            expression.getColumn(),
                            "Error in line: " + expression.getLine() + " column: " + expression.getColumn()
                                    +". Error in Input statement, expression number " + (i + 1)+ ": expected lvalue");
                }
                if (!expression.getType().isBuiltIn()){
                    new ErrorType(expression.getLine(),
                            expression.getColumn(),
                            "Error in line: " + expression.getLine() + " column: " + expression.getColumn()
                                    +". Error in Input statement, expression number " + (i + 1)+ ": expected builtin type");
                }
            }
        }
        return null;
    }

    /**
     * Check all expressions in the print statement are builtin
     * @param print
     * @param param
     * @return
     */
    @Override
    public Void visit(Print print, Type param) {
        for (int i = 0; i < print.getExpressionList().size(); i++) {
            Expression e = print.getExpressionList().get(i);
            e.accept(this, param);

            if (!e.getType().isErrorType()){
                if (!e.getType().isBuiltIn()){
                    new ErrorType(e.getLine(),e.getColumn(),
                            "Error in line: " + e.getLine() + " column: " + e.getColumn()
                                    +"Error print statement, expression number " + (i +1) + ": expected builtin value");
                }
            }
        }
        return null;
    }

    /**
     * Check the type of the expression to return is the same as the function return type
     * @param ret
     * @param param
     * @return
     */
    @Override
    public Void visit(Return ret, Type param) {
        FunctionType functionType = (FunctionType) param; // the param is function type bc we passed it in funcDefinition
        ret.getRet().accept(this, functionType.getReturnType());
        // if the expression is a subtype of the return type, it can be assigned to
        ret.getRet().setType(ret.getRet().getType().canBeAssignedTo(functionType.getReturnType(), ret));
        return null;
    }

    /**
     * Check that the condition of the while statement is boolean
     * @param whileSt
     * @param param
     * @return
     */
    @Override
    public Void visit(While whileSt, Type param) {
        whileSt.getCondition().accept(this, param);
        for (Statement st: whileSt.getBody()) {
            st.accept(this, param);
        }
        if (!whileSt.getCondition().getType().isLogical()){
            new ErrorType(whileSt.getCondition().getLine(), whileSt.getCondition().getColumn(),
                    "Error in line: " + whileSt.getCondition().getLine() +
                            " column: " + whileSt.getCondition().getColumn()
                            +". Condition in WHILE statement is not boolean");
        }
        return null;
    }
}
