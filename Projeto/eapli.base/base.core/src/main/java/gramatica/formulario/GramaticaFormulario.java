package gramatica.formulario;

import eapli.base.form.DTO.FormDTOParser;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.attribute.Attribute;
import eapli.base.form.domain.attribute.AttributeID;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import gramatica.atividadeAutomatica.GramaticaAtividadeAutomaticaParser;
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
        GramaticaFormularioLexer lexer = null;
        try {
            lexer = new GramaticaFormularioLexer(CharStreams.fromFileName("teste_formulario.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaFormularioParser parser = new GramaticaFormularioParser(tokens);
        ParseTree tree = parser.gramatica();
        EvalVisitor eval = new EvalVisitor();
        FormRepository repo = PersistenceContext.repositories().form();
        eval.defineForm(new FormDTOParser().valueOf(repo.findByFormID(FormID.valueOf("6ca92198-5168-4c6c-9467-3877390bde7f")).get()));
        System.out.println(eval.visit(tree));
    }

    static class EvalVisitor extends GramaticaFormularioBaseVisitor<Value> {
        Form form;

        public void defineForm(Form form) {
            this.form = form;
        }

        public static final double SMALL_VALUE = 0.00000000001;

        private Map<String, Value> memory = new HashMap<>();

        @Override
        public Value visitGramatica(GramaticaFormularioParser.GramaticaContext ctx) {
            return visitChildren(ctx);
        }

        @Override
        public Value visitAtomExpr(GramaticaFormularioParser.AtomExprContext ctx) {
            return visitChildren(ctx);
        }
        @Override
        public Value visitVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx) {
            Value value = this.visit(ctx.get_atributo()); //
            memory.put(ctx.identidade().getText(),value);
            return visitChildren(ctx);
        }

        @Override
        public Value visitAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx) {
            for (Attribute atr:form.atributes()) {
                if (atr.number()==Integer.parseInt(ctx.numero.getText())){
                    return memory.get(ctx.numero.getText());
                }
            }
            return Value.VOID;
        }

        @Override
        public Value visitInicializacaoIdent(GramaticaFormularioParser.InicializacaoIdentContext ctx) {
            String id = ctx.identidade().getText();
            return memory.put(id, Value.VOID);
        }

        @Override
        public Value visitVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx) {
            String id = ctx.identidade().getText();
            Value value = this.visit(ctx.expr());
            return memory.put(id, value);
        }

        @Override
        public Value visitIdentidade(GramaticaFormularioParser.IdentidadeContext ctx) {
            return memory.get(ctx.getText());
        }

        @Override
        public Value visitTp_integer(GramaticaFormularioParser.Tp_integerContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitTp_float(GramaticaFormularioParser.Tp_floatContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitPowExpr(GramaticaFormularioParser.PowExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(Math.pow(left.asDouble(), right.asDouble()));
        }

        @Override
        public Value visitMulDivModExpr(GramaticaFormularioParser.MulDivModExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.MULT:
                    return new Value(left.asDouble() * right.asDouble());
                case GramaticaFormularioParser.DIV:
                    return new Value(left.asDouble() / right.asDouble());
                case GramaticaFormularioParser.MOD:
                    return new Value(left.asDouble() % right.asDouble());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitSumDifExpr(GramaticaFormularioParser.SumDifExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.MAIS:
                    return left.isDouble() && right.isDouble() ?
                            new Value(left.asDouble() + right.asDouble()) :
                            new Value(left.asInteger() + right.asInteger());
                case GramaticaFormularioParser.MENOS:
                    return left.isDouble() && right.isDouble() ?
                            new Value(left.asDouble() - right.asDouble()) :
                            new Value(left.asInteger() - right.asInteger());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitRelationalExpr(GramaticaFormularioParser.RelationalExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));


            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.LT:
                    return new Value(left.asDouble() < right.asDouble());
                case GramaticaFormularioParser.LTEQ:
                    return new Value(left.asDouble() <= right.asDouble());
                case GramaticaFormularioParser.GT:
                    return new Value(left.asDouble() > right.asDouble());
                case GramaticaFormularioParser.GTEQ:
                    return new Value(left.asDouble() >= right.asDouble());
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.EQ:
                    return left.isDouble() && right.isDouble() ?
                            new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE) :
                            new Value(left.equals(right));
                case GramaticaFormularioParser.NEQ:
                    return left.isDouble() && right.isDouble() ?
                            new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE) :
                            new Value(!left.equals(right));
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }

        @Override
        public Value visitAndExpr(GramaticaFormularioParser.AndExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(left.asBoolean() && right.asBoolean());
        }

        @Override
        public Value visitOrExpr(GramaticaFormularioParser.OrExprContext ctx) {
            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));
            return new Value(left.asBoolean() || right.asBoolean());
        }


        @Override
        public Value visitIf_stat(GramaticaFormularioParser.If_statContext ctx) {
            GramaticaFormularioParser.Condition_blockContext condition = ctx.condition_block();
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
