package gramatica.formulario;

import gramatica.atividadeAutomatica.GramaticaAtividadeAutomatica;
import gramatica.atividadeAutomatica.GramaticaAtividadeAutomaticaBaseVisitor;
import gramatica.atividadeAutomatica.GramaticaAtividadeAutomaticaParser;
import gramatica.atividadeAutomatica.Value;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GramaticaFormulario {
    public static void main(String[] args) {
            System.out.println("Result with Visitor : ");
            parseWithVisitor();
    }

    public static void parseWithVisitor(){
        gramaticaFormularioLexer lexer = null;
        try {
            lexer = new gramaticaFormularioLexer(CharStreams.fromFileName("teste_formulario.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gramaticaFormularioParser parser = new gramaticaFormularioParser(tokens);
        ParseTree tree = parser.gramaica();
        GramaticaFormulario.EvalVisitor eval = new GramaticaFormulario.EvalVisitor();
        System.out.println(eval.visit(tree));
    }

    static class EvalVisitor extends GramaticaAtividadeAutomaticaBaseVisitor<Value> {

        public static final double SMALL_VALUE = 0.00000000001;

        private Map<String, Value> memory = new HashMap<>();

        @Override
        public Value visitGramatica(GramaticaAtividadeAutomaticaParser.GramaticaContext ctx) {
            return visitChildren(ctx);
        }

        @Override
        public Value visitAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx) {
            return visitChildren(ctx);
        }

        @Override
        public Value visitInicializacaoIdent(GramaticaAtividadeAutomaticaParser.InicializacaoIdentContext ctx) {
            String id = ctx.identidade().getText();
            return memory.put(id, Value.VOID);
        }

        @Override
        public Value visitVariavelExpr(GramaticaAtividadeAutomaticaParser.VariavelExprContext ctx) {
            String id = ctx.identidade().getText();
            Value value = this.visit(ctx.expr());
            return memory.put(id, value);
        }

        @Override
        public Value visitIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx) {
            return memory.get(ctx.getText());
        }

        @Override
        public Value visitTp_integer(GramaticaAtividadeAutomaticaParser.Tp_integerContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitTp_float(GramaticaAtividadeAutomaticaParser.Tp_floatContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitPowExpr(GramaticaAtividadeAutomaticaParser.PowExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(Math.pow(left.asDouble(), right.asDouble()));
        }

        @Override
        public Value visitMulDivModExpr(GramaticaAtividadeAutomaticaParser.MulDivModExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.MULT:
                    return new Value(left.asDouble() * right.asDouble());
                case GramaticaAtividadeAutomaticaParser.DIV:
                    return new Value(left.asDouble() / right.asDouble());
                case GramaticaAtividadeAutomaticaParser.MOD:
                    return new Value(left.asDouble() % right.asDouble());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaAtividadeAutomaticaParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.MAIS:
                    return left.isDouble() && right.isDouble() ?
                            new Value(left.asDouble() + right.asDouble()) :
                            new Value(left.asInteger() + right.asInteger());
                case GramaticaAtividadeAutomaticaParser.MENOS:
                    return left.isDouble() && right.isDouble() ?
                            new Value(left.asDouble() - right.asDouble()) :
                            new Value(left.asInteger() - right.asInteger());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaAtividadeAutomaticaParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));


            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.LT:
                    return new Value(left.asDouble() < right.asDouble());
                case GramaticaAtividadeAutomaticaParser.LTEQ:
                    return new Value(left.asDouble() <= right.asDouble());
                case GramaticaAtividadeAutomaticaParser.GT:
                    return new Value(left.asDouble() > right.asDouble());
                case GramaticaAtividadeAutomaticaParser.GTEQ:
                    return new Value(left.asDouble() >= right.asDouble());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaAtividadeAutomaticaParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.EQ:
                    return left.isDouble() && right.isDouble() ?
                            new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                            new Value(left.equals(right));
                case GramaticaAtividadeAutomaticaParser.NEQ:
                    return left.isDouble() && right.isDouble() ?
                            new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                            new Value(!left.equals(right));
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaAtividadeAutomaticaParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitAndExpr(GramaticaAtividadeAutomaticaParser.AndExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(left.asBoolean() && right.asBoolean());
        }

        @Override
        public Value visitOrExpr(GramaticaAtividadeAutomaticaParser.OrExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(left.asBoolean() || right.asBoolean());
        }


        @Override
        public Value visitIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx) {
            GramaticaAtividadeAutomaticaParser.Condition_blockContext condition = ctx.condition_block();
            boolean evaluatedBlock = false;
            Value evaluated = this.visit(condition.expr());

            if (evaluated.asBoolean()) {
                evaluatedBlock = true;
                return this.visit(condition.stat_block());
            }

            if (!evaluatedBlock && ctx.stat_block() != null)
                return this.visit(ctx.stat_block());

            return Value.VOID;
        }
    }

}
