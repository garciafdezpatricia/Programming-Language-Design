package ast;

import visitor.Visitor;

public abstract class ASTNodeAbstract implements ASTNode {
    private int line;
    private int column;

    public ASTNodeAbstract(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}
