// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\gramatica_formulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramatica_formularioLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, OU=7, E=8, EQ=9, NEQ=10, 
		GT=11, LT=12, GTEQ=13, LTEQ=14, MAIS=15, MENOS=16, MULT=17, DIV=18, MOD=19, 
		POW=20, NOT=21, OPERADORATRIBUICAO=22, VARIAVEL=23, SE=24, ENTAO=25, SENAO=26, 
		END_SE=27, TIPODADOS=28, ELEMENTO=29, NUMERO=30, REAL=31, NOME_FICHEIRO=32, 
		TEXTO=33, STRING=34, DATA_DIA=35, DATA_MES=36, DATA_ANO=37, DATAREGEX=38, 
		COMMENT=39, COMMENTLINE=40, ESPACO=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "DIGITO", "LOWERCASE", 
			"UPPERCASE", "OU", "E", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "MAIS", 
			"MENOS", "MULT", "DIV", "MOD", "POW", "NOT", "OPERADORATRIBUICAO", "VARIAVEL", 
			"SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", "ELEMENTO", "NUMERO", 
			"REAL", "NOME_FICHEIRO", "TEXTO", "STRING", "DATA_DIA", "DATA_MES", "DATA_ANO", 
			"DATAREGEX", "COMMENT", "COMMENTLINE", "ESPACO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BEGIN'", "'END'", "'atr'", "'('", "')'", "'\"'", "'ou'", "'e'", 
			"'='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'^'", "'!'", "'->'", null, "'se'", "'entao'", "'senao'", "'es'", 
			null, "'ELEMENTO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "OU", "E", "EQ", "NEQ", "GT", 
			"LT", "GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", "MOD", "POW", "NOT", 
			"OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", 
			"ELEMENTO", "NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "STRING", "DATA_DIA", 
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


	public gramatica_formularioLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gramatica_formulario.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u013e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u009e\n\33\3\33\3\33\7\33\u00a2\n"+
		"\33\f\33\16\33\u00a5\13\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00cc\n \3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3\"\6\"\u00d8\n\"\r\"\16\"\u00d9\3#\6#\u00dd\n#\r#\16#\u00de\3#\3"+
		"#\6#\u00e3\n#\r#\16#\u00e4\5#\u00e7\n#\3$\3$\6$\u00eb\n$\r$\16$\u00ec"+
		"\3$\3$\3$\3%\5%\u00f3\n%\3%\6%\u00f6\n%\r%\16%\u00f7\3&\3&\6&\u00fc\n"+
		"&\r&\16&\u00fd\3&\3&\3\'\5\'\u0103\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u010a\n"+
		"\'\3(\5(\u010d\n(\3(\3(\3(\5(\u0112\n(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\7+\u0123\n+\f+\16+\u0126\13+\3+\3+\3+\3+\3+\3,\3,\3,\3,"+
		"\7,\u0131\n,\f,\16,\u0134\13,\3,\3,\3-\6-\u0139\n-\r-\16-\u013a\3-\3-"+
		"\3\u0124\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2\25\t\27\n\31\13\33"+
		"\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\32"+
		"9\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+\3\2\21\3\2\62;\3\2c|\3"+
		"\2C\\\3\2aa\4\2..\60\60\3\2$$\3\2\62\62\3\2\63;\3\2\63\64\3\2\65\65\3"+
		"\2\62\63\3\2\63\63\3\2\62\64\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0151"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2"+
		"\2\2\5a\3\2\2\2\7e\3\2\2\2\ti\3\2\2\2\13k\3\2\2\2\rm\3\2\2\2\17o\3\2\2"+
		"\2\21q\3\2\2\2\23s\3\2\2\2\25u\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33|\3\2"+
		"\2\2\35\177\3\2\2\2\37\u0081\3\2\2\2!\u0083\3\2\2\2#\u0086\3\2\2\2%\u0089"+
		"\3\2\2\2\'\u008b\3\2\2\2)\u008d\3\2\2\2+\u008f\3\2\2\2-\u0091\3\2\2\2"+
		"/\u0093\3\2\2\2\61\u0095\3\2\2\2\63\u0097\3\2\2\2\65\u009a\3\2\2\2\67"+
		"\u00a6\3\2\2\29\u00a9\3\2\2\2;\u00af\3\2\2\2=\u00b5\3\2\2\2?\u00cb\3\2"+
		"\2\2A\u00cd\3\2\2\2C\u00d7\3\2\2\2E\u00dc\3\2\2\2G\u00ea\3\2\2\2I\u00f5"+
		"\3\2\2\2K\u00f9\3\2\2\2M\u0109\3\2\2\2O\u0111\3\2\2\2Q\u0113\3\2\2\2S"+
		"\u0118\3\2\2\2U\u011e\3\2\2\2W\u012c\3\2\2\2Y\u0138\3\2\2\2[\\\7D\2\2"+
		"\\]\7G\2\2]^\7I\2\2^_\7K\2\2_`\7P\2\2`\4\3\2\2\2ab\7G\2\2bc\7P\2\2cd\7"+
		"F\2\2d\6\3\2\2\2ef\7c\2\2fg\7v\2\2gh\7t\2\2h\b\3\2\2\2ij\7*\2\2j\n\3\2"+
		"\2\2kl\7+\2\2l\f\3\2\2\2mn\7$\2\2n\16\3\2\2\2op\t\2\2\2p\20\3\2\2\2qr"+
		"\t\3\2\2r\22\3\2\2\2st\t\4\2\2t\24\3\2\2\2uv\7q\2\2vw\7w\2\2w\26\3\2\2"+
		"\2xy\7g\2\2y\30\3\2\2\2z{\7?\2\2{\32\3\2\2\2|}\7#\2\2}~\7?\2\2~\34\3\2"+
		"\2\2\177\u0080\7@\2\2\u0080\36\3\2\2\2\u0081\u0082\7>\2\2\u0082 \3\2\2"+
		"\2\u0083\u0084\7@\2\2\u0084\u0085\7?\2\2\u0085\"\3\2\2\2\u0086\u0087\7"+
		">\2\2\u0087\u0088\7?\2\2\u0088$\3\2\2\2\u0089\u008a\7-\2\2\u008a&\3\2"+
		"\2\2\u008b\u008c\7/\2\2\u008c(\3\2\2\2\u008d\u008e\7,\2\2\u008e*\3\2\2"+
		"\2\u008f\u0090\7\61\2\2\u0090,\3\2\2\2\u0091\u0092\7\'\2\2\u0092.\3\2"+
		"\2\2\u0093\u0094\7`\2\2\u0094\60\3\2\2\2\u0095\u0096\7#\2\2\u0096\62\3"+
		"\2\2\2\u0097\u0098\7/\2\2\u0098\u0099\7@\2\2\u0099\64\3\2\2\2\u009a\u009b"+
		"\7&\2\2\u009b\u009d\5I%\2\u009c\u009e\t\5\2\2\u009d\u009c\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a3\3\2\2\2\u009f\u00a2\5I%\2\u00a0\u00a2\5C\""+
		"\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\66\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a88\3\2\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7q\2\2"+
		"\u00ae:\3\2\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7g\2\2\u00b1\u00b2\7p\2"+
		"\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7q\2\2\u00b4<\3\2\2\2\u00b5\u00b6\7"+
		"g\2\2\u00b6\u00b7\7u\2\2\u00b7>\3\2\2\2\u00b8\u00b9\7P\2\2\u00b9\u00ba"+
		"\7W\2\2\u00ba\u00bb\7O\2\2\u00bb\u00bc\7G\2\2\u00bc\u00bd\7T\2\2\u00bd"+
		"\u00cc\7Q\2\2\u00be\u00bf\7T\2\2\u00bf\u00c0\7G\2\2\u00c0\u00c1\7C\2\2"+
		"\u00c1\u00cc\7N\2\2\u00c2\u00c3\7V\2\2\u00c3\u00c4\7G\2\2\u00c4\u00c5"+
		"\7Z\2\2\u00c5\u00c6\7V\2\2\u00c6\u00cc\7Q\2\2\u00c7\u00c8\7F\2\2\u00c8"+
		"\u00c9\7C\2\2\u00c9\u00ca\7V\2\2\u00ca\u00cc\7C\2\2\u00cb\u00b8\3\2\2"+
		"\2\u00cb\u00be\3\2\2\2\u00cb\u00c2\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cc@"+
		"\3\2\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7N\2\2\u00cf\u00d0\7G\2\2\u00d0"+
		"\u00d1\7O\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7P\2\2\u00d3\u00d4\7V\2\2"+
		"\u00d4\u00d5\7Q\2\2\u00d5B\3\2\2\2\u00d6\u00d8\5\17\b\2\u00d7\u00d6\3"+
		"\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"D\3\2\2\2\u00db\u00dd\5\17\b\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e6\3\2\2\2\u00e0\u00e2"+
		"\t\6\2\2\u00e1\u00e3\5\17\b\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e0"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7F\3\2\2\2\u00e8\u00eb\5I%\2\u00e9\u00eb"+
		"\5C\"\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\60"+
		"\2\2\u00ef\u00f0\5I%\2\u00f0H\3\2\2\2\u00f1\u00f3\5\23\n\2\u00f2\u00f1"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\5\21\t\2"+
		"\u00f5\u00f2\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8J\3\2\2\2\u00f9\u00fb\7$\2\2\u00fa\u00fc\n\7\2\2\u00fb\u00fa"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\7$\2\2\u0100L\3\2\2\2\u0101\u0103\t\b\2\2\u0102"+
		"\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u010a\t\t"+
		"\2\2\u0105\u0106\t\n\2\2\u0106\u010a\t\2\2\2\u0107\u0108\t\13\2\2\u0108"+
		"\u010a\t\f\2\2\u0109\u0102\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u010aN\3\2\2\2\u010b\u010d\t\b\2\2\u010c\u010b\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0112\t\t\2\2\u010f\u0110\t\r\2\2\u0110"+
		"\u0112\t\16\2\2\u0111\u010c\3\2\2\2\u0111\u010f\3\2\2\2\u0112P\3\2\2\2"+
		"\u0113\u0114\5\17\b\2\u0114\u0115\5\17\b\2\u0115\u0116\5\17\b\2\u0116"+
		"\u0117\5\17\b\2\u0117R\3\2\2\2\u0118\u0119\5M\'\2\u0119\u011a\7\61\2\2"+
		"\u011a\u011b\5O(\2\u011b\u011c\7\61\2\2\u011c\u011d\5Q)\2\u011dT\3\2\2"+
		"\2\u011e\u011f\7\61\2\2\u011f\u0120\7,\2\2\u0120\u0124\3\2\2\2\u0121\u0123"+
		"\13\2\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0125\3\2\2\2"+
		"\u0124\u0122\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128"+
		"\7,\2\2\u0128\u0129\7\61\2\2\u0129\u012a\3\2\2\2\u012a\u012b\b+\2\2\u012b"+
		"V\3\2\2\2\u012c\u012d\7\61\2\2\u012d\u012e\7\61\2\2\u012e\u0132\3\2\2"+
		"\2\u012f\u0131\n\17\2\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0135\u0136\b,\2\2\u0136X\3\2\2\2\u0137\u0139\t\20\2\2\u0138\u0137"+
		"\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\b-\2\2\u013dZ\3\2\2\2\27\2\u009d\u00a1\u00a3"+
		"\u00cb\u00d9\u00de\u00e4\u00e6\u00ea\u00ec\u00f2\u00f7\u00fd\u0102\u0109"+
		"\u010c\u0111\u0124\u0132\u013a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}