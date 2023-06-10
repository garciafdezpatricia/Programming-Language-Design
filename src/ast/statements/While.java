package ast.statements;

import ast.expressions.Expression;
import ast.expressions.ExpressionAbstract;
import visitor.Visitor;

import java.util.*;

public class While extends StatementAbstract {

    private List<Statement> body = new ArrayList<Statement>();;
    private Expression condition;

    public While(int l, int c, Expression condition, List<Statement> body){
        super(l,c);
        setBody(body);
        setCondition(condition);
    }

    private void setBody(List<Statement> b){
        this.body.addAll(b);
    }
    private void setCondition(Expression c){
        this.condition = c;
    }

    public Expression getCondition() {return condition;}
    public List<Statement> getBody() {return body;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        String ret = "While " + this.condition + " is true: ";
        for (Statement statement : this.getBody()) {
            ret += statement + " - ";
        }
        return ret;
    }
}
