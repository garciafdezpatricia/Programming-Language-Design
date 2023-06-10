package ast.expressions;

import ast.ASTNode;
import ast.types.Type;

public interface Expression extends ASTNode {

    boolean getLValue();

    void setLValue(boolean lvalue);

    void setType(Type type);

    Type getType();

}
