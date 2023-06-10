package ast.expressions;

import visitor.Visitor;

public class Negation extends ExpressionAbstract {
    private String operator;
    private Expression exp;
    public Negation(int l, int c, Expression exp) {
        super(l, c);
        setOperator("!");
        setExpression(exp);
    }

    private void setOperator(String v){
        this.operator = v;
    }

    private void setExpression(Expression v){
        this.exp = v;
    }
    public Expression getExp() {return exp;}
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Negation: " + this.operator + this.exp;
    }
}
