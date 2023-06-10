package ast.statements;

import ast.expressions.Expression;
import ast.expressions.ExpressionAbstract;
import visitor.Visitor;

public class Return extends StatementAbstract {

    private Expression ret;

    public Return(int l, int c, Expression r){
        super(l,c);
        setRet(r);
    }

    private void setRet(Expression r){
        this.ret = r;
    }
    public Expression getRet(){return ret;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Return: " + this.ret;
    }
}
