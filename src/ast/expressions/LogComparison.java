package ast.expressions;

import visitor.Visitor;

// models && and ||
public class LogComparison extends ExpressionAbstract {

    private Expression left;
    private Expression right;
    private String operator;
    public LogComparison(int l, int c, Expression left, Expression right, String operator) {
        super(l, c);
        setOperator(operator);
        setLeft(left);
        setRight(right);
    }
    private void setOperator(String v){
            this.operator = v;
    }

    public String getOperator(){return this.operator;}
    private void setLeft(Expression l) {
        this.left = l;
    }
    private void setRight(Expression r) {
        this.right = r;
    }
    public Expression getLeft(){return left;}
    public Expression getRight() {return right;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Logical Comparison: " + this.getLeft() + " " + this.operator + " " + this.getRight();
    }
}
