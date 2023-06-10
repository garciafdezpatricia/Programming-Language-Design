package ast.expressions;

import visitor.Visitor;

public class FieldAccess extends ExpressionAbstract {

    private String fieldName;
    private String operator;
    private Expression expression;
    public FieldAccess(int l, int c, Expression exp, String field) {
        super(l, c);
        setOperator(".");
        setVariable(exp);
        setFieldName(field);
    }

    private void setVariable(Expression exp){
        this.expression = exp;
    }
    private void setOperator(String o){
        this.operator = o;
    }
    private void setFieldName(String f){
        this.fieldName = f;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Expression getExpression() {return expression;}
    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "FieldAcess: " + this.expression + this.operator + this.fieldName;
    }
}
