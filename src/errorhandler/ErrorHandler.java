package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.*;

public class ErrorHandler {

    private static ErrorHandler instance;
    private List<ErrorType> errors;

    public ErrorHandler(){
        errors = new ArrayList<ErrorType>();
    }

    public static ErrorHandler getInstance(){
        if (instance == null){
            instance = new ErrorHandler();
        }
        return instance;
    }

    /**
     * Checks if the handler contains any error.
     * @return false if empty, true otherwise
     */
    public boolean anyError() {
        if (errors.isEmpty())
            return false;
        return true;
    }

    /**
     * Shows errors in the console
     * @param out
     */
    public void showErrors(PrintStream out){
        for (ErrorType e : errors){
            out.println(e.toString());
        }
    }

    /**
     * Adds error to the list
     * @param error
     */
    public void addError(ErrorType error){
        errors.add(error);
    }
}
