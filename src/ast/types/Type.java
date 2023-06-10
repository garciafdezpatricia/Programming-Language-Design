package ast.types;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    boolean isLogical();

    Type arithmetic(Type other, ASTNode node);

    Type unaryMinus(ASTNode node);

    Type unaryNegation(ASTNode node);

    Type arithComparison(Type other, ASTNode node);

    Type logicComparison(Type other, ASTNode node);

    Type fieldAccess(String fieldName, ASTNode node);

    Type squareBrackets(Type indexer, ASTNode node);

    Type canCastTo(Type castTo, ASTNode node);

    Type parenthesis(List<Type> paramsTypes, ASTNode node);

    Type canBeAssignedTo(Type other, ASTNode node);

    boolean isErrorType();

    boolean isBuiltIn();

    int numberOfBytes();

    char suffix();
}
