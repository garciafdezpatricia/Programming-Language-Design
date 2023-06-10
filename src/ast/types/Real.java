package ast.types;

import ast.ASTNode;
import ast.expressions.Arithmetic;
import visitor.Visitor;

public class Real extends TypeAbstract {

    private static Real instance;
    private Real(int l, int c) {
        super(l, c);
    }

    public static Real getInstance(){
        if (instance == null){
            instance = new Real(0,0);
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Real";
    }


    @Override
    public Type arithmetic(Type other, ASTNode node) {
        Arithmetic arithOperation = (Arithmetic) node;
        if (arithOperation.getOperator().equals("%")){
            if (other instanceof ErrorType)
                return other;
            if (other instanceof Real)
                return Real.getInstance();
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                    + ". Cannot perform an arithmetic modulus (%) operation between an integer and a " + other);
        }
        else{
            if (other instanceof ErrorType)
                return other;
            if (other instanceof Real)
                return Real.getInstance();
            if (other instanceof Int)
                return Real.getInstance();
            if (other instanceof Char)
                return Real.getInstance();
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                    + ". Cannot perform an arithmetic operation between an integer and a " + other);
        }
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return Real.getInstance();
    }

    @Override
    public Type arithComparison(Type other, ASTNode node) {
        if (other instanceof ErrorType)
            return other;
        if (other instanceof Real)
            return Real.getInstance();
        if (other instanceof Char)
            return Real.getInstance();
        if (other instanceof Int)
            return Real.getInstance();
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Reals cannot be compared to " + other);
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public Type canCastTo(Type castTo, ASTNode node) {
        if (castTo instanceof ErrorType)
            return castTo;
        if (castTo.isBuiltIn())
            return castTo;
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Real can only be casted to Integer or Char");
    }

    // Right hand side can be assined to left hand side if right is a subtype of left.
    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        if (other.isErrorType())
            return other;
        if (other instanceof Real)
            return Real.getInstance();
        // real is not a subtype of int and char
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Real cannot be assigned to type " + other);
    }

    @Override
    public char suffix() {
        return 'f';
    }
}
