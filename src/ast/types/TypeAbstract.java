package ast.types;

import ast.ASTNode;
import ast.ASTNodeAbstract;

import java.util.List;

public abstract class TypeAbstract extends ASTNodeAbstract implements Type {

    public TypeAbstract(int l, int c) {
        super(l, c);
    }

    public boolean isErrorType() {
        return false;
    }

    public boolean isLogical() {
        return false;
    }

    public Type arithmetic(Type other, ASTNode node){
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform an arithmetic operation with type " + other);
    }

    public Type unaryMinus(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform unary minus operation on not unary minus expression");
    }

    public Type unaryNegation(ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform unary negation operation on not unary negation expression");
    }

    public Type arithComparison(Type other, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform an arithmetic comparison in types distinct than real, int or char");
    }

    public Type logicComparison(Type other, ASTNode node){
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Logical comparison cannot be performed in this node " + node);
    }

    public Type fieldAccess(String fieldName, ASTNode node){
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform field accesses in constructions different than Structs");
    }

    public Type squareBrackets(Type indexer, ASTNode node){
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot perform an array indexer in constructions different than Arrays");
    }

    public Type canCastTo(Type castTo, ASTNode node){
        if (castTo instanceof ErrorType)
            return castTo;
        if (!castTo.isBuiltIn())
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                    + node.getLine() + " column: " + node.getColumn() +
                    ". Casts can only be used to cast to BuiltIn types");
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot invoke cast here");
    }

    @Override
    public Type parenthesis(List<Type> paramsTypes, ASTNode node) {
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot use the () operator on anything distinct from a function");
    }

    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        if (other.isErrorType())
            return other;
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: "
                + node.getLine() + " column: " + node.getColumn() +
                ". Cannot assign type " + other);
    }

    public boolean isBuiltIn(){
        return false;
    }

    @Override
    public char suffix() {
        throw new RuntimeException("suffix() called for " + this.getClass());
    }
}
