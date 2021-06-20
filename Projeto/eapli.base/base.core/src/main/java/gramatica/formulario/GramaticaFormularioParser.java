// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OU=10, E=11, EQ=12, NEQ=13, GT=14, LT=15, GTEQ=16, LTEQ=17, MAIS=18, MENOS=19, 
		MULT=20, DIV=21, MOD=22, POW=23, NOT=24, FAIL=25, PASS=26, MATCHREGEX=27, 
		OPERADORATRIBUICAO=28, VARIAVEL=29, SE=30, ENTAO=31, SENAO=32, END_SE=33, 
		TIPODADOS=34, ELEMENTO=35, NUMERO=36, REAL=37, NOME_FICHEIRO=38, TEXTO=39, 
		STRING=40, REGEX=41, DATA_DIA=42, DATA_MES=43, DATA_ANO=44, DATAREGEX=45, 
		COMMENT=46, COMMENTLINE=47, ESPACO=48;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_fail = 2, RULE_inicializacao = 3, 
		RULE_atribuicao_atributo = 4, RULE_get_atributo = 5, RULE_matchregex = 6, 
		RULE_matchregexatribut = 7, RULE_atribuicao = 8, RULE_expr = 9, RULE_tipo_dados = 10, 
		RULE_integer = 11, RULE_floate = 12, RULE_data = 13, RULE_identidade = 14, 
		RULE_if_stat = 15, RULE_senao_rule = 16, RULE_entao_rule = 17, RULE_condition_block = 18, 
		RULE_stat_block = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"gramatica", "instrucao", "fail", "inicializacao", "atribuicao_atributo", 
			"get_atributo", "matchregex", "matchregexatribut", "atribuicao", "expr", 
			"tipo_dados", "integer", "floate", "data", "identidade", "if_stat", "senao_rule", 
			"entao_rule", "condition_block", "stat_block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'atr'", "'['", "']'", "','", "'('", "')'", 
			"'\"'", "'ou'", "'e'", "'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'FAIL'", "'PASS'", "'matchRegex'", 
			"'->'", null, "'se'", "'entao'", "'senao'", "'es'", null, "'ELEMENTO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OU", "E", 
			"EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", 
			"MOD", "POW", "NOT", "FAIL", "PASS", "MATCHREGEX", "OPERADORATRIBUICAO", 
			"VARIAVEL", "SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", "ELEMENTO", 
			"NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "STRING", "REGEX", "DATA_DIA", 
			"DATA_MES", "DATA_ANO", "DATAREGEX", "COMMENT", "COMMENTLINE", "ESPACO"
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
			setState(40);
			match(T__0);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				instrucao();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MENOS) | (1L << FAIL) | (1L << PASS) | (1L << MATCHREGEX) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0) );
			setState(46);
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
		public FailContext fail() {
			return getRuleContext(FailContext.class,0);
		}
		public MatchregexContext matchregex() {
			return getRuleContext(MatchregexContext.class,0);
		}
		public MatchregexatributContext matchregexatribut() {
			return getRuleContext(MatchregexatributContext.class,0);
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
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				inicializacao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				if_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				atribuicao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				atribuicao_atributo();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				fail();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				matchregex();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				matchregexatribut();
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

	public static class FailContext extends ParserRuleContext {
		public FailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fail; }
	 
		public FailContext() { }
		public void copyFrom(FailContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValidationPassContext extends FailContext {
		public TerminalNode PASS() { return getToken(GramaticaFormularioParser.PASS, 0); }
		public ValidationPassContext(FailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterValidationPass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitValidationPass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitValidationPass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValidationFailContext extends FailContext {
		public TerminalNode FAIL() { return getToken(GramaticaFormularioParser.FAIL, 0); }
		public ValidationFailContext(FailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterValidationFail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitValidationFail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitValidationFail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FailContext fail() throws RecognitionException {
		FailContext _localctx = new FailContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fail);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FAIL:
				_localctx = new ValidationFailContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(FAIL);
				}
				break;
			case PASS:
				_localctx = new ValidationPassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(PASS);
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
		public Token tipoDados;
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode TIPODADOS() { return getToken(GramaticaFormularioParser.TIPODADOS, 0); }
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
		public Token tipoDados;
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TerminalNode TIPODADOS() { return getToken(GramaticaFormularioParser.TIPODADOS, 0); }
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
		enterRule(_localctx, 6, RULE_inicializacao);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((InicializacaoIdentContext)_localctx).tipoDados = match(TIPODADOS);
				setState(63);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				((InicializacaoAtribuicaoContext)_localctx).tipoDados = match(TIPODADOS);
				setState(65);
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
		enterRule(_localctx, 8, RULE_atribuicao_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			inicializacao();
			setState(69);
			match(OPERADORATRIBUICAO);
			setState(70);
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
		enterRule(_localctx, 10, RULE_get_atributo);
		try {
			_localctx = new Atr_atributoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__2);
			setState(73);
			match(T__3);
			setState(74);
			((Atr_atributoContext)_localctx).numero = match(NUMERO);
			setState(75);
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

	public static class MatchregexContext extends ParserRuleContext {
		public MatchregexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchregex; }
	 
		public MatchregexContext() { }
		public void copyFrom(MatchregexContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Match_regexContext extends MatchregexContext {
		public Token var;
		public Token regex;
		public TerminalNode MATCHREGEX() { return getToken(GramaticaFormularioParser.MATCHREGEX, 0); }
		public TerminalNode VARIAVEL() { return getToken(GramaticaFormularioParser.VARIAVEL, 0); }
		public TerminalNode REGEX() { return getToken(GramaticaFormularioParser.REGEX, 0); }
		public Match_regexContext(MatchregexContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterMatch_regex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitMatch_regex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitMatch_regex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchregexContext matchregex() throws RecognitionException {
		MatchregexContext _localctx = new MatchregexContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matchregex);
		try {
			_localctx = new Match_regexContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(MATCHREGEX);
			setState(78);
			match(T__3);
			setState(79);
			((Match_regexContext)_localctx).var = match(VARIAVEL);
			setState(80);
			match(T__5);
			setState(81);
			((Match_regexContext)_localctx).regex = match(REGEX);
			setState(82);
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

	public static class MatchregexatributContext extends ParserRuleContext {
		public MatchregexatributContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchregexatribut; }
	 
		public MatchregexatributContext() { }
		public void copyFrom(MatchregexatributContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Match_regex_atributContext extends MatchregexatributContext {
		public Token regex;
		public TerminalNode MATCHREGEX() { return getToken(GramaticaFormularioParser.MATCHREGEX, 0); }
		public Get_atributoContext get_atributo() {
			return getRuleContext(Get_atributoContext.class,0);
		}
		public TerminalNode REGEX() { return getToken(GramaticaFormularioParser.REGEX, 0); }
		public Match_regex_atributContext(MatchregexatributContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterMatch_regex_atribut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitMatch_regex_atribut(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitMatch_regex_atribut(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchregexatributContext matchregexatribut() throws RecognitionException {
		MatchregexatributContext _localctx = new MatchregexatributContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_matchregexatribut);
		try {
			_localctx = new Match_regex_atributContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(MATCHREGEX);
			setState(85);
			match(T__3);
			setState(86);
			get_atributo();
			setState(87);
			match(T__5);
			setState(88);
			((Match_regex_atributContext)_localctx).regex = match(REGEX);
			setState(89);
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
	public static class VariavelAtrContext extends AtribuicaoContext {
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaFormularioParser.OPERADORATRIBUICAO, 0); }
		public Get_atributoContext get_atributo() {
			return getRuleContext(Get_atributoContext.class,0);
		}
		public VariavelAtrContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterVariavelAtr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitVariavelAtr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitVariavelAtr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariavelExprContext extends AtribuicaoContext {
		public IdentidadeContext iden;
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaFormularioParser.OPERADORATRIBUICAO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
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
		enterRule(_localctx, 16, RULE_atribuicao);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new VariavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				((VariavelExprContext)_localctx).iden = identidade();
				setState(92);
				match(OPERADORATRIBUICAO);
				setState(93);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VariavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				identidade();
				setState(96);
				match(OPERADORATRIBUICAO);
				setState(97);
				identidade();
				setState(98);
				match(T__6);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
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
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(104);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new VariavelAtrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				identidade();
				setState(107);
				match(OPERADORATRIBUICAO);
				setState(108);
				get_atributo();
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
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OU() { return getToken(GramaticaFormularioParser.OU, 0); }
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
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode E() { return getToken(GramaticaFormularioParser.E, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(113);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(116);
						match(POW);
						setState(117);
						((PowExprContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(119);
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
						setState(120);
						((MulDivModExprContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(122);
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
						setState(123);
						((SumDifExprContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
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
						setState(126);
						((RelationalExprContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
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
						setState(129);
						((EqualExprContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						((AndExprContext)_localctx).op = match(E);
						setState(132);
						((AndExprContext)_localctx).right = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(134);
						((OrExprContext)_localctx).op = match(OU);
						setState(135);
						((OrExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 20, RULE_tipo_dados);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				integer();
				}
				break;
			case 3:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				floate();
				}
				break;
			case 4:
				_localctx = new Tp_stringeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new Tp_dataContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
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
		enterRule(_localctx, 22, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(148);
				match(MENOS);
				}
			}

			setState(151);
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
		enterRule(_localctx, 24, RULE_floate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(153);
				match(MENOS);
				}
			}

			setState(156);
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
		enterRule(_localctx, 26, RULE_data);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__8);
			setState(159);
			match(DATAREGEX);
			setState(160);
			match(T__8);
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
		public IdentidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identidade; }
	 
		public IdentidadeContext() { }
		public void copyFrom(IdentidadeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariavelContext extends IdentidadeContext {
		public Token var;
		public TerminalNode VARIAVEL() { return getToken(GramaticaFormularioParser.VARIAVEL, 0); }
		public VariavelContext(IdentidadeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentidadeContext identidade() throws RecognitionException {
		IdentidadeContext _localctx = new IdentidadeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_identidade);
		try {
			_localctx = new VariavelContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			((VariavelContext)_localctx).var = match(VARIAVEL);
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
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
	 
		public If_statContext() { }
		public void copyFrom(If_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfContext extends If_statContext {
		public TerminalNode SE() { return getToken(GramaticaFormularioParser.SE, 0); }
		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class,0);
		}
		public TerminalNode END_SE() { return getToken(GramaticaFormularioParser.END_SE, 0); }
		public Senao_ruleContext senao_rule() {
			return getRuleContext(Senao_ruleContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public IfContext(If_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_stat);
		int _la;
		try {
			_localctx = new IfContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(SE);
			setState(165);
			condition_block();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(166);
				senao_rule();
				setState(167);
				stat_block();
				}
			}

			setState(171);
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

	public static class Senao_ruleContext extends ParserRuleContext {
		public Senao_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao_rule; }
	 
		public Senao_ruleContext() { }
		public void copyFrom(Senao_ruleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SenaoContext extends Senao_ruleContext {
		public TerminalNode SENAO() { return getToken(GramaticaFormularioParser.SENAO, 0); }
		public SenaoContext(Senao_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterSenao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitSenao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitSenao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Senao_ruleContext senao_rule() throws RecognitionException {
		Senao_ruleContext _localctx = new Senao_ruleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_senao_rule);
		try {
			_localctx = new SenaoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(SENAO);
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

	public static class Entao_ruleContext extends ParserRuleContext {
		public Entao_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entao_rule; }
	 
		public Entao_ruleContext() { }
		public void copyFrom(Entao_ruleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EntaoContext extends Entao_ruleContext {
		public TerminalNode ENTAO() { return getToken(GramaticaFormularioParser.ENTAO, 0); }
		public EntaoContext(Entao_ruleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).enterEntao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaFormularioListener ) ((GramaticaFormularioListener)listener).exitEntao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaFormularioVisitor ) return ((GramaticaFormularioVisitor<? extends T>)visitor).visitEntao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entao_ruleContext entao_rule() throws RecognitionException {
		Entao_ruleContext _localctx = new Entao_ruleContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_entao_rule);
		try {
			_localctx = new EntaoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(ENTAO);
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
		public Entao_ruleContext entao_rule() {
			return getRuleContext(Entao_ruleContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			expr(0);
			setState(178);
			entao_rule();
			setState(179);
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
		enterRule(_localctx, 38, RULE_stat_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MENOS) | (1L << FAIL) | (1L << PASS) | (1L << MATCHREGEX) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0)) {
				{
				{
				setState(181);
				instrucao();
				}
				}
				setState(186);
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
		case 9:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u00be\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\6\2-\n\2\r\2\16\2.\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5"+
		"\5\5E\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6"+
		"\ng\n\n\r\n\16\nh\3\n\3\n\3\n\3\n\3\n\3\n\5\nq\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008b\n\13\f\13\16\13\u008e\13\13"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0095\n\f\3\r\5\r\u0098\n\r\3\r\3\r\3\16\5\16"+
		"\u009d\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00ac\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\7\25\u00b9\n\25\f\25\16\25\u00bc\13\25\3\25\2\3\24\26\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(\2\7\4\2&&))\3\2\26\30\3\2\24\25\3"+
		"\2\20\23\3\2\16\17\2\u00c5\2*\3\2\2\2\4:\3\2\2\2\6>\3\2\2\2\bD\3\2\2\2"+
		"\nF\3\2\2\2\fJ\3\2\2\2\16O\3\2\2\2\20V\3\2\2\2\22p\3\2\2\2\24r\3\2\2\2"+
		"\26\u0094\3\2\2\2\30\u0097\3\2\2\2\32\u009c\3\2\2\2\34\u00a0\3\2\2\2\36"+
		"\u00a4\3\2\2\2 \u00a6\3\2\2\2\"\u00af\3\2\2\2$\u00b1\3\2\2\2&\u00b3\3"+
		"\2\2\2(\u00ba\3\2\2\2*,\7\3\2\2+-\5\4\3\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2"+
		"\2./\3\2\2\2/\60\3\2\2\2\60\61\7\4\2\2\61\3\3\2\2\2\62;\5\b\5\2\63;\5"+
		"\24\13\2\64;\5 \21\2\65;\5\22\n\2\66;\5\n\6\2\67;\5\6\4\28;\5\16\b\29"+
		";\5\20\t\2:\62\3\2\2\2:\63\3\2\2\2:\64\3\2\2\2:\65\3\2\2\2:\66\3\2\2\2"+
		":\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\5\3\2\2\2<?\7\33\2\2=?\7\34\2\2><\3"+
		"\2\2\2>=\3\2\2\2?\7\3\2\2\2@A\7$\2\2AE\5\36\20\2BC\7$\2\2CE\5\22\n\2D"+
		"@\3\2\2\2DB\3\2\2\2E\t\3\2\2\2FG\5\b\5\2GH\7\36\2\2HI\5\f\7\2I\13\3\2"+
		"\2\2JK\7\5\2\2KL\7\6\2\2LM\7&\2\2MN\7\7\2\2N\r\3\2\2\2OP\7\35\2\2PQ\7"+
		"\6\2\2QR\7\37\2\2RS\7\b\2\2ST\7+\2\2TU\7\7\2\2U\17\3\2\2\2VW\7\35\2\2"+
		"WX\7\6\2\2XY\5\f\7\2YZ\7\b\2\2Z[\7+\2\2[\\\7\7\2\2\\\21\3\2\2\2]^\5\36"+
		"\20\2^_\7\36\2\2_`\5\24\13\2`q\3\2\2\2ab\5\36\20\2bc\7\36\2\2cd\5\36\20"+
		"\2df\7\t\2\2eg\t\2\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2"+
		"\2jk\7\n\2\2kq\3\2\2\2lm\5\36\20\2mn\7\36\2\2no\5\f\7\2oq\3\2\2\2p]\3"+
		"\2\2\2pa\3\2\2\2pl\3\2\2\2q\23\3\2\2\2rs\b\13\1\2st\5\26\f\2t\u008c\3"+
		"\2\2\2uv\f\n\2\2vw\7\31\2\2w\u008b\5\24\13\13xy\f\t\2\2yz\t\3\2\2z\u008b"+
		"\5\24\13\n{|\f\b\2\2|}\t\4\2\2}\u008b\5\24\13\t~\177\f\7\2\2\177\u0080"+
		"\t\5\2\2\u0080\u008b\5\24\13\b\u0081\u0082\f\6\2\2\u0082\u0083\t\6\2\2"+
		"\u0083\u008b\5\24\13\7\u0084\u0085\f\5\2\2\u0085\u0086\7\r\2\2\u0086\u008b"+
		"\5\24\13\6\u0087\u0088\f\4\2\2\u0088\u0089\7\f\2\2\u0089\u008b\5\24\13"+
		"\5\u008au\3\2\2\2\u008ax\3\2\2\2\u008a{\3\2\2\2\u008a~\3\2\2\2\u008a\u0081"+
		"\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008e\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\25\3\2\2\2\u008e\u008c\3\2\2"+
		"\2\u008f\u0095\5\36\20\2\u0090\u0095\5\30\r\2\u0091\u0095\5\32\16\2\u0092"+
		"\u0095\7*\2\2\u0093\u0095\5\34\17\2\u0094\u008f\3\2\2\2\u0094\u0090\3"+
		"\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\27\3\2\2\2\u0096\u0098\7\25\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2"+
		"\2\u0098\u0099\3\2\2\2\u0099\u009a\7&\2\2\u009a\31\3\2\2\2\u009b\u009d"+
		"\7\25\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2"+
		"\u009e\u009f\7\'\2\2\u009f\33\3\2\2\2\u00a0\u00a1\7\13\2\2\u00a1\u00a2"+
		"\7/\2\2\u00a2\u00a3\7\13\2\2\u00a3\35\3\2\2\2\u00a4\u00a5\7\37\2\2\u00a5"+
		"\37\3\2\2\2\u00a6\u00a7\7 \2\2\u00a7\u00ab\5&\24\2\u00a8\u00a9\5\"\22"+
		"\2\u00a9\u00aa\5(\25\2\u00aa\u00ac\3\2\2\2\u00ab\u00a8\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7#\2\2\u00ae!\3\2\2\2\u00af\u00b0"+
		"\7\"\2\2\u00b0#\3\2\2\2\u00b1\u00b2\7!\2\2\u00b2%\3\2\2\2\u00b3\u00b4"+
		"\5\24\13\2\u00b4\u00b5\5$\23\2\u00b5\u00b6\5(\25\2\u00b6\'\3\2\2\2\u00b7"+
		"\u00b9\5\4\3\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb)\3\2\2\2\u00bc\u00ba\3\2\2\2\17.:>Dhp\u008a"+
		"\u008c\u0094\u0097\u009c\u00ab\u00ba";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}