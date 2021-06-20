package gramatica.formulario;

import eapli.base.AppSettings;
import eapli.base.Application;
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
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class GramaticaFormulario {
    public static void main(String[] args) {
        System.out.println("Result with Visitor : ");
        Set<Attribute> attributeSet = new HashSet<>();

        attributeSet.add(new Attribute(
                new AtributteName("tipoRestauro"),
                new AttributeLabel("22/05/2020"),
                new AttributeDescription("Qual o tipo"),
                new AttributeRegex("gboiua"),
                new AttributeType("Date"),
                new AttributeID("88"),
                1)
        );
        attributeSet.add(new Attribute(
                new AtributteName("nomeum"),
                new AttributeLabel("30/06/2021"),
                new AttributeDescription("descricao2"),
                new AttributeRegex("gboiua2"),
                new AttributeType("Date"),
                new AttributeID("fnsaoi2"),
                2)
        );

        Form form = new Form(new FormScript("none"), new FormID("2345678"), new FormName("name"), attributeSet);
        parseWithVisitor("teste_formulario.txt", form);
    }
    public static String parse(String file,Form form){
        String parser = Application.settings().getProperty("GRAMMARFORMTYPE");
        if ("Visitor".equals(parser)){
            return parseWithVisitor(file,form);
        }else{
            return parseWithListener(file,form);
        }
    }



    public static String parseWithVisitor(String file, Form form) {
        try {
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
            eval.visit(tree);
        } catch (RuntimeException e) {
            System.out.println("\nValidacao de formulario falhou:");
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "";
    }

    public static String parseWithListener(String file, Form form) {
        try {
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
            walker.walk(eval, tree);
        } catch (RuntimeException e) {
            System.out.println("Validacao de formulario falhou:");
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "";
    }

    static class EvalListener extends GramaticaFormularioBaseListener {
        Form form;
        private Map<String, Value> memory = new HashMap<>();
        private Map<String, String> attributeAndTypeMap = new HashMap<>();
        private Stack<Value> valueStack = new Stack<>();
        boolean doInstruction = true;


        public void defineForm(Form form) {
            this.form = form;
        }

        @Override
        public void exitMatch_regex(GramaticaFormularioParser.Match_regexContext ctx) {
            if (doInstruction) {
                String toCheck = memory.get(ctx.var.getText()).toString();
                String regexBefore = ctx.regex.getText();
                String regex = regexBefore.substring(2, regexBefore.length() - 2);
                if (!toCheck.matches(regex)) {
                    throw new ParseCancellationException("Regex Inválido");
                }
            }
        }

        @Override
        public void enterGramatica(GramaticaFormularioParser.GramaticaContext ctx) {

        }

        @Override
        public void enterAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx) {
            if (doInstruction) {
                for (Attribute atr : form.atributes()) {
                    if (atr.number() == Integer.parseInt(ctx.numero.getText())) {
                        valueStack.push(new Value(atr.toDTO().label));
                    }
                }
            }
        }

        @Override
        public void exitPowExpr(GramaticaFormularioParser.PowExprContext ctx) {
            if (doInstruction){
                String leftString = ctx.left.getText();
                if (leftString.matches("^[0-9]+([.][0-9]+)?\\^\\d+(\\.\\d+)?$")){
                    leftString = valueStack.pop().toString();
                }
                String rightString = ctx.right.getText();
                if (!Value.isValidNumber(leftString)&&!Value.isValidNumber(rightString))
                    throw new ParseCancellationException("Só se pode fazer potencias com numeros");
                Value left = new Value(leftString);
                Value right = new Value(rightString);
                valueStack.push(new Value(Math.pow(left.asDouble(),right.asDouble())));
            }
        }

        @Override
        public void exitVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx) {
            if (doInstruction) {
                String id = ctx.identidade().getText();
                Value value = valueStack.pop();
                addToMemory(id, value);
                valueStack.push(new Value(id));
            }
        }

        @Override
        public void exitInicializacaoIdent(GramaticaFormularioParser.InicializacaoIdentContext ctx) {
            if (doInstruction) {
                attributeAndTypeMap.put(valueStack.pop().toString(), ctx.tipoDados.getText());
            }
        }

        @Override
        public void exitInicializacaoAtribuicao(GramaticaFormularioParser.InicializacaoAtribuicaoContext ctx) {
            if (doInstruction) {
                Value var = valueStack.pop();
                attributeAndTypeMap.put(var.toString(), ctx.tipoDados.getText());
                addToMemory(var.toString(), memory.get(var.toString()));
            }
        }


        @Override
        public void exitAtribuicao_atributo(GramaticaFormularioParser.Atribuicao_atributoContext ctx) {
            if (doInstruction) {
                String id = ctx.inicializacao().getText();
                memory.put(id, valueStack.pop());
                valueStack.push(new Value(id));
            }
        }

        @Override
        public void exitMatch_regex_atribut(GramaticaFormularioParser.Match_regex_atributContext ctx) {
            if (doInstruction) {
                String toCheck = valueStack.pop().toString();
                String regexBefore = ctx.regex.getText();
                String regex = regexBefore.substring(2, regexBefore.length() - 2);
                if (!toCheck.matches(regex)) {
                    throw new ParseCancellationException("Regex Inválido");
                }
            }
        }

        @Override
        public void exitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx) {
            if (doInstruction) {
                Value left = memory.get(ctx.left.getText());
                Value right = memory.get(ctx.right.getText());
                switch (ctx.op.getText()) {
                    case "=" -> {
                        valueStack.push(new Value(left.equals(right)));
                    }
                    case "!=" -> {
                        valueStack.push(new Value(!left.equals(right)));
                    }
                }
            }

        }

        @Override
        public void exitRelationalExpr(GramaticaFormularioParser.RelationalExprContext ctx) {

            if (doInstruction) {
                Value left = memory.get(ctx.left.getText());
                if (left == null)
                    left = new Value(ctx.left.getText());
                Value right = memory.get(ctx.right.getText());
                if (right == null)
                    right = new Value(ctx.right.getText());

                final int compareString = left.toString().compareTo(right.toString());
                switch (ctx.op.getType()) {
                    case GramaticaFormularioParser.LT -> {
                        if (Value.isValidNumber(left.toString()) && Value.isValidNumber(right.toString()))
                            valueStack.push(new Value(left.asDouble() < right.asDouble()));
                        else if (left.isDate() && right.isDate())
                            valueStack.push(new Value(left.asDate().isBefore(right.asDate())));
                        else
                            valueStack.push(new Value(compareString < 0));
                    }
                    case GramaticaFormularioParser.LTEQ -> {
                        if (Value.isValidNumber(left.toString()) && Value.isValidNumber(right.toString()))
                            valueStack.push(new Value(left.asDouble() <= right.asDouble()));
                        else if (left.isDate() && right.isDate())
                            valueStack.push(new Value(left.asDate().isBefore(right.asDate()) || left.toString().equals(right.toString())));
                        else
                            valueStack.push(new Value(compareString <= 0));
                    }
                    case GramaticaFormularioParser.GT -> {
                        if (Value.isValidNumber(left.toString()) && Value.isValidNumber(right.toString()))
                            valueStack.push(new Value(left.asDouble() > right.asDouble()));
                        else if (left.isDate() && right.isDate())
                            valueStack.push(new Value(left.asDate().isAfter(right.asDate())));
                        else
                            valueStack.push(new Value(compareString > 0));
                    }
                    case GramaticaFormularioParser.GTEQ -> {
                        if (Value.isValidNumber(left.toString()) && Value.isValidNumber(right.toString()))
                            valueStack.push(new Value(left.asDouble() >= right.asDouble()));
                        else if (left.isDate() && right.isDate())
                            valueStack.push(new Value(left.asDate().isAfter(right.asDate()) || left.toString().equals(right.toString())));
                        else
                            valueStack.push(new Value(compareString >= 0));
                    }
                    default -> throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
                }
            }
        }

        @Override
        public void enterValidationFail(GramaticaFormularioParser.ValidationFailContext ctx) {
            if (doInstruction) {
                throw new ParseCancellationException("O script deu erro");
            }
        }


        @Override
        public void enterEntao(GramaticaFormularioParser.EntaoContext ctx) {
            if (doInstruction) {
                Value bool = valueStack.pop();
                doInstruction = bool.asBoolean();
            }
        }

        @Override
        public void exitAndExpr(GramaticaFormularioParser.AndExprContext ctx) {
            if (doInstruction) {
                Value right = valueStack.pop();
                Value left = valueStack.pop();
                valueStack.push(new Value(right.asBoolean() && left.asBoolean()));
            }
        }

        @Override
        public void exitOrExpr(GramaticaFormularioParser.OrExprContext ctx) {
            if (doInstruction) {
                Value right = valueStack.pop();
                Value left = valueStack.pop();
                valueStack.push(new Value(right.asBoolean() || left.asBoolean()));
            }
        }

        @Override
        public void enterSenao(GramaticaFormularioParser.SenaoContext ctx) {
            doInstruction = !doInstruction;
        }

        @Override
        public void exitIf(GramaticaFormularioParser.IfContext ctx) {
            doInstruction = true;
        }


        @Override
        public void exitMulDivModExpr(GramaticaFormularioParser.MulDivModExprContext ctx) {
            if (doInstruction) {
                String typeLeft = attributeAndTypeMap.get(ctx.left.getText());
                String typeRight = attributeAndTypeMap.get(ctx.right.getText());


                if ("TEXTO".equals(typeLeft) || "DATA".equals(typeLeft) || "TEXTO".equals(typeRight) || "DATA".equals(typeRight) || ctx.right.getText().matches(".*[^0-9.]+.*")) {
                    throw new ParseCancellationException("Só pode fazer-se operacao em numeros");
                }
                String number = ctx.left.getText();

                Value left = memory.get(number);
                if (left == null)
                    left = new Value(ctx.left.getText());
                else
                    number = left.toString();
                Value right = memory.get(ctx.right.getText());
                if (right == null)
                    right = new Value(ctx.right.getText());
                if (number.matches(".*[^0-9.]+.*") && valueStack.size() > 1) {
                    left = valueStack.pop();
                }

                switch (ctx.op.getType()) {
                    case GramaticaFormularioParser.MULT -> valueStack.push(new Value(left.asDouble() * right.asDouble()));
                    case GramaticaFormularioParser.DIV -> valueStack.push(new Value(left.asDouble() / right.asDouble()));
                    case GramaticaFormularioParser.MOD -> valueStack.push(new Value(left.asDouble() % right.asDouble()));
                }
            }
        }

        @Override
        public void enterVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx) {
            if (doInstruction) {
                valueStack.push(new Value(ctx.iden.getText()));
            }
        }

        @Override
        public void exitVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx) {
            if (doInstruction) {
                Value result = valueStack.pop();
                Value var = valueStack.pop();
                String dataType = attributeAndTypeMap.get(var.toString());


                if ("NUMERO".equals(dataType)) {
                    String res = result.toString().replaceAll("[.][0-9]+", "");
                    result = new Value(res);
                    memory.put(var.toString(), result);
                }
                if (!attributeAndTypeMap.containsKey(var.toString()))
                    valueStack.push(var);
                memory.put(var.toString(), result);
            }
        }

        @Override
        public void exitSumDifExpr(GramaticaFormularioParser.SumDifExprContext ctx) {
            if (doInstruction) {
                String typeLeft = attributeAndTypeMap.get(ctx.left.getText());
                String typeRight = attributeAndTypeMap.get(ctx.right.getText());

                Value left = memory.get(ctx.left.getText());
                if (left == null)
                    left = new Value(ctx.left.getText());
                Value right = memory.get(ctx.right.getText());
                if (right == null)
                    right = new Value(ctx.right.getText());


                switch (ctx.op.getType()) {
                    case GramaticaFormularioParser.MAIS -> {
                        if (Value.isValidNumber(left.toString()) && Value.isValidNumber(right.toString()))
                            valueStack.push(new Value(left.asDouble() * right.asDouble()));
                        else if ((Value.isValidDate(left.toString()) && Value.isValidNumber(right.toString())) || (Value.isValidDate(right.toString()) && Value.isValidNumber(left.toString()))) {
                            if (Value.isValidNumber(right.toString())) {
                                String rightString = right.asString();
                                valueStack.push(new Value(Value.localDate(left.asDate().plusDays(new Value(rightString.replaceAll("[.][0-9]+", "")).asInteger()))));
                            } else {
                                valueStack.push(new Value(right.asDate().plusDays(new Value(left.toString().replaceAll("[.][0-9]+", "")).asInteger())));
                            }
                        } else
                            valueStack.push(new Value(left.toString() + right));
                    }
                    case GramaticaFormularioParser.MENOS -> {
                        if ("TEXTO".equals(typeLeft) || "TEXTO".equals(typeRight))
                            throw new ParseCancellationException("Não se pode subtrair texto");
                        if (Value.isValidDate(left.toString()) && Value.isValidDate(right.toString())) {
                            LocalDate localDateLeft = left.asDate();
                            LocalDate localDateRight = right.asDate();
                            valueStack.push(new Value(DAYS.between(localDateLeft, localDateRight)));
                        } else if ((Value.isValidDate(left.toString()) && Value.isValidNumber(right.toString())) || (Value.isValidDate(right.toString()) && Value.isValidNumber(left.toString()))) {
                            if (Value.isValidNumber(right.toString())) {
                                String rightString = right.asString();
                                valueStack.push(new Value(Value.localDate(left.asDate().minusDays(new Value(rightString.replaceAll("[.][0-9]+", "")).asInteger()))));
                            } else {
                                valueStack.push(new Value(right.asDate().minusDays(new Value(left.toString().replaceAll("[.][0-9]+", "")).asInteger())));
                            }
                        } else
                            valueStack.push(new Value(left.asDouble() / right.asDouble()));
                    }
                }
            }
        }


        private void addToMemory(String var, Value value) {
            if (doInstruction) {
                if (attributeAndTypeMap.containsKey(var)) {
                    String type = attributeAndTypeMap.get(var);
                    if (type.equals("DATA") && !value.isDate())
                        throw new ParseCancellationException("Data invalida");
                    if (type.equals("NUMERO") && !value.toString().matches("^[0-9]+([.][0-9]+)?$")) {
                        throw new ParseCancellationException("Numero invalido");
                    } else {
                        if (type.equals("NUMERO"))
                            value = new Value(value.toString().replaceAll("[.][0-9]+", ""));
                    }

                    if (type.equals("REAL") && value.toString().matches("^[0-9]+([.][0-9]+)?$"))
                        throw new ParseCancellationException("Real invalido");
                }
                memory.put(var, value);
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
                    return new Value(atr.label());
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
        public Value visitVariavel(GramaticaFormularioParser.VariavelContext ctx) {
            return memory.get(ctx.var.getText());
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
                    if (left.isInteger() && right.isInteger())
                        return new Value(left.asInteger() + right.asInteger());

                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() + right.asDouble());

                    if (left.isString() && right.isDate())
                        return new Value(removeAspas(left) + right.asString());

                    if (left.isString() && right.isString())
                        return new Value(removeAspas(left) + removeAspas(right));

                    if(left.isDate() && right.isInteger()){
                        return new Value(left.asDate().plusDays(right.asInteger()));
                    }

                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);

                case GramaticaFormularioParser.MENOS:
                    if (left.isDouble() && right.isDouble()){
                        return new Value(left.asDouble() - right.asDouble());
                    }
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asInteger() - right.asInteger());
                    }
                    if (left.isDate() && right.isDate()) {
                        return new Value(ChronoUnit.DAYS.between(right.asDate(), left.asDate()));
                    }

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
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asDouble() < right.asDouble());
                    }
                    break;

                case GramaticaFormularioParser.LTEQ:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() <= right.asDouble());
                    if (left.isDate() && right.isDate()) {
                        if (left.asDate().equals(right.asDate())) {
                            return new Value(left.asDate().equals(right.asDate()));
                        } else {
                            return new Value(left.asDate().isBefore(right.asDate()));
                        }
                    }
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asDouble() <= right.asDouble());
                    }
                    break;


                case GramaticaFormularioParser.GT:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() > right.asDouble());
                    if (left.isDate() && right.isDate())
                        return new Value(left.asDate().isAfter(right.asDate()));
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asDouble() > right.asDouble());
                    }
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
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asDouble() >= right.asDouble());
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
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(left.asDouble().equals(right.asDouble()));
                    }
                case GramaticaFormularioParser.NEQ:
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE);
                    }
                    if (left.isString() && right.isString()) {
                        String lefte = removeAspas(left);
                        String rightt = removeAspas(right);
                        boolean b = !lefte.equals(rightt);
                        return new Value(b);
                    }
                    if (left.isDate() && right.isDate()) {
                        return new Value(!left.value.equals(right.value));
                    }
                    if (left.isDouble() && right.isDouble()) {
                        return new Value(!left.asDouble().equals(right.asDouble()));
                    }
                default:
                    throw new RuntimeException("unknown operator: " + GramaticaFormularioParser.tokenNames[ctx.op.getType()]);
            }
        }

        public String removeAspas(Value val) {
            if (val.toString().contains("\"")) {
                return val.toString().substring(1, val.toString().length() - 1);
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
        public Value visitIf(GramaticaFormularioParser.IfContext ctx) {
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
            throw new ParseCancellationException("FAIL Detected: " + ctx.getParent().getParent().getParent().getText());
        }

        @Override
        public Value visitMatch_regex(GramaticaFormularioParser.Match_regexContext ctx) {
            String toCheck = memory.get(ctx.var.getText()).toString();
            String regexBefore = ctx.regex.getText();
            String regex = regexBefore.substring(2, regexBefore.length() - 2);
            if (toCheck.matches(regex)) {
                return Value.VOID;
            } else {
                throw new ParseCancellationException(toCheck + " Does not match regex");
            }
        }

    }
}
