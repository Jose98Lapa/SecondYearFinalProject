// Generated from C:/Users/guilh/OneDrive/Documents/ISEP/Licenciatura/2�Ano/2�Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
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
		RULE_if_stat = 15, RULE_condition_block = 16, RULE_stat_block = 17;
	private static String[] makeRuleNames() {
		return new String[] {
                "gramatica", "instrucao", "fail", "inicializacao", "atribuicao_atributo",
			"get_atributo", "matchregex", "matchregexatribut", "atribuicao", "expr", 
			"tipo_dados", "integer", "floate", "data", "identidade", "if_stat", "condition_block", 
			"stat_block"
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
			setState(36);
			match(T__0);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				instrucao();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MENOS) | (1L << FAIL) | (1L << PASS) | (1L << MATCHREGEX) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0) );
			setState(42);
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
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				inicializacao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				if_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				atribuicao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				atribuicao_atributo();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				fail();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(50);
				matchregex();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(51);
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
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FAIL:
				_localctx = new ValidationFailContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(FAIL);
				}
				break;
			case PASS:
				_localctx = new ValidationPassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
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
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((InicializacaoIdentContext)_localctx).tipoDados = match(TIPODADOS);
				setState(59);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((InicializacaoAtribuicaoContext)_localctx).tipoDados = match(TIPODADOS);
				setState(61);
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
			setState(64);
			inicializacao();
			setState(65);
			match(OPERADORATRIBUICAO);
			setState(66);
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
			setState(68);
			match(T__2);
			setState(69);
			match(T__3);
			setState(70);
			((Atr_atributoContext)_localctx).numero = match(NUMERO);
			setState(71);
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
			setState(73);
			match(MATCHREGEX);
			setState(74);
			match(T__3);
			setState(75);
			((Match_regexContext)_localctx).var = match(VARIAVEL);
			setState(76);
			match(T__5);
			setState(77);
			((Match_regexContext)_localctx).regex = match(REGEX);
			setState(78);
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
			setState(80);
			match(MATCHREGEX);
			setState(81);
			match(T__3);
			setState(82);
			get_atributo();
			setState(83);
			match(T__5);
			setState(84);
			((Match_regex_atributContext)_localctx).regex = match(REGEX);
			setState(85);
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
		enterRule(_localctx, 16, RULE_atribuicao);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new VariavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				identidade();
				setState(88);
				match(OPERADORATRIBUICAO);
				setState(89);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VariavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				identidade();
				setState(92);
				match(OPERADORATRIBUICAO);
				setState(93);
				identidade();
				setState(94);
				match(T__6);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
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
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(100);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new VariavelAtrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				identidade();
				setState(103);
				match(OPERADORATRIBUICAO);
				setState(104);
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

			setState(109);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(112);
						match(POW);
						setState(113);
						((PowExprContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(115);
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
						setState(116);
						((MulDivModExprContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(118);
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
						setState(119);
						((SumDifExprContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(121);
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
						setState(122);
						((RelationalExprContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(124);
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
						setState(125);
						((EqualExprContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(127);
						match(E);
						setState(128);
						((AndExprContext)_localctx).right = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(130);
						match(OU);
						setState(131);
						((OrExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(136);
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
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				integer();
				}
				break;
			case 3:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				floate();
				}
				break;
			case 4:
				_localctx = new Tp_stringeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new Tp_dataContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
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
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(144);
				match(MENOS);
				}
			}

			setState(147);
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
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(149);
				match(MENOS);
				}
			}

			setState(152);
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
			setState(154);
			match(T__8);
			setState(155);
			match(DATAREGEX);
			setState(156);
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
			setState(158);
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
		enterRule(_localctx, 30, RULE_if_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(SE);
			setState(161);
			condition_block();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(162);
				match(SENAO);
				setState(163);
				stat_block();
				}
			}

			setState(166);
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
		enterRule(_localctx, 32, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			expr(0);
			setState(169);
			match(ENTAO);
			setState(170);
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
		enterRule(_localctx, 34, RULE_stat_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << MENOS) | (1L << FAIL) | (1L << PASS) | (1L << MATCHREGEX) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0)) {
				{
				{
				setState(172);
				instrucao();
				}
				}
				setState(177);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u00b5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\6\2)\n\2\r\2\16\2*\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\nc\n\n\r\n\16\nd"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a\13\13\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u0091\n\f\3\r\5\r\u0094\n\r\3\r\3\r\3\16\5\16\u0099\n\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00a7\n\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\7\23\u00b0\n\23\f\23\16\23\u00b3\13"+
		"\23\3\23\2\3\24\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\7\4\2"+
		"&&))\3\2\26\30\3\2\24\25\3\2\20\23\3\2\16\17\2\u00be\2&\3\2\2\2\4\66\3"+
		"\2\2\2\6:\3\2\2\2\b@\3\2\2\2\nB\3\2\2\2\fF\3\2\2\2\16K\3\2\2\2\20R\3\2"+
		"\2\2\22l\3\2\2\2\24n\3\2\2\2\26\u0090\3\2\2\2\30\u0093\3\2\2\2\32\u0098"+
		"\3\2\2\2\34\u009c\3\2\2\2\36\u00a0\3\2\2\2 \u00a2\3\2\2\2\"\u00aa\3\2"+
		"\2\2$\u00b1\3\2\2\2&(\7\3\2\2\')\5\4\3\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2"+
		"\2*+\3\2\2\2+,\3\2\2\2,-\7\4\2\2-\3\3\2\2\2.\67\5\b\5\2/\67\5\24\13\2"+
		"\60\67\5 \21\2\61\67\5\22\n\2\62\67\5\n\6\2\63\67\5\6\4\2\64\67\5\16\b"+
		"\2\65\67\5\20\t\2\66.\3\2\2\2\66/\3\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2"+
		"\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\2"+
		"8;\7\33\2\29;\7\34\2\2:8\3\2\2\2:9\3\2\2\2;\7\3\2\2\2<=\7$\2\2=A\5\36"+
		"\20\2>?\7$\2\2?A\5\22\n\2@<\3\2\2\2@>\3\2\2\2A\t\3\2\2\2BC\5\b\5\2CD\7"+
		"\36\2\2DE\5\f\7\2E\13\3\2\2\2FG\7\5\2\2GH\7\6\2\2HI\7&\2\2IJ\7\7\2\2J"+
		"\r\3\2\2\2KL\7\35\2\2LM\7\6\2\2MN\7\37\2\2NO\7\b\2\2OP\7+\2\2PQ\7\7\2"+
		"\2Q\17\3\2\2\2RS\7\35\2\2ST\7\6\2\2TU\5\f\7\2UV\7\b\2\2VW\7+\2\2WX\7\7"+
		"\2\2X\21\3\2\2\2YZ\5\36\20\2Z[\7\36\2\2[\\\5\24\13\2\\m\3\2\2\2]^\5\36"+
		"\20\2^_\7\36\2\2_`\5\36\20\2`b\7\t\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2d"+
		"b\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\n\2\2gm\3\2\2\2hi\5\36\20\2ij\7\36\2"+
		"\2jk\5\f\7\2km\3\2\2\2lY\3\2\2\2l]\3\2\2\2lh\3\2\2\2m\23\3\2\2\2no\b\13"+
		"\1\2op\5\26\f\2p\u0088\3\2\2\2qr\f\n\2\2rs\7\31\2\2s\u0087\5\24\13\13"+
		"tu\f\t\2\2uv\t\3\2\2v\u0087\5\24\13\nwx\f\b\2\2xy\t\4\2\2y\u0087\5\24"+
		"\13\tz{\f\7\2\2{|\t\5\2\2|\u0087\5\24\13\b}~\f\6\2\2~\177\t\6\2\2\177"+
		"\u0087\5\24\13\7\u0080\u0081\f\5\2\2\u0081\u0082\7\r\2\2\u0082\u0087\5"+
		"\24\13\6\u0083\u0084\f\4\2\2\u0084\u0085\7\f\2\2\u0085\u0087\5\24\13\5"+
		"\u0086q\3\2\2\2\u0086t\3\2\2\2\u0086w\3\2\2\2\u0086z\3\2\2\2\u0086}\3"+
		"\2\2\2\u0086\u0080\3\2\2\2\u0086\u0083\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\25\3\2\2\2\u008a\u0088\3\2\2"+
		"\2\u008b\u0091\5\36\20\2\u008c\u0091\5\30\r\2\u008d\u0091\5\32\16\2\u008e"+
		"\u0091\7*\2\2\u008f\u0091\5\34\17\2\u0090\u008b\3\2\2\2\u0090\u008c\3"+
		"\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\27\3\2\2\2\u0092\u0094\7\25\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2"+
		"\2\u0094\u0095\3\2\2\2\u0095\u0096\7&\2\2\u0096\31\3\2\2\2\u0097\u0099"+
		"\7\25\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2"+
		"\u009a\u009b\7\'\2\2\u009b\33\3\2\2\2\u009c\u009d\7\13\2\2\u009d\u009e"+
		"\7/\2\2\u009e\u009f\7\13\2\2\u009f\35\3\2\2\2\u00a0\u00a1\7\37\2\2\u00a1"+
		"\37\3\2\2\2\u00a2\u00a3\7 \2\2\u00a3\u00a6\5\"\22\2\u00a4\u00a5\7\"\2"+
		"\2\u00a5\u00a7\5$\23\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a9\7#\2\2\u00a9!\3\2\2\2\u00aa\u00ab\5\24\13\2\u00ab"+
		"\u00ac\7!\2\2\u00ac\u00ad\5$\23\2\u00ad#\3\2\2\2\u00ae\u00b0\5\4\3\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2%\3\2\2\2\u00b3\u00b1\3\2\2\2\17*\66:@dl\u0086\u0088\u0090\u0093"+
		"\u0098\u00a6\u00b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}