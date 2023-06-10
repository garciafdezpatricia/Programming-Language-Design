package ast.expressions;

import ast.definitions.Definition;
import ast.definitions.DefinitionAbstract;
import ast.definitions.VarDefinition;
import visitor.Visitor;

public class Variable extends ExpressionAbstract {
    private String name;

    private Definition definition;
    public Variable(int l, int c, String name) {
        super(l, c);
        setName(name);
    }

    private void setName(String n){
        this.name = n;
    }

    public String getName(){return name;}

    public Definition getDefinition() {return definition;}
    public void setDefinition(Definition definition){
        this.definition = definition;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Variable: " + this.name;
    }
}
