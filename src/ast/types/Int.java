package ast.types;

import ast.ASTNode;
import ast.expressions.Arithmetic;
import visitor.Visitor;

public class Int extends TypeAbstract {

    private static Int instance;
    private Int(int l, int c) {
        super(l, c);
    }

    public static Int getInstance(){
        if (instance == null){
            instance = new Int(0,0);
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Int";
    }

    @Override
    public boolean isLogical(){
        return true;
    }

    @Override
    public Type arithmetic(Type other, ASTNode node){
        Arithmetic arithOperation = (Arithmetic) node;

        if (arithOperation.getOperator().equals("%")){
            if (other instanceof Int)
                return Int.getInstance();
            if (other instanceof ErrorType)
                return other;
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                    + ". Cannot perform an arithmetic modulus (%) operation between an integer and a " + other);
        }
        else{
            if (other instanceof ErrorType)
                return other;
            if (other instanceof Int)
                return Int.getInstance();
            if (other instanceof Real)
                return Real.getInstance();
            if (other instanceof Char)
                return Int.getInstance();
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                    + ". Cannot perform an arithmetic operation between an integer and a " + other);
        }
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return Int.getInstance();
    }

    @Override
    public Type arithComparison(Type other, ASTNode node) {
        if (other instanceof ErrorType)
            return other;
        if (other instanceof Int)
            return Int.getInstance();
        if (other instanceof Char)
            return Int.getInstance();
        if (other instanceof Real)
            return Real.getInstance();
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Int cannot be compared with " + other);
    }

    @Override
    public Type logicComparison(Type other, ASTNode node) {
        if (other instanceof ErrorType)
            return other;
        if (other instanceof Int)
            return Int.getInstance();
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " +
                node.getColumn() +". A logical comparison cannot be performed with type " + other);
    }

    @Override
    public Type unaryNegation(ASTNode node) {
        return Int.getInstance();
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public Type canCastTo(Type castTo, ASTNode node) {
        if (castTo instanceof ErrorType)
            return castTo;
        if (castTo.isBuiltIn())
            return castTo;
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Integer can only be casted to Char or Real");
    }

    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        if (other.isErrorType())
            return other;
        if (other instanceof Int)
            return Int.getInstance();
        // int is a subtype of real
        if (other instanceof Real)
            return Real.getInstance();
        // int is not a subtype of char
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Int cannot be assigned to type " + other);
    }

    @Override
    public char suffix() {
        return 'i';
    }
}
