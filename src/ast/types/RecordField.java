package ast.types;

import ast.ASTNode;
import visitor.Visitor;

public class RecordField implements ASTNode {

    int line;
    int column;
    int offset;
    String fieldName;
    Type type;

    public RecordField(int l, int c, Type t, String name) {
        this.line = l;
        this.column = c;
        this.fieldName = name;
        this.type = t;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    public String getName(){
        return fieldName;
    }

    public Type getType() {
        return type;
    }

    public void setFieldName(String fieldName){
        this.fieldName = fieldName;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setOffset(int offset){this.offset = offset;}

    public int getOffset(){
        return this.offset;
    }

    @Override
    public String toString(){
        return "Record Field: Name: " + this.fieldName + " - Type " + this.type;
    }
}
