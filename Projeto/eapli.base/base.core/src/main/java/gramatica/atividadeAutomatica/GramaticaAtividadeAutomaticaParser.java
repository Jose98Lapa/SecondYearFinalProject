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
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OU=10, E=11, EQ=12, NEQ=13, GT=14, LT=15, GTEQ=16, LTEQ=17, MAIS=18, MENOS=19, 
		MULT=20, DIV=21, MOD=22, POW=23, NOT=24, OPERADORATRIBUICAO=25, VARIAVEL=26, 
		SE=27, ENTAO=28, SENAO=29, END_SE=30, TIPODADOS=31, ELEMENTO=32, TIPOFICHEIRO=33, 
		END_FICHEIRO=34, SEND_EMAIL=35, UPDATE=36, NUMERO=37, REAL=38, NOME_FICHEIRO=39, 
		TEXTO=40, STRING=41, COMMENT=42, COMMENTLINE=43, ESPACO=44;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_estrutura_xml = 2, RULE_tipo_ficheiro = 3, 
		RULE_elemento = 4, RULE_atribuicao_elemento = 5, RULE_inicializacao = 6, 
		RULE_atribuicao = 7, RULE_if_stat = 8, RULE_condition_block = 9, RULE_stat_block = 10, 
		RULE_expr = 11, RULE_tipo_dados = 12, RULE_integer = 13, RULE_floate = 14, 
		RULE_identidade = 15, RULE_string = 16, RULE_enviar_email = 17, RULE_update_informacao = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"gramatica", "instrucao", "estrutura_xml", "tipo_ficheiro", "elemento", 
			"atribuicao_elemento", "inicializacao", "atribuicao", "if_stat", "condition_block", 
			"stat_block", "expr", "tipo_dados", "integer", "floate", "identidade", 
			"string", "enviar_email", "update_informacao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'FIND'", "'['", "','", "']'", "'where'", "'('", 
			"')'", "'ou'", "'e'", "'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'->'", null, "'se'", "'entao'", 
			"'senao'", "'es'", null, "'ELEMENTO'", "'XML'", "'LMX'", "'ENVIAR_EMAIL'", 
			"'ATUALIZAR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OU", "E", 
			"EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", 
			"MOD", "POW", "NOT", "OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", 
			"SENAO", "END_SE", "TIPODADOS", "ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", 
			"SEND_EMAIL", "UPDATE", "NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "STRING", 
			"COMMENT", "COMMENTLINE", "ESPACO"
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
			setState(38);
			match(T__0);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0)) {
				{
				{
				setState(39);
				instrucao();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				inicializacao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				if_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				atribuicao();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				estrutura_xml();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(52);
				enviar_email();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(53);
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
		enterRule(_localctx, 4, RULE_estrutura_xml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			tipo_ficheiro();
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				elemento();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELEMENTO );
			setState(62);
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

	public static class Tipo_ficheiroContext extends ParserRuleContext {
		public Tipo_ficheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_ficheiro; }
	 
		public Tipo_ficheiroContext() { }
		public void copyFrom(Tipo_ficheiroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FicheiroIdentContext extends Tipo_ficheiroContext {
		public TerminalNode TIPOFICHEIRO() { return getToken(GramaticaAtividadeAutomaticaParser.TIPOFICHEIRO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public FicheiroIdentContext(Tipo_ficheiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterFicheiroIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitFicheiroIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitFicheiroIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FicheiroNomeFicheiroContext extends Tipo_ficheiroContext {
		public TerminalNode TIPOFICHEIRO() { return getToken(GramaticaAtividadeAutomaticaParser.TIPOFICHEIRO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public TerminalNode STRING() { return getToken(GramaticaAtividadeAutomaticaParser.STRING, 0); }
		public FicheiroNomeFicheiroContext(Tipo_ficheiroContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterFicheiroNomeFicheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitFicheiroNomeFicheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitFicheiroNomeFicheiro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_ficheiroContext tipo_ficheiro() throws RecognitionException {
		Tipo_ficheiroContext _localctx = new Tipo_ficheiroContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo_ficheiro);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FicheiroIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(TIPOFICHEIRO);
				setState(65);
				identidade();
				}
				break;
			case 2:
				_localctx = new FicheiroNomeFicheiroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(TIPOFICHEIRO);
				setState(67);
				identidade();
				setState(68);
				match(OPERADORATRIBUICAO);
				setState(69);
				match(STRING);
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
		enterRule(_localctx, 8, RULE_elemento);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(ELEMENTO);
				setState(74);
				identidade();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(ELEMENTO);
				setState(76);
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
		public Token what;
		public IdentidadeContext file;
		public Token id;
		public Token idvalue;
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
		enterRule(_localctx, 10, RULE_atribuicao_elemento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			identidade();
			setState(80);
			match(OPERADORATRIBUICAO);
			setState(81);
			match(T__2);
			setState(82);
			match(T__3);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				((Atribuicao_elementoContext)_localctx).what = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Atribuicao_elementoContext)_localctx).what = (Token)_errHandler.recoverInline(this);
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
			match(T__4);
			setState(89);
			((Atribuicao_elementoContext)_localctx).file = identidade();
			setState(90);
			match(T__5);
			setState(91);
			match(T__6);
			setState(92);
			match(T__7);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				((Atribuicao_elementoContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Atribuicao_elementoContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(98);
			match(T__4);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(99);
				((Atribuicao_elementoContext)_localctx).idvalue = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Atribuicao_elementoContext)_localctx).idvalue = (Token)_errHandler.recoverInline(this);
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
		enterRule(_localctx, 12, RULE_inicializacao);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(TIPODADOS);
				setState(107);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(TIPODADOS);
				setState(109);
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
		enterRule(_localctx, 14, RULE_atribuicao);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new VariavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				identidade();
				setState(113);
				match(OPERADORATRIBUICAO);
				setState(114);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VariavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				identidade();
				setState(117);
				match(OPERADORATRIBUICAO);
				setState(118);
				identidade();
				setState(119);
				match(T__7);
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(120);
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
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(125);
				match(T__8);
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
		enterRule(_localctx, 16, RULE_if_stat);
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
		enterRule(_localctx, 18, RULE_condition_block);
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
		enterRule(_localctx, 20, RULE_stat_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOS) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL) | (1L << STRING))) != 0)) {
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(148);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(151);
						match(POW);
						setState(152);
						((PowExprContext)_localctx).right = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(154);
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
						setState(155);
						((MulDivModExprContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(157);
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
						setState(158);
						((SumDifExprContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(160);
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
						setState(161);
						((RelationalExprContext)_localctx).right = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(163);
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
						setState(164);
						((EqualExprContext)_localctx).right = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(166);
						match(E);
						setState(167);
						((AndExprContext)_localctx).right = expr(3);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(169);
						match(OU);
						setState(170);
						((OrExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
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
		enterRule(_localctx, 24, RULE_tipo_dados);
		try {
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				integer();
				}
				break;
			case 3:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				floate();
				}
				break;
			case 4:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				string();
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
		enterRule(_localctx, 26, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(182);
				match(MENOS);
				}
			}

			setState(185);
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
		enterRule(_localctx, 28, RULE_floate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(187);
				match(MENOS);
				}
			}

			setState(190);
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
		enterRule(_localctx, 30, RULE_identidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GramaticaAtividadeAutomaticaParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(STRING);
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
		public Enviar_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enviar_email; }
	 
		public Enviar_emailContext() { }
		public void copyFrom(Enviar_emailContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmailAtributosContext extends Enviar_emailContext {
		public IdentidadeContext destinatario;
		public IdentidadeContext assunto;
		public IdentidadeContext corpo;
		public TerminalNode SEND_EMAIL() { return getToken(GramaticaAtividadeAutomaticaParser.SEND_EMAIL, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public EmailAtributosContext(Enviar_emailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEmailAtributos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEmailAtributos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEmailAtributos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmailStringContext extends Enviar_emailContext {
		public IdentidadeContext destinatario;
		public Token assunto;
		public Token corpo;
		public TerminalNode SEND_EMAIL() { return getToken(GramaticaAtividadeAutomaticaParser.SEND_EMAIL, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public List<TerminalNode> STRING() { return getTokens(GramaticaAtividadeAutomaticaParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.STRING, i);
		}
		public EmailStringContext(Enviar_emailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEmailString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEmailString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEmailString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enviar_email);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new EmailAtributosContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(SEND_EMAIL);
				setState(197);
				match(T__7);
				setState(198);
				((EmailAtributosContext)_localctx).destinatario = identidade();
				setState(199);
				match(T__4);
				setState(200);
				((EmailAtributosContext)_localctx).assunto = identidade();
				setState(201);
				match(T__4);
				setState(202);
				((EmailAtributosContext)_localctx).corpo = identidade();
				setState(203);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new EmailStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(SEND_EMAIL);
				setState(206);
				match(T__7);
				setState(207);
				((EmailStringContext)_localctx).destinatario = identidade();
				setState(208);
				match(T__4);
				setState(209);
				((EmailStringContext)_localctx).assunto = match(STRING);
				setState(210);
				match(T__4);
				setState(211);
				((EmailStringContext)_localctx).corpo = match(STRING);
				setState(212);
				match(T__8);
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
		enterRule(_localctx, 36, RULE_update_informacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(UPDATE);
			setState(217);
			match(T__7);
			setState(219); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(218);
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
				setState(221); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(223);
			match(T__4);
			setState(225); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
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
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(229);
			match(T__4);
			setState(231); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(230);
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
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(235);
			match(T__8);
			setState(236);
			match(OPERADORATRIBUICAO);
			setState(237);
			match(T__7);
			setState(239); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(238);
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
				setState(241); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(243);
			match(T__4);
			setState(244);
			identidade();
			setState(245);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u00fa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\6\4=\n\4\r\4\16\4>\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\5\6P\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\6\7W\n\7\r\7\16\7X\3\7\3\7\3\7\3\7\3\7\3\7\6\7a\n\7\r\7\16\7b\3\7"+
		"\3\7\6\7g\n\7\r\7\16\7h\3\7\3\7\3\b\3\b\3\b\3\b\5\bq\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\6\t|\n\t\r\t\16\t}\3\t\3\t\5\t\u0082\n\t\3\n\3"+
		"\n\3\n\3\n\5\n\u0088\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\7\f\u0091\n\f"+
		"\f\f\16\f\u0094\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ae\n\r\f\r\16\r"+
		"\u00b1\13\r\3\16\3\16\3\16\3\16\5\16\u00b7\n\16\3\17\5\17\u00ba\n\17\3"+
		"\17\3\17\3\20\5\20\u00bf\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00d9\n\23\3\24\3\24\3\24\6\24\u00de\n\24\r\24\16\24\u00df"+
		"\3\24\3\24\6\24\u00e4\n\24\r\24\16\24\u00e5\3\24\3\24\6\24\u00ea\n\24"+
		"\r\24\16\24\u00eb\3\24\3\24\3\24\3\24\6\24\u00f2\n\24\r\24\16\24\u00f3"+
		"\3\24\3\24\3\24\3\24\3\24\2\3\30\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&\2\7\4\2\'\'**\3\2\26\30\3\2\24\25\3\2\20\23\3\2\16\17\2\u0109"+
		"\2(\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\bI\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16"+
		"p\3\2\2\2\20\u0081\3\2\2\2\22\u0083\3\2\2\2\24\u008b\3\2\2\2\26\u0092"+
		"\3\2\2\2\30\u0095\3\2\2\2\32\u00b6\3\2\2\2\34\u00b9\3\2\2\2\36\u00be\3"+
		"\2\2\2 \u00c2\3\2\2\2\"\u00c4\3\2\2\2$\u00d8\3\2\2\2&\u00da\3\2\2\2(,"+
		"\7\3\2\2)+\5\4\3\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2."+
		",\3\2\2\2/\60\7\4\2\2\60\3\3\2\2\2\619\5\16\b\2\629\5\30\r\2\639\5\22"+
		"\n\2\649\5\20\t\2\659\5\6\4\2\669\5$\23\2\679\5&\24\28\61\3\2\2\28\62"+
		"\3\2\2\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29"+
		"\5\3\2\2\2:<\5\b\5\2;=\5\n\6\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?@\3\2\2\2@A\7$\2\2A\7\3\2\2\2BC\7#\2\2CJ\5 \21\2DE\7#\2\2EF\5 \21\2F"+
		"G\7\33\2\2GH\7+\2\2HJ\3\2\2\2IB\3\2\2\2ID\3\2\2\2J\t\3\2\2\2KL\7\"\2\2"+
		"LP\5 \21\2MN\7\"\2\2NP\5\f\7\2OK\3\2\2\2OM\3\2\2\2P\13\3\2\2\2QR\5 \21"+
		"\2RS\7\33\2\2ST\7\5\2\2TV\7\6\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\7\2\2[\\\5 \21\2\\]\7\b\2\2]^\7\t\2\2^`\7"+
		"\n\2\2_a\t\2\2\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2df\7"+
		"\7\2\2eg\t\2\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7"+
		"\13\2\2k\r\3\2\2\2lm\7!\2\2mq\5 \21\2no\7!\2\2oq\5\20\t\2pl\3\2\2\2pn"+
		"\3\2\2\2q\17\3\2\2\2rs\5 \21\2st\7\33\2\2tu\5\30\r\2u\u0082\3\2\2\2vw"+
		"\5 \21\2wx\7\33\2\2xy\5 \21\2y{\7\n\2\2z|\t\2\2\2{z\3\2\2\2|}\3\2\2\2"+
		"}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\7\13\2\2\u0080\u0082\3\2\2"+
		"\2\u0081r\3\2\2\2\u0081v\3\2\2\2\u0082\21\3\2\2\2\u0083\u0084\7\35\2\2"+
		"\u0084\u0087\5\24\13\2\u0085\u0086\7\37\2\2\u0086\u0088\5\26\f\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7 "+
		"\2\2\u008a\23\3\2\2\2\u008b\u008c\5\30\r\2\u008c\u008d\7\36\2\2\u008d"+
		"\u008e\5\26\f\2\u008e\25\3\2\2\2\u008f\u0091\5\4\3\2\u0090\u008f\3\2\2"+
		"\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\27"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\b\r\1\2\u0096\u0097\5\32\16\2"+
		"\u0097\u00af\3\2\2\2\u0098\u0099\f\t\2\2\u0099\u009a\7\31\2\2\u009a\u00ae"+
		"\5\30\r\n\u009b\u009c\f\b\2\2\u009c\u009d\t\3\2\2\u009d\u00ae\5\30\r\t"+
		"\u009e\u009f\f\7\2\2\u009f\u00a0\t\4\2\2\u00a0\u00ae\5\30\r\b\u00a1\u00a2"+
		"\f\6\2\2\u00a2\u00a3\t\5\2\2\u00a3\u00ae\5\30\r\7\u00a4\u00a5\f\5\2\2"+
		"\u00a5\u00a6\t\6\2\2\u00a6\u00ae\5\30\r\6\u00a7\u00a8\f\4\2\2\u00a8\u00a9"+
		"\7\r\2\2\u00a9\u00ae\5\30\r\5\u00aa\u00ab\f\3\2\2\u00ab\u00ac\7\f\2\2"+
		"\u00ac\u00ae\5\30\r\4\u00ad\u0098\3\2\2\2\u00ad\u009b\3\2\2\2\u00ad\u009e"+
		"\3\2\2\2\u00ad\u00a1\3\2\2\2\u00ad\u00a4\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ad"+
		"\u00aa\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\31\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b7\5 \21\2\u00b3\u00b7"+
		"\5\34\17\2\u00b4\u00b7\5\36\20\2\u00b5\u00b7\5\"\22\2\u00b6\u00b2\3\2"+
		"\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7"+
		"\33\3\2\2\2\u00b8\u00ba\7\25\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2"+
		"\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\'\2\2\u00bc\35\3\2\2\2\u00bd\u00bf"+
		"\7\25\2\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2"+
		"\u00c0\u00c1\7(\2\2\u00c1\37\3\2\2\2\u00c2\u00c3\7\34\2\2\u00c3!\3\2\2"+
		"\2\u00c4\u00c5\7+\2\2\u00c5#\3\2\2\2\u00c6\u00c7\7%\2\2\u00c7\u00c8\7"+
		"\n\2\2\u00c8\u00c9\5 \21\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\5 \21\2\u00cb"+
		"\u00cc\7\7\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\7\13\2\2\u00ce\u00d9\3"+
		"\2\2\2\u00cf\u00d0\7%\2\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\5 \21\2\u00d2"+
		"\u00d3\7\7\2\2\u00d3\u00d4\7+\2\2\u00d4\u00d5\7\7\2\2\u00d5\u00d6\7+\2"+
		"\2\u00d6\u00d7\7\13\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00c6\3\2\2\2\u00d8"+
		"\u00cf\3\2\2\2\u00d9%\3\2\2\2\u00da\u00db\7&\2\2\u00db\u00dd\7\n\2\2\u00dc"+
		"\u00de\t\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\7\7\2\2\u00e2"+
		"\u00e4\t\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\7\7\2\2\u00e8"+
		"\u00ea\t\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\7\13\2\2\u00ee"+
		"\u00ef\7\33\2\2\u00ef\u00f1\7\n\2\2\u00f0\u00f2\t\2\2\2\u00f1\u00f0\3"+
		"\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\7\2\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\7\13"+
		"\2\2\u00f8\'\3\2\2\2\31,8>IOXbhp}\u0081\u0087\u0092\u00ad\u00af\u00b6"+
		"\u00b9\u00be\u00d8\u00df\u00e5\u00eb\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}