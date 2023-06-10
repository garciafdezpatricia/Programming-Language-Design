package codegenerator;

import ast.Program;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {
    @Override
    public TR visit(Program program, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        return null;
    }

    @Override
    public TR visit(ArithComparison arithComparison, TP param) {
        return null;
    }

    @Override
    public TR visit(LogComparison logComparison, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayIndexer arrayIndexer, TP param) {
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        return null;
    }

    @Override
    public TR visit(Minus minus, TP param) {
        return null;
    }

    @Override
    public TR visit(Negation negation, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        return null;
    }

    @Override
    public TR visit(IfStatement ifStatement, TP param) {
        return null;
    }

    @Override
    public TR visit(Input input, TP param) {
        return null;
    }

    @Override
    public TR visit(Print print, TP param) {
        return null;
    }

    @Override
    public TR visit(Return ret, TP param) {
        return null;
    }

    @Override
    public TR visit(While whileSt, TP param) {
        return null;
    }

    @Override
    public TR visit(Array array, TP param) {
        return null;
    }

    @Override
    public TR visit(Char character, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        return null;
    }

    @Override
    public TR visit(Int integer, TP param) {
        return null;
    }

    @Override
    public TR visit(Real real, TP param) {
        return null;
    }

    @Override
    public TR visit(Struct struct, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
