package semantic;

import ast.Program;
import ast.definitions.Definition;
import ast.types.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;
import visitor.Visitor;

/**
 * Visitor to do the identification phase of the compiler (link definitions with variables) using the Symbol Table
 */
public class IdentificationVisitor extends AbstractVisitor<Object, Object> {

    private SymbolTable table = new SymbolTable();


    /**
     * Check if the symbol table has a function with the name of the function invocation. If not, raise an error.
     * @param funcInvocation contains the function invocation
     * @param param
     * @return
     */
    @Override
    public Object visit(FuncInvocation funcInvocation, Object param) {
        // accept in every parameter of the function invocation
        for (Expression expression: funcInvocation.getParameters()) {
            expression.accept(this, param);
        }
        funcInvocation.getName().accept(this, param);
        // check if we have a function with this name, else error (you cannot invoke a function that does not exist)
        if (table.find(funcInvocation.getName().getName()) != null){
            funcInvocation.setFuncDefinition(table.find(funcInvocation.getName().getName()));
        }
        else{
            ErrorType error = new ErrorType(funcInvocation.getLine(), funcInvocation.getColumn(),
                    "Error in line: " + funcInvocation.getLine() + " column: " + funcInvocation.getColumn()
                            +". Function with name " + funcInvocation.getName() + " is not defined");
            // the definition must be set to error
            funcInvocation.setFuncDefinition(new FuncDefinition(funcInvocation.getLine(), funcInvocation.getColumn(),
                    error, funcInvocation.getName().getName()));
        }
        return null;
    }

    /**
     * Check if the symbol table contains a variable definition with the variable name. If not, raise an error.
     * @param variable contains the variable
     * @param param
     * @return
     */
    @Override
    public Object visit(Variable variable, Object param) {
        // check if we have a variable definition with that name
        Definition varDefinition = table.find(variable.getName());
        if (varDefinition != null) { // if we have it
            // assign the definition attribute of the variable to the definition
            variable.setDefinition(varDefinition);
        }
        else{
            // if we don't have a definition raise an error
            ErrorType error = new ErrorType(variable.getLine(), variable.getColumn(), "Error in line: "
                    + variable.getLine() + " column: " + variable.getColumn() +
                    ". Variable " + variable.getName() + " not defined");
            variable.setDefinition(new VarDefinition(variable.getLine(), variable.getColumn(),
                    error, variable.getName())); // the definition must be initialised to error
        }
        return null;
    }


    // ********** DEFINITION ************

    /**
     * Check if the symbol table contains a function definition with the same name. If there is, raise an error, as
     * we cant have two functions with the same name in the same scope.
     * @param funcDefinition contains the function definition
     * @param param
     * @return
     */
    @Override
    public Object visit(FuncDefinition funcDefinition, Object param) {
        // check that there is not a function with that name already defined in scope
        if (table.findInCurrentScope(funcDefinition.getName()) != null){
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(), "Error in line: "
                    + funcDefinition.getLine() + " column: " + funcDefinition.getColumn()
                    + ". Function '" + funcDefinition.getName() + "' already defined in scope");
        }
        else{
            // insert definition in symbol table
            table.insert(funcDefinition);
            // increment scope
            table.set();
            funcDefinition.getType().accept(this, param); // accept in type (identify parameters)
            for (Definition definition: funcDefinition.getDefinitionList()) {
                definition.accept(this, param); // accept in each definition
            }
            for (Statement statement : funcDefinition.getStatementList()) {
                statement.accept(this, param); // accept in each statement
            }
            // all the body processed, now decrement scope
            table.reset();
        }
        return null;
    }

    /**
     * Check if the symbol table contains a variable definition with the same name. If it exists, raise an error.
     * @param varDefinition contains the variable definition to check
     * @param param
     * @return
     */
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        varDefinition.getType().accept(this, param);
        // check that there is not a variable definition with that name
        if (table.findInCurrentScope(varDefinition.getName()) != null) {
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(),
                    "Error in line: " + varDefinition.getLine() + " column: " + varDefinition.getColumn()
                            + ". Variable '" + varDefinition.getName() + "' already defined in scope");
        }
        else
            table.insert(varDefinition);
        return null;
    }

    /**
     * Function Type contains variable definitions that need to be visited.
     * @param functionType
     * @param param
     * @return
     */
    @Override
    public Object visit(FunctionType functionType, Object param) {
        functionType.getReturnType().accept(this, param); //accept in returned type
        for (VarDefinition vardefinition: functionType.getArguments()) {
            vardefinition.accept(this, param);
        }
        return null;
    }
}
