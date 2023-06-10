package ast.statements;

import ast.ASTNode;
import ast.ASTNodeAbstract;

public abstract class StatementAbstract extends ASTNodeAbstract implements Statement {

    public StatementAbstract(int l, int c) {
        super(l, c);
    }

}
