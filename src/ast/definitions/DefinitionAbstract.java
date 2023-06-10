package ast.definitions;

import ast.ASTNodeAbstract;
import ast.types.Type;
import ast.types.TypeAbstract;

public abstract class DefinitionAbstract extends ASTNodeAbstract implements Definition {

    private Type type;
    private String name;

    private int scope;

    public DefinitionAbstract(int l, int c, Type type, String name) {
        super(l, c);
        setType(type);
        setName(name);
    }


    public void setType(Type t){this.type = t;}
    public void setName(String n){this.name = n;}

    public String getName(){
        return this.name;
    }
    public Type getType(){
        return this.type;
    }

    public void setScope(int scope){this.scope = scope;}
    public int getScope() {return this.scope;}
}
