package gramatica.atividadeAutomatica;

import java.io.*;
import java.util.Stack;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class GramaticaAtividadeAutomatica {
    public static void main(String[] args) throws IOException {
        System.out.println("Result with Visitor : ");
        parseWithVisitor();
    }

    public static void parseWithVisitor() throws IOException {
        GramaticaAtividadeAutomaticaLexer lexer = new GramaticaAtividadeAutomaticaLexer(CharStreams.fromFileName("teste_atividade_automatica.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaAtividadeAutomaticaParser parser = new GramaticaAtividadeAutomaticaParser(tokens);
        ParseTree tree = parser.gramatica(); // parse
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener eval = new EvalListener();
        walker.walk(eval, tree);
        System.out.println(eval.getResult());
    }


    static class EvalListener extends GramaticaAtividadeAutomaticaBaseListener {

        private final Stack<String> stack = new Stack<>();

        public String getResult() {
            return stack.peek();
        }

        @Override
        public void enterAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx) {
            stack.push(ctx.atom.getText());
        }

        @Override
        public void exitOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx) {
            double right = Double.parseDouble(stack.pop());
            double left = Double.parseDouble(stack.pop());
            double result;
            if (ctx.op.getText().charAt(0) == '*') {
                result = left * right;
            } else {
                result = left / right;
            }
            stack.push(Double.toString(result));
        }

        @Override
        public void exitOpExprSumDif(GramaticaAtividadeAutomaticaParser.OpExprSumDifContext ctx) {
            double right = Double.parseDouble(stack.pop());
            double left = Double.parseDouble(stack.pop());
            double result;
            if (ctx.op.getText().charAt(0) == '+') {
                result = left + right;
            } else {
                result = left - right;
            }
            stack.push(Double.toString(result));
        }

    }
}
