package ast.types;

import ast.ASTNode;
import visitor.Visitor;

public class VoidType extends TypeAbstract {
    public static VoidType instance;
    private VoidType(int l, int c) {
        super(l, c);
    }

    public static VoidType getInstance(){
        if (instance == null){
            instance = new VoidType(0,0);
        }
        return instance;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Void";
    }

    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        if (other.isErrorType())
            return other;
        if (other instanceof VoidType)
            return VoidType.getInstance();
        return new ErrorType(node.getLine(), node.getColumn(),
                "Void cannot be assigned to type " + other);
    }

    @Override
    public int numberOfBytes() {
        return 0; // no size
    }
}
