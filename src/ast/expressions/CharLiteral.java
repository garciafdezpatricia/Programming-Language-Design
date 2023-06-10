package ast.expressions;

import visitor.Visitor;

public class CharLiteral extends ExpressionAbstract {

    private char value;
    public CharLiteral(int l, int c, char value) {
        super(l, c);
        setValue(value);
    }

    private void setValue(char v){
        this.value = v;
    }

    public char getValue(){return this.value;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this,param);
    }

    @Override
    public String toString(){
        return "CharLiteral: " + this.value;
    }
}
