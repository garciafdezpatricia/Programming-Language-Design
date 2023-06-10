package ast.expressions;

import ast.ASTNodeAbstract;
import ast.types.Type;

public abstract class ExpressionAbstract extends ASTNodeAbstract implements Expression {

    private boolean lvalue;

    private Type type;

    public ExpressionAbstract(int l, int c) {
        super(l, c);
    }

    public void setLValue(boolean value){
        lvalue = value;
    }
    public boolean getLValue(){return lvalue;}

    public Type getType() {
        return this.type;
    }

    public void setType(Type type){
        this.type = type;
    }
}
