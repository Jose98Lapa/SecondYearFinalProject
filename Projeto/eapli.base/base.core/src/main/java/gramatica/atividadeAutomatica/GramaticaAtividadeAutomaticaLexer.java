// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package gramatica.atividadeAutomatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaAtividadeAutomaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

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
			"OPERADORATRIBUICAO", "VARIAVEL", "SE", "ENTAO", "SENAO", "END_SE", "TIPODADOS", 
			"ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", "SEND_EMAIL", "UPDATE", "NUMERO", 
			"REAL", "NOME_FICHEIRO", "TEXTO", "STRING", "COMMENT", "COMMENTLINE", 
			"ESPACO"
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


	public GramaticaAtividadeAutomaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GramaticaAtividadeAutomatica.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u014d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u00af\n\36\3\36\3\36\7\36\u00b3"+
		"\n\36\f\36\16\36\u00b6\13\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5"+
		"#\u00d9\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3)\6)\u0104\n)\r)\16)\u0105\3*\6*\u0109\n*\r*\16*\u010a\3*\3*\6*"+
		"\u010f\n*\r*\16*\u0110\5*\u0113\n*\3+\3+\6+\u0117\n+\r+\16+\u0118\3+\3"+
		"+\3+\3,\5,\u011f\n,\3,\6,\u0122\n,\r,\16,\u0123\3-\3-\6-\u0128\n-\r-\16"+
		"-\u0129\3-\3-\3.\3.\3.\3.\7.\u0132\n.\f.\16.\u0135\13.\3.\3.\3.\3.\3."+
		"\3/\3/\3/\3/\7/\u0140\n/\f/\16/\u0143\13/\3/\3/\3\60\6\60\u0148\n\60\r"+
		"\60\16\60\u0149\3\60\3\60\3\u0133\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\2\27\2\31\2\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/"+
		"\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)"+
		"W*Y+[,]-_.\3\2\n\3\2\62;\3\2c|\3\2C\\\3\2aa\4\2..\60\60\3\2$$\4\2\f\f"+
		"\17\17\5\2\13\f\17\17\"\"\2\u015a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2"+
		"\5g\3\2\2\2\7k\3\2\2\2\tp\3\2\2\2\13r\3\2\2\2\rt\3\2\2\2\17v\3\2\2\2\21"+
		"|\3\2\2\2\23~\3\2\2\2\25\u0080\3\2\2\2\27\u0082\3\2\2\2\31\u0084\3\2\2"+
		"\2\33\u0086\3\2\2\2\35\u0089\3\2\2\2\37\u008b\3\2\2\2!\u008d\3\2\2\2#"+
		"\u0090\3\2\2\2%\u0092\3\2\2\2\'\u0094\3\2\2\2)\u0097\3\2\2\2+\u009a\3"+
		"\2\2\2-\u009c\3\2\2\2/\u009e\3\2\2\2\61\u00a0\3\2\2\2\63\u00a2\3\2\2\2"+
		"\65\u00a4\3\2\2\2\67\u00a6\3\2\2\29\u00a8\3\2\2\2;\u00ab\3\2\2\2=\u00b7"+
		"\3\2\2\2?\u00ba\3\2\2\2A\u00c0\3\2\2\2C\u00c6\3\2\2\2E\u00d8\3\2\2\2G"+
		"\u00da\3\2\2\2I\u00e3\3\2\2\2K\u00e7\3\2\2\2M\u00eb\3\2\2\2O\u00f8\3\2"+
		"\2\2Q\u0103\3\2\2\2S\u0108\3\2\2\2U\u0116\3\2\2\2W\u0121\3\2\2\2Y\u0125"+
		"\3\2\2\2[\u012d\3\2\2\2]\u013b\3\2\2\2_\u0147\3\2\2\2ab\7D\2\2bc\7G\2"+
		"\2cd\7I\2\2de\7K\2\2ef\7P\2\2f\4\3\2\2\2gh\7G\2\2hi\7P\2\2ij\7F\2\2j\6"+
		"\3\2\2\2kl\7H\2\2lm\7K\2\2mn\7P\2\2no\7F\2\2o\b\3\2\2\2pq\7]\2\2q\n\3"+
		"\2\2\2rs\7.\2\2s\f\3\2\2\2tu\7_\2\2u\16\3\2\2\2vw\7y\2\2wx\7j\2\2xy\7"+
		"g\2\2yz\7t\2\2z{\7g\2\2{\20\3\2\2\2|}\7*\2\2}\22\3\2\2\2~\177\7+\2\2\177"+
		"\24\3\2\2\2\u0080\u0081\t\2\2\2\u0081\26\3\2\2\2\u0082\u0083\t\3\2\2\u0083"+
		"\30\3\2\2\2\u0084\u0085\t\4\2\2\u0085\32\3\2\2\2\u0086\u0087\7q\2\2\u0087"+
		"\u0088\7w\2\2\u0088\34\3\2\2\2\u0089\u008a\7g\2\2\u008a\36\3\2\2\2\u008b"+
		"\u008c\7?\2\2\u008c \3\2\2\2\u008d\u008e\7#\2\2\u008e\u008f\7?\2\2\u008f"+
		"\"\3\2\2\2\u0090\u0091\7@\2\2\u0091$\3\2\2\2\u0092\u0093\7>\2\2\u0093"+
		"&\3\2\2\2\u0094\u0095\7@\2\2\u0095\u0096\7?\2\2\u0096(\3\2\2\2\u0097\u0098"+
		"\7>\2\2\u0098\u0099\7?\2\2\u0099*\3\2\2\2\u009a\u009b\7-\2\2\u009b,\3"+
		"\2\2\2\u009c\u009d\7/\2\2\u009d.\3\2\2\2\u009e\u009f\7,\2\2\u009f\60\3"+
		"\2\2\2\u00a0\u00a1\7\61\2\2\u00a1\62\3\2\2\2\u00a2\u00a3\7\'\2\2\u00a3"+
		"\64\3\2\2\2\u00a4\u00a5\7`\2\2\u00a5\66\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7"+
		"8\3\2\2\2\u00a8\u00a9\7/\2\2\u00a9\u00aa\7@\2\2\u00aa:\3\2\2\2\u00ab\u00ac"+
		"\7&\2\2\u00ac\u00ae\5W,\2\u00ad\u00af\t\5\2\2\u00ae\u00ad\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b4\3\2\2\2\u00b0\u00b3\5W,\2\u00b1\u00b3\5Q)\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5<\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\7u\2\2\u00b8\u00b9\7g\2\2\u00b9>\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\u00bc\7p\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7q\2\2"+
		"\u00bf@\3\2\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7p\2"+
		"\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7q\2\2\u00c5B\3\2\2\2\u00c6\u00c7\7"+
		"g\2\2\u00c7\u00c8\7u\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb"+
		"\7W\2\2\u00cb\u00cc\7O\2\2\u00cc\u00cd\7G\2\2\u00cd\u00ce\7T\2\2\u00ce"+
		"\u00d9\7Q\2\2\u00cf\u00d0\7T\2\2\u00d0\u00d1\7G\2\2\u00d1\u00d2\7C\2\2"+
		"\u00d2\u00d9\7N\2\2\u00d3\u00d4\7V\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6"+
		"\7Z\2\2\u00d6\u00d7\7V\2\2\u00d7\u00d9\7Q\2\2\u00d8\u00c9\3\2\2\2\u00d8"+
		"\u00cf\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d9F\3\2\2\2\u00da\u00db\7G\2\2\u00db"+
		"\u00dc\7N\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7O\2\2\u00de\u00df\7G\2\2"+
		"\u00df\u00e0\7P\2\2\u00e0\u00e1\7V\2\2\u00e1\u00e2\7Q\2\2\u00e2H\3\2\2"+
		"\2\u00e3\u00e4\7Z\2\2\u00e4\u00e5\7O\2\2\u00e5\u00e6\7N\2\2\u00e6J\3\2"+
		"\2\2\u00e7\u00e8\7N\2\2\u00e8\u00e9\7O\2\2\u00e9\u00ea\7Z\2\2\u00eaL\3"+
		"\2\2\2\u00eb\u00ec\7G\2\2\u00ec\u00ed\7P\2\2\u00ed\u00ee\7X\2\2\u00ee"+
		"\u00ef\7K\2\2\u00ef\u00f0\7C\2\2\u00f0\u00f1\7T\2\2\u00f1\u00f2\7a\2\2"+
		"\u00f2\u00f3\7G\2\2\u00f3\u00f4\7O\2\2\u00f4\u00f5\7C\2\2\u00f5\u00f6"+
		"\7K\2\2\u00f6\u00f7\7N\2\2\u00f7N\3\2\2\2\u00f8\u00f9\7C\2\2\u00f9\u00fa"+
		"\7V\2\2\u00fa\u00fb\7W\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fd\7N\2\2\u00fd"+
		"\u00fe\7K\2\2\u00fe\u00ff\7\\\2\2\u00ff\u0100\7C\2\2\u0100\u0101\7T\2"+
		"\2\u0101P\3\2\2\2\u0102\u0104\5\25\13\2\u0103\u0102\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106R\3\2\2\2\u0107"+
		"\u0109\5\25\13\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3"+
		"\2\2\2\u010a\u010b\3\2\2\2\u010b\u0112\3\2\2\2\u010c\u010e\t\6\2\2\u010d"+
		"\u010f\5\25\13\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3"+
		"\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u010c\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113T\3\2\2\2\u0114\u0117\5W,\2\u0115\u0117\5Q)\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7\60\2\2\u011b"+
		"\u011c\5W,\2\u011cV\3\2\2\2\u011d\u011f\5\31\r\2\u011e\u011d\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\5\27\f\2\u0121\u011e\3"+
		"\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"X\3\2\2\2\u0125\u0127\7$\2\2\u0126\u0128\n\7\2\2\u0127\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012c\7$\2\2\u012cZ\3\2\2\2\u012d\u012e\7\61\2\2\u012e\u012f"+
		"\7,\2\2\u012f\u0133\3\2\2\2\u0130\u0132\13\2\2\2\u0131\u0130\3\2\2\2\u0132"+
		"\u0135\3\2\2\2\u0133\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0136\3\2"+
		"\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7,\2\2\u0137\u0138\7\61\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013a\b.\2\2\u013a\\\3\2\2\2\u013b\u013c\7\61\2\2"+
		"\u013c\u013d\7\61\2\2\u013d\u0141\3\2\2\2\u013e\u0140\n\b\2\2\u013f\u013e"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0144\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\b/\2\2\u0145^\3\2\2\2\u0146"+
		"\u0148\t\t\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\60\2\2\u014c"+
		"`\3\2\2\2\23\2\u00ae\u00b2\u00b4\u00d8\u0105\u010a\u0110\u0112\u0116\u0118"+
		"\u011e\u0123\u0129\u0133\u0141\u0149\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}