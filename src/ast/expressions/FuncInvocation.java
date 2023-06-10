package ast.expressions;

import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.statements.Statement;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncInvocation extends ExpressionAbstract implements Statement {

    private Variable name;

    private Definition funcDefinition;
    private List<Expression> parameters = new ArrayList<Expression>();
    public FuncInvocation(int l, int c, Variable name) {
        super(l, c);
        setName(name);
    }

    private void setName(Variable v){
        this.name = v;
    }

    public void addExpression(Expression e){
        parameters.add(e);
    }
    public List<Expression> getParameters() {return parameters;}
    public Variable getName() {return name;}

    public Definition getFuncDefinition(){
        return this.funcDefinition;
    }

    public void setFuncDefinition(Definition definition){
        this.funcDefinition = definition;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this,param);
    }

    @Override
    public String toString(){
        String ret = "Function Invocation: " + this.name + " - Expressions: ";
        for (Expression expression : this.parameters) {
            ret += expression + " - ";
        }
        return ret;
    }
}
