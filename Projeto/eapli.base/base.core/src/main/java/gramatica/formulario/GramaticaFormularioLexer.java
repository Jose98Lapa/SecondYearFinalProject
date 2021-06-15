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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OU=9, 
		E=10, EQ=11, NEQ=12, GT=13, LT=14, GTEQ=15, LTEQ=16, MAIS=17, MENOS=18, 
		MULT=19, DIV=20, MOD=21, POW=22, NOT=23, OPERADORATRIBUICAO=24, VARIAVEL=25, 
		SE=26, ENTAO=27, SENAO=28, END_SE=29, TIPODADOS=30, ELEMENTO=31, NUMERO=32, 
		REAL=33, NOME_FICHEIRO=34, TEXTO=35, STRING=36, DATA_DIA=37, DATA_MES=38, 
		DATA_ANO=39, DATAREGEX=40, COMMENT=41, COMMENTLINE=42, ESPACO=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DIGITO", 
			"LOWERCASE", "UPPERCASE", "OU", "E", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "MAIS", "MENOS", "MULT", "DIV", "MOD", "POW", "NOT", "OPERADORATRIBUICAO", 
			"VARIAVEL", "SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", "ELEMENTO", 
			"NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "STRING", "DATA_DIA", "DATA_MES", 
			"DATA_ANO", "DATAREGEX", "COMMENT", "COMMENTLINE", "ESPACO"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0146\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u00a6"+
		"\n\35\3\35\3\35\7\35\u00aa\n\35\f\35\16\35\u00ad\13\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00d4"+
		"\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\6$\u00e0\n$\r$\16$\u00e1\3%\6%\u00e5"+
		"\n%\r%\16%\u00e6\3%\3%\6%\u00eb\n%\r%\16%\u00ec\5%\u00ef\n%\3&\3&\6&\u00f3"+
		"\n&\r&\16&\u00f4\3&\3&\3&\3\'\5\'\u00fb\n\'\3\'\6\'\u00fe\n\'\r\'\16\'"+
		"\u00ff\3(\3(\6(\u0104\n(\r(\16(\u0105\3(\3(\3)\5)\u010b\n)\3)\3)\3)\3"+
		")\3)\5)\u0112\n)\3*\5*\u0115\n*\3*\3*\3*\5*\u011a\n*\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\3,\3-\3-\3-\3-\7-\u012b\n-\f-\16-\u012e\13-\3-\3-\3-\3-"+
		"\3-\3.\3.\3.\3.\7.\u0139\n.\f.\16.\u013c\13.\3.\3.\3/\6/\u0141\n/\r/\16"+
		"/\u0142\3/\3/\3\u012c\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25"+
		"\2\27\2\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63"+
		"\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-\3\2"+
		"\21\3\2\62;\3\2c|\3\2C\\\3\2aa\4\2..\60\60\3\2$$\3\2\62\62\3\2\63;\3\2"+
		"\63\64\3\2\65\65\3\2\62\63\3\2\63\63\3\2\62\64\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\2\u0159\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5e\3\2\2\2\7i\3\2\2\2\tm\3\2"+
		"\2\2\13o\3\2\2\2\rq\3\2\2\2\17s\3\2\2\2\21u\3\2\2\2\23w\3\2\2\2\25y\3"+
		"\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0084"+
		"\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2\2\2\'\u008e\3\2\2\2"+
		")\u0091\3\2\2\2+\u0093\3\2\2\2-\u0095\3\2\2\2/\u0097\3\2\2\2\61\u0099"+
		"\3\2\2\2\63\u009b\3\2\2\2\65\u009d\3\2\2\2\67\u009f\3\2\2\29\u00a2\3\2"+
		"\2\2;\u00ae\3\2\2\2=\u00b1\3\2\2\2?\u00b7\3\2\2\2A\u00bd\3\2\2\2C\u00d3"+
		"\3\2\2\2E\u00d5\3\2\2\2G\u00df\3\2\2\2I\u00e4\3\2\2\2K\u00f2\3\2\2\2M"+
		"\u00fd\3\2\2\2O\u0101\3\2\2\2Q\u0111\3\2\2\2S\u0119\3\2\2\2U\u011b\3\2"+
		"\2\2W\u0120\3\2\2\2Y\u0126\3\2\2\2[\u0134\3\2\2\2]\u0140\3\2\2\2_`\7D"+
		"\2\2`a\7G\2\2ab\7I\2\2bc\7K\2\2cd\7P\2\2d\4\3\2\2\2ef\7G\2\2fg\7P\2\2"+
		"gh\7F\2\2h\6\3\2\2\2ij\7c\2\2jk\7v\2\2kl\7t\2\2l\b\3\2\2\2mn\7]\2\2n\n"+
		"\3\2\2\2op\7_\2\2p\f\3\2\2\2qr\7*\2\2r\16\3\2\2\2st\7+\2\2t\20\3\2\2\2"+
		"uv\7$\2\2v\22\3\2\2\2wx\t\2\2\2x\24\3\2\2\2yz\t\3\2\2z\26\3\2\2\2{|\t"+
		"\4\2\2|\30\3\2\2\2}~\7q\2\2~\177\7w\2\2\177\32\3\2\2\2\u0080\u0081\7g"+
		"\2\2\u0081\34\3\2\2\2\u0082\u0083\7?\2\2\u0083\36\3\2\2\2\u0084\u0085"+
		"\7#\2\2\u0085\u0086\7?\2\2\u0086 \3\2\2\2\u0087\u0088\7@\2\2\u0088\"\3"+
		"\2\2\2\u0089\u008a\7>\2\2\u008a$\3\2\2\2\u008b\u008c\7@\2\2\u008c\u008d"+
		"\7?\2\2\u008d&\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\7?\2\2\u0090(\3"+
		"\2\2\2\u0091\u0092\7-\2\2\u0092*\3\2\2\2\u0093\u0094\7/\2\2\u0094,\3\2"+
		"\2\2\u0095\u0096\7,\2\2\u0096.\3\2\2\2\u0097\u0098\7\61\2\2\u0098\60\3"+
		"\2\2\2\u0099\u009a\7\'\2\2\u009a\62\3\2\2\2\u009b\u009c\7`\2\2\u009c\64"+
		"\3\2\2\2\u009d\u009e\7#\2\2\u009e\66\3\2\2\2\u009f\u00a0\7/\2\2\u00a0"+
		"\u00a1\7@\2\2\u00a18\3\2\2\2\u00a2\u00a3\7&\2\2\u00a3\u00a5\5M\'\2\u00a4"+
		"\u00a6\t\5\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00ab\3\2"+
		"\2\2\u00a7\u00aa\5M\'\2\u00a8\u00aa\5G$\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		":\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"<\3\2\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7v\2\2\u00b4"+
		"\u00b5\7c\2\2\u00b5\u00b6\7q\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7u\2\2\u00b8"+
		"\u00b9\7g\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7q\2\2"+
		"\u00bc@\3\2\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7u\2\2\u00bfB\3\2\2\2\u00c0"+
		"\u00c1\7P\2\2\u00c1\u00c2\7W\2\2\u00c2\u00c3\7O\2\2\u00c3\u00c4\7G\2\2"+
		"\u00c4\u00c5\7T\2\2\u00c5\u00d4\7Q\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8"+
		"\7G\2\2\u00c8\u00c9\7C\2\2\u00c9\u00d4\7N\2\2\u00ca\u00cb\7V\2\2\u00cb"+
		"\u00cc\7G\2\2\u00cc\u00cd\7Z\2\2\u00cd\u00ce\7V\2\2\u00ce\u00d4\7Q\2\2"+
		"\u00cf\u00d0\7F\2\2\u00d0\u00d1\7C\2\2\u00d1\u00d2\7V\2\2\u00d2\u00d4"+
		"\7C\2\2\u00d3\u00c0\3\2\2\2\u00d3\u00c6\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3"+
		"\u00cf\3\2\2\2\u00d4D\3\2\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7N\2\2\u00d7"+
		"\u00d8\7G\2\2\u00d8\u00d9\7O\2\2\u00d9\u00da\7G\2\2\u00da\u00db\7P\2\2"+
		"\u00db\u00dc\7V\2\2\u00dc\u00dd\7Q\2\2\u00ddF\3\2\2\2\u00de\u00e0\5\23"+
		"\n\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2H\3\2\2\2\u00e3\u00e5\5\23\n\2\u00e4\u00e3\3\2\2\2"+
		"\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ee"+
		"\3\2\2\2\u00e8\u00ea\t\6\2\2\u00e9\u00eb\5\23\n\2\u00ea\u00e9\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00ef\3\2\2\2\u00efJ\3\2\2\2\u00f0"+
		"\u00f3\5M\'\2\u00f1\u00f3\5G$\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2"+
		"\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f7\7\60\2\2\u00f7\u00f8\5M\'\2\u00f8L\3\2\2\2\u00f9"+
		"\u00fb\5\27\f\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3"+
		"\2\2\2\u00fc\u00fe\5\25\13\2\u00fd\u00fa\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100N\3\2\2\2\u0101\u0103\7$\2\2\u0102"+
		"\u0104\n\7\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7$\2\2\u0108"+
		"P\3\2\2\2\u0109\u010b\t\b\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2"+
		"\u010b\u010c\3\2\2\2\u010c\u0112\t\t\2\2\u010d\u010e\t\n\2\2\u010e\u0112"+
		"\t\2\2\2\u010f\u0110\t\13\2\2\u0110\u0112\t\f\2\2\u0111\u010a\3\2\2\2"+
		"\u0111\u010d\3\2\2\2\u0111\u010f\3\2\2\2\u0112R\3\2\2\2\u0113\u0115\t"+
		"\b\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u011a\t\t\2\2\u0117\u0118\t\r\2\2\u0118\u011a\t\16\2\2\u0119\u0114\3"+
		"\2\2\2\u0119\u0117\3\2\2\2\u011aT\3\2\2\2\u011b\u011c\5\23\n\2\u011c\u011d"+
		"\5\23\n\2\u011d\u011e\5\23\n\2\u011e\u011f\5\23\n\2\u011fV\3\2\2\2\u0120"+
		"\u0121\5Q)\2\u0121\u0122\7\61\2\2\u0122\u0123\5S*\2\u0123\u0124\7\61\2"+
		"\2\u0124\u0125\5U+\2\u0125X\3\2\2\2\u0126\u0127\7\61\2\2\u0127\u0128\7"+
		",\2\2\u0128\u012c\3\2\2\2\u0129\u012b\13\2\2\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012d\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012f\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012f\u0130\7,\2\2\u0130\u0131\7\61\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\b-\2\2\u0133Z\3\2\2\2\u0134\u0135\7\61\2\2"+
		"\u0135\u0136\7\61\2\2\u0136\u013a\3\2\2\2\u0137\u0139\n\17\2\2\u0138\u0137"+
		"\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u013e\b.\2\2\u013e\\\3\2\2\2"+
		"\u013f\u0141\t\20\2\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b/\2\2\u0145"+
		"^\3\2\2\2\27\2\u00a5\u00a9\u00ab\u00d3\u00e1\u00e6\u00ec\u00ee\u00f2\u00f4"+
		"\u00fa\u00ff\u0105\u010a\u0111\u0114\u0119\u012c\u013a\u0142\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}