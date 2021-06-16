// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
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
public class GramaticaFormularioLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"DIGITO", "LOWERCASE", "UPPERCASE", "OU", "E", "EQ", "NEQ", "GT", "LT", 
			"GTEQ", "LTEQ", "MAIS", "MENOS", "MULT", "DIV", "MOD", "POW", "NOT", 
			"FAIL", "PASS", "MATCHREGEX", "OPERADORATRIBUICAO", "VARIAVEL", "SE", 
			"ENTAO", "SENAO", "END_SE", "TIPODADOS", "ELEMENTO", "NUMERO", "REAL", 
			"NOME_FICHEIRO", "TEXTO", "STRING", "REGEX", "DATA_DIA", "DATA_MES", 
			"DATA_ANO", "DATAREGEX", "COMMENT", "COMMENTLINE", "ESPACO"
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


	public GramaticaFormularioLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GramaticaFormulario.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0173\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\5!\u00c7\n!\3!\3!\7!\u00cb\n!\f!\16!\u00ce\13!\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u00f5\n&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3(\6(\u0101\n(\r(\16(\u0102\3)\6)\u0106\n)\r)\16)\u0107\3)"+
		"\3)\6)\u010c\n)\r)\16)\u010d\5)\u0110\n)\3*\3*\6*\u0114\n*\r*\16*\u0115"+
		"\3*\3*\3*\3+\5+\u011c\n+\3+\6+\u011f\n+\r+\16+\u0120\3,\3,\6,\u0125\n"+
		",\r,\16,\u0126\3,\3,\3-\3-\3-\3-\7-\u012f\n-\f-\16-\u0132\13-\3-\3-\3"+
		"-\3.\5.\u0138\n.\3.\3.\3.\3.\3.\5.\u013f\n.\3/\5/\u0142\n/\3/\3/\3/\5"+
		"/\u0147\n/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\7\62\u0158\n\62\f\62\16\62\u015b\13\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u0166\n\63\f\63\16\63\u0169\13\63"+
		"\3\63\3\63\3\64\6\64\u016e\n\64\r\64\16\64\u016f\3\64\3\64\4\u0130\u0159"+
		"\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33\f\35"+
		"\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33"+
		";\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/c\60e\61g\62\3\2\21"+
		"\3\2\62;\3\2c|\3\2C\\\3\2aa\4\2..\60\60\3\2$$\3\2\62\62\3\2\63;\3\2\63"+
		"\64\3\2\65\65\3\2\62\63\3\2\63\63\3\2\62\64\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\2\u0187\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\3i\3\2\2\2\5o\3\2\2\2\7s\3\2\2\2\tw\3\2\2\2\13y\3\2\2\2"+
		"\r{\3\2\2\2\17}\3\2\2\2\21\177\3\2\2\2\23\u0081\3\2\2\2\25\u0083\3\2\2"+
		"\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008c\3\2\2\2"+
		"\37\u008e\3\2\2\2!\u0090\3\2\2\2#\u0093\3\2\2\2%\u0095\3\2\2\2\'\u0097"+
		"\3\2\2\2)\u009a\3\2\2\2+\u009d\3\2\2\2-\u009f\3\2\2\2/\u00a1\3\2\2\2\61"+
		"\u00a3\3\2\2\2\63\u00a5\3\2\2\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00ab"+
		"\3\2\2\2;\u00b0\3\2\2\2=\u00b5\3\2\2\2?\u00c0\3\2\2\2A\u00c3\3\2\2\2C"+
		"\u00cf\3\2\2\2E\u00d2\3\2\2\2G\u00d8\3\2\2\2I\u00de\3\2\2\2K\u00f4\3\2"+
		"\2\2M\u00f6\3\2\2\2O\u0100\3\2\2\2Q\u0105\3\2\2\2S\u0113\3\2\2\2U\u011e"+
		"\3\2\2\2W\u0122\3\2\2\2Y\u012a\3\2\2\2[\u013e\3\2\2\2]\u0146\3\2\2\2_"+
		"\u0148\3\2\2\2a\u014d\3\2\2\2c\u0153\3\2\2\2e\u0161\3\2\2\2g\u016d\3\2"+
		"\2\2ij\7D\2\2jk\7G\2\2kl\7I\2\2lm\7K\2\2mn\7P\2\2n\4\3\2\2\2op\7G\2\2"+
		"pq\7P\2\2qr\7F\2\2r\6\3\2\2\2st\7c\2\2tu\7v\2\2uv\7t\2\2v\b\3\2\2\2wx"+
		"\7]\2\2x\n\3\2\2\2yz\7_\2\2z\f\3\2\2\2{|\7.\2\2|\16\3\2\2\2}~\7*\2\2~"+
		"\20\3\2\2\2\177\u0080\7+\2\2\u0080\22\3\2\2\2\u0081\u0082\7$\2\2\u0082"+
		"\24\3\2\2\2\u0083\u0084\t\2\2\2\u0084\26\3\2\2\2\u0085\u0086\t\3\2\2\u0086"+
		"\30\3\2\2\2\u0087\u0088\t\4\2\2\u0088\32\3\2\2\2\u0089\u008a\7q\2\2\u008a"+
		"\u008b\7w\2\2\u008b\34\3\2\2\2\u008c\u008d\7g\2\2\u008d\36\3\2\2\2\u008e"+
		"\u008f\7?\2\2\u008f \3\2\2\2\u0090\u0091\7#\2\2\u0091\u0092\7?\2\2\u0092"+
		"\"\3\2\2\2\u0093\u0094\7@\2\2\u0094$\3\2\2\2\u0095\u0096\7>\2\2\u0096"+
		"&\3\2\2\2\u0097\u0098\7@\2\2\u0098\u0099\7?\2\2\u0099(\3\2\2\2\u009a\u009b"+
		"\7>\2\2\u009b\u009c\7?\2\2\u009c*\3\2\2\2\u009d\u009e\7-\2\2\u009e,\3"+
		"\2\2\2\u009f\u00a0\7/\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7,\2\2\u00a2\60\3"+
		"\2\2\2\u00a3\u00a4\7\61\2\2\u00a4\62\3\2\2\2\u00a5\u00a6\7\'\2\2\u00a6"+
		"\64\3\2\2\2\u00a7\u00a8\7`\2\2\u00a8\66\3\2\2\2\u00a9\u00aa\7#\2\2\u00aa"+
		"8\3\2\2\2\u00ab\u00ac\7H\2\2\u00ac\u00ad\7C\2\2\u00ad\u00ae\7K\2\2\u00ae"+
		"\u00af\7N\2\2\u00af:\3\2\2\2\u00b0\u00b1\7R\2\2\u00b1\u00b2\7C\2\2\u00b2"+
		"\u00b3\7U\2\2\u00b3\u00b4\7U\2\2\u00b4<\3\2\2\2\u00b5\u00b6\7o\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7e\2\2\u00b9\u00ba\7j\2\2"+
		"\u00ba\u00bb\7T\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7i\2\2\u00bd\u00be"+
		"\7g\2\2\u00be\u00bf\7z\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7/\2\2\u00c1\u00c2"+
		"\7@\2\2\u00c2@\3\2\2\2\u00c3\u00c4\7&\2\2\u00c4\u00c6\5U+\2\u00c5\u00c7"+
		"\t\5\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00cc\3\2\2\2\u00c8"+
		"\u00cb\5U+\2\u00c9\u00cb\5O(\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2"+
		"\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cdB\3"+
		"\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7g\2\2\u00d1"+
		"D\3\2\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7v\2\2\u00d5"+
		"\u00d6\7c\2\2\u00d6\u00d7\7q\2\2\u00d7F\3\2\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"\u00da\7g\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7q\2\2"+
		"\u00ddH\3\2\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7u\2\2\u00e0J\3\2\2\2\u00e1"+
		"\u00e2\7P\2\2\u00e2\u00e3\7W\2\2\u00e3\u00e4\7O\2\2\u00e4\u00e5\7G\2\2"+
		"\u00e5\u00e6\7T\2\2\u00e6\u00f5\7Q\2\2\u00e7\u00e8\7T\2\2\u00e8\u00e9"+
		"\7G\2\2\u00e9\u00ea\7C\2\2\u00ea\u00f5\7N\2\2\u00eb\u00ec\7V\2\2\u00ec"+
		"\u00ed\7G\2\2\u00ed\u00ee\7Z\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f5\7Q\2\2"+
		"\u00f0\u00f1\7F\2\2\u00f1\u00f2\7C\2\2\u00f2\u00f3\7V\2\2\u00f3\u00f5"+
		"\7C\2\2\u00f4\u00e1\3\2\2\2\u00f4\u00e7\3\2\2\2\u00f4\u00eb\3\2\2\2\u00f4"+
		"\u00f0\3\2\2\2\u00f5L\3\2\2\2\u00f6\u00f7\7G\2\2\u00f7\u00f8\7N\2\2\u00f8"+
		"\u00f9\7G\2\2\u00f9\u00fa\7O\2\2\u00fa\u00fb\7G\2\2\u00fb\u00fc\7P\2\2"+
		"\u00fc\u00fd\7V\2\2\u00fd\u00fe\7Q\2\2\u00feN\3\2\2\2\u00ff\u0101\5\25"+
		"\13\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103P\3\2\2\2\u0104\u0106\5\25\13\2\u0105\u0104\3\2\2"+
		"\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010f"+
		"\3\2\2\2\u0109\u010b\t\6\2\2\u010a\u010c\5\25\13\2\u010b\u010a\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110"+
		"\3\2\2\2\u010f\u0109\3\2\2\2\u010f\u0110\3\2\2\2\u0110R\3\2\2\2\u0111"+
		"\u0114\5U+\2\u0112\u0114\5O(\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2"+
		"\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117\u0118\7\60\2\2\u0118\u0119\5U+\2\u0119T\3\2\2\2\u011a\u011c"+
		"\5\31\r\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2"+
		"\u011d\u011f\5\27\f\2\u011e\u011b\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121V\3\2\2\2\u0122\u0124\7$\2\2\u0123\u0125"+
		"\n\7\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\7$\2\2\u0129X\3\2\2\2\u012a"+
		"\u012b\7B\2\2\u012b\u012c\7B\2\2\u012c\u0130\3\2\2\2\u012d\u012f\13\2"+
		"\2\2\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u0131\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7B"+
		"\2\2\u0134\u0135\7B\2\2\u0135Z\3\2\2\2\u0136\u0138\t\b\2\2\u0137\u0136"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013f\t\t\2\2\u013a"+
		"\u013b\t\n\2\2\u013b\u013f\t\2\2\2\u013c\u013d\t\13\2\2\u013d\u013f\t"+
		"\f\2\2\u013e\u0137\3\2\2\2\u013e\u013a\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\\\3\2\2\2\u0140\u0142\t\b\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2"+
		"\u0142\u0143\3\2\2\2\u0143\u0147\t\t\2\2\u0144\u0145\t\r\2\2\u0145\u0147"+
		"\t\16\2\2\u0146\u0141\3\2\2\2\u0146\u0144\3\2\2\2\u0147^\3\2\2\2\u0148"+
		"\u0149\5\25\13\2\u0149\u014a\5\25\13\2\u014a\u014b\5\25\13\2\u014b\u014c"+
		"\5\25\13\2\u014c`\3\2\2\2\u014d\u014e\5[.\2\u014e\u014f\7\61\2\2\u014f"+
		"\u0150\5]/\2\u0150\u0151\7\61\2\2\u0151\u0152\5_\60\2\u0152b\3\2\2\2\u0153"+
		"\u0154\7\61\2\2\u0154\u0155\7,\2\2\u0155\u0159\3\2\2\2\u0156\u0158\13"+
		"\2\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\7,"+
		"\2\2\u015d\u015e\7\61\2\2\u015e\u015f\3\2\2\2\u015f\u0160\b\62\2\2\u0160"+
		"d\3\2\2\2\u0161\u0162\7\61\2\2\u0162\u0163\7\61\2\2\u0163\u0167\3\2\2"+
		"\2\u0164\u0166\n\17\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2\2\2\u0167"+
		"\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u016a\u016b\b\63\2\2\u016bf\3\2\2\2\u016c\u016e\t\20\2\2\u016d\u016c"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171\u0172\b\64\2\2\u0172h\3\2\2\2\30\2\u00c6\u00ca\u00cc"+
		"\u00f4\u0102\u0107\u010d\u010f\u0113\u0115\u011b\u0120\u0126\u0130\u0137"+
		"\u013e\u0141\u0146\u0159\u0167\u016f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}