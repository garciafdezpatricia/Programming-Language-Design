package codegenerator;

import ast.definitions.VarDefinition;
import ast.expressions.ArrayIndexer;
import ast.expressions.FieldAccess;
import ast.expressions.Variable;
import ast.types.Int;
import ast.types.Struct;

/**
 * Only defined for lvalue expressions
 */
public class AddressCGVisitor extends AbstractCGVisitor<Object, Void>{

    private CodeGenerator codeGenerator;

    private ValueCGVisitor valueCGVisitor;
    public AddressCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public void setValueCGVisitor(ValueCGVisitor visitor){
        this.valueCGVisitor = visitor;
    }


    /*
        address[[Variable: exp -> ID]] =
            if (exp.definition.scope == 0) // is global, the memory address is the offset
                <pusha> + variable.definition.offset
            else // is a local variable or a function parameter
                <pushbp>
                <pushi> + exp.definition.offset
                <addi> // in parameters we store the sign, so it is the same

     */
    @Override
    public Void visit(Variable variable, Object param) {
        // is a leaf node -> do not traverse
        if (variable.getDefinition().getScope() == 0){
            codeGenerator.pusha(((VarDefinition)variable.getDefinition()).getOffset()); // offset in vardef
        }
        else{
            codeGenerator.pushBP();
            codeGenerator.pushi(((VarDefinition)variable.getDefinition()).getOffset());
            codeGenerator.add(Int.getInstance());
        }
        return null;
    }

    /*
        address[[FieldAccess: exp1 -> exp2 ID]] =
            address[[exp2]]
            <pushi> exp2.type.getfield(ID).offset
            <addi>
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpression().accept(this, param);
        // must do a cast to struct to get the field offset
        codeGenerator.pushi(((Struct)fieldAccess.getExpression().getType()).getField(fieldAccess.getFieldName()).getOffset());
        codeGenerator.add(Int.getInstance());
        return null;
    }

    /*
        address[[ArrayIndexer: exp1 -> exp2 exp3]] =
            address[[exp2]]
            value[[exp3]]
            <pushi> exp1.type.numberOfBytes()
            <muli>
            <addi>
     */
    @Override
    public Void visit(ArrayIndexer arrayIndexer, Object param) {
        arrayIndexer.getLeft().accept(this, param);
        arrayIndexer.getRight().accept(valueCGVisitor, param);
        codeGenerator.pushi(arrayIndexer.getType().numberOfBytes());
        codeGenerator.mul(Int.getInstance());
        codeGenerator.add(Int.getInstance());
        return null;
    }
}
