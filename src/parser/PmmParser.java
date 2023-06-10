// Generated from java-escape by ANTLR 4.11.1
package parser;

    import ast.expressions.*;
    import ast.definitions.*;
    import ast.statements.*;
    import ast.types.*;
    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, MANTISSA=38, 
		INT_CONSTANT=39, CHAR_CONSTANT=40, REAL_CONSTANT=41, ID=42, ONE_LINE_COMMENT=43, 
		MULTI_LINE_COMMENT=44, WS=45;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_statement = 2, RULE_body = 3, 
		RULE_type = 4, RULE_func_definition = 5, RULE_var_definition = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "statement", "body", "type", "func_definition", 
			"var_definition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "'['", "']'", 
			"'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>='", "'<='", "'=='", 
			"'<'", "'>'", "'!='", "'&&'", "'||'", "','", "'print'", "';'", "'input'", 
			"'='", "'return'", "'if'", "'else'", "'while'", "'int'", "'double'", 
			"'char'", "'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "MANTISSA", "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", 
			"ID", "ONE_LINE_COMMENT", "MULTI_LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public FuncDefinition main;
		public Var_definitionContext v;
		public Func_definitionContext f;
		public Token MAIN;
		public Var_definitionContext v2;
		public StatementContext st;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<Func_definitionContext> func_definition() {
			return getRuleContexts(Func_definitionContext.class);
		}
		public Func_definitionContext func_definition(int i) {
			return getRuleContext(Func_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).ast =  new Program(0,0); 
			setState(23);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(21);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(15);
						((ProgramContext)_localctx).v = var_definition();
						 for (VarDefinition vd : ((ProgramContext)_localctx).v.ast) _localctx.ast.addDefinition(vd); 
						}
						break;
					case T__0:
						{
						setState(18);
						((ProgramContext)_localctx).f = func_definition();
						 _localctx.ast.addDefinition(((ProgramContext)_localctx).f.ast); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(26);
			match(T__0);
			setState(27);
			((ProgramContext)_localctx).MAIN = match(T__1);
			setState(28);
			match(T__2);
			setState(29);
			match(T__3);
			setState(30);
			match(T__4);
			((ProgramContext)_localctx).main =  new FuncDefinition(((ProgramContext)_localctx).MAIN.getLine(), ((ProgramContext)_localctx).MAIN.getCharPositionInLine()+1,
			                                                new FunctionType(((ProgramContext)_localctx).MAIN.getLine(), ((ProgramContext)_localctx).MAIN.getCharPositionInLine()+1, new ArrayList<>(),
			                                                                        VoidType.getInstance())
			                                                , (((ProgramContext)_localctx).MAIN!=null?((ProgramContext)_localctx).MAIN.getText():null)); 
			setState(32);
			match(T__5);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					((ProgramContext)_localctx).v2 = var_definition();
					for (VarDefinition vd : ((ProgramContext)_localctx).v2.ast) _localctx.main.addDefinition(vd);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 8258483918856L) != 0) {
				{
				{
				setState(41);
				((ProgramContext)_localctx).st = statement();
				 _localctx.main.addStatement(((ProgramContext)_localctx).st.ast); 
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(T__6);
			_localctx.ast.addDefinition(_localctx.main); 
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext left;
		public ExpressionContext exp;
		public TypeContext type;
		public Token ID;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Token OP;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(54);
				match(T__2);
				setState(55);
				((ExpressionContext)_localctx).exp = expression(0);
				setState(56);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).exp.ast; 
				}
				break;
			case 2:
				{
				setState(59);
				match(T__2);
				setState(60);
				((ExpressionContext)_localctx).type = type();
				setState(61);
				match(T__3);
				setState(62);
				((ExpressionContext)_localctx).exp = expression(12);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).type.ast, ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 3:
				{
				setState(65);
				match(T__10);
				setState(66);
				((ExpressionContext)_localctx).exp = expression(11);
				((ExpressionContext)_localctx).ast =  new Minus(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 4:
				{
				setState(69);
				match(T__11);
				setState(70);
				((ExpressionContext)_localctx).exp = expression(10);
				 ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast); 
				}
				break;
			case 5:
				{
				setState(73);
				((ExpressionContext)_localctx).ID = match(ID);
				FuncInvocation funcInv = new FuncInvocation(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getText())); 
				setState(75);
				match(T__2);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337214472L) != 0) {
					{
					setState(76);
					((ExpressionContext)_localctx).exp1 = expression(0);
					funcInv.addExpression(((ExpressionContext)_localctx).exp1.ast);
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__24) {
						{
						{
						setState(78);
						match(T__24);
						setState(79);
						((ExpressionContext)_localctx).exp2 = expression(0);
						funcInv.addExpression(((ExpressionContext)_localctx).exp2.ast);
						}
						}
						setState(86);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(89);
				match(T__3);
				((ExpressionContext)_localctx).ast =  funcInv; 
				}
				break;
			case 6:
				{
				setState(91);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(), ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt(((ExpressionContext)_localctx).INT_CONSTANT.getText())); 
				}
				break;
			case 7:
				{
				setState(93);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(), ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar(((ExpressionContext)_localctx).CHAR_CONSTANT.getText())); 
				}
				break;
			case 8:
				{
				setState(95);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(), ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal(((ExpressionContext)_localctx).REAL_CONSTANT.getText()));
				}
				break;
			case 9:
				{
				setState(97);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, ((ExpressionContext)_localctx).ID.getText()); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((ExpressionContext)_localctx).right = expression(10);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(), ((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(107);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__15) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						((ExpressionContext)_localctx).right = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(), ((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(112);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(113);
						((ExpressionContext)_localctx).right = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ArithComparison(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(), ((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null)); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(117);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						((ExpressionContext)_localctx).right = expression(7);
						 ((ExpressionContext)_localctx).ast =  new LogComparison(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(), ((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null));
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(122);
						match(T__7);
						setState(123);
						((ExpressionContext)_localctx).right = expression(0);
						setState(124);
						match(T__8);
						((ExpressionContext)_localctx).ast =  new ArrayIndexer(((ExpressionContext)_localctx).left.ast.getLine(), ((ExpressionContext)_localctx).left.ast.getColumn(), ((ExpressionContext)_localctx).left.ast, ((ExpressionContext)_localctx).right.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(128);
						match(T__9);
						setState(129);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).exp.ast.getLine(), ((ExpressionContext)_localctx).exp.ast.getColumn(), ((ExpressionContext)_localctx).exp.ast, ((ExpressionContext)_localctx).ID.getText()); 
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement ast;
		public Token PRINT;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public Token INPUT;
		public BodyContext b1;
		public BodyContext b2;
		public ExpressionContext exp;
		public BodyContext b;
		public Token ID;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((StatementContext)_localctx).PRINT = match(T__25);
				Print print = new Print(((StatementContext)_localctx).PRINT.getLine(), ((StatementContext)_localctx).PRINT.getCharPositionInLine()+1); 
				setState(138);
				((StatementContext)_localctx).exp1 = expression(0);
				print.addExpression(((StatementContext)_localctx).exp1.ast); 
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(140);
					match(T__24);
					setState(141);
					((StatementContext)_localctx).exp2 = expression(0);
					print.addExpression(((StatementContext)_localctx).exp2.ast);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(T__26);
				((StatementContext)_localctx).ast =  print; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				((StatementContext)_localctx).INPUT = match(T__27);
				Input input = new Input(((StatementContext)_localctx).INPUT.getLine(), ((StatementContext)_localctx).INPUT.getCharPositionInLine()+1); 
				setState(154);
				((StatementContext)_localctx).exp1 = expression(0);
				input.addExpression(((StatementContext)_localctx).exp1.ast); 
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(156);
					match(T__24);
					setState(157);
					((StatementContext)_localctx).exp2 = expression(0);
					input.addExpression(((StatementContext)_localctx).exp2.ast); 
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				match(T__26);
				((StatementContext)_localctx).ast =  input; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(169);
				match(T__28);
				setState(170);
				((StatementContext)_localctx).exp2 = expression(0);
				setState(171);
				match(T__26);
				((StatementContext)_localctx).ast =  new Assignment(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).exp2.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				match(T__29);
				setState(175);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(176);
				match(T__26);
				((StatementContext)_localctx).ast =  new Return(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(T__30);
				setState(180);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(181);
				match(T__4);
				setState(182);
				((StatementContext)_localctx).b1 = body();
				IfStatement ifs = new IfStatement(((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn(), ((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).b1.ast);
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(184);
					match(T__31);
					setState(185);
					match(T__4);
					setState(186);
					((StatementContext)_localctx).b2 = body();
					ifs.setElse(((StatementContext)_localctx).b2.ast); 
					}
					break;
				}
				((StatementContext)_localctx).ast =  ifs; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(193);
				match(T__32);
				setState(194);
				((StatementContext)_localctx).exp = expression(0);
				setState(195);
				match(T__4);
				setState(196);
				((StatementContext)_localctx).b = body();
				((StatementContext)_localctx).ast =  new While(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).b.ast);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				((StatementContext)_localctx).ID = match(ID);
				FuncInvocation funcInv = new FuncInvocation(((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine()+1, new Variable(((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine()+1, ((StatementContext)_localctx).ID.getText())); 
				setState(201);
				match(T__2);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8246337214472L) != 0) {
					{
					setState(202);
					((StatementContext)_localctx).exp1 = expression(0);
					funcInv.addExpression(((StatementContext)_localctx).exp1.ast);
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__24) {
						{
						{
						setState(204);
						match(T__24);
						setState(205);
						((StatementContext)_localctx).exp2 = expression(0);
						funcInv.addExpression(((StatementContext)_localctx).exp2.ast);
						}
						}
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(215);
				match(T__3);
				setState(216);
				match(T__26);
				((StatementContext)_localctx).ast =  funcInv; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext st1;
		public StatementContext st2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__10:
			case T__11:
			case T__25:
			case T__27:
			case T__29:
			case T__30:
			case T__32:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				((BodyContext)_localctx).st1 = statement();
				_localctx.ast.add(((BodyContext)_localctx).st1.ast);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(223);
				match(T__5);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 8258483918856L) != 0) {
					{
					{
					setState(224);
					((BodyContext)_localctx).st2 = statement();
					_localctx.ast.add(((BodyContext)_localctx).st2.ast);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(T__6);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> fields = new ArrayList<RecordField>();
		public Struct struct;
		public IntLiteral size;
		public Token ST;
		public Token F1;
		public Token F2;
		public TypeContext t1;
		public Token SIZE;
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(T__33);
				((TypeContext)_localctx).ast =  Int.getInstance();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(T__34);
				((TypeContext)_localctx).ast =  Real.getInstance();
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(T__35);
				((TypeContext)_localctx).ast =  Char.getInstance();
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				((TypeContext)_localctx).ST = match(T__36);
				 ((TypeContext)_localctx).struct =  new Struct(((TypeContext)_localctx).ST.getLine(), ((TypeContext)_localctx).ST.getCharPositionInLine()+1); 
				setState(243);
				match(T__5);
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(244);
					((TypeContext)_localctx).F1 = match(ID);
					 for (RecordField field : _localctx.fields) { //for fields in separate lines
					                    ErrorType e;
					                    if (field.getName().equals((((TypeContext)_localctx).F1!=null?((TypeContext)_localctx).F1.getText():null)))
					                        e = new ErrorType(((TypeContext)_localctx).F1.getLine(), ((TypeContext)_localctx).F1.getCharPositionInLine()+1, "Error in line: "
					                        + ((TypeContext)_localctx).F1.getLine() + " column: " + ((TypeContext)_localctx).F1.getCharPositionInLine()+1 +
					                        ". Field with identifier '"  + (((TypeContext)_localctx).F1!=null?((TypeContext)_localctx).F1.getText():null) + "' already defined in scope");
					                   }
					                
					_localctx.fields.add(new RecordField(((TypeContext)_localctx).F1.getLine(), ((TypeContext)_localctx).F1.getCharPositionInLine()+1, null, (((TypeContext)_localctx).F1!=null?((TypeContext)_localctx).F1.getText():null))); 
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__24) {
						{
						{
						setState(247);
						match(T__24);
						setState(248);
						((TypeContext)_localctx).F2 = match(ID);
						 for (RecordField field : _localctx.fields) {//for consecutive declared fields
						                    ErrorType e;
						                    if (field.getName().equals((((TypeContext)_localctx).F2!=null?((TypeContext)_localctx).F2.getText():null)))
						                        e = new ErrorType(((TypeContext)_localctx).F2.getLine(), ((TypeContext)_localctx).F2.getCharPositionInLine()+1, "Error in line: "
						                        + ((TypeContext)_localctx).F2.getLine() + " column: " + ((TypeContext)_localctx).F2.getCharPositionInLine()+1 +
						                        ". Field with identifier '"  + (((TypeContext)_localctx).F2!=null?((TypeContext)_localctx).F2.getText():null) + "' already defined in scope");
						                   }
						                
						_localctx.fields.add(new RecordField(((TypeContext)_localctx).F2.getLine(), ((TypeContext)_localctx).F2.getCharPositionInLine()+1, null, (((TypeContext)_localctx).F2!=null?((TypeContext)_localctx).F2.getText():null))); 
						}
						}
						setState(255);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(256);
					match(T__4);
					setState(257);
					((TypeContext)_localctx).t1 = type();
					setState(258);
					match(T__26);
					for (RecordField fd : _localctx.fields) {
					            if (fd.getType() == null)
					                fd.setType(((TypeContext)_localctx).t1.ast);
					        }
					}
					}
					setState(263); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(265);
				match(T__6);
				_localctx.struct.setFields(_localctx.fields); 
				((TypeContext)_localctx).ast =  _localctx.struct; 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(269);
				match(T__7);
				setState(270);
				((TypeContext)_localctx).SIZE = match(INT_CONSTANT);
				setState(271);
				match(T__8);
				}
				setState(273);
				((TypeContext)_localctx).t = type();
				((TypeContext)_localctx).ast =  new Array(((TypeContext)_localctx).SIZE.getLine(), ((TypeContext)_localctx).SIZE.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((TypeContext)_localctx).SIZE!=null?((TypeContext)_localctx).SIZE.getText():null)), ((TypeContext)_localctx).t.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public List<VarDefinition> args = new ArrayList<VarDefinition>();
		public FunctionType funcType;
		public Type retType;
		public Token NAME;
		public Token ARG1;
		public TypeContext t1;
		public Token ARG2;
		public TypeContext t2;
		public TypeContext t;
		public Var_definitionContext def;
		public StatementContext st;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunc_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__0);
			setState(279);
			((Func_definitionContext)_localctx).NAME = match(ID);
			setState(280);
			match(T__2);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(281);
				((Func_definitionContext)_localctx).ARG1 = match(ID);
				setState(282);
				match(T__4);
				setState(283);
				((Func_definitionContext)_localctx).t1 = type();
				 _localctx.args.add(new VarDefinition(((Func_definitionContext)_localctx).ARG1.getLine(), ((Func_definitionContext)_localctx).ARG1.getCharPositionInLine()+1, ((Func_definitionContext)_localctx).t1.ast, (((Func_definitionContext)_localctx).ARG1!=null?((Func_definitionContext)_localctx).ARG1.getText():null)));
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(285);
					match(T__24);
					setState(286);
					((Func_definitionContext)_localctx).ARG2 = match(ID);
					setState(287);
					match(T__4);
					setState(288);
					((Func_definitionContext)_localctx).t2 = type();

					                    for (VarDefinition var : _localctx.args){
					                        ErrorType e;
					                        if (var.getName().equals((((Func_definitionContext)_localctx).ARG2!=null?((Func_definitionContext)_localctx).ARG2.getText():null)))
					                            e = new ErrorType(((Func_definitionContext)_localctx).ARG2.getLine(), ((Func_definitionContext)_localctx).ARG2.getCharPositionInLine()+1,
					                            "Error in line: " + ((Func_definitionContext)_localctx).ARG2.getLine() + " column: " + ((Func_definitionContext)_localctx).ARG2.getCharPositionInLine()+1 +
					                            ". Argument with identifier '" + (((Func_definitionContext)_localctx).ARG2!=null?((Func_definitionContext)_localctx).ARG2.getText():null) + "' already defined in scope");
					                    }
					               
					 _localctx.args.add(new VarDefinition(((Func_definitionContext)_localctx).ARG2.getLine(), ((Func_definitionContext)_localctx).ARG2.getCharPositionInLine()+1, ((Func_definitionContext)_localctx).t2.ast, (((Func_definitionContext)_localctx).ARG2!=null?((Func_definitionContext)_localctx).ARG2.getText():null))); 
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(299);
			match(T__3);
			setState(300);
			match(T__4);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 257698038016L) != 0) {
				{
				setState(301);
				((Func_definitionContext)_localctx).t = type();
				 ((Func_definitionContext)_localctx).retType =  ((Func_definitionContext)_localctx).t.ast; 
				}
			}

			 if (_localctx.retType == null) ((Func_definitionContext)_localctx).retType =  VoidType.getInstance(); 
			 ((Func_definitionContext)_localctx).funcType =  new FunctionType(((Func_definitionContext)_localctx).NAME.getLine(), ((Func_definitionContext)_localctx).NAME.getCharPositionInLine()+1, _localctx.args, _localctx.retType); 
			 ((Func_definitionContext)_localctx).ast =  new FuncDefinition(((Func_definitionContext)_localctx).NAME.getLine(), ((Func_definitionContext)_localctx).NAME.getCharPositionInLine()+1, _localctx.funcType, (((Func_definitionContext)_localctx).NAME!=null?((Func_definitionContext)_localctx).NAME.getText():null)); 
			setState(309);
			match(T__5);
			setState(315);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(310);
					((Func_definitionContext)_localctx).def = var_definition();
					 for(VarDefinition vd : ((Func_definitionContext)_localctx).def.ast) _localctx.ast.addDefinition(vd); 
					}
					} 
				}
				setState(317);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 8258483918856L) != 0) {
				{
				{
				setState(318);
				((Func_definitionContext)_localctx).st = statement();
				 _localctx.ast.addStatement(((Func_definitionContext)_localctx).st.ast); 
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Token VAR1;
		public Token VAR2;
		public TypeContext t1;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVar_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			((Var_definitionContext)_localctx).VAR1 = match(ID);
			_localctx.ast.add(new VarDefinition(((Var_definitionContext)_localctx).VAR1.getLine(), ((Var_definitionContext)_localctx).VAR1.getCharPositionInLine()+1, null, (((Var_definitionContext)_localctx).VAR1!=null?((Var_definitionContext)_localctx).VAR1.getText():null)));
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(330);
				match(T__24);
				setState(331);
				((Var_definitionContext)_localctx).VAR2 = match(ID);

				            for (VarDefinition var : _localctx.ast){ // if the list already contains this name raise an error
				                ErrorType e;
				                if (var.getName().equals((((Var_definitionContext)_localctx).VAR2!=null?((Var_definitionContext)_localctx).VAR2.getText():null)))
				                    e = new ErrorType(((Var_definitionContext)_localctx).VAR2.getLine(), ((Var_definitionContext)_localctx).VAR2.getCharPositionInLine()+1,
				                    "Error in line: " + ((Var_definitionContext)_localctx).VAR2.getLine() + " column: " + ((Var_definitionContext)_localctx).VAR2.getCharPositionInLine()+1 +
				                    ". Variable with identifier '"  + (((Var_definitionContext)_localctx).VAR2!=null?((Var_definitionContext)_localctx).VAR2.getText():null) + "' is already defined in the scope");
				            }
				            _localctx.ast.add(new VarDefinition(((Var_definitionContext)_localctx).VAR2.getLine(), ((Var_definitionContext)_localctx).VAR2.getCharPositionInLine()+1, null, (((Var_definitionContext)_localctx).VAR2!=null?((Var_definitionContext)_localctx).VAR2.getText():null)));
				        
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			match(T__4);
			setState(339);
			((Var_definitionContext)_localctx).t1 = type();
			setState(340);
			match(T__26);
			for(VarDefinition varDef : _localctx.ast) {varDef.setType(((Var_definitionContext)_localctx).t1.ast);};
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0158\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u0016"+
		"\b\u0000\n\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000%\b\u0000\n\u0000\f\u0000(\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000-\b\u0000\n\u0000\f\u00000\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001S\b\u0001\n\u0001\f\u0001"+
		"V\t\u0001\u0003\u0001X\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001d\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0084\b\u0001\n\u0001\f\u0001"+
		"\u0087\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0091\b\u0002\n\u0002"+
		"\f\u0002\u0094\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u00a1\b\u0002\n\u0002\f\u0002\u00a4\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u00be\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00d1\b\u0002\n\u0002\f\u0002\u00d4\t\u0002\u0003\u0002"+
		"\u00d6\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00db\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u00e4\b\u0003\n\u0003\f\u0003\u00e7\t\u0003"+
		"\u0001\u0003\u0003\u0003\u00ea\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u00fc\b\u0004\n\u0004\f\u0004\u00ff\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0106"+
		"\b\u0004\u000b\u0004\f\u0004\u0107\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u0115\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0125\b\u0005\n\u0005\f\u0005\u0128\t\u0005\u0003\u0005\u012a"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0131\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u013a\b\u0005\n\u0005\f\u0005"+
		"\u013d\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0142\b"+
		"\u0005\n\u0005\f\u0005\u0145\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u014e\b\u0006"+
		"\n\u0006\f\u0006\u0151\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0000\u0001\u0002\u0007\u0000\u0002\u0004"+
		"\u0006\b\n\f\u0000\u0004\u0001\u0000\r\u000f\u0002\u0000\u000b\u000b\u0010"+
		"\u0010\u0001\u0000\u0011\u0016\u0001\u0000\u0017\u0018\u017d\u0000\u000e"+
		"\u0001\u0000\u0000\u0000\u0002c\u0001\u0000\u0000\u0000\u0004\u00da\u0001"+
		"\u0000\u0000\u0000\u0006\u00e9\u0001\u0000\u0000\u0000\b\u0114\u0001\u0000"+
		"\u0000\u0000\n\u0116\u0001\u0000\u0000\u0000\f\u0148\u0001\u0000\u0000"+
		"\u0000\u000e\u0017\u0006\u0000\uffff\uffff\u0000\u000f\u0010\u0003\f\u0006"+
		"\u0000\u0010\u0011\u0006\u0000\uffff\uffff\u0000\u0011\u0016\u0001\u0000"+
		"\u0000\u0000\u0012\u0013\u0003\n\u0005\u0000\u0013\u0014\u0006\u0000\uffff"+
		"\uffff\u0000\u0014\u0016\u0001\u0000\u0000\u0000\u0015\u000f\u0001\u0000"+
		"\u0000\u0000\u0015\u0012\u0001\u0000\u0000\u0000\u0016\u0019\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c\u0005\u0002"+
		"\u0000\u0000\u001c\u001d\u0005\u0003\u0000\u0000\u001d\u001e\u0005\u0004"+
		"\u0000\u0000\u001e\u001f\u0005\u0005\u0000\u0000\u001f \u0006\u0000\uffff"+
		"\uffff\u0000 &\u0005\u0006\u0000\u0000!\"\u0003\f\u0006\u0000\"#\u0006"+
		"\u0000\uffff\uffff\u0000#%\u0001\u0000\u0000\u0000$!\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'.\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0003"+
		"\u0004\u0002\u0000*+\u0006\u0000\uffff\uffff\u0000+-\u0001\u0000\u0000"+
		"\u0000,)\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000012\u0005\u0007\u0000\u000023\u0006\u0000\uffff\uffff"+
		"\u000034\u0005\u0000\u0000\u00014\u0001\u0001\u0000\u0000\u000056\u0006"+
		"\u0001\uffff\uffff\u000067\u0005\u0003\u0000\u000078\u0003\u0002\u0001"+
		"\u000089\u0005\u0004\u0000\u00009:\u0006\u0001\uffff\uffff\u0000:d\u0001"+
		"\u0000\u0000\u0000;<\u0005\u0003\u0000\u0000<=\u0003\b\u0004\u0000=>\u0005"+
		"\u0004\u0000\u0000>?\u0003\u0002\u0001\f?@\u0006\u0001\uffff\uffff\u0000"+
		"@d\u0001\u0000\u0000\u0000AB\u0005\u000b\u0000\u0000BC\u0003\u0002\u0001"+
		"\u000bCD\u0006\u0001\uffff\uffff\u0000Dd\u0001\u0000\u0000\u0000EF\u0005"+
		"\f\u0000\u0000FG\u0003\u0002\u0001\nGH\u0006\u0001\uffff\uffff\u0000H"+
		"d\u0001\u0000\u0000\u0000IJ\u0005*\u0000\u0000JK\u0006\u0001\uffff\uffff"+
		"\u0000KW\u0005\u0003\u0000\u0000LM\u0003\u0002\u0001\u0000MT\u0006\u0001"+
		"\uffff\uffff\u0000NO\u0005\u0019\u0000\u0000OP\u0003\u0002\u0001\u0000"+
		"PQ\u0006\u0001\uffff\uffff\u0000QS\u0001\u0000\u0000\u0000RN\u0001\u0000"+
		"\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000"+
		"WL\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0004\u0000\u0000Zd\u0006\u0001\uffff\uffff\u0000[\\\u0005"+
		"\'\u0000\u0000\\d\u0006\u0001\uffff\uffff\u0000]^\u0005(\u0000\u0000^"+
		"d\u0006\u0001\uffff\uffff\u0000_`\u0005)\u0000\u0000`d\u0006\u0001\uffff"+
		"\uffff\u0000ab\u0005*\u0000\u0000bd\u0006\u0001\uffff\uffff\u0000c5\u0001"+
		"\u0000\u0000\u0000c;\u0001\u0000\u0000\u0000cA\u0001\u0000\u0000\u0000"+
		"cE\u0001\u0000\u0000\u0000cI\u0001\u0000\u0000\u0000c[\u0001\u0000\u0000"+
		"\u0000c]\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000ca\u0001\u0000"+
		"\u0000\u0000d\u0085\u0001\u0000\u0000\u0000ef\n\t\u0000\u0000fg\u0007"+
		"\u0000\u0000\u0000gh\u0003\u0002\u0001\nhi\u0006\u0001\uffff\uffff\u0000"+
		"i\u0084\u0001\u0000\u0000\u0000jk\n\b\u0000\u0000kl\u0007\u0001\u0000"+
		"\u0000lm\u0003\u0002\u0001\tmn\u0006\u0001\uffff\uffff\u0000n\u0084\u0001"+
		"\u0000\u0000\u0000op\n\u0007\u0000\u0000pq\u0007\u0002\u0000\u0000qr\u0003"+
		"\u0002\u0001\brs\u0006\u0001\uffff\uffff\u0000s\u0084\u0001\u0000\u0000"+
		"\u0000tu\n\u0006\u0000\u0000uv\u0007\u0003\u0000\u0000vw\u0003\u0002\u0001"+
		"\u0007wx\u0006\u0001\uffff\uffff\u0000x\u0084\u0001\u0000\u0000\u0000"+
		"yz\n\u000e\u0000\u0000z{\u0005\b\u0000\u0000{|\u0003\u0002\u0001\u0000"+
		"|}\u0005\t\u0000\u0000}~\u0006\u0001\uffff\uffff\u0000~\u0084\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\n\r\u0000\u0000\u0080\u0081\u0005\n\u0000\u0000"+
		"\u0081\u0082\u0005*\u0000\u0000\u0082\u0084\u0006\u0001\uffff\uffff\u0000"+
		"\u0083e\u0001\u0000\u0000\u0000\u0083j\u0001\u0000\u0000\u0000\u0083o"+
		"\u0001\u0000\u0000\u0000\u0083t\u0001\u0000\u0000\u0000\u0083y\u0001\u0000"+
		"\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0003\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0005\u001a\u0000\u0000\u0089\u008a\u0006\u0002"+
		"\uffff\uffff\u0000\u008a\u008b\u0003\u0002\u0001\u0000\u008b\u0092\u0006"+
		"\u0002\uffff\uffff\u0000\u008c\u008d\u0005\u0019\u0000\u0000\u008d\u008e"+
		"\u0003\u0002\u0001\u0000\u008e\u008f\u0006\u0002\uffff\uffff\u0000\u008f"+
		"\u0091\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u001b\u0000\u0000\u0096"+
		"\u0097\u0006\u0002\uffff\uffff\u0000\u0097\u00db\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u001c\u0000\u0000\u0099\u009a\u0006\u0002\uffff\uffff"+
		"\u0000\u009a\u009b\u0003\u0002\u0001\u0000\u009b\u00a2\u0006\u0002\uffff"+
		"\uffff\u0000\u009c\u009d\u0005\u0019\u0000\u0000\u009d\u009e\u0003\u0002"+
		"\u0001\u0000\u009e\u009f\u0006\u0002\uffff\uffff\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u009c\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005\u001b\u0000\u0000\u00a6\u00a7\u0006"+
		"\u0002\uffff\uffff\u0000\u00a7\u00db\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0003\u0002\u0001\u0000\u00a9\u00aa\u0005\u001d\u0000\u0000\u00aa\u00ab"+
		"\u0003\u0002\u0001\u0000\u00ab\u00ac\u0005\u001b\u0000\u0000\u00ac\u00ad"+
		"\u0006\u0002\uffff\uffff\u0000\u00ad\u00db\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0005\u001e\u0000\u0000\u00af\u00b0\u0003\u0002\u0001\u0000\u00b0"+
		"\u00b1\u0005\u001b\u0000\u0000\u00b1\u00b2\u0006\u0002\uffff\uffff\u0000"+
		"\u00b2\u00db\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000"+
		"\u00b4\u00b5\u0003\u0002\u0001\u0000\u00b5\u00b6\u0005\u0005\u0000\u0000"+
		"\u00b6\u00b7\u0003\u0006\u0003\u0000\u00b7\u00bd\u0006\u0002\uffff\uffff"+
		"\u0000\u00b8\u00b9\u0005 \u0000\u0000\u00b9\u00ba\u0005\u0005\u0000\u0000"+
		"\u00ba\u00bb\u0003\u0006\u0003\u0000\u00bb\u00bc\u0006\u0002\uffff\uffff"+
		"\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0006\u0002\uffff\uffff\u0000\u00c0\u00db\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005!\u0000\u0000\u00c2\u00c3\u0003\u0002\u0001"+
		"\u0000\u00c3\u00c4\u0005\u0005\u0000\u0000\u00c4\u00c5\u0003\u0006\u0003"+
		"\u0000\u00c5\u00c6\u0006\u0002\uffff\uffff\u0000\u00c6\u00db\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0005*\u0000\u0000\u00c8\u00c9\u0006\u0002\uffff"+
		"\uffff\u0000\u00c9\u00d5\u0005\u0003\u0000\u0000\u00ca\u00cb\u0003\u0002"+
		"\u0001\u0000\u00cb\u00d2\u0006\u0002\uffff\uffff\u0000\u00cc\u00cd\u0005"+
		"\u0019\u0000\u0000\u00cd\u00ce\u0003\u0002\u0001\u0000\u00ce\u00cf\u0006"+
		"\u0002\uffff\uffff\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u0004\u0000\u0000\u00d8\u00d9"+
		"\u0005\u001b\u0000\u0000\u00d9\u00db\u0006\u0002\uffff\uffff\u0000\u00da"+
		"\u0088\u0001\u0000\u0000\u0000\u00da\u0098\u0001\u0000\u0000\u0000\u00da"+
		"\u00a8\u0001\u0000\u0000\u0000\u00da\u00ae\u0001\u0000\u0000\u0000\u00da"+
		"\u00b3\u0001\u0000\u0000\u0000\u00da\u00c1\u0001\u0000\u0000\u0000\u00da"+
		"\u00c7\u0001\u0000\u0000\u0000\u00db\u0005\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0003\u0004\u0002\u0000\u00dd\u00de\u0006\u0003\uffff\uffff\u0000"+
		"\u00de\u00ea\u0001\u0000\u0000\u0000\u00df\u00e5\u0005\u0006\u0000\u0000"+
		"\u00e0\u00e1\u0003\u0004\u0002\u0000\u00e1\u00e2\u0006\u0003\uffff\uffff"+
		"\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00ea\u0005\u0007\u0000"+
		"\u0000\u00e9\u00dc\u0001\u0000\u0000\u0000\u00e9\u00df\u0001\u0000\u0000"+
		"\u0000\u00ea\u0007\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\"\u0000\u0000"+
		"\u00ec\u0115\u0006\u0004\uffff\uffff\u0000\u00ed\u00ee\u0005#\u0000\u0000"+
		"\u00ee\u0115\u0006\u0004\uffff\uffff\u0000\u00ef\u00f0\u0005$\u0000\u0000"+
		"\u00f0\u0115\u0006\u0004\uffff\uffff\u0000\u00f1\u00f2\u0005%\u0000\u0000"+
		"\u00f2\u00f3\u0006\u0004\uffff\uffff\u0000\u00f3\u0105\u0005\u0006\u0000"+
		"\u0000\u00f4\u00f5\u0005*\u0000\u0000\u00f5\u00f6\u0006\u0004\uffff\uffff"+
		"\u0000\u00f6\u00fd\u0006\u0004\uffff\uffff\u0000\u00f7\u00f8\u0005\u0019"+
		"\u0000\u0000\u00f8\u00f9\u0005*\u0000\u0000\u00f9\u00fa\u0006\u0004\uffff"+
		"\uffff\u0000\u00fa\u00fc\u0006\u0004\uffff\uffff\u0000\u00fb\u00f7\u0001"+
		"\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0100\u0001"+
		"\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0101\u0005"+
		"\u0005\u0000\u0000\u0101\u0102\u0003\b\u0004\u0000\u0102\u0103\u0005\u001b"+
		"\u0000\u0000\u0103\u0104\u0006\u0004\uffff\uffff\u0000\u0104\u0106\u0001"+
		"\u0000\u0000\u0000\u0105\u00f4\u0001\u0000\u0000\u0000\u0106\u0107\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u0005"+
		"\u0007\u0000\u0000\u010a\u010b\u0006\u0004\uffff\uffff\u0000\u010b\u010c"+
		"\u0006\u0004\uffff\uffff\u0000\u010c\u0115\u0001\u0000\u0000\u0000\u010d"+
		"\u010e\u0005\b\u0000\u0000\u010e\u010f\u0005\'\u0000\u0000\u010f\u0110"+
		"\u0005\t\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0003"+
		"\b\u0004\u0000\u0112\u0113\u0006\u0004\uffff\uffff\u0000\u0113\u0115\u0001"+
		"\u0000\u0000\u0000\u0114\u00eb\u0001\u0000\u0000\u0000\u0114\u00ed\u0001"+
		"\u0000\u0000\u0000\u0114\u00ef\u0001\u0000\u0000\u0000\u0114\u00f1\u0001"+
		"\u0000\u0000\u0000\u0114\u010d\u0001\u0000\u0000\u0000\u0115\t\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005\u0001\u0000\u0000\u0117\u0118\u0005*\u0000"+
		"\u0000\u0118\u0129\u0005\u0003\u0000\u0000\u0119\u011a\u0005*\u0000\u0000"+
		"\u011a\u011b\u0005\u0005\u0000\u0000\u011b\u011c\u0003\b\u0004\u0000\u011c"+
		"\u0126\u0006\u0005\uffff\uffff\u0000\u011d\u011e\u0005\u0019\u0000\u0000"+
		"\u011e\u011f\u0005*\u0000\u0000\u011f\u0120\u0005\u0005\u0000\u0000\u0120"+
		"\u0121\u0003\b\u0004\u0000\u0121\u0122\u0006\u0005\uffff\uffff\u0000\u0122"+
		"\u0123\u0006\u0005\uffff\uffff\u0000\u0123\u0125\u0001\u0000\u0000\u0000"+
		"\u0124\u011d\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000"+
		"\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000"+
		"\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000"+
		"\u0129\u0119\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000"+
		"\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0005\u0004\u0000\u0000"+
		"\u012c\u0130\u0005\u0005\u0000\u0000\u012d\u012e\u0003\b\u0004\u0000\u012e"+
		"\u012f\u0006\u0005\uffff\uffff\u0000\u012f\u0131\u0001\u0000\u0000\u0000"+
		"\u0130\u012d\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0006\u0005\uffff\uffff"+
		"\u0000\u0133\u0134\u0006\u0005\uffff\uffff\u0000\u0134\u0135\u0006\u0005"+
		"\uffff\uffff\u0000\u0135\u013b\u0005\u0006\u0000\u0000\u0136\u0137\u0003"+
		"\f\u0006\u0000\u0137\u0138\u0006\u0005\uffff\uffff\u0000\u0138\u013a\u0001"+
		"\u0000\u0000\u0000\u0139\u0136\u0001\u0000\u0000\u0000\u013a\u013d\u0001"+
		"\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013b\u013c\u0001"+
		"\u0000\u0000\u0000\u013c\u0143\u0001\u0000\u0000\u0000\u013d\u013b\u0001"+
		"\u0000\u0000\u0000\u013e\u013f\u0003\u0004\u0002\u0000\u013f\u0140\u0006"+
		"\u0005\uffff\uffff\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013e"+
		"\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0146"+
		"\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0147"+
		"\u0005\u0007\u0000\u0000\u0147\u000b\u0001\u0000\u0000\u0000\u0148\u0149"+
		"\u0005*\u0000\u0000\u0149\u014f\u0006\u0006\uffff\uffff\u0000\u014a\u014b"+
		"\u0005\u0019\u0000\u0000\u014b\u014c\u0005*\u0000\u0000\u014c\u014e\u0006"+
		"\u0006\uffff\uffff\u0000\u014d\u014a\u0001\u0000\u0000\u0000\u014e\u0151"+
		"\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150"+
		"\u0001\u0000\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014f"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0005\u0005\u0000\u0000\u0153\u0154"+
		"\u0003\b\u0004\u0000\u0154\u0155\u0005\u001b\u0000\u0000\u0155\u0156\u0006"+
		"\u0006\uffff\uffff\u0000\u0156\r\u0001\u0000\u0000\u0000\u001a\u0015\u0017"+
		"&.TWc\u0083\u0085\u0092\u00a2\u00bd\u00d2\u00d5\u00da\u00e5\u00e9\u00fd"+
		"\u0107\u0114\u0126\u0129\u0130\u013b\u0143\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}