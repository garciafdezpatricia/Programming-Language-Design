package ast.expressions;

import visitor.Visitor;

public class DoubleLiteral extends ExpressionAbstract {
    private double value;
    public DoubleLiteral(int l, int c, double v) {
        super(l, c);
        setValue(v);
    }

    private void setValue(double v){
        this.value = v;
    }

    public double getValue() {
        return value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this,param);
    }

    @Override
    public String toString(){
        return "DoubleLiteral: " + this.value;
    }
}
