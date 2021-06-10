package gramatica.atividade.automatica;// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/resources\gramatica_atividade_automatica.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramatica_atividade_automaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, VARIAVEL=15, OPERADORLOGICO=16, 
		OPERADORLOGICO_EC=17, OPERADORMATEMATICO=18, OPERADORATRIBUICAO=19, SE=20, 
		ENTAO=21, SENAO=22, END_SE=23, TIPODADOS=24, ELEMENTO=25, TIPOFICHEIRO=26, 
		END_FICHEIRO=27, SEND_EMAIL=28, UPDATE=29, NUMERO=30, REAL=31, TEXTO=32, 
		NOME_FICHEIRO=33, COMMENT=34, COMMENTLINE=35, ESPACO=36;
	public static final int
		RULE_gramatica = 0, RULE_instrucao = 1, RULE_inicializacao_tipo_ficheiro = 2, 
		RULE_inicializacao_elemento = 3, RULE_atribuicao_elemento = 4, RULE_expressao_inicializacao = 5, 
		RULE_expressao_atribuicao = 6, RULE_expr = 7, RULE_tipo_dados = 8, RULE_integer = 9, 
		RULE_floate = 10, RULE_identidade = 11, RULE_estrutura_xml = 12, RULE_enviar_email = 13, 
		RULE_update_informacao = 14, RULE_estrutura_condicional = 15, RULE_ife = 16, 
		RULE_elsee = 17;
	private static String[] makeRuleNames() {
		return new String[] {
                "gramatica", "instrucao", "inicializacao_tipo_ficheiro", "inicializacao_elemento",
			"atribuicao_elemento", "expressao_inicializacao", "expressao_atribuicao", 
			"expr", "tipo_dados", "integer", "floate", "identidade", "estrutura_xml", 
			"enviar_email", "update_informacao", "estrutura_condicional", "ife", 
			"elsee"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'\"'", "'FIND'", "'['", "']'", "'where'", 
			"'('", "','", "')'", "'+'", "'-'", "'/'", "'*'", null, null, null, null, 
			"'->'", "'se'", "'entao'", "'senao'", "'es'", null, "'ELEMENTO'", "'XML'", 
			"'LMX'", "'ENVIAR_EMAIL'", "'ATUALIZAR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "VARIAVEL", "OPERADORLOGICO", "OPERADORLOGICO_EC", 
			"OPERADORMATEMATICO", "OPERADORATRIBUICAO", "SE", "ENTAO", "SENAO", "END_SE", 
			"TIPODADOS", "ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", "SEND_EMAIL", 
			"UPDATE", "NUMERO", "REAL", "TEXTO", "NOME_FICHEIRO", "COMMENT", "COMMENTLINE", 
			"ESPACO"
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
	public String getGrammarFileName() { return "gramatica/atividade/automatica/gramatica_atividade_automatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramatica_atividade_automaticaParser(TokenStream input) {
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
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterGramatica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitGramatica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitGramatica(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL))) != 0)) {
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
		public Expressao_inicializacaoContext expressao_inicializacao() {
			return getRuleContext(Expressao_inicializacaoContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Estrutura_condicionalContext estrutura_condicional() {
			return getRuleContext(Estrutura_condicionalContext.class,0);
		}
		public Expressao_atribuicaoContext expressao_atribuicao() {
			return getRuleContext(Expressao_atribuicaoContext.class,0);
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
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterInstrucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitInstrucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitInstrucao(this);
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
				expressao_inicializacao();
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
				estrutura_condicional();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				expressao_atribuicao();
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

	public static class Inicializacao_tipo_ficheiroContext extends ParserRuleContext {
		public TerminalNode TIPOFICHEIRO() { return getToken(gramatica_atividade_automaticaParser.TIPOFICHEIRO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(gramatica_atividade_automaticaParser.OPERADORATRIBUICAO, 0); }
		public TerminalNode NOME_FICHEIRO() { return getToken(gramatica_atividade_automaticaParser.NOME_FICHEIRO, 0); }
		public Inicializacao_tipo_ficheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacao_tipo_ficheiro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterInicializacao_tipo_ficheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitInicializacao_tipo_ficheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitInicializacao_tipo_ficheiro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inicializacao_tipo_ficheiroContext inicializacao_tipo_ficheiro() throws RecognitionException {
		Inicializacao_tipo_ficheiroContext _localctx = new Inicializacao_tipo_ficheiroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inicializacao_tipo_ficheiro);
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

	public static class Inicializacao_elementoContext extends ParserRuleContext {
		public TerminalNode ELEMENTO() { return getToken(gramatica_atividade_automaticaParser.ELEMENTO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Atribuicao_elementoContext atribuicao_elemento() {
			return getRuleContext(Atribuicao_elementoContext.class,0);
		}
		public Inicializacao_elementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicializacao_elemento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterInicializacao_elemento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitInicializacao_elemento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitInicializacao_elemento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inicializacao_elementoContext inicializacao_elemento() throws RecognitionException {
		Inicializacao_elementoContext _localctx = new Inicializacao_elementoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inicializacao_elemento);
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
		public TerminalNode OPERADORATRIBUICAO() { return getToken(gramatica_atividade_automaticaParser.OPERADORATRIBUICAO, 0); }
		public List<TerminalNode> TEXTO() { return getTokens(gramatica_atividade_automaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(gramatica_atividade_automaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(gramatica_atividade_automaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(gramatica_atividade_automaticaParser.NUMERO, i);
		}
		public Atribuicao_elementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao_elemento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterAtribuicao_elemento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitAtribuicao_elemento(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitAtribuicao_elemento(this);
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

	public static class Expressao_inicializacaoContext extends ParserRuleContext {
		public TerminalNode TIPODADOS() { return getToken(gramatica_atividade_automaticaParser.TIPODADOS, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public Expressao_atribuicaoContext expressao_atribuicao() {
			return getRuleContext(Expressao_atribuicaoContext.class,0);
		}
		public Expressao_inicializacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao_inicializacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterExpressao_inicializacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitExpressao_inicializacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitExpressao_inicializacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao_inicializacaoContext expressao_inicializacao() throws RecognitionException {
		Expressao_inicializacaoContext _localctx = new Expressao_inicializacaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expressao_inicializacao);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(TIPODADOS);
				setState(97);
				identidade();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(TIPODADOS);
				setState(99);
				expressao_atribuicao();
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

	public static class Expressao_atribuicaoContext extends ParserRuleContext {
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public TerminalNode OPERADORATRIBUICAO() { return getToken(gramatica_atividade_automaticaParser.OPERADORATRIBUICAO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> TEXTO() { return getTokens(gramatica_atividade_automaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(gramatica_atividade_automaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(gramatica_atividade_automaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(gramatica_atividade_automaticaParser.NUMERO, i);
		}
		public Expressao_atribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterExpressao_atribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitExpressao_atribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitExpressao_atribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expressao_atribuicaoContext expressao_atribuicao() throws RecognitionException {
		Expressao_atribuicaoContext _localctx = new Expressao_atribuicaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expressao_atribuicao);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
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
		public Tipo_dadosContext atom;
		public Token op;
		public Tipo_dadosContext tipo_dados() {
			return getRuleContext(Tipo_dadosContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitExpr(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(120);
			((ExprContext)_localctx).atom = tipo_dados();
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(122);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(123);
						((ExprContext)_localctx).op = match(T__10);
						setState(124);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(126);
						((ExprContext)_localctx).op = match(T__11);
						setState(127);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(129);
						((ExprContext)_localctx).op = match(T__12);
						setState(130);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(132);
						((ExprContext)_localctx).op = match(T__13);
						setState(133);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(138);
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
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public FloateContext floate() {
			return getRuleContext(FloateContext.class,0);
		}
		public Tipo_dadosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_dados; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterTipo_dados(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitTipo_dados(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitTipo_dados(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_dadosContext tipo_dados() throws RecognitionException {
		Tipo_dadosContext _localctx = new Tipo_dadosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo_dados);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				identidade();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				integer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
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
		public TerminalNode NUMERO() { return getToken(gramatica_atividade_automaticaParser.NUMERO, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitInteger(this);
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
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(144);
				match(T__11);
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
		public TerminalNode REAL() { return getToken(gramatica_atividade_automaticaParser.REAL, 0); }
		public FloateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterFloate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitFloate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitFloate(this);
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
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(149);
				match(T__11);
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

	public static class IdentidadeContext extends ParserRuleContext {
		public TerminalNode VARIAVEL() { return getToken(gramatica_atividade_automaticaParser.VARIAVEL, 0); }
		public IdentidadeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identidade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterIdentidade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitIdentidade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitIdentidade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentidadeContext identidade() throws RecognitionException {
		IdentidadeContext _localctx = new IdentidadeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identidade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
		public Inicializacao_tipo_ficheiroContext inicializacao_tipo_ficheiro() {
			return getRuleContext(Inicializacao_tipo_ficheiroContext.class,0);
		}
		public TerminalNode END_FICHEIRO() { return getToken(gramatica_atividade_automaticaParser.END_FICHEIRO, 0); }
		public List<Inicializacao_elementoContext> inicializacao_elemento() {
			return getRuleContexts(Inicializacao_elementoContext.class);
		}
		public Inicializacao_elementoContext inicializacao_elemento(int i) {
			return getRuleContext(Inicializacao_elementoContext.class,i);
		}
		public Estrutura_xmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estrutura_xml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterEstrutura_xml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitEstrutura_xml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitEstrutura_xml(this);
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
			setState(156);
			inicializacao_tipo_ficheiro();
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				inicializacao_elemento();
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELEMENTO );
			setState(162);
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
		public TerminalNode SEND_EMAIL() { return getToken(gramatica_atividade_automaticaParser.SEND_EMAIL, 0); }
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
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterEnviar_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitEnviar_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitEnviar_email(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enviar_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(SEND_EMAIL);
			setState(165);
			match(T__7);
			setState(166);
			identidade();
			setState(167);
			match(T__8);
			setState(168);
			identidade();
			setState(169);
			match(T__8);
			setState(170);
			identidade();
			setState(171);
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
		public TerminalNode UPDATE() { return getToken(gramatica_atividade_automaticaParser.UPDATE, 0); }
		public TerminalNode OPERADORATRIBUICAO() { return getToken(gramatica_atividade_automaticaParser.OPERADORATRIBUICAO, 0); }
		public IdentidadeContext identidade() {
			return getRuleContext(IdentidadeContext.class,0);
		}
		public List<TerminalNode> TEXTO() { return getTokens(gramatica_atividade_automaticaParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(gramatica_atividade_automaticaParser.TEXTO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(gramatica_atividade_automaticaParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(gramatica_atividade_automaticaParser.NUMERO, i);
		}
		public Update_informacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_informacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterUpdate_informacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitUpdate_informacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitUpdate_informacao(this);
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
			setState(173);
			match(UPDATE);
			setState(174);
			match(T__7);
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
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
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(180);
			match(T__8);
			setState(182); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(181);
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
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(186);
			match(T__8);
			setState(188); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(187);
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
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(192);
			match(T__9);
			setState(193);
			match(OPERADORATRIBUICAO);
			setState(194);
			match(T__7);
			setState(196); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(195);
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
				setState(198); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO || _la==TEXTO );
			setState(200);
			match(T__8);
			setState(201);
			identidade();
			setState(202);
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

	public static class Estrutura_condicionalContext extends ParserRuleContext {
		public IfeContext ife() {
			return getRuleContext(IfeContext.class,0);
		}
		public TerminalNode END_SE() { return getToken(gramatica_atividade_automaticaParser.END_SE, 0); }
		public ElseeContext elsee() {
			return getRuleContext(ElseeContext.class,0);
		}
		public Estrutura_condicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estrutura_condicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterEstrutura_condicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitEstrutura_condicional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitEstrutura_condicional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Estrutura_condicionalContext estrutura_condicional() throws RecognitionException {
		Estrutura_condicionalContext _localctx = new Estrutura_condicionalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_estrutura_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			ife();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(205);
				elsee();
				}
			}

			setState(208);
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

	public static class IfeContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(gramatica_atividade_automaticaParser.SE, 0); }
		public List<TerminalNode> OPERADORLOGICO() { return getTokens(gramatica_atividade_automaticaParser.OPERADORLOGICO); }
		public TerminalNode OPERADORLOGICO(int i) {
			return getToken(gramatica_atividade_automaticaParser.OPERADORLOGICO, i);
		}
		public TerminalNode ENTAO() { return getToken(gramatica_atividade_automaticaParser.ENTAO, 0); }
		public List<IdentidadeContext> identidade() {
			return getRuleContexts(IdentidadeContext.class);
		}
		public IdentidadeContext identidade(int i) {
			return getRuleContext(IdentidadeContext.class,i);
		}
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public List<TerminalNode> OPERADORLOGICO_EC() { return getTokens(gramatica_atividade_automaticaParser.OPERADORLOGICO_EC); }
		public TerminalNode OPERADORLOGICO_EC(int i) {
			return getToken(gramatica_atividade_automaticaParser.OPERADORLOGICO_EC, i);
		}
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public IfeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ife; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterIfe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitIfe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitIfe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfeContext ife() throws RecognitionException {
		IfeContext _localctx = new IfeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ife);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(SE);
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIAVEL:
				{
				setState(211);
				identidade();
				}
				break;
			case T__11:
			case NUMERO:
				{
				setState(212);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(215);
			match(OPERADORLOGICO);
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIAVEL:
				{
				setState(216);
				identidade();
				}
				break;
			case T__11:
			case NUMERO:
				{
				setState(217);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPERADORLOGICO_EC) {
				{
				{
				setState(220);
				match(OPERADORLOGICO_EC);
				setState(223);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARIAVEL:
					{
					setState(221);
					identidade();
					}
					break;
				case T__11:
				case NUMERO:
					{
					setState(222);
					integer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225);
				match(OPERADORLOGICO);
				setState(228);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARIAVEL:
					{
					setState(226);
					identidade();
					}
					break;
				case T__11:
				case NUMERO:
					{
					setState(227);
					integer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPERADORLOGICO) {
				{
				setState(235);
				match(OPERADORLOGICO);
				}
			}

			setState(238);
			match(ENTAO);
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(239);
				instrucao();
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL))) != 0) );
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

	public static class ElseeContext extends ParserRuleContext {
		public TerminalNode SENAO() { return getToken(gramatica_atividade_automaticaParser.SENAO, 0); }
		public List<InstrucaoContext> instrucao() {
			return getRuleContexts(InstrucaoContext.class);
		}
		public InstrucaoContext instrucao(int i) {
			return getRuleContext(InstrucaoContext.class,i);
		}
		public ElseeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).enterElsee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramatica_atividade_automaticaListener ) ((gramatica_atividade_automaticaListener)listener).exitElsee(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramatica_atividade_automaticaVisitor ) return ((gramatica_atividade_automaticaVisitor<? extends T>)visitor).visitElsee(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseeContext elsee() throws RecognitionException {
		ElseeContext _localctx = new ElseeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elsee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(SENAO);
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(245);
				instrucao();
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << VARIAVEL) | (1L << SE) | (1L << TIPODADOS) | (1L << TIPOFICHEIRO) | (1L << SEND_EMAIL) | (1L << UPDATE) | (1L << NUMERO) | (1L << REAL))) != 0) );
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
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3"+
		"\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\6\6O\n\6\r\6\16\6P\3\6\3\6\3\6"+
		"\3\6\6\6W\n\6\r\6\16\6X\3\6\3\6\6\6]\n\6\r\6\16\6^\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\5\7g\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\br\n\b\r\b\16\bs\3"+
		"\b\3\b\5\bx\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\7\t\u0089\n\t\f\t\16\t\u008c\13\t\3\n\3\n\3\n\5\n\u0091\n\n\3\13"+
		"\5\13\u0094\n\13\3\13\3\13\3\f\5\f\u0099\n\f\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\6\16\u00a1\n\16\r\16\16\16\u00a2\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\6\20\u00b3\n\20\r\20\16\20\u00b4\3\20"+
		"\3\20\6\20\u00b9\n\20\r\20\16\20\u00ba\3\20\3\20\6\20\u00bf\n\20\r\20"+
		"\16\20\u00c0\3\20\3\20\3\20\3\20\6\20\u00c7\n\20\r\20\16\20\u00c8\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\5\21\u00d1\n\21\3\21\3\21\3\22\3\22\3\22\5\22"+
		"\u00d8\n\22\3\22\3\22\3\22\5\22\u00dd\n\22\3\22\3\22\3\22\5\22\u00e2\n"+
		"\22\3\22\3\22\3\22\5\22\u00e7\n\22\7\22\u00e9\n\22\f\22\16\22\u00ec\13"+
		"\22\3\22\5\22\u00ef\n\22\3\22\3\22\6\22\u00f3\n\22\r\22\16\22\u00f4\3"+
		"\23\3\23\6\23\u00f9\n\23\r\23\16\23\u00fa\3\23\2\3\20\24\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$\2\3\4\2  \"\"\2\u010f\2&\3\2\2\2\4\66\3\2"+
		"\2\2\6A\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\ff\3\2\2\2\16w\3\2\2\2\20y\3\2\2"+
		"\2\22\u0090\3\2\2\2\24\u0093\3\2\2\2\26\u0098\3\2\2\2\30\u009c\3\2\2\2"+
		"\32\u009e\3\2\2\2\34\u00a6\3\2\2\2\36\u00af\3\2\2\2 \u00ce\3\2\2\2\"\u00d4"+
		"\3\2\2\2$\u00f6\3\2\2\2&*\7\3\2\2\')\5\4\3\2(\'\3\2\2\2),\3\2\2\2*(\3"+
		"\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\4\2\2.\3\3\2\2\2/\67\5\f\7\2"+
		"\60\67\5\20\t\2\61\67\5 \21\2\62\67\5\16\b\2\63\67\5\32\16\2\64\67\5\34"+
		"\17\2\65\67\5\36\20\2\66/\3\2\2\2\66\60\3\2\2\2\66\61\3\2\2\2\66\62\3"+
		"\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\7\34\2"+
		"\29B\5\30\r\2:;\7\34\2\2;<\5\30\r\2<=\7\25\2\2=>\7\5\2\2>?\7#\2\2?@\7"+
		"\5\2\2@B\3\2\2\2A8\3\2\2\2A:\3\2\2\2B\7\3\2\2\2CD\7\33\2\2DH\5\30\r\2"+
		"EF\7\33\2\2FH\5\n\6\2GC\3\2\2\2GE\3\2\2\2H\t\3\2\2\2IJ\5\30\r\2JK\7\25"+
		"\2\2KL\7\6\2\2LN\7\7\2\2MO\t\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2"+
		"\2\2QR\3\2\2\2RS\7\b\2\2ST\7\t\2\2TV\7\n\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2"+
		"\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7\13\2\2[]\t\2\2\2\\[\3\2\2\2]^"+
		"\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\f\2\2a\13\3\2\2\2bc\7\32\2"+
		"\2cg\5\30\r\2de\7\32\2\2eg\5\16\b\2fb\3\2\2\2fd\3\2\2\2g\r\3\2\2\2hi\5"+
		"\30\r\2ij\7\25\2\2jk\5\20\t\2kx\3\2\2\2lm\5\30\r\2mn\7\25\2\2no\5\30\r"+
		"\2oq\7\n\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2"+
		"\2uv\7\f\2\2vx\3\2\2\2wh\3\2\2\2wl\3\2\2\2x\17\3\2\2\2yz\b\t\1\2z{\5\22"+
		"\n\2{\u008a\3\2\2\2|}\f\7\2\2}~\7\r\2\2~\u0089\5\20\t\b\177\u0080\f\6"+
		"\2\2\u0080\u0081\7\16\2\2\u0081\u0089\5\20\t\7\u0082\u0083\f\5\2\2\u0083"+
		"\u0084\7\17\2\2\u0084\u0089\5\20\t\6\u0085\u0086\f\4\2\2\u0086\u0087\7"+
		"\20\2\2\u0087\u0089\5\20\t\5\u0088|\3\2\2\2\u0088\177\3\2\2\2\u0088\u0082"+
		"\3\2\2\2\u0088\u0085\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\21\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0091\5\30\r"+
		"\2\u008e\u0091\5\24\13\2\u008f\u0091\5\26\f\2\u0090\u008d\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\23\3\2\2\2\u0092\u0094\7\16\2"+
		"\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096"+
		"\7 \2\2\u0096\25\3\2\2\2\u0097\u0099\7\16\2\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7!\2\2\u009b\27\3\2\2\2"+
		"\u009c\u009d\7\21\2\2\u009d\31\3\2\2\2\u009e\u00a0\5\6\4\2\u009f\u00a1"+
		"\5\b\5\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\35\2\2\u00a5\33\3\2\2"+
		"\2\u00a6\u00a7\7\36\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\5\30\r\2\u00a9"+
		"\u00aa\7\13\2\2\u00aa\u00ab\5\30\r\2\u00ab\u00ac\7\13\2\2\u00ac\u00ad"+
		"\5\30\r\2\u00ad\u00ae\7\f\2\2\u00ae\35\3\2\2\2\u00af\u00b0\7\37\2\2\u00b0"+
		"\u00b2\7\n\2\2\u00b1\u00b3\t\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\7\13\2\2\u00b7\u00b9\t\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3"+
		"\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00be\7\13\2\2\u00bd\u00bf\t\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c3\7\f\2\2\u00c3\u00c4\7\25\2\2\u00c4\u00c6\7\n\2\2\u00c5\u00c7\t"+
		"\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\13\2\2\u00cb\u00cc\5"+
		"\30\r\2\u00cc\u00cd\7\f\2\2\u00cd\37\3\2\2\2\u00ce\u00d0\5\"\22\2\u00cf"+
		"\u00d1\5$\23\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\7\31\2\2\u00d3!\3\2\2\2\u00d4\u00d7\7\26\2\2\u00d5\u00d8"+
		"\5\30\r\2\u00d6\u00d8\5\24\13\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2"+
		"\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc\7\22\2\2\u00da\u00dd\5\30\r\2\u00db"+
		"\u00dd\5\24\13\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00ea\3"+
		"\2\2\2\u00de\u00e1\7\23\2\2\u00df\u00e2\5\30\r\2\u00e0\u00e2\5\24\13\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6"+
		"\7\22\2\2\u00e4\u00e7\5\30\r\2\u00e5\u00e7\5\24\13\2\u00e6\u00e4\3\2\2"+
		"\2\u00e6\u00e5\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00de\3\2\2\2\u00e9\u00ec"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ed\u00ef\7\22\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\7\27\2\2\u00f1\u00f3\5\4\3\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5#\3\2\2\2\u00f6\u00f8\7\30\2\2\u00f7\u00f9\5\4\3\2\u00f8\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"%\3\2\2\2\37*\66AGPX^fsw\u0088\u008a\u0090\u0093\u0098\u00a2\u00b4\u00ba"+
		"\u00c0\u00c8\u00d0\u00d7\u00dc\u00e1\u00e6\u00ea\u00ee\u00f4\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}