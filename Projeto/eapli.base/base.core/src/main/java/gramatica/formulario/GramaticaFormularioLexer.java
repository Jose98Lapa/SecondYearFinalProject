// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
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
			"NOME_FICHEIRO", "TEXTO", "STRING", "STR", "REGEX", "DATA_DIA", "DATA_MES", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0181\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3!\3!\6!\u00c8\n!\r!\16!\u00c9\3!\5!\u00cd\n!\3!\6!\u00d0\n"+
		"!\r!\16!\u00d1\3!\7!\u00d5\n!\f!\16!\u00d8\13!\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\5&\u00ff\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\6(\u010b\n(\r(\16(\u010c\3)\6)\u0110\n)\r)\16)\u0111\3)\3)\6)\u0116"+
		"\n)\r)\16)\u0117\5)\u011a\n)\3*\3*\6*\u011e\n*\r*\16*\u011f\3*\3*\3*\3"+
		"+\5+\u0126\n+\3+\6+\u0129\n+\r+\16+\u012a\3,\3,\3,\3,\3-\6-\u0132\n-\r"+
		"-\16-\u0133\3-\5-\u0137\n-\3.\3.\3.\3.\7.\u013d\n.\f.\16.\u0140\13.\3"+
		".\3.\3.\3/\5/\u0146\n/\3/\3/\3/\3/\3/\5/\u014d\n/\3\60\5\60\u0150\n\60"+
		"\3\60\3\60\3\60\5\60\u0155\n\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\63\7\63\u0166\n\63\f\63\16\63\u0169\13"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0174\n\64\f\64"+
		"\16\64\u0177\13\64\3\64\3\64\3\65\6\65\u017c\n\65\r\65\16\65\u017d\3\65"+
		"\3\65\4\u013e\u0167\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2"+
		"\27\2\31\2\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30"+
		"\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y\2[+],_-a.c/"+
		"e\60g\61i\62\3\2\22\3\2\62;\3\2c|\3\2C\\\5\2C\\aac|\3\2aa\3\2\60\60\3"+
		"\2$$\3\2\62\62\3\2\63;\3\2\63\64\3\2\65\65\3\2\62\63\3\2\63\63\3\2\62"+
		"\64\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0197\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G"+
		"\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2"+
		"\2\2\2U\3\2\2\2\2W\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5q\3\2\2\2\7u"+
		"\3\2\2\2\ty\3\2\2\2\13{\3\2\2\2\r}\3\2\2\2\17\177\3\2\2\2\21\u0081\3\2"+
		"\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31\u0089\3\2\2"+
		"\2\33\u008b\3\2\2\2\35\u008e\3\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#"+
		"\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2)\u009c\3\2\2\2+\u009f\3"+
		"\2\2\2-\u00a1\3\2\2\2/\u00a3\3\2\2\2\61\u00a5\3\2\2\2\63\u00a7\3\2\2\2"+
		"\65\u00a9\3\2\2\2\67\u00ab\3\2\2\29\u00ad\3\2\2\2;\u00b2\3\2\2\2=\u00b7"+
		"\3\2\2\2?\u00c2\3\2\2\2A\u00c5\3\2\2\2C\u00d9\3\2\2\2E\u00dc\3\2\2\2G"+
		"\u00e2\3\2\2\2I\u00e8\3\2\2\2K\u00fe\3\2\2\2M\u0100\3\2\2\2O\u010a\3\2"+
		"\2\2Q\u010f\3\2\2\2S\u011d\3\2\2\2U\u0128\3\2\2\2W\u012c\3\2\2\2Y\u0136"+
		"\3\2\2\2[\u0138\3\2\2\2]\u014c\3\2\2\2_\u0154\3\2\2\2a\u0156\3\2\2\2c"+
		"\u015b\3\2\2\2e\u0161\3\2\2\2g\u016f\3\2\2\2i\u017b\3\2\2\2kl\7D\2\2l"+
		"m\7G\2\2mn\7I\2\2no\7K\2\2op\7P\2\2p\4\3\2\2\2qr\7G\2\2rs\7P\2\2st\7F"+
		"\2\2t\6\3\2\2\2uv\7c\2\2vw\7v\2\2wx\7t\2\2x\b\3\2\2\2yz\7]\2\2z\n\3\2"+
		"\2\2{|\7_\2\2|\f\3\2\2\2}~\7.\2\2~\16\3\2\2\2\177\u0080\7*\2\2\u0080\20"+
		"\3\2\2\2\u0081\u0082\7+\2\2\u0082\22\3\2\2\2\u0083\u0084\7$\2\2\u0084"+
		"\24\3\2\2\2\u0085\u0086\t\2\2\2\u0086\26\3\2\2\2\u0087\u0088\t\3\2\2\u0088"+
		"\30\3\2\2\2\u0089\u008a\t\4\2\2\u008a\32\3\2\2\2\u008b\u008c\7q\2\2\u008c"+
		"\u008d\7w\2\2\u008d\34\3\2\2\2\u008e\u008f\7g\2\2\u008f\36\3\2\2\2\u0090"+
		"\u0091\7?\2\2\u0091 \3\2\2\2\u0092\u0093\7#\2\2\u0093\u0094\7?\2\2\u0094"+
		"\"\3\2\2\2\u0095\u0096\7@\2\2\u0096$\3\2\2\2\u0097\u0098\7>\2\2\u0098"+
		"&\3\2\2\2\u0099\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b(\3\2\2\2\u009c\u009d"+
		"\7>\2\2\u009d\u009e\7?\2\2\u009e*\3\2\2\2\u009f\u00a0\7-\2\2\u00a0,\3"+
		"\2\2\2\u00a1\u00a2\7/\2\2\u00a2.\3\2\2\2\u00a3\u00a4\7,\2\2\u00a4\60\3"+
		"\2\2\2\u00a5\u00a6\7\61\2\2\u00a6\62\3\2\2\2\u00a7\u00a8\7\'\2\2\u00a8"+
		"\64\3\2\2\2\u00a9\u00aa\7`\2\2\u00aa\66\3\2\2\2\u00ab\u00ac\7#\2\2\u00ac"+
		"8\3\2\2\2\u00ad\u00ae\7H\2\2\u00ae\u00af\7C\2\2\u00af\u00b0\7K\2\2\u00b0"+
		"\u00b1\7N\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7R\2\2\u00b3\u00b4\7C\2\2\u00b4"+
		"\u00b5\7U\2\2\u00b5\u00b6\7U\2\2\u00b6<\3\2\2\2\u00b7\u00b8\7o\2\2\u00b8"+
		"\u00b9\7c\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc\7j\2\2"+
		"\u00bc\u00bd\7T\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7i\2\2\u00bf\u00c0"+
		"\7g\2\2\u00c0\u00c1\7z\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7/\2\2\u00c3\u00c4"+
		"\7@\2\2\u00c4@\3\2\2\2\u00c5\u00c7\7&\2\2\u00c6\u00c8\t\5\2\2\u00c7\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cc\3\2\2\2\u00cb\u00cd\t\6\2\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00d6\3\2\2\2\u00ce\u00d0\t\5\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2"+
		"\2\2\u00d3\u00d5\5O(\2\u00d4\u00cf\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7B\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7g\2\2\u00dbD\3\2\2\2\u00dc"+
		"\u00dd\7g\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7c\2\2"+
		"\u00e0\u00e1\7q\2\2\u00e1F\3\2\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7g\2"+
		"\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7q\2\2\u00e7H\3\2"+
		"\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7u\2\2\u00eaJ\3\2\2\2\u00eb\u00ec"+
		"\7P\2\2\u00ec\u00ed\7W\2\2\u00ed\u00ee\7O\2\2\u00ee\u00ef\7G\2\2\u00ef"+
		"\u00f0\7T\2\2\u00f0\u00ff\7Q\2\2\u00f1\u00f2\7T\2\2\u00f2\u00f3\7G\2\2"+
		"\u00f3\u00f4\7C\2\2\u00f4\u00ff\7N\2\2\u00f5\u00f6\7V\2\2\u00f6\u00f7"+
		"\7G\2\2\u00f7\u00f8\7Z\2\2\u00f8\u00f9\7V\2\2\u00f9\u00ff\7Q\2\2\u00fa"+
		"\u00fb\7F\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fd\7V\2\2\u00fd\u00ff\7C\2\2"+
		"\u00fe\u00eb\3\2\2\2\u00fe\u00f1\3\2\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00fa"+
		"\3\2\2\2\u00ffL\3\2\2\2\u0100\u0101\7G\2\2\u0101\u0102\7N\2\2\u0102\u0103"+
		"\7G\2\2\u0103\u0104\7O\2\2\u0104\u0105\7G\2\2\u0105\u0106\7P\2\2\u0106"+
		"\u0107\7V\2\2\u0107\u0108\7Q\2\2\u0108N\3\2\2\2\u0109\u010b\5\25\13\2"+
		"\u010a\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d"+
		"\3\2\2\2\u010dP\3\2\2\2\u010e\u0110\5\25\13\2\u010f\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0119\3\2"+
		"\2\2\u0113\u0115\t\7\2\2\u0114\u0116\5\25\13\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2"+
		"\2\2\u0119\u0113\3\2\2\2\u0119\u011a\3\2\2\2\u011aR\3\2\2\2\u011b\u011e"+
		"\5U+\2\u011c\u011e\5O(\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\7\60\2\2\u0122\u0123\5U+\2\u0123T\3\2\2\2\u0124\u0126"+
		"\5\31\r\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2"+
		"\u0127\u0129\5\27\f\2\u0128\u0125\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012bV\3\2\2\2\u012c\u012d\7$\2\2\u012d\u012e"+
		"\5Y-\2\u012e\u012f\7$\2\2\u012fX\3\2\2\2\u0130\u0132\n\b\2\2\u0131\u0130"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0137\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0131\3\2\2\2\u0136\u0135\3\2"+
		"\2\2\u0137Z\3\2\2\2\u0138\u0139\7B\2\2\u0139\u013a\7B\2\2\u013a\u013e"+
		"\3\2\2\2\u013b\u013d\13\2\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2"+
		"\u013e\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0141\u0142\7B\2\2\u0142\u0143\7B\2\2\u0143\\\3\2\2\2\u0144\u0146"+
		"\t\t\2\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u014d\t\n\2\2\u0148\u0149\t\13\2\2\u0149\u014d\t\2\2\2\u014a\u014b\t"+
		"\f\2\2\u014b\u014d\t\r\2\2\u014c\u0145\3\2\2\2\u014c\u0148\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014d^\3\2\2\2\u014e\u0150\t\t\2\2\u014f\u014e\3\2\2\2"+
		"\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0155\t\n\2\2\u0152\u0153"+
		"\t\16\2\2\u0153\u0155\t\17\2\2\u0154\u014f\3\2\2\2\u0154\u0152\3\2\2\2"+
		"\u0155`\3\2\2\2\u0156\u0157\5\25\13\2\u0157\u0158\5\25\13\2\u0158\u0159"+
		"\5\25\13\2\u0159\u015a\5\25\13\2\u015ab\3\2\2\2\u015b\u015c\5]/\2\u015c"+
		"\u015d\7\61\2\2\u015d\u015e\5_\60\2\u015e\u015f\7\61\2\2\u015f\u0160\5"+
		"a\61\2\u0160d\3\2\2\2\u0161\u0162\7\61\2\2\u0162\u0163\7,\2\2\u0163\u0167"+
		"\3\2\2\2\u0164\u0166\13\2\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2\2\2"+
		"\u0167\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016b\7,\2\2\u016b\u016c\7\61\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\b\63\2\2\u016ef\3\2\2\2\u016f\u0170\7\61\2\2\u0170\u0171\7\61\2"+
		"\2\u0171\u0175\3\2\2\2\u0172\u0174\n\20\2\2\u0173\u0172\3\2\2\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0178\u0179\b\64\2\2\u0179h\3\2\2\2\u017a\u017c"+
		"\t\21\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2\2\2"+
		"\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\b\65\2\2\u0180j\3"+
		"\2\2\2\33\2\u00c9\u00cc\u00d1\u00d4\u00d6\u00fe\u010c\u0111\u0117\u0119"+
		"\u011d\u011f\u0125\u012a\u0133\u0136\u013e\u0145\u014c\u014f\u0154\u0167"+
		"\u0175\u017d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}