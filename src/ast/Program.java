package ast;

import ast.definitions.Definition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends ASTNodeAbstract {
    private List<Definition> body;

    public Program(int l, int c) {
        super(l, c);
        body = new ArrayList<Definition>();
    }

    public void addDefinition(Definition def){
        body.add(def);
    }
    public List<Definition> getBody(){return body;}

    @Override
    public <TP, TR> TR accept(Visitor<TP,TR> v, TP param) {
        return v.visit(this, param);
    }
}
