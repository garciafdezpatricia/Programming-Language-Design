package ast.definitions;

import ast.expressions.Expression;
import ast.statements.Statement;
import ast.types.Type;
import ast.types.TypeAbstract;
import visitor.Visitor;

public class VarDefinition extends DefinitionAbstract implements Statement {
    private int offset;
    public VarDefinition(int l, int c, Type t, String name) {
        super(l, c, t, name);
    }

    public int getOffset() { return this.offset; }
    public void setOffset(int value) {this.offset = value; }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Variable Definition: " + this.getName() + " Type: " + this.getType();
    }
}
