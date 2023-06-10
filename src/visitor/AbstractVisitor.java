package visitor;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;

public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {
    @Override
    public TR visit(Program program, TP param) {
        for (Definition definition: program.getBody()) {
            definition.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.getLeft().accept(this, param);
        arithmetic.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArithComparison arithComparison, TP param) {
        arithComparison.getLeft().accept(this, param);
        arithComparison.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(LogComparison logComparison, TP param) {
        logComparison.getLeft().accept(this, param);
        logComparison.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(ArrayIndexer arrayIndexer, TP param) {
        arrayIndexer.getLeft().accept(this, param);
        arrayIndexer.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.getExpression().accept(this, param);
        cast.getCastTo().accept(this, param);
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
        fieldAccess.getExpression().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncInvocation funcInvocation, TP param) {
        for (Expression expression: funcInvocation.getParameters()) {
            expression.accept(this, param);
        }
        funcInvocation.getName().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Minus minus, TP param) {
        minus.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Negation negation, TP param) {
        negation.getExp().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
//        variable.getDefinition().accept(this, param);
//        variable.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        recordField.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(FuncDefinition funcDefinition, TP param) {
        for (Statement statement: funcDefinition.getStatementList()) {
            statement.accept(this, param);
        }
        for (VarDefinition definition: funcDefinition.getDefinitionList()) {
            definition.accept(this, param);
        }
        funcDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.getLeft().accept(this, param);
        assignment.getRight().accept(this, param);
        return null;
    }

    @Override
    public TR visit(IfStatement ifStatement, TP param) {
        ifStatement.getExpression().accept(this, param);
        for (Statement statemt: ifStatement.getIfBody()) {
            statemt.accept(this, param);
        }
        for (Statement statemt: ifStatement.getElseBody()) {
            statemt.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Input input, TP param) {
        for (Expression expression:input.getExpressionList()) {
            expression.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Print print, TP param) {
        for (Expression expression:print.getExpressionList()) {
            expression.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Return ret, TP param) {
        ret.getRet().accept(this, param);
        return null;
    }

    @Override
    public TR visit(While whileSt, TP param) {
        whileSt.getCondition().accept(this, param);
        for (Statement statement : whileSt.getBody()) {
            statement.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(Array array, TP param) {
        array.getType().accept(this, param);
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
        functionType.getReturnType().accept(this, param);
        for (VarDefinition definition : functionType.getArguments()) {
            definition.accept(this, param);
        }
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
        for (RecordField field: struct.getFields()) {
            field.accept(this, param);
        }
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
