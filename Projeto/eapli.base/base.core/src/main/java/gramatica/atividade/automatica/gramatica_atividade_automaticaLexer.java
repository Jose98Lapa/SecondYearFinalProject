package gramatica.atividade.automatica;// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/resources\gramatica_atividade_automatica.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramatica_atividade_automaticaLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "DIGITO", "LOWERCASE", "UPPERCASE", 
			"VARIAVEL", "OPERADORLOGICO", "OPERADORLOGICO_EC", "OPERADORMATEMATICO", 
			"OPERADORATRIBUICAO", "SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", 
			"ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", "SEND_EMAIL", "UPDATE", "NUMERO", 
			"REAL", "TEXTO", "NOME_FICHEIRO", "COMMENT", "COMMENTLINE", "ESPACO"
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


	public gramatica_atividade_automaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gramatica/atividade/automatica/gramatica_atividade_automatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u012d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\5\23\u0084\n\23"+
		"\3\23\3\23\7\23\u0088\n\23\f\23\16\23\u008b\13\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0094\n\24\3\25\3\25\3\25\5\25\u0099\n\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00c1\n\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3\"\6\"\u00ec\n\"\r\"\16\"\u00ed\3#\6#\u00f1\n#\r#\16#\u00f2\3#\3"+
		"#\6#\u00f7\n#\r#\16#\u00f8\5#\u00fb\n#\3$\5$\u00fe\n$\3$\6$\u0101\n$\r"+
		"$\16$\u0102\3%\3%\6%\u0107\n%\r%\16%\u0108\3%\3%\3%\3&\3&\3&\3&\7&\u0112"+
		"\n&\f&\16&\u0115\13&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u0120\n\'\f\'"+
		"\16\'\u0123\13\'\3\'\3\'\3(\6(\u0128\n(\r(\16(\u0129\3(\3(\3\u0113\2)"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\2!\2#\2%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34="+
		"\35?\36A\37C E!G\"I#K$M%O&\3\2\n\3\2\62;\3\2c|\3\2C\\\3\2aa\5\2,-//\61"+
		"\61\4\2..\60\60\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u013d\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q"+
		"\3\2\2\2\5W\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13b\3\2\2\2\rd\3\2\2\2\17f\3"+
		"\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25p\3\2\2\2\27r\3\2\2\2\31t\3\2\2\2\33"+
		"v\3\2\2\2\35x\3\2\2\2\37z\3\2\2\2!|\3\2\2\2#~\3\2\2\2%\u0080\3\2\2\2\'"+
		"\u0093\3\2\2\2)\u0098\3\2\2\2+\u009a\3\2\2\2-\u009c\3\2\2\2/\u009f\3\2"+
		"\2\2\61\u00a2\3\2\2\2\63\u00a8\3\2\2\2\65\u00ae\3\2\2\2\67\u00c0\3\2\2"+
		"\29\u00c2\3\2\2\2;\u00cb\3\2\2\2=\u00cf\3\2\2\2?\u00d3\3\2\2\2A\u00e0"+
		"\3\2\2\2C\u00eb\3\2\2\2E\u00f0\3\2\2\2G\u0100\3\2\2\2I\u0106\3\2\2\2K"+
		"\u010d\3\2\2\2M\u011b\3\2\2\2O\u0127\3\2\2\2QR\7D\2\2RS\7G\2\2ST\7I\2"+
		"\2TU\7K\2\2UV\7P\2\2V\4\3\2\2\2WX\7G\2\2XY\7P\2\2YZ\7F\2\2Z\6\3\2\2\2"+
		"[\\\7$\2\2\\\b\3\2\2\2]^\7H\2\2^_\7K\2\2_`\7P\2\2`a\7F\2\2a\n\3\2\2\2"+
		"bc\7]\2\2c\f\3\2\2\2de\7_\2\2e\16\3\2\2\2fg\7y\2\2gh\7j\2\2hi\7g\2\2i"+
		"j\7t\2\2jk\7g\2\2k\20\3\2\2\2lm\7*\2\2m\22\3\2\2\2no\7.\2\2o\24\3\2\2"+
		"\2pq\7+\2\2q\26\3\2\2\2rs\7-\2\2s\30\3\2\2\2tu\7/\2\2u\32\3\2\2\2vw\7"+
		"\61\2\2w\34\3\2\2\2xy\7,\2\2y\36\3\2\2\2z{\t\2\2\2{ \3\2\2\2|}\t\3\2\2"+
		"}\"\3\2\2\2~\177\t\4\2\2\177$\3\2\2\2\u0080\u0081\7&\2\2\u0081\u0083\5"+
		"G$\2\u0082\u0084\t\5\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0089\3\2\2\2\u0085\u0088\5G$\2\u0086\u0088\5C\"\2\u0087\u0085\3\2\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a&\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0094\4>@\2\u008d\u008e"+
		"\7#\2\2\u008e\u0094\7?\2\2\u008f\u0090\7@\2\2\u0090\u0094\7?\2\2\u0091"+
		"\u0092\7>\2\2\u0092\u0094\7?\2\2\u0093\u008c\3\2\2\2\u0093\u008d\3\2\2"+
		"\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094(\3\2\2\2\u0095\u0096"+
		"\7q\2\2\u0096\u0099\7w\2\2\u0097\u0099\7g\2\2\u0098\u0095\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099*\3\2\2\2\u009a\u009b\t\6\2\2\u009b,\3\2\2\2\u009c"+
		"\u009d\7/\2\2\u009d\u009e\7@\2\2\u009e.\3\2\2\2\u009f\u00a0\7u\2\2\u00a0"+
		"\u00a1\7g\2\2\u00a1\60\3\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7v\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7q\2\2\u00a7\62\3\2\2\2\u00a8"+
		"\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7c\2\2"+
		"\u00ac\u00ad\7q\2\2\u00ad\64\3\2\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7"+
		"u\2\2\u00b0\66\3\2\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b3\7W\2\2\u00b3\u00b4"+
		"\7O\2\2\u00b4\u00b5\7G\2\2\u00b5\u00b6\7T\2\2\u00b6\u00c1\7Q\2\2\u00b7"+
		"\u00b8\7T\2\2\u00b8\u00b9\7G\2\2\u00b9\u00ba\7C\2\2\u00ba\u00c1\7N\2\2"+
		"\u00bb\u00bc\7V\2\2\u00bc\u00bd\7G\2\2\u00bd\u00be\7Z\2\2\u00be\u00bf"+
		"\7V\2\2\u00bf\u00c1\7Q\2\2\u00c0\u00b1\3\2\2\2\u00c0\u00b7\3\2\2\2\u00c0"+
		"\u00bb\3\2\2\2\u00c18\3\2\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7N\2\2\u00c4"+
		"\u00c5\7G\2\2\u00c5\u00c6\7O\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7P\2\2"+
		"\u00c8\u00c9\7V\2\2\u00c9\u00ca\7Q\2\2\u00ca:\3\2\2\2\u00cb\u00cc\7Z\2"+
		"\2\u00cc\u00cd\7O\2\2\u00cd\u00ce\7N\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7"+
		"N\2\2\u00d0\u00d1\7O\2\2\u00d1\u00d2\7Z\2\2\u00d2>\3\2\2\2\u00d3\u00d4"+
		"\7G\2\2\u00d4\u00d5\7P\2\2\u00d5\u00d6\7X\2\2\u00d6\u00d7\7K\2\2\u00d7"+
		"\u00d8\7C\2\2\u00d8\u00d9\7T\2\2\u00d9\u00da\7a\2\2\u00da\u00db\7G\2\2"+
		"\u00db\u00dc\7O\2\2\u00dc\u00dd\7C\2\2\u00dd\u00de\7K\2\2\u00de\u00df"+
		"\7N\2\2\u00df@\3\2\2\2\u00e0\u00e1\7C\2\2\u00e1\u00e2\7V\2\2\u00e2\u00e3"+
		"\7W\2\2\u00e3\u00e4\7C\2\2\u00e4\u00e5\7N\2\2\u00e5\u00e6\7K\2\2\u00e6"+
		"\u00e7\7\\\2\2\u00e7\u00e8\7C\2\2\u00e8\u00e9\7T\2\2\u00e9B\3\2\2\2\u00ea"+
		"\u00ec\5\37\20\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00eeD\3\2\2\2\u00ef\u00f1\5\37\20\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00fa\3\2\2\2\u00f4\u00f6\t\7\2\2\u00f5\u00f7\5\37\20\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f4\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"F\3\2\2\2\u00fc\u00fe\5#\22\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2"+
		"\u00fe\u00ff\3\2\2\2\u00ff\u0101\5!\21\2\u0100\u00fd\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103H\3\2\2\2\u0104"+
		"\u0107\5G$\2\u0105\u0107\5C\"\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2"+
		"\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010b\7\60\2\2\u010b\u010c\5G$\2\u010cJ\3\2\2\2\u010d\u010e"+
		"\7\61\2\2\u010e\u010f\7,\2\2\u010f\u0113\3\2\2\2\u0110\u0112\13\2\2\2"+
		"\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0114\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7,\2\2\u0117"+
		"\u0118\7\61\2\2\u0118\u0119\3\2\2\2\u0119\u011a\b&\2\2\u011aL\3\2\2\2"+
		"\u011b\u011c\7\61\2\2\u011c\u011d\7\61\2\2\u011d\u0121\3\2\2\2\u011e\u0120"+
		"\n\b\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\b\'"+
		"\2\2\u0125N\3\2\2\2\u0126\u0128\t\t\2\2\u0127\u0126\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\b(\2\2\u012cP\3\2\2\2\24\2\u0083\u0087\u0089\u0093\u0098\u00c0"+
		"\u00ed\u00f2\u00f8\u00fa\u00fd\u0102\u0106\u0108\u0113\u0121\u0129\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}