package ast.definitions;

import ast.expressions.Expression;
import ast.statements.Statement;
import ast.statements.StatementAbstract;
import ast.types.Type;
import ast.types.TypeAbstract;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FuncDefinition extends DefinitionAbstract {

    private List<Statement> statementList;
    private List<VarDefinition> definitionList;
    public FuncDefinition(int l, int c, Type type, String name) {
        super(l, c, type, name);
        statementList = new ArrayList<Statement>();
        definitionList = new ArrayList<VarDefinition>();
    }

    public void addStatement(Statement b){
        statementList.add(b);
    }

    public void addDefinition(VarDefinition b){
        definitionList.add(b);
    }

    public List<Statement> getStatementList() {return statementList;}
    public List<VarDefinition> getDefinitionList() {return definitionList; }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Function Definition: " + this.getName() + " Type: " + this.getType();
    }
}
