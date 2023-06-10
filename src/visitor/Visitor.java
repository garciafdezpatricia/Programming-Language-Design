package visitor;

import ast.Program;
import ast.types.RecordField;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor<TP,TR> {

    // PROGRAM
    TR visit(Program program, TP param);

    // EXPRESSIONS
    TR visit(Arithmetic arithmetic, TP param);
    TR visit(ArithComparison arithComparison,TP param);
    TR visit(LogComparison logComparison,TP param);
    TR visit(ArrayIndexer arrayIndexer, TP param);
    TR visit(Cast cast, TP param);
    TR visit(CharLiteral charLiteral, TP param);
    TR visit(DoubleLiteral doubleLiteral,TP param);
    TR visit(IntLiteral intLiteral,TP param);
    TR visit(FieldAccess fieldAccess,TP param);
    TR visit(FuncInvocation funcInvocation,TP param);
    TR visit(Minus minus,TP param);
    TR visit(Negation negation,TP param);
    TR visit(Variable variable,TP param);

    // DEFINITIONS
    TR visit(RecordField recordField, TP param);
    TR visit(FuncDefinition funcDefinition, TP param);
    TR visit(VarDefinition varDefinition, TP param);


    // STATEMENTS
    TR visit(Assignment assignment, TP param);
    TR visit(IfStatement ifStatement, TP param);
    TR visit(Input input, TP param);
    TR visit(Print print, TP param);
    TR visit(Return ret, TP param);
    TR visit(While whileSt, TP param);


    // TYPES
    TR visit(Array array, TP param);
    TR visit(Char character, TP param);
    TR visit(ErrorType errorType, TP param);
    TR visit(FunctionType functionType, TP param);
    TR visit(Int integer, TP param);
    TR visit(Real real, TP param);
    TR visit(Struct struct, TP param);
    TR visit(VoidType voidType, TP param);
}
