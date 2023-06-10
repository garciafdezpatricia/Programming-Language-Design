package ast.types;

import ast.ASTNode;
import errorhandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends TypeAbstract{

    private String message;
    public ErrorType(int l, int c, String message) {
        super(l, c);
        setMessage(message);
        ErrorHandler.getInstance().addError(this);
    }

    private void setMessage(String message){
        this.message = message;
    }


    public String toString(){
        return this.message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public boolean isErrorType() {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    @Override
    public Type canBeAssignedTo(Type other, ASTNode node) {
        return this;
    }
}
