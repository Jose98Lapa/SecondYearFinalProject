// Generated from C:/ROOT/Universidade/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.app.automatictask.executor/src/main/java/eapli/base/automatictask/executor/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package eapli.base.automatictask.executor.gramatica.atividadeAutomatica;
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
		END_FICHEIRO=34, SEND_EMAIL=35, UPDATE=36, FORM=37, NUMERO=38, REAL=39, 
		NOME_FICHEIRO=40, TEXTO=41, APPROV=42, ANSWER=43, STRING=44, COMMENT=45, 
		COMMENTLINE=46, ESPACO=47;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_estrutura_xml = 2, RULE_tipo_ficheiro = 3, 
		RULE_elemento = 4, RULE_atribuicao_elemento = 5, RULE_inicializacao = 6, 
		RULE_atribuicao = 7, RULE_if_stat = 8, RULE_condition_block = 9, RULE_stat_block = 10, 
		RULE_entao = 11, RULE_senao = 12, RULE_expr = 13, RULE_tipo_dados = 14, 
		RULE_integer = 15, RULE_floate = 16, RULE_identidade = 17, RULE_string = 18, 
		RULE_enviar_email = 19, RULE_update_informacao = 20, RULE_formulario_informacao = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"gramatica", "instrucao", "estrutura_xml", "tipo_ficheiro", "elemento", 
			"atribuicao_elemento", "inicializacao", "atribuicao", "if_stat", "condition_block", 
			"stat_block", "entao", "senao", "expr", "tipo_dados", "integer", "floate", 
			"identidade", "string", "enviar_email", "update_informacao", "formulario_informacao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'FIND'", "'['", "','", "']'", "'where'", "'('", 
			"')'", "'ou'", "'e'", "'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "'->'", null, "'se'", "'entao'", 
			"'senao'", "'es'", null, "'ELEMENTO'", "'XML'", "'LMX'", "'ENVIAR_EMAIL'", 
			"'ATUALIZAR'", "'FORM'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OU", "E", 
			"EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", 
			"MOD", "POW", "NOT", "OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", 
			"SENAO", "END_SE", "TIPODADOS", "ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", 
			"SEND_EMAIL", "UPDATE", "FORM", "NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", 
			"APPROV", "ANSWER", "STRING", "COMMENT", "COMMENTLINE", "ESPACO"
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
			setState(44);
			match(T__0);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE))) != 0)) {
				{
				{
				setState(45);
				instrucao();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPODADOS:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				inicializacao();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				if_stat();
				}
				break;
			case VARIAVEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				atribuicao();
				}
				break;
			case TIPOFICHEIRO:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				estrutura_xml();
				}
				break;
			case SEND_EMAIL:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				enviar_email();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				update_informacao();
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
			setState(61);
			tipo_ficheiro();
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				elemento();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELEMENTO );
			setState(67);
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
		public Token stringficheiro;
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
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FicheiroIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(TIPOFICHEIRO);
				setState(70);
				identidade();
				}
				break;
			case 2:
				_localctx = new FicheiroNomeFicheiroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(TIPOFICHEIRO);
				setState(72);
				identidade();
				setState(73);
				match(OPERADORATRIBUICAO);
				setState(74);
				((FicheiroNomeFicheiroContext)_localctx).stringficheiro = match(STRING);
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
		public ElementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemento; }
	 
		public ElementoContext() { }
		public void copyFrom(ElementoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Elem_atrContext extends ElementoContext {
		public TerminalNode ELEMENTO() { return getToken(GramaticaAtividadeAutomaticaParser.ELEMENTO, 0); }
		public Atribuicao_elementoContext atribuicao_elemento() {
			return getRuleContext(Atribuicao_elementoContext.class,0);
		}
		public Elem_atrContext(ElementoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterElem_atr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitElem_atr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitElem_atr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Elem_idtContext extends ElementoContext {
		public TerminalNode ELEMENTO() { return getToken(GramaticaAtividadeAutomaticaParser.ELEMENTO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Elem_idtContext(ElementoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterElem_idt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitElem_idt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitElem_idt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementoContext elemento() throws RecognitionException {
		ElementoContext _localctx = new ElementoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elemento);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Elem_idtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(ELEMENTO);
				setState(79);
				identidade();
				}
				break;
			case 2:
				_localctx = new Elem_atrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(ELEMENTO);
				setState(81);
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
		public IdentidadeContext nomeVar;
		public Token what;
		public IdentidadeContext file;
		public Token id;
		public Token idvalue;
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
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
			setState(84);
			((Atribuicao_elementoContext)_localctx).nomeVar = identidade();
			setState(85);
			match(OPERADORATRIBUICAO);
			setState(86);
			match(T__2);
			setState(87);
			match(T__3);
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
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
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(93);
			match(T__4);
			setState(94);
			((Atribuicao_elementoContext)_localctx).file = identidade();
			setState(95);
			match(T__5);
			setState(96);
			match(T__6);
			setState(97);
			match(T__7);
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
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
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(103);
			match(T__4);
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
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
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(109);
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new InicializacaoIdentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(TIPODADOS);
				setState(112);
				identidade();
				}
				break;
			case 2:
				_localctx = new InicializacaoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(TIPODADOS);
				setState(114);
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
	public static class Atr_variavelFormContext extends AtribuicaoContext {
		public IdentidadeContext nomeVar;
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public Formulario_informacaoContext formulario_informacao() {
			return getRuleContext(Formulario_informacaoContext.class,0);
		}
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Atr_variavelFormContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAtr_variavelForm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAtr_variavelForm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAtr_variavelForm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atr_variavelExprContext extends AtribuicaoContext {
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Atr_variavelExprContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAtr_variavelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAtr_variavelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAtr_variavelExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atr_variavelVariavelContext extends AtribuicaoContext {
		public IdentidadeContext nomeVar;
		public IdentidadeContext nomeElemento;
		public Token what;
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public List<TerminalNode> TEXTO() { return getTokens(GramaticaAtividadeAutomaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(GramaticaAtividadeAutomaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, i);
		}
		public Atr_variavelVariavelContext(AtribuicaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterAtr_variavelVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitAtr_variavelVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitAtr_variavelVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atribuicao);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new Atr_variavelExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				identidade();
				setState(118);
				match(OPERADORATRIBUICAO);
				setState(119);
				expr(0);
				}
				break;
			case 2:
				_localctx = new Atr_variavelVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				((Atr_variavelVariavelContext)_localctx).nomeVar = identidade();
				setState(122);
				match(OPERADORATRIBUICAO);
				setState(123);
				((Atr_variavelVariavelContext)_localctx).nomeElemento = identidade();
				setState(124);
				match(T__7);
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(125);
					((Atr_variavelVariavelContext)_localctx).what = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==NUMERO || _la==TEXTO) ) {
						((Atr_variavelVariavelContext)_localctx).what = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(128); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMERO || _la==TEXTO );
				setState(130);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new Atr_variavelFormContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				((Atr_variavelFormContext)_localctx).nomeVar = identidade();
				setState(133);
				match(OPERADORATRIBUICAO);
				setState(134);
				formulario_informacao();
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
		public SenaoContext senao() {
			return getRuleContext(SenaoContext.class,0);
		}
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
			setState(138);
			match(SE);
			setState(139);
			condition_block();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(140);
				senao();
				setState(141);
				stat_block();
				}
			}

			setState(145);
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
		public EntaoContext entao() {
			return getRuleContext(EntaoContext.class,0);
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
			setState(147);
			expr(0);
			setState(148);
			entao();
			setState(149);
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
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE))) != 0)) {
				{
				{
				setState(151);
				instrucao();
				}
				}
				setState(156);
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

	public static class EntaoContext extends ParserRuleContext {
		public TerminalNode ENTAO() { return getToken(GramaticaAtividadeAutomaticaParser.ENTAO, 0); }
		public EntaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEntao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEntao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEntao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntaoContext entao() throws RecognitionException {
		EntaoContext _localctx = new EntaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_entao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
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

	public static class SenaoContext extends ParserRuleContext {
		public TerminalNode SENAO() { return getToken(GramaticaAtividadeAutomaticaParser.SENAO, 0); }
		public SenaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterSenao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitSenao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitSenao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SenaoContext senao() throws RecognitionException {
		SenaoContext _localctx = new SenaoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_senao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(162);
			((AtomExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(185);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						((PowExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(165);
						match(POW);
						setState(166);
						((PowExprContext)_localctx).right = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new MulDivModExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivModExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(168);
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
						setState(169);
						((MulDivModExprContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new SumDifExprContext(new ExprContext(_parentctx, _parentState));
						((SumDifExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(171);
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
						setState(172);
						((SumDifExprContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						((RelationalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(174);
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
						setState(175);
						((RelationalExprContext)_localctx).right = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualExprContext(new ExprContext(_parentctx, _parentState));
						((EqualExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(177);
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
						setState(178);
						((EqualExprContext)_localctx).right = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						((AndExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(180);
						match(E);
						setState(181);
						((AndExprContext)_localctx).right = expr(3);
						}
						break;
					case 7:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						((OrExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(183);
						match(OU);
						setState(184);
						((OrExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(189);
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
	public static class Tp_stringContext extends Tipo_dadosContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Tp_stringContext(Tipo_dadosContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterTp_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitTp_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitTp_string(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_dadosContext tipo_dados() throws RecognitionException {
		Tipo_dadosContext _localctx = new Tipo_dadosContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_dados);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new Tp_identContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				identidade();
				}
				break;
			case 2:
				_localctx = new Tp_stringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				string();
				}
				break;
			case 3:
				_localctx = new Tp_integerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				integer();
				}
				break;
			case 4:
				_localctx = new Tp_floatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
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
		enterRule(_localctx, 30, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(196);
				match(MENOS);
				}
			}

			setState(199);
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
		enterRule(_localctx, 32, RULE_floate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(201);
				match(MENOS);
				}
			}

			setState(204);
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
		public Token var;
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
		enterRule(_localctx, 34, RULE_identidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((IdentidadeContext)_localctx).var = match(VARIAVEL);
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
		enterRule(_localctx, 36, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
	public static class EmailStringDefaultEmailContext extends Enviar_emailContext {
		public Token assunto;
		public Token corpo;
		public TerminalNode SEND_EMAIL() { return getToken(GramaticaAtividadeAutomaticaParser.SEND_EMAIL, 0); }
		public List<TerminalNode> STRING() { return getTokens(GramaticaAtividadeAutomaticaParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GramaticaAtividadeAutomaticaParser.STRING, i);
		}
		public EmailStringDefaultEmailContext(Enviar_emailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEmailStringDefaultEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEmailStringDefaultEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEmailStringDefaultEmail(this);
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
	public static class EmailAtributosDefaultEmailContext extends Enviar_emailContext {
		public IdentidadeContext assunto;
		public IdentidadeContext corpo;
		public TerminalNode SEND_EMAIL() { return getToken(GramaticaAtividadeAutomaticaParser.SEND_EMAIL, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public EmailAtributosDefaultEmailContext(Enviar_emailContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterEmailAtributosDefaultEmail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitEmailAtributosDefaultEmail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitEmailAtributosDefaultEmail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_enviar_email);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new EmailAtributosContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(SEND_EMAIL);
				setState(211);
				match(T__7);
				setState(212);
				((EmailAtributosContext)_localctx).destinatario = identidade();
				setState(213);
				match(T__4);
				setState(214);
				((EmailAtributosContext)_localctx).assunto = identidade();
				setState(215);
				match(T__4);
				setState(216);
				((EmailAtributosContext)_localctx).corpo = identidade();
				setState(217);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new EmailStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(SEND_EMAIL);
				setState(220);
				match(T__7);
				setState(221);
				((EmailStringContext)_localctx).destinatario = identidade();
				setState(222);
				match(T__4);
				setState(223);
				((EmailStringContext)_localctx).assunto = match(STRING);
				setState(224);
				match(T__4);
				setState(225);
				((EmailStringContext)_localctx).corpo = match(STRING);
				setState(226);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new EmailAtributosDefaultEmailContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(SEND_EMAIL);
				setState(229);
				match(T__7);
				setState(230);
				((EmailAtributosDefaultEmailContext)_localctx).assunto = identidade();
				setState(231);
				match(T__4);
				setState(232);
				((EmailAtributosDefaultEmailContext)_localctx).corpo = identidade();
				setState(233);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new EmailStringDefaultEmailContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(SEND_EMAIL);
				setState(236);
				match(T__7);
				setState(237);
				((EmailStringDefaultEmailContext)_localctx).assunto = match(STRING);
				setState(238);
				match(T__4);
				setState(239);
				((EmailStringDefaultEmailContext)_localctx).corpo = match(STRING);
				setState(240);
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
		public Token what;
		public Token id;
		public Token idvalue;
		public Token whatToUpdate;
		public IdentidadeContext updatevalue;
		public TerminalNode UPDATE() { return getToken(GramaticaAtividadeAutomaticaParser.UPDATE, 0); }
		public TerminalNode OPERADORATRIBUICAO() { return getToken(GramaticaAtividadeAutomaticaParser.OPERADORATRIBUICAO, 0); }
		public TerminalNode STRING() { return getToken(GramaticaAtividadeAutomaticaParser.STRING, 0); }
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
		enterRule(_localctx, 40, RULE_update_informacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(UPDATE);
			setState(244);
			match(T__7);
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(245);
				((Update_informacaoContext)_localctx).what = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Update_informacaoContext)_localctx).what = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(250);
			match(T__4);
			setState(252); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(251);
				((Update_informacaoContext)_localctx).id = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Update_informacaoContext)_localctx).id = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(254); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(256);
			match(T__4);
			setState(257);
			((Update_informacaoContext)_localctx).idvalue = match(STRING);
			setState(258);
			match(T__8);
			setState(259);
			match(OPERADORATRIBUICAO);
			setState(260);
			match(T__7);
			setState(262); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(261);
				((Update_informacaoContext)_localctx).whatToUpdate = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==TEXTO) ) {
					((Update_informacaoContext)_localctx).whatToUpdate = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(264); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(266);
			match(T__4);
			setState(267);
			((Update_informacaoContext)_localctx).updatevalue = identidade();
			setState(268);
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

	public static class Formulario_informacaoContext extends ParserRuleContext {
		public Formulario_informacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formulario_informacao; }
	 
		public Formulario_informacaoContext() { }
		public void copyFrom(Formulario_informacaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FormAnswerContext extends Formulario_informacaoContext {
		public Token dados;
		public TerminalNode FORM() { return getToken(GramaticaAtividadeAutomaticaParser.FORM, 0); }
		public TerminalNode ANSWER() { return getToken(GramaticaAtividadeAutomaticaParser.ANSWER, 0); }
		public TerminalNode NUMERO() { return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, 0); }
		public FormAnswerContext(Formulario_informacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterFormAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitFormAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitFormAnswer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FormApprovContext extends Formulario_informacaoContext {
		public Token dados;
		public TerminalNode FORM() { return getToken(GramaticaAtividadeAutomaticaParser.FORM, 0); }
		public TerminalNode APPROV() { return getToken(GramaticaAtividadeAutomaticaParser.APPROV, 0); }
		public TerminalNode NUMERO() { return getToken(GramaticaAtividadeAutomaticaParser.NUMERO, 0); }
		public FormApprovContext(Formulario_informacaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).enterFormApprov(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaAtividadeAutomaticaListener ) ((GramaticaAtividadeAutomaticaListener)listener).exitFormApprov(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaAtividadeAutomaticaVisitor ) return ((GramaticaAtividadeAutomaticaVisitor<? extends T>)visitor).visitFormApprov(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formulario_informacaoContext formulario_informacao() throws RecognitionException {
		Formulario_informacaoContext _localctx = new Formulario_informacaoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_formulario_informacao);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new FormApprovContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(FORM);
				setState(271);
				match(T__7);
				setState(272);
				match(APPROV);
				setState(273);
				match(T__4);
				setState(274);
				((FormApprovContext)_localctx).dados = match(NUMERO);
				setState(275);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new FormAnswerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(FORM);
				setState(277);
				match(T__7);
				setState(278);
				match(ANSWER);
				setState(279);
				match(T__4);
				setState(280);
				((FormAnswerContext)_localctx).dados = match(NUMERO);
				setState(281);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u011f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\6\4"+
		"B\n\4\r\4\16\4C\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3"+
		"\6\3\6\5\6U\n\6\3\7\3\7\3\7\3\7\3\7\6\7\\\n\7\r\7\16\7]\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\6\7f\n\7\r\7\16\7g\3\7\3\7\6\7l\n\7\r\7\16\7m\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\5\bv\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u0081\n\t"+
		"\r\t\16\t\u0082\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0092\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\7\f\u009b\n\f\f\f\16"+
		"\f\u009e\13\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u00bc\n\17\f\17\16\17\u00bf\13\17\3\20\3\20\3\20\3\20"+
		"\5\20\u00c5\n\20\3\21\5\21\u00c8\n\21\3\21\3\21\3\22\5\22\u00cd\n\22\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00f4\n\25\3\26\3\26"+
		"\3\26\6\26\u00f9\n\26\r\26\16\26\u00fa\3\26\3\26\6\26\u00ff\n\26\r\26"+
		"\16\26\u0100\3\26\3\26\3\26\3\26\3\26\3\26\6\26\u0109\n\26\r\26\16\26"+
		"\u010a\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u011d\n\27\3\27\2\3\34\30\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,\2\7\4\2((++\3\2\26\30\3\2\24\25\3\2\20\23\3\2"+
		"\16\17\2\u012d\2.\3\2\2\2\4=\3\2\2\2\6?\3\2\2\2\bN\3\2\2\2\nT\3\2\2\2"+
		"\fV\3\2\2\2\16u\3\2\2\2\20\u008a\3\2\2\2\22\u008c\3\2\2\2\24\u0095\3\2"+
		"\2\2\26\u009c\3\2\2\2\30\u009f\3\2\2\2\32\u00a1\3\2\2\2\34\u00a3\3\2\2"+
		"\2\36\u00c4\3\2\2\2 \u00c7\3\2\2\2\"\u00cc\3\2\2\2$\u00d0\3\2\2\2&\u00d2"+
		"\3\2\2\2(\u00f3\3\2\2\2*\u00f5\3\2\2\2,\u011c\3\2\2\2.\62\7\3\2\2/\61"+
		"\5\4\3\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3"+
		"\2\2\2\64\62\3\2\2\2\65\66\7\4\2\2\66\3\3\2\2\2\67>\5\16\b\28>\5\22\n"+
		"\29>\5\20\t\2:>\5\6\4\2;>\5(\25\2<>\5*\26\2=\67\3\2\2\2=8\3\2\2\2=9\3"+
		"\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\5\3\2\2\2?A\5\b\5\2@B\5\n\6\2A@"+
		"\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7$\2\2F\7\3\2\2\2G"+
		"H\7#\2\2HO\5$\23\2IJ\7#\2\2JK\5$\23\2KL\7\33\2\2LM\7.\2\2MO\3\2\2\2NG"+
		"\3\2\2\2NI\3\2\2\2O\t\3\2\2\2PQ\7\"\2\2QU\5$\23\2RS\7\"\2\2SU\5\f\7\2"+
		"TP\3\2\2\2TR\3\2\2\2U\13\3\2\2\2VW\5$\23\2WX\7\33\2\2XY\7\5\2\2Y[\7\6"+
		"\2\2Z\\\t\2\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7"+
		"\7\2\2`a\5$\23\2ab\7\b\2\2bc\7\t\2\2ce\7\n\2\2df\t\2\2\2ed\3\2\2\2fg\3"+
		"\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2ik\7\7\2\2jl\t\2\2\2kj\3\2\2\2lm\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\13\2\2p\r\3\2\2\2qr\7!\2\2rv"+
		"\5$\23\2st\7!\2\2tv\5\20\t\2uq\3\2\2\2us\3\2\2\2v\17\3\2\2\2wx\5$\23\2"+
		"xy\7\33\2\2yz\5\34\17\2z\u008b\3\2\2\2{|\5$\23\2|}\7\33\2\2}~\5$\23\2"+
		"~\u0080\7\n\2\2\177\u0081\t\2\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\7\13\2\2\u0085\u008b\3\2\2\2\u0086\u0087\5$\23\2\u0087\u0088\7\33\2\2"+
		"\u0088\u0089\5,\27\2\u0089\u008b\3\2\2\2\u008aw\3\2\2\2\u008a{\3\2\2\2"+
		"\u008a\u0086\3\2\2\2\u008b\21\3\2\2\2\u008c\u008d\7\35\2\2\u008d\u0091"+
		"\5\24\13\2\u008e\u008f\5\32\16\2\u008f\u0090\5\26\f\2\u0090\u0092\3\2"+
		"\2\2\u0091\u008e\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\7 \2\2\u0094\23\3\2\2\2\u0095\u0096\5\34\17\2\u0096\u0097\5\30"+
		"\r\2\u0097\u0098\5\26\f\2\u0098\25\3\2\2\2\u0099\u009b\5\4\3\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\27\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\36\2\2\u00a0\31\3\2\2\2"+
		"\u00a1\u00a2\7\37\2\2\u00a2\33\3\2\2\2\u00a3\u00a4\b\17\1\2\u00a4\u00a5"+
		"\5\36\20\2\u00a5\u00bd\3\2\2\2\u00a6\u00a7\f\t\2\2\u00a7\u00a8\7\31\2"+
		"\2\u00a8\u00bc\5\34\17\n\u00a9\u00aa\f\b\2\2\u00aa\u00ab\t\3\2\2\u00ab"+
		"\u00bc\5\34\17\t\u00ac\u00ad\f\7\2\2\u00ad\u00ae\t\4\2\2\u00ae\u00bc\5"+
		"\34\17\b\u00af\u00b0\f\6\2\2\u00b0\u00b1\t\5\2\2\u00b1\u00bc\5\34\17\7"+
		"\u00b2\u00b3\f\5\2\2\u00b3\u00b4\t\6\2\2\u00b4\u00bc\5\34\17\6\u00b5\u00b6"+
		"\f\4\2\2\u00b6\u00b7\7\r\2\2\u00b7\u00bc\5\34\17\5\u00b8\u00b9\f\3\2\2"+
		"\u00b9\u00ba\7\f\2\2\u00ba\u00bc\5\34\17\4\u00bb\u00a6\3\2\2\2\u00bb\u00a9"+
		"\3\2\2\2\u00bb\u00ac\3\2\2\2\u00bb\u00af\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb"+
		"\u00b5\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\35\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c5"+
		"\5$\23\2\u00c1\u00c5\5&\24\2\u00c2\u00c5\5 \21\2\u00c3\u00c5\5\"\22\2"+
		"\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3"+
		"\3\2\2\2\u00c5\37\3\2\2\2\u00c6\u00c8\7\25\2\2\u00c7\u00c6\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7(\2\2\u00ca!\3\2\2\2\u00cb"+
		"\u00cd\7\25\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3"+
		"\2\2\2\u00ce\u00cf\7)\2\2\u00cf#\3\2\2\2\u00d0\u00d1\7\34\2\2\u00d1%\3"+
		"\2\2\2\u00d2\u00d3\7.\2\2\u00d3\'\3\2\2\2\u00d4\u00d5\7%\2\2\u00d5\u00d6"+
		"\7\n\2\2\u00d6\u00d7\5$\23\2\u00d7\u00d8\7\7\2\2\u00d8\u00d9\5$\23\2\u00d9"+
		"\u00da\7\7\2\2\u00da\u00db\5$\23\2\u00db\u00dc\7\13\2\2\u00dc\u00f4\3"+
		"\2\2\2\u00dd\u00de\7%\2\2\u00de\u00df\7\n\2\2\u00df\u00e0\5$\23\2\u00e0"+
		"\u00e1\7\7\2\2\u00e1\u00e2\7.\2\2\u00e2\u00e3\7\7\2\2\u00e3\u00e4\7.\2"+
		"\2\u00e4\u00e5\7\13\2\2\u00e5\u00f4\3\2\2\2\u00e6\u00e7\7%\2\2\u00e7\u00e8"+
		"\7\n\2\2\u00e8\u00e9\5$\23\2\u00e9\u00ea\7\7\2\2\u00ea\u00eb\5$\23\2\u00eb"+
		"\u00ec\7\13\2\2\u00ec\u00f4\3\2\2\2\u00ed\u00ee\7%\2\2\u00ee\u00ef\7\n"+
		"\2\2\u00ef\u00f0\7.\2\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\7.\2\2\u00f2\u00f4"+
		"\7\13\2\2\u00f3\u00d4\3\2\2\2\u00f3\u00dd\3\2\2\2\u00f3\u00e6\3\2\2\2"+
		"\u00f3\u00ed\3\2\2\2\u00f4)\3\2\2\2\u00f5\u00f6\7&\2\2\u00f6\u00f8\7\n"+
		"\2\2\u00f7\u00f9\t\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\7\7"+
		"\2\2\u00fd\u00ff\t\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\7"+
		"\2\2\u0103\u0104\7.\2\2\u0104\u0105\7\13\2\2\u0105\u0106\7\33\2\2\u0106"+
		"\u0108\7\n\2\2\u0107\u0109\t\2\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010d\7\7\2\2\u010d\u010e\5$\23\2\u010e\u010f\7\13\2\2\u010f+\3\2\2\2"+
		"\u0110\u0111\7\'\2\2\u0111\u0112\7\n\2\2\u0112\u0113\7,\2\2\u0113\u0114"+
		"\7\7\2\2\u0114\u0115\7(\2\2\u0115\u011d\7\13\2\2\u0116\u0117\7\'\2\2\u0117"+
		"\u0118\7\n\2\2\u0118\u0119\7-\2\2\u0119\u011a\7\7\2\2\u011a\u011b\7(\2"+
		"\2\u011b\u011d\7\13\2\2\u011c\u0110\3\2\2\2\u011c\u0116\3\2\2\2\u011d"+
		"-\3\2\2\2\31\62=CNT]gmu\u0082\u008a\u0091\u009c\u00bb\u00bd\u00c4\u00c7"+
		"\u00cc\u00f3\u00fa\u0100\u010a\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}