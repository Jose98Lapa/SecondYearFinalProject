// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package gramatica.atividadeAutomatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaAtividadeAutomaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, OU=11, E=12, EQ=13, NEQ=14, GT=15, LT=16, GTEQ=17, LTEQ=18, MAIS=19, 
		MENOS=20, MULT=21, DIV=22, MOD=23, POW=24, NOT=25, OPERADORATRIBUICAO=26, 
		VARIAVEL=27, SE=28, ENTAO=29, SENAO=30, END_SE=31, TIPODADOS=32, ELEMENTO=33, 
		TIPOFICHEIRO=34, END_FICHEIRO=35, SEND_EMAIL=36, UPDATE=37, NUMERO=38, 
		REAL=39, NOME_FICHEIRO=40, TEXTO=41, COMMENT=42, COMMENTLINE=43, ESPACO=44;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_tipo_ficheiro = 2, RULE_elemento = 3, 
		RULE_atribuicao_elemento = 4, RULE_inicializacao = 5, RULE_atribuicao = 6, 
		RULE_expr = 7, RULE_tipo_dados = 8, RULE_integer = 9, RULE_floate = 10, 
		RULE_identidade = 11, RULE_estrutura_xml = 12, RULE_enviar_email = 13, 
		RULE_update_informacao = 14, RULE_if_stat = 15, RULE_condition_block = 16, 
		RULE_stat_block = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"gramatica", "instrucao", "tipo_ficheiro", "elemento", "atribuicao_elemento", 
			"inicializacao", "atribuicao", "expr", "tipo_dados", "integer", "floate", 
			"identidade", "estrutura_xml", "enviar_email", "update_informacao", "if_stat", 
			"condition_block", "stat_block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'\"'", "'FIND'", "'['", "']'", "'where'", 
			"'('", "','", "')'", "'ou'", "'e'", "'='", "'!='", "'>'", "'<'", "'>='", 
			"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'->'", null, 
			"'se'", "'entao'", "'senao'", "'es'", null, "'ELEMENTO'", "'XML'", "'LMX'", 
			"'ENVIAR_EMAIL'", "'ATUALIZAR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "OU", 
			"E", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", 
			"DIV", "MOD", "POW", "NOT", "OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", 
			"SENAO", "END_SE", "TIPODADOS", "ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", 
			"SEND_EMAIL", "UPDATE", "NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "COMMENT", 
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
	public String getGrammarFileName() { return "GramaticaAtividadeAutomatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaAtividadeAutomaticaParser(TokenStream input) {
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
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterGramatica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitGramatica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitGramatica(this);
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
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL))) != 0)) {
				{
				{
				setState(37);
				instrucao();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
		public Estrutura_xmlContext estrutura_xml() {
			return getRuleContext(Estrutura_xmlContext.class,0);
		}
		public Enviar_emailContext enviar_email() {
			return getRuleContext(Enviar_emailContext.class,0);
		}
		public Update_informacaoContext update_informacao() {
			return getRuleContext(Update_informacaoContext.class,0);
		}
		public InstrucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitInstrucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitInstrucao(this);
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
				setState(45);
				inicializacao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				if_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				atribuicao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				estrutura_xml();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				enviar_email();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(51);
				update_informacao();
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

	public static class Tipo_ficheiroContext extends ParserRuleContext {
		public TerminalNode TIPOFICHEIRO() { return getToken(GramaticaAtividadeAutomaticaParser.TIPOFICHEIRO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public TerminalNode NOME_FICHEIRO() { return getToken(GramaticaAtividadeAutomaticaParser.NOME_FICHEIRO, 0); }
		public Tipo_ficheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_ficheiro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterTipo_ficheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitTipo_ficheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitTipo_ficheiro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_ficheiroContext tipo_ficheiro() throws RecognitionException {
		Tipo_ficheiroContext _localctx = new Tipo_ficheiroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo_ficheiro);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(TIPOFICHEIRO);
				setState(55);
				identidade();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(TIPOFICHEIRO);
				setState(57);
				identidade();
				setState(58);
				match(OPERADORATRIBUICAO);
				setState(59);
				match(T__2);
				setState(60);
				match(NOME_FICHEIRO);
				setState(61);
				match(T__2);
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

	public static class ElementoContext extends ParserRuleContext {
		public TerminalNode ELEMENTO() { return getToken(GramaticaAtividadeAutomaticaParser.ELEMENTO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Atribuicao_elementoContext atribuicao_elemento() {
			return getRuleContext(Atribuicao_elementoContext.class,0);
		}
		public ElementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterElemento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitElemento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitElemento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementoContext elemento() throws RecognitionException {
		ElementoContext _localctx = new ElementoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elemento);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(ELEMENTO);
				setState(66);
				identidade();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(ELEMENTO);
				setState(68);
				atribuicao_elemento();
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

	public static class Atribuicao_elementoContext extends ParserRuleContext {
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public List<TerminalNode> TEXTO() { return getTokens(GramaticaAtividadeAutomaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaticaAtividadeAutomaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, i);
		}
		public Atribuicao_elementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao_elemento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAtribuicao_elemento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAtribuicao_elemento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAtribuicao_elemento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atribuicao_elementoContext atribuicao_elemento() throws RecognitionException {
		Atribuicao_elementoContext _localctx = new Atribuicao_elementoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atribuicao_elemento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			identidade();
			setState(72);
			match(OPERADORATRIBUICAO);
			setState(73);
			match(T__3);
			setState(74);
			match(T__4);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
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
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(80);
			match(T__5);
			setState(81);
			match(T__6);
			setState(82);
			match(T__7);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
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
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(88);
			match(T__8);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
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
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(94);
			match(T__9);
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
		public TerminalNode TIPODADOS() { return getToken(GramaticaAtividadeAutomaticaParser.TIPODADOS, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public InicializacaoIdentContext(InicializacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterInicializacaoIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitInicializacaoIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitInicializacaoIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InicializacaoAtribuicaoContext extends InicializacaoContext {
		public TerminalNode TIPODADOS() { return getToken(GramaticaAtividadeAutomaticaParser.TIPODADOS, 0); }
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public InicializacaoAtribuicaoContext(InicializacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterInicializacaoAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitInicializacaoAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitInicializacaoAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicializacaoContext inicializacao() throws RecognitionException {
		InicializacaoContext _localctx = new InicializacaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inicializacao);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(TIPODADOS);
				setState(97);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(TIPODADOS);
				setState(99);
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
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariavelExprContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterVariavelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitVariavelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitVariavelExpr(this);
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
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public List<TerminalNode> TEXTO() { return getTokens(GramaticaAtividadeAutomaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaticaAtividadeAutomaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, i);
		}
		public VariavelVariavelContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterVariavelVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitVariavelVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitVariavelVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atribuicao);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VariavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				identidade();
				setState(103);
				match(OPERADORATRIBUICAO);
				setState(104);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VariavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				identidade();
				setState(107);
				match(OPERADORATRIBUICAO);
				setState(108);
				identidade();
				setState(109);
				match(T__7);
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(110);
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
					setState(113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(115);
				match(T__9);
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
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode OU() { return getToken(GramaticaAtividadeAutomaticaParser.OU, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitOrExpr(this);
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
		public TerminalNode MULT() { return getToken(GramaticaAtividadeAutomaticaParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(GramaticaAtividadeAutomaticaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(GramaticaAtividadeAutomaticaParser.MOD, 0); }
		public MulDivModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterMulDivModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitMulDivModExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitMulDivModExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode POW() { return getToken(GramaticaAtividadeAutomaticaParser.POW, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitPowExpr(this);
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
		public TerminalNode MAIS() { return getToken(GramaticaAtividadeAutomaticaParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaAtividadeAutomaticaParser.MENOS, 0); }
		public SumDifExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterSumDifExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitSumDifExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitSumDifExpr(this);
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
		public TerminalNode LTEQ() { return getToken(GramaticaAtividadeAutomaticaParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(GramaticaAtividadeAutomaticaParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(GramaticaAtividadeAutomaticaParser.LT, 0); }
		public TerminalNode GT() { return getToken(GramaticaAtividadeAutomaticaParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitRelationalExpr(this);
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
		public TerminalNode EQ() { return getToken(GramaticaAtividadeAutomaticaParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(GramaticaAtividadeAutomaticaParser.NEQ, 0); }
		public EqualExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode E() { return getToken(GramaticaAtividadeAutomaticaParser.E, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAndExpr(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(120);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(123);
						match(POW);
						setState(124);
						((PowExprContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(126);
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
						setState(127);
						((MulDivModExprContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(129);
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
						setState(130);
						((SumDifExprContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(132);
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
						setState(133);
						((RelationalExprContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(135);
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
						setState(136);
						((EqualExprContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(138);
						match(E);
						setState(139);
						((AndExprContext)_localctx).right = expr(4);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(141);
						match(OU);
						setState(142);
						((OrExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class Tp_integerContext extends Tipo_dadosContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Tp_integerContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterTp_integer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitTp_integer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitTp_integer(this);
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
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterTp_float(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitTp_float(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitTp_float(this);
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
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterTp_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitTp_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitTp_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_dadosContext tipo_dados() throws RecognitionException {
		Tipo_dadosContext _localctx = new Tipo_dadosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo_dados);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				integer();
				}
				break;
			case 3:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				floate();
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
		public TerminalNode NUMERO() { return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaAtividadeAutomaticaParser.MENOS, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_integer);
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
		public TerminalNode REAL() { return getToken(GramaticaAtividadeAutomaticaParser.REAL, 0); }
		public TerminalNode MENOS() { return getToken(GramaticaAtividadeAutomaticaParser.MENOS, 0); }
		public FloateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterFloate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitFloate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitFloate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloateContext floate() throws RecognitionException {
		FloateContext _localctx = new FloateContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_floate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(158);
				match(MENOS);
				}
			}

			setState(161);
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

	public static class IdentidadeContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(GramaticaAtividadeAutomaticaParser.VARIAVEL, 0); }
		public IdentidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterIdentidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitIdentidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitIdentidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentidadeContext identidade() throws RecognitionException {
		IdentidadeContext _localctx = new IdentidadeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
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

	public static class Estrutura_xmlContext extends ParserRuleContext {
		public Tipo_ficheiroContext tipo_ficheiro() {
			return getRuleContext(Tipo_ficheiroContext.class,0);
		}
		public TerminalNode END_FICHEIRO() { return getToken(GramaticaAtividadeAutomaticaParser.END_FICHEIRO, 0); }
		public List<ElementoContext> elemento() {
			return getRuleContexts(ElementoContext.class);
		}
		public ElementoContext elemento(int i) {
			return getRuleContext(ElementoContext.class,i);
		}
		public Estrutura_xmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estrutura_xml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEstrutura_xml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEstrutura_xml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEstrutura_xml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Estrutura_xmlContext estrutura_xml() throws RecognitionException {
		Estrutura_xmlContext _localctx = new Estrutura_xmlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_estrutura_xml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			tipo_ficheiro();
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				elemento();
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELEMENTO );
			setState(171);
			match(END_FICHEIRO);
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

	public static class Enviar_emailContext extends ParserRuleContext {
		public TerminalNode SEND_EMAIL() { return getToken(GramaticaAtividadeAutomaticaParser.SEND_EMAIL, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public Enviar_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enviar_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEnviar_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEnviar_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEnviar_email(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enviar_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(SEND_EMAIL);
			setState(174);
			match(T__7);
			setState(175);
			identidade();
			setState(176);
			match(T__8);
			setState(177);
			identidade();
			setState(178);
			match(T__8);
			setState(179);
			identidade();
			setState(180);
			match(T__9);
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

	public static class Update_informacaoContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(GramaticaAtividadeAutomaticaParser.UPDATE, 0); }
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public List<TerminalNode> TEXTO() { return getTokens(GramaticaAtividadeAutomaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaticaAtividadeAutomaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, i);
		}
		public Update_informacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_informacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterUpdate_informacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitUpdate_informacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitUpdate_informacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_informacaoContext update_informacao() throws RecognitionException {
		Update_informacaoContext _localctx = new Update_informacaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_update_informacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(UPDATE);
			setState(183);
			match(T__7);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
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
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(189);
			match(T__8);
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
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
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(195);
			match(T__8);
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(196);
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
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(201);
			match(T__9);
			setState(202);
			match(OPERADORATRIBUICAO);
			setState(203);
			match(T__7);
			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(204);
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
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(209);
			match(T__8);
			setState(210);
			identidade();
			setState(211);
			match(T__9);
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
		public TerminalNode SE() { return getToken(GramaticaAtividadeAutomaticaParser.SE, 0); }
		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class,0);
		}
		public TerminalNode END_SE() { return getToken(GramaticaAtividadeAutomaticaParser.END_SE, 0); }
		public TerminalNode SENAO() { return getToken(GramaticaAtividadeAutomaticaParser.SENAO, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitIf_stat(this);
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
			setState(213);
			match(SE);
			setState(214);
			condition_block();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(215);
				match(SENAO);
				setState(216);
				stat_block();
				}
			}

			setState(219);
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
		public TerminalNode ENTAO() { return getToken(GramaticaAtividadeAutomaticaParser.ENTAO, 0); }
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterCondition_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitCondition_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitCondition_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			expr(0);
			setState(222);
			match(ENTAO);
			setState(223);
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
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterStat_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitStat_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitStat_block(this);
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
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL))) != 0)) {
				{
				{
				setState(225);
				instrucao();
				}
				}
				setState(230);
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
		case 7:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00ea\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3"+
		"\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\6\6O\n\6\r\6\16\6P\3\6\3\6\3\6"+
		"\3\6\6\6W\n\6\r\6\16\6X\3\6\3\6\6\6]\n\6\r\6\16\6^\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\5\7g\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\br\n\b\r\b\16\bs\3"+
		"\b\3\b\5\bx\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0092\n\t\f\t\16\t\u0095"+
		"\13\t\3\n\3\n\3\n\5\n\u009a\n\n\3\13\5\13\u009d\n\13\3\13\3\13\3\f\5\f"+
		"\u00a2\n\f\3\f\3\f\3\r\3\r\3\16\3\16\6\16\u00aa\n\16\r\16\16\16\u00ab"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\6\20\u00bc\n\20\r\20\16\20\u00bd\3\20\3\20\6\20\u00c2\n\20\r\20\16\20"+
		"\u00c3\3\20\3\20\6\20\u00c8\n\20\r\20\16\20\u00c9\3\20\3\20\3\20\3\20"+
		"\6\20\u00d0\n\20\r\20\16\20\u00d1\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\5\21\u00dc\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\7\23\u00e5\n\23"+
		"\f\23\16\23\u00e8\13\23\3\23\2\3\20\24\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$\2\7\4\2((++\3\2\27\31\3\2\25\26\3\2\21\24\3\2\17\20\2\u00f8"+
		"\2&\3\2\2\2\4\66\3\2\2\2\6A\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\ff\3\2\2\2\16"+
		"w\3\2\2\2\20y\3\2\2\2\22\u0099\3\2\2\2\24\u009c\3\2\2\2\26\u00a1\3\2\2"+
		"\2\30\u00a5\3\2\2\2\32\u00a7\3\2\2\2\34\u00af\3\2\2\2\36\u00b8\3\2\2\2"+
		" \u00d7\3\2\2\2\"\u00df\3\2\2\2$\u00e6\3\2\2\2&*\7\3\2\2\')\5\4\3\2(\'"+
		"\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\4\2\2."+
		"\3\3\2\2\2/\67\5\f\7\2\60\67\5\20\t\2\61\67\5 \21\2\62\67\5\16\b\2\63"+
		"\67\5\32\16\2\64\67\5\34\17\2\65\67\5\36\20\2\66/\3\2\2\2\66\60\3\2\2"+
		"\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2"+
		"\2\67\5\3\2\2\289\7$\2\29B\5\30\r\2:;\7$\2\2;<\5\30\r\2<=\7\34\2\2=>\7"+
		"\5\2\2>?\7*\2\2?@\7\5\2\2@B\3\2\2\2A8\3\2\2\2A:\3\2\2\2B\7\3\2\2\2CD\7"+
		"#\2\2DH\5\30\r\2EF\7#\2\2FH\5\n\6\2GC\3\2\2\2GE\3\2\2\2H\t\3\2\2\2IJ\5"+
		"\30\r\2JK\7\34\2\2KL\7\6\2\2LN\7\7\2\2MO\t\2\2\2NM\3\2\2\2OP\3\2\2\2P"+
		"N\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\b\2\2ST\7\t\2\2TV\7\n\2\2UW\t\2\2\2"+
		"VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7\13\2\2[]\t\2\2"+
		"\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\f\2\2a\13\3"+
		"\2\2\2bc\7\"\2\2cg\5\30\r\2de\7\"\2\2eg\5\16\b\2fb\3\2\2\2fd\3\2\2\2g"+
		"\r\3\2\2\2hi\5\30\r\2ij\7\34\2\2jk\5\20\t\2kx\3\2\2\2lm\5\30\r\2mn\7\34"+
		"\2\2no\5\30\r\2oq\7\n\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2tu\3\2\2\2uv\7\f\2\2vx\3\2\2\2wh\3\2\2\2wl\3\2\2\2x\17\3\2\2\2y"+
		"z\b\t\1\2z{\5\22\n\2{\u0093\3\2\2\2|}\f\n\2\2}~\7\32\2\2~\u0092\5\20\t"+
		"\13\177\u0080\f\t\2\2\u0080\u0081\t\3\2\2\u0081\u0092\5\20\t\n\u0082\u0083"+
		"\f\b\2\2\u0083\u0084\t\4\2\2\u0084\u0092\5\20\t\t\u0085\u0086\f\7\2\2"+
		"\u0086\u0087\t\5\2\2\u0087\u0092\5\20\t\b\u0088\u0089\f\6\2\2\u0089\u008a"+
		"\t\6\2\2\u008a\u0092\5\20\t\7\u008b\u008c\f\5\2\2\u008c\u008d\7\16\2\2"+
		"\u008d\u0092\5\20\t\6\u008e\u008f\f\4\2\2\u008f\u0090\7\r\2\2\u0090\u0092"+
		"\5\20\t\5\u0091|\3\2\2\2\u0091\177\3\2\2\2\u0091\u0082\3\2\2\2\u0091\u0085"+
		"\3\2\2\2\u0091\u0088\3\2\2\2\u0091\u008b\3\2\2\2\u0091\u008e\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\21\3\2\2"+
		"\2\u0095\u0093\3\2\2\2\u0096\u009a\5\30\r\2\u0097\u009a\5\24\13\2\u0098"+
		"\u009a\5\26\f\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098\3"+
		"\2\2\2\u009a\23\3\2\2\2\u009b\u009d\7\26\2\2\u009c\u009b\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7(\2\2\u009f\25\3\2\2\2"+
		"\u00a0\u00a2\7\26\2\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a4\7)\2\2\u00a4\27\3\2\2\2\u00a5\u00a6\7\35\2\2\u00a6"+
		"\31\3\2\2\2\u00a7\u00a9\5\6\4\2\u00a8\u00aa\5\b\5\2\u00a9\u00a8\3\2\2"+
		"\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\7%\2\2\u00ae\33\3\2\2\2\u00af\u00b0\7&\2\2\u00b0"+
		"\u00b1\7\n\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\7\13\2\2\u00b3\u00b4\5"+
		"\30\r\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7\f\2\2"+
		"\u00b7\35\3\2\2\2\u00b8\u00b9\7\'\2\2\u00b9\u00bb\7\n\2\2\u00ba\u00bc"+
		"\t\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\7\13\2\2\u00c0\u00c2\t"+
		"\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\7\13\2\2\u00c6\u00c8\t"+
		"\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\7\34"+
		"\2\2\u00cd\u00cf\7\n\2\2\u00ce\u00d0\t\2\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d4\7\13\2\2\u00d4\u00d5\5\30\r\2\u00d5\u00d6\7\f\2\2\u00d6"+
		"\37\3\2\2\2\u00d7\u00d8\7\36\2\2\u00d8\u00db\5\"\22\2\u00d9\u00da\7 \2"+
		"\2\u00da\u00dc\5$\23\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\7!\2\2\u00de!\3\2\2\2\u00df\u00e0\5\20\t\2\u00e0"+
		"\u00e1\7\37\2\2\u00e1\u00e2\5$\23\2\u00e2#\3\2\2\2\u00e3\u00e5\5\4\3\2"+
		"\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7%\3\2\2\2\u00e8\u00e6\3\2\2\2\30*\66AGPX^fsw\u0091\u0093"+
		"\u0099\u009c\u00a1\u00ab\u00bd\u00c3\u00c9\u00d1\u00db\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}