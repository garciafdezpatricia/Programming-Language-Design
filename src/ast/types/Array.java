package ast.types;

import ast.ASTNode;
import ast.expressions.IntLiteral;
import visitor.Visitor;

public class Array extends TypeAbstract {

    private int size;
    private Type type;

    public Array(int l, int c, int size, Type type){
        super(l, c);
        this.size = size;
        this.type = type;
    }

    public Type getType() {return type;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        return "Array of type: " + this.type + " - Size: " + this.size;
    }

    @Override
    public Type squareBrackets(Type indexer, ASTNode node) {
        if (indexer instanceof ErrorType)
            return indexer;
        if (indexer instanceof Int)
            return this.type; // return the type of the array if the indexer is valid
        return new ErrorType(node.getLine(), node.getColumn(),
                "Error in line: " + node.getLine() + " column: " + node.getColumn()
                        + ". Cannot index an array if the index is not an Integer");
    }

    @Override
    public int numberOfBytes() {
        return this.size * this.type.numberOfBytes();
    }
}
