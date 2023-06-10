package ast.definitions;

import ast.types.Type;
import ast.types.TypeAbstract;
import ast.ASTNode;

public interface Definition extends ASTNode {

    public Type getType();
    public String getName();

    public void setScope(int scope);
    public int getScope();
}
