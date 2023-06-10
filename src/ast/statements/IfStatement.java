package ast.statements;

import ast.expressions.Expression;
import ast.expressions.ExpressionAbstract;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class IfStatement extends StatementAbstract {

    private Expression expression;
    private List<Statement> ifBody = new ArrayList<Statement>();
    private List<Statement> elseBody = new ArrayList<Statement>();

    public IfStatement(int l, int c, Expression exp, List<Statement> ifBody){
        super(l,c);
        setExpression(exp);
        setIf(ifBody);
    }

    private void setExpression(Expression e){this.expression = e;}
    private void setIf(List<Statement> b){
        this.ifBody.addAll(b);
    }
    public void setElse(List<Statement>b){
        this.elseBody.addAll(b);
    }
    public Expression getExpression() {return expression;}
    public List<Statement> getIfBody() {return ifBody;}
    public List<Statement> getElseBody() {return elseBody;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        String ret = "If : " + this.expression + " is true:";
        for (Statement st: this.getIfBody()) {
            ret += st + " - ";
        }
        ret += "\n when is false:";
        for (Statement st: this.getElseBody()) {
            ret += st + " - ";
        }
        return ret;
    }
}
