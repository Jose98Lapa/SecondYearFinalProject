package gramatica.atividadeAutomatica;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;

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
        //ParseTreeWalker walker = new ParseTreeWalker();
        //EvalListener eval = new EvalListener();
        //walker.walk(eval, tree);
        EvalVisitor eval = new EvalVisitor();
        System.out.println(eval.visit(tree));
    }


    static class EvalListener extends GramaticaAtividadeAutomaticaBaseListener implements GramaticaAtividadeAutomaticaListener {
       /* public static final double SMALL_VALUE = 0.00000000001;

        private Map<String, Value> memory = new HashMap<String, Value>();

        private final Stack<Value> stack = new Stack<>();

        public Value getResult() {
            return stack.peek();
        }

        @Override
        public void enterAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx) {
            //stack.push(new Value(ctx.atom.getText()));
        }

        @Override
        public void enterOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx) {
            stack.push(new Value(ctx.right.getText()));
            stack.push(new Value(ctx.left.getText()));
        }

        @Override
        public void exitOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx) {
            Value right = stack.pop();
            Value left = stack.pop();

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.MULT:
                    stack.push(new Value(left.asDouble() * right.asDouble()));
                    break;
                case GramaticaAtividadeAutomaticaParser.DIV:
                    stack.push(new Value(left.asDouble() / right.asDouble()));
                    break;
                case GramaticaAtividadeAutomaticaParser.MOD:
                    stack.push(new Value(left.asDouble() % right.asDouble()));
                    break;
                default:
                    throw new RuntimeException("unknown operator");
            }
        }

        @Override
        public void enterRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx) {
            stack.push(new Value(ctx.right.getText()));
            stack.push(new Value(ctx.left.getText()));
        }

        @Override
        public void exitRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx) {
            Value right = stack.pop();
            Value left = stack.pop();

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.LT:
                    stack.push(new Value(left.asDouble() < right.asDouble()));
                    break;
                case GramaticaAtividadeAutomaticaParser.LTEQ:
                    stack.push(new Value(left.asDouble() <= right.asDouble()));
                    break;
                case GramaticaAtividadeAutomaticaParser.GT:
                    stack.push(new Value(left.asDouble() > right.asDouble()));
                    break;
                case GramaticaAtividadeAutomaticaParser.GTEQ:
                    stack.push(new Value(left.asDouble() >= right.asDouble()));
                    break;
                default:
                    throw new RuntimeException("unknown operator");
            }
        }


        @Override
        public void enterEqualityExpr(GramaticaAtividadeAutomaticaParser.EqualityExprContext ctx) {
            stack.push(new Value(ctx.right.getText()));
            stack.push(new Value(ctx.left.getText()));
        }

        @Override
        public void exitEqualityExpr(GramaticaAtividadeAutomaticaParser.EqualityExprContext ctx) {
            Value right = stack.pop();
            Value left = stack.pop();

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.EQ:
                    if (left.isDouble() && right.isDouble()) {
                        stack.push(new Value(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE));
                    } else {
                        stack.push(new Value(left.equals(right)));
                    }
                    break;
                case GramaticaAtividadeAutomaticaParser.NEQ:
                    if (left.isDouble() && right.isDouble()) {
                        stack.push(new Value(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE));
                    } else {
                        stack.push(new Value(!left.equals(right)));
                    }
                    break;
                default:
                    throw new RuntimeException("unknown operator");
            }
        }

        @Override
        public void exitOpExprSumDif(GramaticaAtividadeAutomaticaParser.OpExprSumDifContext ctx) {
            Value right = stack.pop();
            Value left = stack.pop();

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.PLUS:
                    if (left.isDouble() && right.isDouble())
                        stack.push(new Value(left.asDouble() + right.asDouble()));
                    else
                        stack.push(new Value(left.asString() + right.asString()));
                    break;
                case GramaticaAtividadeAutomaticaParser.MINUS:
                    stack.push(new Value(left.asDouble() - right.asDouble()));
                    break;
                default:
                    throw new RuntimeException("unknown operator");
            }
        }

        @Override
        public void enterEstrutura_condicional(GramaticaAtividadeAutomaticaParser.Estrutura_condicionalContext ctx) {
            List<GramaticaAtividadeAutomaticaParser.CondicaoContext> conditions = ctx.ife().condicao();

            boolean evaluatedBlock = true;

            for (GramaticaAtividadeAutomaticaParser.CondicaoContext condition : conditions) {
                condition.expr().enterRule(this);
                condition.expr().exitRule(this);
                Value evaluated = stack.pop();

                if (!evaluated.asBoolean()) {
                    evaluatedBlock = false;
                    break;
                }
            }

            stack.push(new Value(evaluatedBlock));

        }

        @Override
        public void exitEstrutura_condicional(GramaticaAtividadeAutomaticaParser.Estrutura_condicionalContext ctx) {
            Value evaluatedBlock = stack.pop();

            if (evaluatedBlock.asBoolean()) {
                List<GramaticaAtividadeAutomaticaParser.InstrucaoContext> instrucoes = ctx.ife().instrucao();
                for (GramaticaAtividadeAutomaticaParser.InstrucaoContext instrucao : instrucoes) {
                    instrucao.expr().enterRule(this);
                    instrucao.expr().exitRule(this);
                }
            }

            if (!evaluatedBlock.asBoolean() && ctx.elsee() != null) {
                List<GramaticaAtividadeAutomaticaParser.InstrucaoContext> instrucoes = ctx.elsee().instrucao();
                for (GramaticaAtividadeAutomaticaParser.InstrucaoContext instrucao : instrucoes) {
                    instrucao.expr().enterRule(this);
                    instrucao.expr().exitRule(this);
                }
            }
        }

        @Override
        public void enterIfe(GramaticaAtividadeAutomaticaParser.IfeContext ctx) {
        }

        @Override
        public void exitIfe(GramaticaAtividadeAutomaticaParser.IfeContext ctx) {
        }

        @Override
        public void enterElsee(GramaticaAtividadeAutomaticaParser.ElseeContext ctx) {
        }

        @Override
        public void exitElsee(GramaticaAtividadeAutomaticaParser.ElseeContext ctx) {
        }

        @Override
        public void enterCondicao(GramaticaAtividadeAutomaticaParser.CondicaoContext ctx) {
        }

        @Override
        public void exitCondicao(GramaticaAtividadeAutomaticaParser.CondicaoContext ctx) {
        }

        @Override
        public void enterIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx) {

            GramaticaAtividadeAutomaticaParser.Condition_blockContext condition = ctx.condition_block();

            boolean evaluatedBlock = false;
            condition.expr().enterRule(this);
            condition.expr().exitRule(this);
            Value evaluated = stack.pop();

            if (evaluated.asBoolean()) {
                evaluatedBlock = true;
                condition.stat_block().enterRule(this);
            }

            if (!evaluatedBlock && ctx.stat_block() != null) {
                // evaluate the else-stat_block (if present == not null)
                ctx.stat_block().enterRule(this);
            }

        }
        */
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
        public Value visitTp_ident(GramaticaAtividadeAutomaticaParser.Tp_identContext ctx) {
            String id = ctx.identidade().getText();
            return memory.get(id);
        }

        @Override
        public Value visitTp_float(GramaticaAtividadeAutomaticaParser.Tp_floatContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitTp_string(GramaticaAtividadeAutomaticaParser.Tp_stringContext ctx) {
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
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() + right.asDouble());

                    if (left.isInteger() && right.isInteger())
                        return new Value(left.asInteger() + right.asInteger());

                    if (left.isString() || right.isString())
                        return new Value(left.asString() + right.asString());

                    throw new RuntimeException("unknown operator: " + GramaticaAtividadeAutomaticaParser.tokenNames[ctx.op.getType()]);
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

        @Override
        public Value visitEmailAtributos(GramaticaAtividadeAutomaticaParser.EmailAtributosContext ctx) {
            String destinatario = this.visit(ctx.destinatario).asString().replaceAll("\"", "");
            String assunto = this.visit(ctx.assunto).asString().replaceAll("\"", "");
            String corpo = this.visit(ctx.corpo).asString().replaceAll("\"", "");
            EmailSender.sendEmail(destinatario, assunto, corpo);
            return Value.VOID;
        }

        @Override
        public Value visitEmailString(GramaticaAtividadeAutomaticaParser.EmailStringContext ctx) {
            String destinatario = this.visit(ctx.destinatario).asString().replaceAll("\"", "");
            String assunto = ctx.assunto.getText().replaceAll("\"", "");
            String corpo = ctx.corpo.getText().replaceAll("\"", "");
            EmailSender.sendEmail(destinatario, assunto, corpo);
            return Value.VOID;
        }

        @Override
        public Value visitFicheiroNomeFicheiro(GramaticaAtividadeAutomaticaParser.FicheiroNomeFicheiroContext ctx) {
            String id = ctx.identidade().getText();
            Value value = new Value(ctx.STRING().getText().replaceAll("\"", ""));
            return memory.put(id, value);
        }

        @Override
        public Value visitAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx) {
            String file = this.visit(ctx.file).asString();
            String what = ctx.what.getText();
            String id = ctx.id.getText();
            String idValue = ctx.idvalue.getText();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder;
            Document doc = null;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(file);
                XPathFactory xpathFactory = XPathFactory.newInstance();
                XPath xpath = xpathFactory.newXPath();

                return memory.put(ctx.nomeVar.getText(), new Value(getSomethingByID(doc, xpath, what, id, idValue)));

            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Node getSomethingByID(Document doc, XPath xpath, String what, String id, String idValue) {
            try {
                XPathExpression expr = xpath.compile("//" + what + "[@" + id + "='" + idValue + "']");
                Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
                Element element = (Element) node;
                return element;
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public Value visitVariavelVariavel(GramaticaAtividadeAutomaticaParser.VariavelVariavelContext ctx) {
            Element element = this.visit(ctx.nomeElemento).asElement();
            String what = ctx.what.getText();
            Node node = element.getElementsByTagName(what).item(0);
            Element resultElement = (Element) node;
            Value result = new Value(resultElement.getTextContent());
            return memory.put(ctx.nomeVar.getText(), result);
        }

        @Override
        public Value visitUpdate_informacao(GramaticaAtividadeAutomaticaParser.Update_informacaoContext ctx) {
            String what = ctx.what.getText().replaceAll("\"", "");
            String id = ctx.id.getText().replaceAll("\"", "");
            String idvalue = ctx.idvalue.getText().replaceAll("\"", "");
            String whatToUpdate = ctx.whatToUpdate.getText().replaceAll("\"", "");
            String updatevalue = this.visit(ctx.updatevalue).asString().replaceAll("\"", "");

            String url = "jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10221/dados";
            String user = "admin";
            String passwd = "eapli";

            String query = String.format("UPDATE %s SET %s = '%s' WHERE %s = '%s'", what, whatToUpdate, updatevalue, id, idvalue);
            try {
                Class.forName("org.h2.Driver");

                Connection conn = DriverManager.getConnection(url, user, passwd);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return Value.VOID;
        }


    }
}
