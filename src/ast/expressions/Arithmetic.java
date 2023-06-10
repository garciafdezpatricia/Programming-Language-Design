package ast.expressions;

import visitor.Visitor;

public class Arithmetic extends ExpressionAbstract {
    private Expression left;
    private Expression right;
    private String operator;
    public Arithmetic(int l, int c, Expression left, Expression right, String operator) {
        super(l, c);
        setLeft(left);
        setRight(right);
        setOperator(operator);
    }

    private void setOperator(String operator){
        this.operator = operator;
    }

    public String getOperator(){return this.operator;}
    private void setLeft(Expression l){
        this.left = l;
    }
    private void setRight(Expression r){
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
        return "Arithmetic: " + this.getLeft() + this.operator + this.getRight();
    }
}
