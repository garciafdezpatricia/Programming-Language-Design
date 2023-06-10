package ast.expressions;

import ast.types.Type;
import ast.types.TypeAbstract;
import visitor.Visitor;

public class Cast extends ExpressionAbstract {
    private String operator;
    private Type castTo;
    private Expression exp;

    public Cast(int l, int c, Type castToType, Expression exp) {
        super(l, c);
        setOperator("()");
        setCastTo(castToType);
        setExpression(exp);
    }

    private void setOperator(String value){
        this.operator = value;
    }
    private void setCastTo(Type value){
        this.castTo = value;
    }
    public Type getCastTo(){return castTo;}

    private void setExpression(Expression e){this.exp = e;}
    public Expression getExpression(){return exp;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Cast: (" + this.castTo + ")" + this.getExpression();
    }
}
