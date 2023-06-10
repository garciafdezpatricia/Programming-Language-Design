package codegenerator;

import ast.expressions.*;
import ast.types.Real;

/**
 * Only for expressions
 */
public class ValueCGVisitor extends AbstractCGVisitor<Object, Void>{

    private AddressCGVisitor addressCGVisitor;
    private CodeGenerator codeGenerator;
    public ValueCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public void setAddressCGVisitor(AddressCGVisitor visitor){
        this.addressCGVisitor = visitor;
    }

    /*
        value[[Variable: exp -> ID]] = address[[exp]]
                                        <load> exp.getType().suffix()
     */
    @Override
    public Void visit(Variable variable, Object param) {
        variable.accept(this.addressCGVisitor, param); // address[[exp]]
        codeGenerator.load(variable.getType());
        return null;
    }

    /*
        value[[ArithComparison: exp1 -> exp2 (operator) exp3]] =
            value[[exp2]]
            exp2.type.convertTo(exp1.type)
            value [[exp3]]
            exp3.type.convertTo(exp1.type)
            switch(operator){
                case "<": {<lt> exp2.type.suffix(); break;}
                case ">": {<gt> exp2.type.suffix(); break;}
                case "<=": {<le> exp2.type.suffix(); break;}
                case ">=": {<ge> exp2.type.suffix(); break;}
                case "==": {<eq> exp2.type.suffix(); break;}
                case "!=": {<ne> exp2.type.suffix(); break;}
            }
     */
    @Override
    public Void visit(ArithComparison arithComparison, Object param) {
        arithComparison.getLeft().accept(this, param);
        codeGenerator.convertTo(arithComparison.getLeft().getType(), arithComparison.getType());
        arithComparison.getRight().accept(this, param);
        codeGenerator.convertTo(arithComparison.getRight().getType(), arithComparison.getType());

        switch(arithComparison.getOperator()){
            case "<": {codeGenerator.lowerThan(arithComparison.getType()); break;}
            case ">": {codeGenerator.greaterThan(arithComparison.getType()); break;}
            case "<=": {codeGenerator.lowerOrEqualTo(arithComparison.getType()); break;}
            case ">=": {codeGenerator.greaterOrEqualTo(arithComparison.getType()); break;}
            case "==": {codeGenerator.equalTo(arithComparison.getType()); break;}
            case "!=": {codeGenerator.notEqualTo(arithComparison.getType()); break;}
        }
        return null;
    }

    /*
        value[[Arithmetic: exp1 -> exp2 (operator) exp3]] =
            value[[exp2]]
            exp2.type.convertTo(exp1.type)
            value[[exp3]]
            exp3.type.convertTo(exp1.type)
            switch(operator){
                case "+": {<add> exp1.type.suffix(); break;}
                case "-": {<sub> exp1.type.suffix(); break;}
                case "*": {<mul> exp1.type.suffix(); break;}
                case "/": {<div> exp1.type.suffix(); break;}
                case "%": {<div> exp1.type.suffix(); break;}
            }
     */
    @Override
    public Void visit(Arithmetic arithmetic, Object param) {
        arithmetic.getLeft().accept(this, param);
        codeGenerator.convertTo(arithmetic.getLeft().getType(), arithmetic.getType());

        arithmetic.getRight().accept(this, param);
        codeGenerator.convertTo(arithmetic.getRight().getType(), arithmetic.getType());

        switch(arithmetic.getOperator()){
            case "+": {codeGenerator.add(arithmetic.getType()); break;}
            case "-": {codeGenerator.sub(arithmetic.getType()); break;}
            case "*": {codeGenerator.mul(arithmetic.getType()); break;}
            case "/": {codeGenerator.div(arithmetic.getType()); break;}
            case "%": {codeGenerator.mod(arithmetic.getType()); break;}
        }
        return null;
    }

    /*
        value[[LogComparison: exp1 -> exp2 operator exp3]] =
            value[[exp2]]
            value[[exp3]]
            switch (operator){
                case "&&": {<and>; break;}
                case "||": {<or>; break;}
            }
     */
    @Override
    public Void visit(LogComparison logComparison, Object param) {
        logComparison.getLeft().accept(this, param);
        logComparison.getRight().accept(this, param);

        switch (logComparison.getOperator()){
            case "&&": {codeGenerator.and(); break;}
            case "||": {codeGenerator.or(); break;}
        }
        return null;
    }

    /*
        value[[Cast: exp1 -> type exp2]] =
            value[[exp2]]
            exp2.type.convertTo(type)
     */
    @Override
    public Void visit(Cast cast, Object param) {
        cast.getExpression().accept(this, param);
        codeGenerator.convertTo(cast.getExpression().getType(), cast.getCastTo());
        return null;
    }

    /*
        value[[IntLiteral: exp -> INTEGER]] =
            <pushi> INTEGER
     */

    @Override
    public Void visit(IntLiteral intLiteral, Object param) {
        codeGenerator.pushi(intLiteral.getValue());
        return null;
    }

    /*
        value[[CharLiteral: exp -> CHARACTER]] =
            <pushb> CHARACTER
     */
    @Override
    public Void visit(CharLiteral charLiteral, Object param) {
        codeGenerator.pushb(charLiteral.getType(), charLiteral);
        return null;
    }

    /*
        value[[DoubleLiteral: exp -> REAL]] =
            <pushf> REAL
     */
    @Override
    public Void visit(DoubleLiteral doubleLiteral, Object param) {
        codeGenerator.pushf(doubleLiteral.getValue());
        return null;
    }

    /* DO 0 - THE VALUE O PUT THE MINUS
        value[[Minus: exp1 -> exp2]] =
            <push> exp1.type.suffix() <0>
            value[[exp2]]
            <sub> exp1.type.suffix()
     */
    @Override
    public Void visit(Minus minus, Object param) {
        switch (minus.getType().suffix()){
            case 'i': {codeGenerator.pushi(0); break;}
            case 'f': {codeGenerator.pushf(0);break;}
            default: throw new RuntimeException(minus.getType() + " cant be applied a unary minus");
        }
        minus.getExp().accept(this, param);
        codeGenerator.sub(minus.getType());
        return null;
    }

    /*
        value[[Negation: exp1 -> exp2]] =
            value[[exp2]]
            <not>
     */
    @Override
    public Void visit(Negation negation, Object param) {
        negation.getExp().accept(this, param);
        codeGenerator.not();
        return null;
    }

    /*
        value[[FieldAcess: exp1 -> exp2 ID]] =
            address[[exp1]]
            <load> exp1.type.suffix()
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.accept(addressCGVisitor, param);
        codeGenerator.load(fieldAccess.getType());
        return null;
    }

    /*
        value[[ArrayIndexer: exp1 -> exp2 exp3]] =
            address[[exp1]]
            <load> exp1.type.suffix()
     */
    @Override
    public Void visit(ArrayIndexer arrayIndexer, Object param) {
        arrayIndexer.accept(addressCGVisitor, param);
        codeGenerator.load(arrayIndexer.getType());
        return null;
    }

    /*
        value[[FuncInvocation: exp1 -> exp2 exp3*]] =
            exp3*.forEach(param -> value[[param]])
            <call> exp2.name
     */
    @Override
    public Void visit(FuncInvocation funcInvocation, Object param) {
        for (Expression parameter : funcInvocation.getParameters()){
            parameter.accept(this, param);
        }
        // funcInvocation.getName() returns a variable and the 2nd getName() returns the String
        codeGenerator.call(funcInvocation.getName().getName());
        return null;
    }
}
