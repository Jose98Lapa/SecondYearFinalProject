package gramatica.formulario;

import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.FormName;
import eapli.base.form.domain.FormScript;
import eapli.base.form.domain.attribute.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.yaml.snakeyaml.parser.ParserException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class GramaticaFormulario {
    public static void main(String[] args) {
        System.out.println("Result with Visitor : ");
        Set<Attribute> attributeSet = new HashSet<>();

        attributeSet.add(new Attribute(
                new AtributteName("tipoRestauro"),
                new AttributeLabel("arroz"),
                new AttributeDescription("Qual o tipo"),
                new AttributeRegex("gboiua"),
                new AttributeType("String"),
                new AttributeID("88"),
                1)
        );
        attributeSet.add(new Attribute(
                new AtributteName("nomeum"),
                new AttributeLabel("label2"),
                new AttributeDescription("descricao2"),
                new AttributeRegex("gboiua2"),
                new AttributeType("int"),
                new AttributeID("fnsaoi2"),
                2)
        );

        Form form = new Form(new FormScript("none"), new FormID("2345678"), new FormName("name"), attributeSet);
        //parseWithVisitor("teste_formulario.txt",form);
        parseWithVisitor("bootstrapForm.txt",form);
    }

    public static void parseWithVisitor(String file,Form form) {
        GramaticaFormularioLexer lexer = null;
        try {
            lexer = new GramaticaFormularioLexer(CharStreams.fromFileName(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaFormularioParser parser = new GramaticaFormularioParser(tokens);
        ParseTree tree = parser.gramatica();
        EvalVisitor eval = new EvalVisitor();

        eval.defineForm(form);
        System.out.println(eval.visit(tree));
    }

    public static void parseWithListener(String file,Form form){
        GramaticaFormularioLexer lexer = null;
        try {
            lexer = new GramaticaFormularioLexer(CharStreams.fromFileName(file));

        } catch (IOException e) {
            e.printStackTrace();
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaFormularioParser parser = new GramaticaFormularioParser(tokens);
        ParseTree tree = parser.gramatica();
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener eval = new EvalListener();

        eval.defineForm(form);
        walker.walk(eval,tree);
    }

    static class EvalListener extends GramaticaFormularioBaseListener {
        Form form;
        private Map<String, Value> memory = new HashMap<>();
        private Stack<Value> valueStack = new Stack<>();
        public void defineForm(Form form) {
            this.form = form;
        }

        @Override
        public void exitMatch_regex(GramaticaFormularioParser.Match_regexContext ctx) {
            String toCheck = memory.get(ctx.var.getText()).toString();
            String regexBefore = ctx.regex.getText();
            String regex = regexBefore.substring(2, regexBefore.length() - 2);
            if (!toCheck.matches(regex)) {
                throw new ParseCancellationException("Regex Inválido");
            }
        }
        @Override
        public void enterGramatica(GramaticaFormularioParser.GramaticaContext ctx){

        }

        @Override
        public void enterAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx) {
            for (Attribute atr : form.atributes()) {
                if (atr.number() == Integer.parseInt(ctx.numero.getText())) {
                    valueStack.push(new Value(atr.toDTO().label));
                }
            }
        }

        @Override
        public void exitVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx) {
            String id = ctx.identidade().getText();
            Value value = valueStack.pop();
            memory.put(id, value);
        }

        @Override
        public void enterAtribuicao_atributo(GramaticaFormularioParser.Atribuicao_atributoContext ctx) {
            String id = ctx.inicializacao().getText();
            memory.put(id,valueStack.pop());
        }

        @Override
        public void exitMatch_regex_atribut(GramaticaFormularioParser.Match_regex_atributContext ctx){
            String toCheck = valueStack.pop().toString();
            String regexBefore = ctx.regex.getText();
            String regex = regexBefore.substring(2, regexBefore.length() - 2);
            if (!toCheck.matches(regex)) {
                throw new ParseCancellationException("Regex Inválido");
            }
        }

        @Override
        public void exitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx) {
            Value left = memory.get(ctx.left.getText());
            Value right = memory.get(ctx.right.getText());
            switch (ctx.op.getText()){
                case "="-> {
                    if (left.equals(right))
                        System.out.println("Passou");
                    else
                        System.out.println("Nao passou");
                }

                case "!=" ->{
                    if (!left.equals(right))
                        System.out.println("Passou");
                    else
                        System.out.println("Nao passou");
                }
            }

        }






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
            String id = ctx.identidade().getText();
            Value value = this.visit(ctx.get_atributo());
            return memory.put(id, value);
        }

        @Override
        public Value visitAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx) {
            for (Attribute atr : form.atributes()) {
                if (atr.number() == Integer.parseInt(ctx.numero.getText())) {
                    return new Value(atr.toDTO().label);
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
        public Value visitTp_stringe(GramaticaFormularioParser.Tp_stringeContext ctx) {
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
        public Value visitTp_ident(GramaticaFormularioParser.Tp_identContext ctx) {
            String id = ctx.identidade().getText();
            return memory.get(id);
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
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() + right.asDouble());

                    if (left.isInteger() && right.isInteger())
                        return new Value(left.asInteger() + right.asInteger());

                    if (left.isString() || right.isString())
                        return new Value(left.asString() + right.asString());

                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
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
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() < right.asDouble());
                    if (left.isDate() && right.isDate())
                        return new Value(left.asDate().isBefore(right.asDate()));
                    break;

                case GramaticaFormularioParser.LTEQ:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() <= right.asDouble());
                    if (left.isDate() && right.isDate())
                        if (left.asDate().equals(right.asDate())) {
                            return new Value(left.asDate().equals(right.asDate()));
                        } else {
                            return new Value(left.asDate().isBefore(right.asDate()));
                        }
                    break;


                case GramaticaFormularioParser.GT:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() > right.asDouble());
                    if (left.isDate() && right.isDate())
                        return new Value(left.asDate().isAfter(right.asDate()));
                    break;

                case GramaticaFormularioParser.GTEQ:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() >= right.asDouble());
                    if (left.isDate() && right.isDate())
                        if (left.asDate().equals(right.asDate())) {
                            return new Value(left.asDate().equals(right.asDate()));
                        } else {
                            return new Value(left.asDate().isAfter(right.asDate()));
                        }
                    break;

                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
            throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
        }

        @Override
        public Value visitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx) {

            Value left = new Value(this.visit(ctx.left));
            Value right = new Value(this.visit(ctx.right));

            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.EQ:
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE);
                    }
                    if (left.isString() && right.isString()) {
                        return new Value(removeAspas(left).equals(removeAspas(right)));
                    }
                    if (left.isDate() && right.isDate()) {
                        return new Value(left.value.equals(right.value));
                    }
                case GramaticaFormularioParser.NEQ:
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE);
                    }
                    if (left.isString() && right.isString()) {
                        return new Value(!removeAspas(left).equals(removeAspas(right)));
                    }
                    if (left.isDate() && right.isDate()) {
                        return new Value(!left.value.equals(right.value));
                    }
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }
        public String removeAspas(Value val){
            if (val.toString().contains("\"")){
                return val.toString().substring(1,val.toString().length()-1);
            }
            return val.toString();
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

        @Override
        public Value visitValidationFail(GramaticaFormularioParser.ValidationFailContext ctx) {
            throw new ParseCancellationException("FAIL Detected");
        }

        @Override
        public Value visitMatch_regex(GramaticaFormularioParser.Match_regexContext ctx) {
            String toCheck =memory.get( ctx.var.getText()).toString();
            String regexBefore = ctx.regex.getText();
            String regex = regexBefore.substring(2,regexBefore.length()-2);
            if (toCheck.matches(regex)) {
                return Value.VOID;
            } else {
                throw new ParseCancellationException(toCheck+ "Does not match regex");
            }
        }

    }
}
