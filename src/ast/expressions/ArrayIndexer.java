package ast.expressions;

import visitor.Visitor;

public class ArrayIndexer extends ExpressionAbstract {

    private String operator;
    private Expression left;
    private Expression right;
    public ArrayIndexer(int l, int c, Expression left, Expression right) {
        super(l, c);
        setOperator("[]");
        setLeft(left);
        setRight(right);
    }

    private void setOperator(String op) {this.operator = op;}

    private void setLeft(Expression l) {this.left = l;}
    private void setRight(Expression r){this.right = r;}
    public Expression getLeft(){return left;}
    public Expression getRight() {return right;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Array indexer: " + this.getLeft() + "[" + this.getRight() + "]";
    }
}
