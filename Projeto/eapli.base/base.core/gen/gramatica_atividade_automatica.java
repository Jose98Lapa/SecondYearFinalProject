import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class gramatica_atividade_automatica {
    public static void main(String[] args) throws IOException {
        System.out.println("Result with Visitor : ");
        parseWithVisitor();
    }

    public static void parseWithVisitor() throws IOException {
        gramatica_atividade_automaticaLexer lexer = new gramatica_atividade_automaticaLexer(CharStreams.fromFileName("teste.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gramatica_atividade_automaticaParser parser = new gramatica_atividade_automaticaParser(tokens);
        ParseTree tree = parser.gramatica(); // parse
        ParseTreeWalker walker = new ParseTreeWalker();
        gramatica_atividade_automaticaBaseListener eval = new gramatica_atividade_automaticaBaseListener();
        walker.walk(eval, tree);
        System.out.println(eval.getResult());
    }
}