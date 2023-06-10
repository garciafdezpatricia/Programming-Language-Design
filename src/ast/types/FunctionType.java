package ast.types;

import ast.ASTNode;
import ast.definitions.VarDefinition;
import ast.expressions.FuncInvocation;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends TypeAbstract {
    private Type returnType;
    private List<VarDefinition> arguments;

    public FunctionType(int l, int c, List<VarDefinition> args, Type retType){
        super(l,c);
        arguments = new ArrayList<VarDefinition>();
        setReturnType(retType);
        setArguments(args);
    }

    private void setReturnType(Type r){
        this.returnType = r;
    }

    private void setArguments(List<VarDefinition> args){
        this.arguments.addAll(args);
    }
    public List<VarDefinition> getArguments() {return arguments;}
    public Type getReturnType() {return returnType;}

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public String toString(){
        String ret = "FunctionType: Returning Type: " + this.returnType + " - Arguments: ";
        for (VarDefinition argument: this.getArguments()) {
            ret += argument + " - ";
        }
        return ret;
    }

    @Override
    public Type parenthesis(List<Type> paramsTypes, ASTNode node) {
        if (this.arguments.size() != paramsTypes.size())
            return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                    + ". Expected number of parameters was " + arguments.size() + " but got " + paramsTypes.size());

        for (int i = 0; i < paramsTypes.size(); i++){
            Type type = paramsTypes.get(i); // argumento (le puse params a los argumentos y argumentos a los params, magnifica gestion)
            if (type instanceof ErrorType)
                return type;
            // arguments can promote to parameters if they are subtypes of the parameters (tengo los nombres cambiaos)
            if (!argumentCanPromoteToParameter(type, arguments.get(i).getType(), node))
                return new ErrorType(node.getLine(), node.getColumn(), "Error in line: " + node.getLine() + " column: " + node.getColumn()
                        + ". Expected parameter of type " + arguments.get(i).getType() + " in position " +
                        i + " but got parameter of type " + type + " instead");
            else{
                FuncInvocation invocation = (FuncInvocation) node;
                // promote each parameter type
                invocation.getParameters().get(i).setType(invocation.getParameters().get(i).getType().canBeAssignedTo(
                        arguments.get(i).getType(), invocation));
            }
        }

        return returnType; // the type if there are no errors is the returned type
    }

    private boolean argumentCanPromoteToParameter(Type argument, Type parameter, ASTNode node){
        Type result = argument.canBeAssignedTo(parameter, node);
        if (!(result instanceof ErrorType)){

            return true;
        }
        return false;
    }

    @Override
    public int numberOfBytes() {
        // function types are pointers, and the size of the word in our compiler is 2bytes.
        throw new RuntimeException("numberOfBytes() should never be called on Function Type");
    }
}
