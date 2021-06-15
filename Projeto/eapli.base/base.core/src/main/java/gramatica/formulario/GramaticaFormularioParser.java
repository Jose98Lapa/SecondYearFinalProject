// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaFormularioParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OU=9, 
		E=10, EQ=11, NEQ=12, GT=13, LT=14, GTEQ=15, LTEQ=16, MAIS=17, MENOS=18, 
		MULT=19, DIV=20, MOD=21, POW=22, NOT=23, OPERADORATRIBUICAO=24, VARIAVEL=25, 
		SE=26, ENTAO=27, SENAO=28, END_SE=29, TIPODADOS=30, ELEMENTO=31, NUMERO=32, 
		REAL=33, NOME_FICHEIRO=34, TEXTO=35, STRING=36, DATA_DIA=37, DATA_MES=38, 
		DATA_ANO=39, DATAREGEX=40, COMMENT=41, COMMENTLINE=42, ESPACO=43;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_inicializacao = 2, RULE_atribuicao_atributo = 3, 
		RULE_get_atributo = 4, RULE_atribuicao = 5, RULE_expr = 6, RULE_tipo_dados = 7, 
		RULE_integer = 8, RULE_floate = 9, RULE_data = 10, RULE_identidade = 11, 
		RULE_if_stat = 12, RULE_condition_block = 13, RULE_stat_block = 14;
	private static String[] makeRuleNames() {
		return new String[] {
                "gramatica", "instrucao", "inicializacao", "atribuicao_atributo", "get_atributo",
			"atribuicao", "expr", "tipo_dados", "integer", "floate", "data", "identidade", 
			"if_stat", "condition_block", "stat_block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'atr'", "'['", "']'", "'('", "')'", "'\"'", 
			"'ou'", "'e'", "'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'^'", "'!'", "'->'", null, "'se'", "'entao'", "'senao'", 
			"'es'", null, "'ELEMENTO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "OU", "E", "EQ", 
			"NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", "MOD", 
			"POW", "NOT", "OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", "SENAO", 
			"END_SE", "TIPODADOS", "ELEMENTO", "NUMERO", "REAL", "NOME_FICHEIRO", 
			"TEXTO", "STRING", "DATA_DIA", "DATA_MES", "DATA_ANO", "DATAREGEX", "COMMENT", 
			"COMMENTLINE", "ESPACO"
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
	public String getGrammarFileName() { return "GramaticaFormulario.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaFormularioParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GramaticaContext extends ParserRuleContext {
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public GramaticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramatica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterGramatica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitGramatica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitGramatica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramaticaContext gramatica() throws RecognitionException {
		GramaticaContext _localctx = new GramaticaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gramatica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				instrucao();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0) );
			setState(36);
			match(T__1);
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

	public static class InstrucaoContext extends ParserRuleContext {
		public InicializacaoContext inicializacao() {
			return getRuleContext(InicializacaoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public Atribuicao_atributoContext atribuicao_atributo() {
			return getRuleContext(Atribuicao_atributoContext.class,0);
		}
		public InstrucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitInstrucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitInstrucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrucaoContext instrucao() throws RecognitionException {
		InstrucaoContext _localctx = new InstrucaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instrucao);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				inicializacao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				if_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				atribuicao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(42);
				atribuicao_atributo();
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

	public static class InicializacaoContext extends ParserRuleContext {
		public InicializacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacao; }
	 
		public InicializacaoContext() { }
		public void copyFrom(InicializacaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InicializacaoIdentContext extends InicializacaoContext {
		public TerminalNode TIPODADOS() { return getToken(GramaticaFormularioParser.TIPODADOS, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public InicializacaoIdentContext(InicializacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterInicializacaoIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitInicializacaoIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitInicializacaoIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InicializacaoAtribuicaoContext extends InicializacaoContext {
		public TerminalNode TIPODADOS() { return getToken(GramaticaFormularioParser.TIPODADOS, 0); }
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public InicializacaoAtribuicaoContext(InicializacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterInicializacaoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitInicializacaoAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitInicializacaoAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializacaoContext inicializacao() throws RecognitionException {
		InicializacaoContext _localctx = new InicializacaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inicializacao);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(TIPODADOS);
				setState(46);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(TIPODADOS);
				setState(48);
				atribuicao();
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

	public static class Atribuicao_atributoContext extends ParserRuleContext {
		public InicializacaoContext inicializacao() {
			return getRuleContext(InicializacaoContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaFormularioParser.OPERADORATRIBUICAO, 0); }
		public Get_atributoContext get_atributo() {
			return getRuleContext(Get_atributoContext.class,0);
		}
		public Atribuicao_atributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterAtribuicao_atributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitAtribuicao_atributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitAtribuicao_atributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atribuicao_atributoContext atribuicao_atributo() throws RecognitionException {
		Atribuicao_atributoContext _localctx = new Atribuicao_atributoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atribuicao_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			inicializacao();
			setState(52);
			match(OPERADORATRIBUICAO);
			setState(53);
			get_atributo();
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

	public static class Get_atributoContext extends ParserRuleContext {
		public Get_atributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_atributo; }
	 
		public Get_atributoContext() { }
		public void copyFrom(Get_atributoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Atr_atributoContext extends Get_atributoContext {
		public Token numero;
		public TerminalNode NUMERO() { return getToken(GramaticaFormularioParser.NUMERO, 0); }
		public Atr_atributoContext(Get_atributoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterAtr_atributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitAtr_atributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitAtr_atributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Get_atributoContext get_atributo() throws RecognitionException {
		Get_atributoContext _localctx = new Get_atributoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_get_atributo);
		try {
			_localctx = new Atr_atributoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__2);
			setState(56);
			match(T__3);
			setState(57);
			((Atr_atributoContext)_localctx).numero = match(NUMERO);
			setState(58);
			match(T__4);
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

	public static class AtribuicaoContext extends ParserRuleContext {
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
	 
		public AtribuicaoContext() { }
		public void copyFrom(AtribuicaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariavelExprContext extends AtribuicaoContext {
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaFormularioParser.OPERADORATRIBUICAO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariavelExprContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterVariavelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitVariavelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitVariavelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariavelVariavelContext extends AtribuicaoContext {
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaFormularioParser.OPERADORATRIBUICAO, 0); }
		public List<TerminalNode> TEXTO() { return getTokens(GramaticaFormularioParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(GramaticaFormularioParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaticaFormularioParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaticaFormularioParser.NUMERO, i);
		}
		public VariavelVariavelContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterVariavelVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitVariavelVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitVariavelVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atribuicao);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new VariavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				identidade();
				setState(61);
				match(OPERADORATRIBUICAO);
				setState(62);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VariavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				identidade();
				setState(65);
				match(OPERADORATRIBUICAO);
				setState(66);
				identidade();
				setState(67);
				match(T__5);
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(68);
					_la = _input.LA(1);
					if ( !(_la==NUMERO || _la==TEXTO) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(73);
				match(T__6);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public Tipo_dadosContext atom;
		public Tipo_dadosContext tipo_dados() {
			return getRuleContext(Tipo_dadosContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode OU() { return getToken(GramaticaFormularioParser.OU, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivModExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(GramaticaFormularioParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(GramaticaFormularioParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GramaticaFormularioParser.MOD, 0); }
		public MulDivModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterMulDivModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitMulDivModExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitMulDivModExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode POW() { return getToken(GramaticaFormularioParser.POW, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumDifExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAIS() { return getToken(GramaticaFormularioParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaFormularioParser.MENOS, 0); }
		public SumDifExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterSumDifExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitSumDifExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitSumDifExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelationalExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(GramaticaFormularioParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(GramaticaFormularioParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(GramaticaFormularioParser.LT, 0); }
		public TerminalNode GT() { return getToken(GramaticaFormularioParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(GramaticaFormularioParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(GramaticaFormularioParser.NEQ, 0); }
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode E() { return getToken(GramaticaFormularioParser.E, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(78);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(80);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(81);
						match(POW);
						setState(82);
						((PowExprContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(83);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(84);
						((MulDivModExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MulDivModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						((MulDivModExprContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(87);
						((SumDifExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAIS || _la==MENOS) ) {
							((SumDifExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						((SumDifExprContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(90);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((RelationalExprContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(93);
						((EqualExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						((EqualExprContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(96);
						match(E);
						setState(97);
						((AndExprContext)_localctx).right = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(99);
						match(OU);
						setState(100);
						((OrExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class Tipo_dadosContext extends ParserRuleContext {
		public Tipo_dadosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_dados; }
	 
		public Tipo_dadosContext() { }
		public void copyFrom(Tipo_dadosContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Tp_dataContext extends Tipo_dadosContext {
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public Tp_dataContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterTp_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitTp_data(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitTp_data(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tp_integerContext extends Tipo_dadosContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Tp_integerContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterTp_integer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitTp_integer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitTp_integer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tp_floatContext extends Tipo_dadosContext {
		public FloateContext floate() {
			return getRuleContext(FloateContext.class,0);
		}
		public Tp_floatContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterTp_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitTp_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitTp_float(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tp_identContext extends Tipo_dadosContext {
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Tp_identContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterTp_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitTp_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitTp_ident(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tp_stringeContext extends Tipo_dadosContext {
		public TerminalNode STRING() { return getToken(GramaticaFormularioParser.STRING, 0); }
		public Tp_stringeContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterTp_stringe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitTp_stringe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitTp_stringe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_dadosContext tipo_dados() throws RecognitionException {
		Tipo_dadosContext _localctx = new Tipo_dadosContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipo_dados);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				integer();
				}
				break;
			case 3:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				floate();
				}
				break;
			case 4:
				_localctx = new Tp_stringeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new Tp_dataContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				data();
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(GramaticaFormularioParser.NUMERO, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaFormularioParser.MENOS, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(113);
				match(MENOS);
				}
			}

			setState(116);
			match(NUMERO);
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

	public static class FloateContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(GramaticaFormularioParser.REAL, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaFormularioParser.MENOS, 0); }
		public FloateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterFloate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitFloate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitFloate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloateContext floate() throws RecognitionException {
		FloateContext _localctx = new FloateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_floate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(118);
				match(MENOS);
				}
			}

			setState(121);
			match(REAL);
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode DATAREGEX() { return getToken(GramaticaFormularioParser.DATAREGEX, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__7);
			setState(124);
			match(DATAREGEX);
			setState(125);
			match(T__7);
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

	public static class IdentidadeContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(GramaticaFormularioParser.VARIAVEL, 0); }
		public IdentidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterIdentidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitIdentidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitIdentidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentidadeContext identidade() throws RecognitionException {
		IdentidadeContext _localctx = new IdentidadeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(VARIAVEL);
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

	public static class If_statContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(GramaticaFormularioParser.SE, 0); }
		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class,0);
		}
		public TerminalNode END_SE() { return getToken(GramaticaFormularioParser.END_SE, 0); }
		public TerminalNode SENAO() { return getToken(GramaticaFormularioParser.SENAO, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(SE);
			setState(130);
			condition_block();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(131);
				match(SENAO);
				setState(132);
				stat_block();
				}
			}

			setState(135);
			match(END_SE);
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

	public static class Condition_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(GramaticaFormularioParser.ENTAO, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterCondition_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitCondition_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			expr(0);
			setState(138);
			match(ENTAO);
			setState(139);
			stat_block();
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

	public static class Stat_blockContext extends ParserRuleContext {
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterStat_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitStat_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitStat_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stat_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0)) {
				{
				{
				setState(141);
				instrucao();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0096\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\6\2#\n\2\r\2"+
		"\16\2$\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\5\4\64\n\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\6\7H\n\7\r\7\16\7I\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bh"+
		"\n\b\f\b\16\bk\13\b\3\t\3\t\3\t\3\t\3\t\5\tr\n\t\3\n\5\nu\n\n\3\n\3\n"+
		"\3\13\5\13z\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\5\16\u0088\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\7\20\u0091\n\20\f"+
		"\20\16\20\u0094\13\20\3\20\2\3\16\21\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36\2\7\4\2\"\"%%\3\2\25\27\3\2\23\24\3\2\17\22\3\2\r\16\2\u009d\2"+
		" \3\2\2\2\4-\3\2\2\2\6\63\3\2\2\2\b\65\3\2\2\2\n9\3\2\2\2\fM\3\2\2\2\16"+
		"O\3\2\2\2\20q\3\2\2\2\22t\3\2\2\2\24y\3\2\2\2\26}\3\2\2\2\30\u0081\3\2"+
		"\2\2\32\u0083\3\2\2\2\34\u008b\3\2\2\2\36\u0092\3\2\2\2 \"\7\3\2\2!#\5"+
		"\4\3\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\7\4\2\2"+
		"\'\3\3\2\2\2(.\5\6\4\2).\5\16\b\2*.\5\32\16\2+.\5\f\7\2,.\5\b\5\2-(\3"+
		"\2\2\2-)\3\2\2\2-*\3\2\2\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60\7 \2\2\60"+
		"\64\5\30\r\2\61\62\7 \2\2\62\64\5\f\7\2\63/\3\2\2\2\63\61\3\2\2\2\64\7"+
		"\3\2\2\2\65\66\5\6\4\2\66\67\7\32\2\2\678\5\n\6\28\t\3\2\2\29:\7\5\2\2"+
		":;\7\6\2\2;<\7\"\2\2<=\7\7\2\2=\13\3\2\2\2>?\5\30\r\2?@\7\32\2\2@A\5\16"+
		"\b\2AN\3\2\2\2BC\5\30\r\2CD\7\32\2\2DE\5\30\r\2EG\7\b\2\2FH\t\2\2\2GF"+
		"\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\t\2\2LN\3\2\2\2M"+
		">\3\2\2\2MB\3\2\2\2N\r\3\2\2\2OP\b\b\1\2PQ\5\20\t\2Qi\3\2\2\2RS\f\n\2"+
		"\2ST\7\30\2\2Th\5\16\b\13UV\f\t\2\2VW\t\3\2\2Wh\5\16\b\nXY\f\b\2\2YZ\t"+
		"\4\2\2Zh\5\16\b\t[\\\f\7\2\2\\]\t\5\2\2]h\5\16\b\b^_\f\6\2\2_`\t\6\2\2"+
		"`h\5\16\b\7ab\f\5\2\2bc\7\f\2\2ch\5\16\b\6de\f\4\2\2ef\7\13\2\2fh\5\16"+
		"\b\5gR\3\2\2\2gU\3\2\2\2gX\3\2\2\2g[\3\2\2\2g^\3\2\2\2ga\3\2\2\2gd\3\2"+
		"\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\17\3\2\2\2ki\3\2\2\2lr\5\30\r\2mr"+
		"\5\22\n\2nr\5\24\13\2or\7&\2\2pr\5\26\f\2ql\3\2\2\2qm\3\2\2\2qn\3\2\2"+
		"\2qo\3\2\2\2qp\3\2\2\2r\21\3\2\2\2su\7\24\2\2ts\3\2\2\2tu\3\2\2\2uv\3"+
		"\2\2\2vw\7\"\2\2w\23\3\2\2\2xz\7\24\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2"+
		"{|\7#\2\2|\25\3\2\2\2}~\7\n\2\2~\177\7*\2\2\177\u0080\7\n\2\2\u0080\27"+
		"\3\2\2\2\u0081\u0082\7\33\2\2\u0082\31\3\2\2\2\u0083\u0084\7\34\2\2\u0084"+
		"\u0087\5\34\17\2\u0085\u0086\7\36\2\2\u0086\u0088\5\36\20\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\37\2\2"+
		"\u008a\33\3\2\2\2\u008b\u008c\5\16\b\2\u008c\u008d\7\35\2\2\u008d\u008e"+
		"\5\36\20\2\u008e\35\3\2\2\2\u008f\u0091\5\4\3\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\37\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\16$-\63IMgiqty\u0087\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}