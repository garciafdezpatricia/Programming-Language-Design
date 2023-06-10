package ast.types;

import ast.ASTNode;
import ast.expressions.Arithmetic;
import visitor.Visitor;

public class Char extends TypeAbstract {

    private static Char instance;
    private Char(int l, int c) {
        super(l, c);
    }

    public static Char getInstance(){
        if (instance == null){
            instance = new Char(0,0);
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Char";
    }

    @Override
    public Type arithmetic(Type other, ASTNode node) {
        Arithmetic arithOperation = (Arithmetic) node;
        if (arithOperation.getOperator().equals("%")){
            if (other instanceof ErrorType)
                return other;
            if (other instanceof Char)
                return Char.getInstance();
            return new ErrorType(node.getLine(), node.getColumn(),
                    "Error in line: " + node.getLine() + " column: " + node.getColumn()
                            + ". An arithmetic modulus (%) operation can not be performed between Char and " + other);
        }
        else{
            if (other instanceof ErrorType)
                return other;
            // an arithmetic with two chars returns an integer
            if (other instanceof Char)
                return Int.getInstance();
            if (other instanceof Real)
                return Real.getInstance();
            if (other instanceof Int)
                return Int.getInstance();
            return new ErrorType(node.getLine(), node.getColumn(),
                    "Error in line: " + node.getLine() + " column: " + node.getColumn()
                            + ". An arithmetic operation can not be performed between Char and " + other);
        }
    }

    @Override
    public Type arithComparison(Type other, ASTNode node) {
        if (other instanceof ErrorType)
            return other;
        if (other instanceof Char)
            return Int.getInstance();
        if (other instanceof Int)
            return Int.getInstance();
        if (other instanceof Real)
            return Real.getInstance();
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". An arithmetic comparison can not be performed between Char and " + other);
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return Char.getInstance();
    }

    @Override
    public boolean isBuiltIn() {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public char suffix() {
        return 'b';
    }

    @Override
    public Type canCastTo(Type castTo, ASTNode node) {
        if (castTo instanceof ErrorType)
            return castTo;
        if (castTo.isBuiltIn())
            return castTo;
        return new ErrorType(node.getLine(), node.getColumn(),
                "Error in line: " + node.getLine() + " column: " + node.getColumn()
                        + ". Char can only be casted to Integer or Real");
    }

    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        if (other.isErrorType())
            return other;
        if (other instanceof Char)
            return Char.getInstance();
        // char is a subtype of int
        if (other instanceof Int)
            return Int.getInstance();
        // char is a subtype of real
        if (other instanceof Real)
            return Real.getInstance();

        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Char cannot be assigned to type " + other);
    }
}
