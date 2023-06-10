package ast.expressions;

import visitor.Visitor;

public class IntLiteral extends ExpressionAbstract {
    private int value;
    public IntLiteral(int l, int c, int value) {
        super(l, c);
        setValue(value);
    }

    private void setValue(int v){
        this.value = v;
    }

    public int getValue() {return this.value;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "IntLiteral: " + this.value;
    }
}
