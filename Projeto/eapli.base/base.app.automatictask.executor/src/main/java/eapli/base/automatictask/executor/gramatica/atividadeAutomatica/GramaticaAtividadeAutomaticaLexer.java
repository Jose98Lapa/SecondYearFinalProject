// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.app.automatictask.executor/src/main/java/eapli/base/automatictask/executor/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package eapli.base.automatictask.executor.gramatica.atividadeAutomatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

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
		END_FICHEIRO=34, SEND_EMAIL=35, UPDATE=36, FORM=37, NUMERO=38, REAL=39, 
		NOME_FICHEIRO=40, TEXTO=41, APPROV=42, ANSWER=43, STRING=44, COMMENT=45, 
		COMMENTLINE=46, ESPACO=47;
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
			"ELEMENTO", "TIPOFICHEIRO", "END_FICHEIRO", "SEND_EMAIL", "UPDATE", "FORM", 
			"NUMERO", "REAL", "NOME_FICHEIRO", "TEXTO", "APPROV", "ANSWER", "STRING", 
			"COMMENT", "COMMENTLINE", "ESPACO"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0180\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\5\36"+
		"\u00b5\n\36\3\36\3\36\7\36\u00b9\n\36\f\36\16\36\u00bc\13\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u00df\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\6*\u010f\n*\r*\16"+
		"*\u0110\3+\6+\u0114\n+\r+\16+\u0115\3+\3+\6+\u011a\n+\r+\16+\u011b\5+"+
		"\u011e\n+\3,\3,\6,\u0122\n,\r,\16,\u0123\3,\3,\3,\3-\5-\u012a\n-\3-\6"+
		"-\u012d\n-\r-\16-\u012e\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\5.\u0145\n.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\5/\u0157\n/\3\60\3\60\6\60\u015b\n\60\r\60\16\60\u015c\3\60\3\60"+
		"\3\61\3\61\3\61\3\61\7\61\u0165\n\61\f\61\16\61\u0168\13\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0173\n\62\f\62\16\62\u0176\13"+
		"\62\3\62\3\62\3\63\6\63\u017b\n\63\r\63\16\63\u017c\3\63\3\63\3\u0166"+
		"\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33\f\35"+
		"\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33"+
		";\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/c\60e\61\3\2\n\3\2\62"+
		";\3\2c|\3\2C\\\3\2aa\3\2\60\60\3\2$$\4\2\f\f\17\17\5\2\13\f\17\17\"\""+
		"\2\u0191\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3"+
		"g\3\2\2\2\5m\3\2\2\2\7q\3\2\2\2\tv\3\2\2\2\13x\3\2\2\2\rz\3\2\2\2\17|"+
		"\3\2\2\2\21\u0082\3\2\2\2\23\u0084\3\2\2\2\25\u0086\3\2\2\2\27\u0088\3"+
		"\2\2\2\31\u008a\3\2\2\2\33\u008c\3\2\2\2\35\u008f\3\2\2\2\37\u0091\3\2"+
		"\2\2!\u0093\3\2\2\2#\u0096\3\2\2\2%\u0098\3\2\2\2\'\u009a\3\2\2\2)\u009d"+
		"\3\2\2\2+\u00a0\3\2\2\2-\u00a2\3\2\2\2/\u00a4\3\2\2\2\61\u00a6\3\2\2\2"+
		"\63\u00a8\3\2\2\2\65\u00aa\3\2\2\2\67\u00ac\3\2\2\29\u00ae\3\2\2\2;\u00b1"+
		"\3\2\2\2=\u00bd\3\2\2\2?\u00c0\3\2\2\2A\u00c6\3\2\2\2C\u00cc\3\2\2\2E"+
		"\u00de\3\2\2\2G\u00e0\3\2\2\2I\u00e9\3\2\2\2K\u00ed\3\2\2\2M\u00f1\3\2"+
		"\2\2O\u00fe\3\2\2\2Q\u0108\3\2\2\2S\u010e\3\2\2\2U\u0113\3\2\2\2W\u0121"+
		"\3\2\2\2Y\u012c\3\2\2\2[\u0144\3\2\2\2]\u0156\3\2\2\2_\u0158\3\2\2\2a"+
		"\u0160\3\2\2\2c\u016e\3\2\2\2e\u017a\3\2\2\2gh\7D\2\2hi\7G\2\2ij\7I\2"+
		"\2jk\7K\2\2kl\7P\2\2l\4\3\2\2\2mn\7G\2\2no\7P\2\2op\7F\2\2p\6\3\2\2\2"+
		"qr\7H\2\2rs\7K\2\2st\7P\2\2tu\7F\2\2u\b\3\2\2\2vw\7]\2\2w\n\3\2\2\2xy"+
		"\7.\2\2y\f\3\2\2\2z{\7_\2\2{\16\3\2\2\2|}\7y\2\2}~\7j\2\2~\177\7g\2\2"+
		"\177\u0080\7t\2\2\u0080\u0081\7g\2\2\u0081\20\3\2\2\2\u0082\u0083\7*\2"+
		"\2\u0083\22\3\2\2\2\u0084\u0085\7+\2\2\u0085\24\3\2\2\2\u0086\u0087\t"+
		"\2\2\2\u0087\26\3\2\2\2\u0088\u0089\t\3\2\2\u0089\30\3\2\2\2\u008a\u008b"+
		"\t\4\2\2\u008b\32\3\2\2\2\u008c\u008d\7q\2\2\u008d\u008e\7w\2\2\u008e"+
		"\34\3\2\2\2\u008f\u0090\7g\2\2\u0090\36\3\2\2\2\u0091\u0092\7?\2\2\u0092"+
		" \3\2\2\2\u0093\u0094\7#\2\2\u0094\u0095\7?\2\2\u0095\"\3\2\2\2\u0096"+
		"\u0097\7@\2\2\u0097$\3\2\2\2\u0098\u0099\7>\2\2\u0099&\3\2\2\2\u009a\u009b"+
		"\7@\2\2\u009b\u009c\7?\2\2\u009c(\3\2\2\2\u009d\u009e\7>\2\2\u009e\u009f"+
		"\7?\2\2\u009f*\3\2\2\2\u00a0\u00a1\7-\2\2\u00a1,\3\2\2\2\u00a2\u00a3\7"+
		"/\2\2\u00a3.\3\2\2\2\u00a4\u00a5\7,\2\2\u00a5\60\3\2\2\2\u00a6\u00a7\7"+
		"\61\2\2\u00a7\62\3\2\2\2\u00a8\u00a9\7\'\2\2\u00a9\64\3\2\2\2\u00aa\u00ab"+
		"\7`\2\2\u00ab\66\3\2\2\2\u00ac\u00ad\7#\2\2\u00ad8\3\2\2\2\u00ae\u00af"+
		"\7/\2\2\u00af\u00b0\7@\2\2\u00b0:\3\2\2\2\u00b1\u00b2\7&\2\2\u00b2\u00b4"+
		"\5Y-\2\u00b3\u00b5\t\5\2\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00ba\3\2\2\2\u00b6\u00b9\5Y-\2\u00b7\u00b9\5S*\2\u00b8\u00b6\3\2\2\2"+
		"\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb<\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7u\2\2\u00be\u00bf"+
		"\7g\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3"+
		"\7v\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7q\2\2\u00c5@\3\2\2\2\u00c6\u00c7"+
		"\7u\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7c\2\2\u00ca"+
		"\u00cb\7q\2\2\u00cbB\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7u\2\2\u00ce"+
		"D\3\2\2\2\u00cf\u00d0\7P\2\2\u00d0\u00d1\7W\2\2\u00d1\u00d2\7O\2\2\u00d2"+
		"\u00d3\7G\2\2\u00d3\u00d4\7T\2\2\u00d4\u00df\7Q\2\2\u00d5\u00d6\7T\2\2"+
		"\u00d6\u00d7\7G\2\2\u00d7\u00d8\7C\2\2\u00d8\u00df\7N\2\2\u00d9\u00da"+
		"\7V\2\2\u00da\u00db\7G\2\2\u00db\u00dc\7Z\2\2\u00dc\u00dd\7V\2\2\u00dd"+
		"\u00df\7Q\2\2\u00de\u00cf\3\2\2\2\u00de\u00d5\3\2\2\2\u00de\u00d9\3\2"+
		"\2\2\u00dfF\3\2\2\2\u00e0\u00e1\7G\2\2\u00e1\u00e2\7N\2\2\u00e2\u00e3"+
		"\7G\2\2\u00e3\u00e4\7O\2\2\u00e4\u00e5\7G\2\2\u00e5\u00e6\7P\2\2\u00e6"+
		"\u00e7\7V\2\2\u00e7\u00e8\7Q\2\2\u00e8H\3\2\2\2\u00e9\u00ea\7Z\2\2\u00ea"+
		"\u00eb\7O\2\2\u00eb\u00ec\7N\2\2\u00ecJ\3\2\2\2\u00ed\u00ee\7N\2\2\u00ee"+
		"\u00ef\7O\2\2\u00ef\u00f0\7Z\2\2\u00f0L\3\2\2\2\u00f1\u00f2\7G\2\2\u00f2"+
		"\u00f3\7P\2\2\u00f3\u00f4\7X\2\2\u00f4\u00f5\7K\2\2\u00f5\u00f6\7C\2\2"+
		"\u00f6\u00f7\7T\2\2\u00f7\u00f8\7a\2\2\u00f8\u00f9\7G\2\2\u00f9\u00fa"+
		"\7O\2\2\u00fa\u00fb\7C\2\2\u00fb\u00fc\7K\2\2\u00fc\u00fd\7N\2\2\u00fd"+
		"N\3\2\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7V\2\2\u0100\u0101\7W\2\2\u0101"+
		"\u0102\7C\2\2\u0102\u0103\7N\2\2\u0103\u0104\7K\2\2\u0104\u0105\7\\\2"+
		"\2\u0105\u0106\7C\2\2\u0106\u0107\7T\2\2\u0107P\3\2\2\2\u0108\u0109\7"+
		"H\2\2\u0109\u010a\7Q\2\2\u010a\u010b\7T\2\2\u010b\u010c\7O\2\2\u010cR"+
		"\3\2\2\2\u010d\u010f\5\25\13\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111T\3\2\2\2\u0112\u0114\5"+
		"\25\13\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u011d\3\2\2\2\u0117\u0119\t\6\2\2\u0118\u011a\5\25"+
		"\13\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u0117\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011eV\3\2\2\2\u011f\u0122\5Y-\2\u0120\u0122\5S*\2\u0121\u011f\3"+
		"\2\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\7\60\2\2\u0126\u0127\5"+
		"Y-\2\u0127X\3\2\2\2\u0128\u012a\5\31\r\2\u0129\u0128\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\5\27\f\2\u012c\u0129\3\2\2\2"+
		"\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012fZ\3"+
		"\2\2\2\u0130\u0131\7@\2\2\u0131\u0132\7c\2\2\u0132\u0133\7r\2\2\u0133"+
		"\u0134\7t\2\2\u0134\u0135\7q\2\2\u0135\u0145\7x\2\2\u0136\u0137\7@\2\2"+
		"\u0137\u0138\7c\2\2\u0138\u0139\7r\2\2\u0139\u013a\7t\2\2\u013a\u013b"+
		"\7q\2\2\u013b\u013c\7x\2\2\u013c\u013d\7c\2\2\u013d\u013e\7\u00c5\2\2"+
		"\u013e\u013f\7\u00a9\2\2\u013f\u0140\7\u00c5\2\2\u0140\u0141\7\u00a5\2"+
		"\2\u0141\u0145\7q\2\2\u0142\u0143\7@\2\2\u0143\u0145\7c\2\2\u0144\u0130"+
		"\3\2\2\2\u0144\u0136\3\2\2\2\u0144\u0142\3\2\2\2\u0145\\\3\2\2\2\u0146"+
		"\u0147\7@\2\2\u0147\u0148\7t\2\2\u0148\u0149\7g\2\2\u0149\u014a\7u\2\2"+
		"\u014a\u0157\7r\2\2\u014b\u014c\7@\2\2\u014c\u014d\7t\2\2\u014d\u014e"+
		"\7g\2\2\u014e\u014f\7u\2\2\u014f\u0150\7r\2\2\u0150\u0151\7q\2\2\u0151"+
		"\u0152\7u\2\2\u0152\u0153\7v\2\2\u0153\u0157\7c\2\2\u0154\u0155\7@\2\2"+
		"\u0155\u0157\7t\2\2\u0156\u0146\3\2\2\2\u0156\u014b\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157^\3\2\2\2\u0158\u015a\7$\2\2\u0159\u015b\n\7\2\2\u015a\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7$\2\2\u015f`\3\2\2\2\u0160\u0161\7\61\2\2"+
		"\u0161\u0162\7,\2\2\u0162\u0166\3\2\2\2\u0163\u0165\13\2\2\2\u0164\u0163"+
		"\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\7,\2\2\u016a\u016b\7\61"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016d\b\61\2\2\u016db\3\2\2\2\u016e\u016f"+
		"\7\61\2\2\u016f\u0170\7\61\2\2\u0170\u0174\3\2\2\2\u0171\u0173\n\b\2\2"+
		"\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0178\b\62\2\2"+
		"\u0178d\3\2\2\2\u0179\u017b\t\t\2\2\u017a\u0179\3\2\2\2\u017b\u017c\3"+
		"\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\b\63\2\2\u017ff\3\2\2\2\25\2\u00b4\u00b8\u00ba\u00de\u0110\u0115"+
		"\u011b\u011d\u0121\u0123\u0129\u012e\u0144\u0156\u015c\u0166\u0174\u017c"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}