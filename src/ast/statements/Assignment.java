package ast.statements;

import ast.expressions.Expression;
import ast.expressions.ExpressionAbstract;
import visitor.Visitor;

public class Assignment extends StatementAbstract {

    private String operator;
    private Expression left;
    private Expression right;

    public Assignment(int l, int c, Expression le, Expression r){
        super(l,c);
        setOperator("=");
        setLeft(le);
        setRight(r);
    }

    private void setOperator(String o){
        this.operator = o;
    }
    private void setLeft(Expression l){
        this.left = l;
    }
    private void setRight(Expression r){
        this.right = r;
    }

    public Expression getRight() {return right;}
    public Expression getLeft() {return left;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Assignment: " + this.getLeft() + this.operator + this.getRight();
    }
}
