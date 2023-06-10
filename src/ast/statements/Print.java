package ast.statements;

import ast.expressions.Expression;
import ast.expressions.ExpressionAbstract;
import visitor.Visitor;

import java.util.*;

public class Print extends StatementAbstract {

    private List<Expression> expressionList = new ArrayList<Expression>();

    public Print(int l, int c){
        super(l,c);
    }

    public void addExpression(Expression e){
        expressionList.add(e);
    }

    public List<Expression> getExpressionList() {return expressionList; }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        String ret = "Print: ";
        for (Expression expression : this.getExpressionList()) {
            ret += expression + " - ";
        }
        return ret;
    }
}
