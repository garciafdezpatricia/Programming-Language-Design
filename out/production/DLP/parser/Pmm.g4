grammar Pmm;	
@header{
    import ast.expressions.*;
    import ast.definitions.*;
    import ast.statements.*;
    import ast.types.*;
    import ast.*;
}

//******** PROGRAM ***********

program returns [Program ast] locals [FuncDefinition main]:
           { $ast = new Program(0,0); } /* Program is going to have the first line and column always */
            (v=var_definition { for (VarDefinition vd : $v.ast) $ast.addDefinition(vd); }

            |f=func_definition{ $ast.addDefinition($f.ast); })*

            'def' MAIN='main' '(' ')' ':' {$main = new FuncDefinition($MAIN.getLine(), $MAIN.getCharPositionInLine()+1,
                                                new FunctionType($MAIN.getLine(), $MAIN.getCharPositionInLine()+1, new ArrayList<>(),
                                                                        VoidType.getInstance())
                                                , $MAIN.text); }
            '{' (v2=var_definition {for (VarDefinition vd : $v2.ast) $main.addDefinition(vd);})*
            (st=statement { $main.addStatement($st.ast); })* '}' {$ast.addDefinition($main); }
            EOF
       ;

//******** EXPRESSIONS ***********

expression returns [Expression ast]:
         '(' exp=expression ')'
         { $ast = $exp.ast; }

        | left=expression '[' right=expression ']'
        {$ast = new ArrayIndexer($left.ast.getLine(), $left.ast.getColumn(), $left.ast, $right.ast); }

        | exp=expression '.' ID
        {$ast = new FieldAccess($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $ID.getText()); }

        | '(' type ')' exp=expression
        {$ast = new Cast($exp.ast.getLine(), $exp.ast.getColumn(), $type.ast, $exp.ast); }

        | '-' exp=expression
        {$ast = new Minus($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }

        | '!' exp=expression
        { $ast = new Negation($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast); }

        | left=expression OP=('*'|'/'|'%') right=expression
        {$ast = new Arithmetic($left.ast.getLine(), $left.ast.getColumn(), $left.ast, $right.ast, $OP.text); }

        | left=expression OP=('+'|'-') right=expression
        { $ast = new Arithmetic($left.ast.getLine(), $left.ast.getColumn(), $left.ast, $right.ast, $OP.text); }

        | left=expression OP=('>='|'<='|'=='|'<'|'>'|'!=') right=expression
        { $ast = new ArithComparison($left.ast.getLine(), $left.ast.getColumn(), $left.ast, $right.ast, $OP.text); }

        | left=expression OP=('&&'|'||') right=expression
        { $ast = new LogComparison($left.ast.getLine(), $left.ast.getColumn(), $left.ast, $right.ast, $OP.text);}

        | ID {FuncInvocation funcInv = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.getText())); }
        '(' (exp1=expression {funcInv.addExpression($exp1.ast);}
        (',' exp2=expression {funcInv.addExpression($exp2.ast);})*)? ')' {$ast = funcInv; }

        | INT_CONSTANT
        { $ast = new IntLiteral($INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.getText())); }

        | CHAR_CONSTANT
        {$ast = new CharLiteral($CHAR_CONSTANT.getLine(), $CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.getText())); }

        | REAL_CONSTANT
        {$ast = new DoubleLiteral($REAL_CONSTANT.getLine(), $REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal($REAL_CONSTANT.getText()));}

        | ID
        { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.getText()); }
;


//******** STATEMENTS ***********

statement returns [Statement ast]:
        PRINT='print' {Print print = new Print($PRINT.getLine(), $PRINT.getCharPositionInLine()+1); }
        exp1=expression {print.addExpression($exp1.ast); }
        (',' exp2=expression {print.addExpression($exp2.ast);} )* ';' {$ast = print; }

        |INPUT='input' {Input input = new Input($INPUT.getLine(), $INPUT.getCharPositionInLine()+1); }
        exp1=expression {input.addExpression($exp1.ast); }
        (',' exp2=expression {input.addExpression($exp2.ast); } )* ';' {$ast = input; }

        | exp1=expression '=' exp2=expression ';' {$ast = new Assignment($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $exp2.ast); }

        | 'return' exp1=expression ';' {$ast = new Return($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast); }

        | 'if' exp1=expression ':' b1=body {IfStatement ifs = new IfStatement($exp1.ast.getLine(), $exp1.ast.getColumn(), $exp1.ast, $b1.ast);}
         ('else' ':' b2=body {ifs.setElse($b2.ast); })? {$ast = ifs; }

        | 'while' exp=expression ':' b=body {$ast = new While($exp.ast.getLine(), $exp.ast.getColumn(), $exp.ast, $b.ast);}

        | ID {FuncInvocation funcInv = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine()+1, new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.getText())); }
                '(' (exp1=expression {funcInv.addExpression($exp1.ast);}
                (',' exp2=expression {funcInv.addExpression($exp2.ast);})*)? ')' ';' {$ast = funcInv; }
;

//******** BODY ***********

body returns [List<Statement> ast = new ArrayList<Statement>()]:
        st1=statement
        {$ast.add($st1.ast);}

        | ('{'(st2=statement {$ast.add($st2.ast);} )* '}')
;


//******** TYPES ***********

type returns [Type ast] locals [List<RecordField> fields = new ArrayList<RecordField>(), Struct struct, IntLiteral size]:
        'int'
        {$ast = Int.getInstance();}

        | 'double'
        {$ast = Real.getInstance();}

        | 'char'
        {$ast = Char.getInstance();}

        | ST='struct' { $struct = new Struct($ST.getLine(), $ST.getCharPositionInLine()+1); }
        '{'
        (F1=ID
                { for (RecordField field : $fields) { //for fields in separate lines
                    ErrorType e;
                    if (field.getName().equals($F1.text))
                        e = new ErrorType($F1.getLine(), $F1.getCharPositionInLine()+1, "Error in line: "
                        + $F1.getLine() + " column: " + $F1.getCharPositionInLine()+1 +
                        ". Field with identifier '"  + $F1.text + "' already defined in scope");
                   }
                }
                {$fields.add(new RecordField($F1.getLine(), $F1.getCharPositionInLine()+1, null, $F1.text)); }

                (',' F2=ID
                { for (RecordField field : $fields) {//for consecutive declared fields
                    ErrorType e;
                    if (field.getName().equals($F2.text))
                        e = new ErrorType($F2.getLine(), $F2.getCharPositionInLine()+1, "Error in line: "
                        + $F2.getLine() + " column: " + $F2.getCharPositionInLine()+1 +
                        ". Field with identifier '"  + $F2.text + "' already defined in scope");
                   }
                }
                {$fields.add(new RecordField($F2.getLine(), $F2.getCharPositionInLine()+1, null, $F2.text)); }
                )*
        ':' t1=type ';'
        {for (RecordField fd : $fields) {
            if (fd.getType() == null)
                fd.setType($t1.ast);
        }}
        )+
        '}'
        {$struct.setFields($fields); } {$ast = $struct; }

        | ('[' SIZE=INT_CONSTANT ']')
        t=type {$ast = new Array($SIZE.getLine(), $SIZE.getCharPositionInLine()+1, LexerHelper.lexemeToInt($SIZE.text), $t.ast); }
;

//******** DEFINITIONS ***********

func_definition returns [FuncDefinition ast] locals [List<VarDefinition> args = new ArrayList<VarDefinition>(), FunctionType funcType, Type retType]:
         'def' NAME=ID '('
         (  ARG1=ID ':' t1=type
            { $args.add(new VarDefinition($ARG1.getLine(), $ARG1.getCharPositionInLine()+1, $t1.ast, $ARG1.text));}
           (',' ARG2=ID ':' t2=type
               {
                    for (VarDefinition var : $args){
                        ErrorType e;
                        if (var.getName().equals($ARG2.text))
                            e = new ErrorType($ARG2.getLine(), $ARG2.getCharPositionInLine()+1,
                            "Error in line: " + $ARG2.getLine() + " column: " + $ARG2.getCharPositionInLine()+1 +
                            ". Argument with identifier '" + $ARG2.text + "' already defined in scope");
                    }
               }
               { $args.add(new VarDefinition($ARG2.getLine(), $ARG2.getCharPositionInLine()+1, $t2.ast, $ARG2.text)); }
           )*
         )? ')' ':' (t=type { $retType = $t.ast; })? { if ($retType == null) $retType = VoidType.getInstance(); }

            { $funcType = new FunctionType($NAME.getLine(), $NAME.getCharPositionInLine()+1, $args, $retType); }
            { $ast = new FuncDefinition($NAME.getLine(), $NAME.getCharPositionInLine()+1, $funcType, $NAME.text); }
            '{' (def=var_definition { for(VarDefinition vd : $def.ast) $ast.addDefinition(vd); } )*
            (st=statement { $ast.addStatement($st.ast); })* '}'
;


var_definition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
        VAR1=ID {$ast.add(new VarDefinition($VAR1.getLine(), $VAR1.getCharPositionInLine()+1, null, $VAR1.text));}
        (',' VAR2=ID
        {
            for (VarDefinition var : $ast){ // if the list already contains this name raise an error
                ErrorType e;
                if (var.getName().equals($VAR2.text))
                    e = new ErrorType($VAR2.getLine(), $VAR2.getCharPositionInLine()+1,
                    "Error in line: " + $VAR2.getLine() + " column: " + $VAR2.getCharPositionInLine()+1 +
                    ". Variable with identifier '"  + $VAR2.text + "' is already defined in the scope");
            }
            $ast.add(new VarDefinition($VAR2.getLine(), $VAR2.getCharPositionInLine()+1, null, $VAR2.text));
        }
        )*
        ':' t1=type ';' {for(VarDefinition varDef : $ast) {varDef.setType($t1.ast);};}
;


/**************** LEXER ********************/
fragment
DIGIT: [0-9]
;

MANTISSA: [Ee] ('-'|'+')? INT_CONSTANT
;
  		 
INT_CONSTANT: ([1-9]+ DIGIT*) | '0'
            ;
CHAR_CONSTANT: ('\'' '\\' INT_CONSTANT '\'')
                | ('\'' .*? '\'')
                | '\'' '\\' ('n' | 't') '\''
;
REAL_CONSTANT: INT_CONSTANT '.' (DIGIT* | INT_CONSTANT) (MANTISSA)?
                | '.' (DIGIT* | INT_CONSTANT) (MANTISSA)?
                | INT_CONSTANT '.' (MANTISSA)?
                | INT_CONSTANT (MANTISSA)
;
ID: ('_' | [a-zA-Z])+ ('_' | [a-zA-Z] | DIGIT)*
;
ONE_LINE_COMMENT: '#' .*? ('\n' | EOF) -> skip
;
MULTI_LINE_COMMENT: '"""' .*? '"""' -> skip
;
WS: [\n\r\t ]+ -> skip
     ;