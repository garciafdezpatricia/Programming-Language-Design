package ast.types;

import ast.ASTNode;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Struct extends TypeAbstract {
    private List<RecordField> fields;

    public Struct(int l, int c){
        super(l, c);
        fields = new ArrayList<RecordField>();
    }

    public void setFields(List<RecordField> f){
        fields.addAll(f);
    }
    public List<RecordField> getFields() {return fields;}

    public RecordField getField(String fieldName){
        for (RecordField field : this.getFields()) {
            if (field.getName().equals(fieldName))
                return field;
        }
        throw new RuntimeException("There is no field with name '" + fieldName + "'");
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        String ret = "Struct: Fields: ";
        for (RecordField field: this.getFields()) {
            ret += field;
        }
        return ret;
    }

    @Override
    public Type fieldAccess(String fieldName, ASTNode node) {
        for (RecordField field : this.fields){
            if (field.getName().equals(fieldName))
                return field.getType();
        }
        return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                + ". Struct does not contain a field named '" + fieldName + "'");
    }

    @Override
    public int numberOfBytes() {
        int totalSum = 0;
        for (RecordField field: this.getFields()){
            totalSum += field.getType().numberOfBytes();
        }
        return totalSum;
    }


}
