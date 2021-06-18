package eapli.base.automatictask.executor;

import eapli.base.automatictask.executor.gramatica.atividadeAutomatica.*;
import gramatica.formulario.GramaticaFormulario;
import gramatica.formulario.GramaticaFormularioParser;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExecutorAtividadeAutomatica {
    public static void main(String[] args) throws IOException {
        //System.out.println("Result with Visitor : ");
        //parseWithVisitor("teste_atividade_automatica.txt");
    }

    public static Pair<Boolean,String> parseWithVisitor(String userEmail, String script, List<String> formAnswers, List<String> formApproval) throws IOException {
        GramaticaAtividadeAutomaticaLexer lexer = new GramaticaAtividadeAutomaticaLexer(CharStreams.fromFileName(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaAtividadeAutomaticaParser parser = new GramaticaAtividadeAutomaticaParser(tokens);
        try {
            parser.removeErrorListeners();
            parser.setErrorHandler(new BailErrorStrategy());
            ParseTree tree = parser.gramatica(); // parse
            EvalVisitor eval = new EvalVisitor(userEmail, formAnswers, formApproval);
            eval.visit(tree);
        } catch (ParseCancellationException e) {
            String errorMessage = e.getMessage();
            if (errorMessage == null)
                errorMessage = "Lexical error";
            return new Pair<>(false,errorMessage);
        }
        return new Pair<>(true,"Succesfull");
    }

    public static Pair<Boolean,String> parseWithListener(String userEmail, String script, List<String> formAnswers, List<String> formApproval) throws IOException {
        GramaticaAtividadeAutomaticaLexer lexer = new GramaticaAtividadeAutomaticaLexer(CharStreams.fromFileName(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaAtividadeAutomaticaParser parser = new GramaticaAtividadeAutomaticaParser(tokens);
        try {
            parser.removeErrorListeners();
            parser.setErrorHandler(new BailErrorStrategy());
            ParseTree tree = parser.gramatica(); // parse
            ParseTreeWalker walker = new ParseTreeWalker();
            EvalListener eval = new EvalListener(userEmail, formAnswers, formApproval);
            walker.walk(eval, tree);
        } catch (ParseCancellationException e) {
            String errorMessage = e.getMessage();
            if (errorMessage == null)
                errorMessage = "Lexical error";
            return new Pair<>(false,errorMessage);
        }
        return new Pair<>(true,"Succesfull");
    }


    static class EvalListener extends GramaticaAtividadeAutomaticaBaseListener implements GramaticaAtividadeAutomaticaListener {
        private String userEmail;
        List<String> formAnswers;
        List<String> formApproved;
        public static final double SMALL_VALUE = 0.00000000001;
        private Map<String, Value> memory = new HashMap<String, Value>();
        private final Stack<Value> stack = new Stack<>();
        public Value getResult() {
            return stack.peek();
        }
        boolean doInstruction=true;

        public EvalListener(String userEmail, List<String> formAnswers, List<String> formApproved) {
            this.userEmail = userEmail;
            this.formAnswers = formAnswers;
            this.formApproved = formApproved;
        }

        @Override
        public void exitFicheiroNomeFicheiro(GramaticaAtividadeAutomaticaParser.FicheiroNomeFicheiroContext ctx) {
            if (doInstruction) {
                Value identidade = stack.pop();
                String stringFicheiro = ctx.stringficheiro.getText();
                memory.put(identidade.toString(), new Value(stringFicheiro));
            }
        }

        @Override
        public void enterIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx) {
            if (doInstruction) {
                stack.push(new Value(ctx.var.getText()));
            }
        }

        @Override
        public void exitElem_idt(GramaticaAtividadeAutomaticaParser.Elem_idtContext ctx) {
            if (doInstruction) {
                Value identidade = stack.pop();
                memory.put(identidade.toString(), null);
            }
        }

        @Override
        public void exitAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx) {
            if (doInstruction) {
                Value identidade = stack.pop();
                String what = ctx.what.getText();
                String file = ctx.file.getText();
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

                    memory.put(identidade.toString(), new Value(getSomethingByID(doc, xpath, what, id, idValue)));

                } catch (ParserConfigurationException | SAXException | IOException e) {
                    throw new ParseCancellationException("Ficheiro xml não reconhecido");
                }
            }
        }

        private Node getSomethingByID(Document doc, XPath xpath, String what, String id, String idValue) {
                try {
                    XPathExpression expr = xpath.compile("//" + what + "[@" + id + "='" + idValue + "']");
                    Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
                    Element element = (Element) node;
                    return element;
                } catch (XPathExpressionException e) {
                    throw new ParseCancellationException("Atributo xml não encontrado");
                }
        }

        @Override
        public void exitAtr_variavelVariavel(GramaticaAtividadeAutomaticaParser.Atr_variavelVariavelContext ctx) {
            if (doInstruction) {
                try {
                    Value identidade = stack.pop();
                    Element element = stack.pop().asElement();
                    String what = ctx.what.getText();
                    Node node = element.getElementsByTagName(what).item(0);
                    Element resultElement = (Element) node;
                    Value result = new Value(resultElement.getTextContent());
                    memory.put(ctx.nomeVar.getText(), result);
                } catch (Exception e) {
                    throw new ParseCancellationException("Elemento xml não encontrado");
                }
            }
        }

        @Override
        public void exitInicializacaoAtribuicao(GramaticaAtividadeAutomaticaParser.InicializacaoAtribuicaoContext ctx){
            if (doInstruction) {
                Value identidade = stack.pop();
                Value value = stack.pop();
                memory.put(identidade.toString(), value);
            }
        }

        @Override
        public void enterAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx){
            if (doInstruction) {
                stack.push(new Value(ctx.atom.getText()));
            }
        }

        @Override
        public void enterFormAnswer(GramaticaAtividadeAutomaticaParser.FormAnswerContext ctx) {
            if (doInstruction) {
                int index = new Value(ctx.dados.getText()).asInteger();
                Value identidade = stack.pop();

                if (index >= this.formAnswers.size())
                    throw new ParseCancellationException(String.format("Indice fora dos limites: %d.", index));
                Value dados = new Value(formAnswers.get(index - 1));
                memory.put(identidade.toString(), dados);
            }
        }

        @Override
        public void enterFormApprov(GramaticaAtividadeAutomaticaParser.FormApprovContext ctx){
            if (doInstruction) {
                int index = new Value(ctx.dados.getText()).asInteger();
                Value identidade = stack.pop();

                if (index >= this.formApproved.size())
                    throw new ParseCancellationException(String.format("Indice fora dos limites: %d.", index));
                Value dados = new Value(formApproved.get(index - 1));
                memory.put(identidade.toString(), dados);
            }
        }

        @Override
        public void exitEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx){
            Value identidade = stack.pop();
            if(!memory.containsKey(identidade.toString()))
                throw new ParseCancellationException("Variável não inicializada");
            Value left=memory.get(identidade.toString());
            Value right=new Value(ctx.right);
            switch (ctx.op.getType()) {
                case GramaticaFormularioParser.EQ:
                    stack.push(new Value(left.equals(right)));
                    break;
                case GramaticaFormularioParser.NEQ:
                    stack.push(new Value(!left.equals(right)));
                    break;
            }
        }

        @Override
        public void enterEntao(GramaticaAtividadeAutomaticaParser.EntaoContext ctx) {
            if (doInstruction) {
                Value bool = stack.pop();
                doInstruction = bool.asBoolean();
            }
        }

        @Override
        public void enterSenao(GramaticaAtividadeAutomaticaParser.SenaoContext ctx){
            doInstruction=!doInstruction;
        }

        @Override
        public void exitIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx){
            doInstruction=true;
        }
        @Override
        public void exitAtr_variavelExpr(GramaticaAtividadeAutomaticaParser.Atr_variavelExprContext ctx) {
            if (doInstruction) {
                Value identidade = stack.pop();
            }
        }

        @Override
        public void exitSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx) {
            if (doInstruction) {
                Value left = stack.pop();
                Value right = new Value(ctx.right);
                switch (ctx.op.getType()) {
                    case GramaticaFormularioParser.MAIS:
                        if (left.isDouble() && right.isDouble())
                            stack.push(new Value(left.asDouble() + right.asDouble()));
                        if (left.isInteger() && right.isInteger())
                            stack.push(new Value(left.asInteger() + right.asInteger()));
                        if (left.isString() || right.isString())
                            stack.push(new Value(left.asString() + right.asString()));
                        break;
                    case GramaticaFormularioParser.MENOS:
                        if (left.isDouble() && right.isDouble())
                            stack.push(new Value(left.asDouble() - right.asDouble()));
                        if (left.isInteger() && right.isInteger())
                            stack.push(new Value(left.asInteger() - right.asInteger()));
                        if (left.isString() || right.isString())
                            throw new ParseCancellationException("Não foi possivel fazer a operação");
                        break;
                }
            }
        }

        @Override
        public void exitEmailAtributos(GramaticaAtividadeAutomaticaParser.EmailAtributosContext ctx) {
            if (doInstruction) {
                Value destinatario = stack.pop();
                Value assunto = stack.pop();
                Value corpo = stack.pop();
                EmailSender.sendEmail(destinatario.toString().replaceAll("\"", ""), assunto.toString().replaceAll("\"", ""), corpo.toString().replaceAll("\"", ""));
            }
        }

        @Override
        public void exitEmailString(GramaticaAtividadeAutomaticaParser.EmailStringContext ctx) {
            if (doInstruction) {
                Value destinatario = stack.pop();
                String assunto = ctx.assunto.getText();
                String corpo = ctx.corpo.getText();
                EmailSender.sendEmail(destinatario.toString().replaceAll("\"", ""), assunto.replaceAll("\"", ""), corpo.replaceAll("\"", ""));
            }
        }

        @Override
        public void exitEmailAtributosDefaultEmail(GramaticaAtividadeAutomaticaParser.EmailAtributosDefaultEmailContext ctx){
            if (doInstruction) {
                Value assunto = stack.pop();
                Value corpo = stack.pop();
                EmailSender.sendEmail(userEmail, assunto.toString().replaceAll("\"", ""), corpo.toString().replaceAll("\"", ""));
            }
        }

        @Override
        public void exitEmailStringDefaultEmail(GramaticaAtividadeAutomaticaParser.EmailStringDefaultEmailContext ctx) {
            if (doInstruction) {
                String assunto = ctx.assunto.getText();
                String corpo = ctx.corpo.getText();
                EmailSender.sendEmail(userEmail, assunto.replaceAll("\"", ""), corpo.replaceAll("\"", ""));
            }
        }

        @Override
        public void exitUpdate_informacao(GramaticaAtividadeAutomaticaParser.Update_informacaoContext ctx) {
            if (doInstruction){
                String what = ctx.what.getText().replaceAll("\"", "");
                String id = ctx.id.getText().replaceAll("\"", "");
                String idvalue = ctx.idvalue.getText().replaceAll("\"", "");
                String whatToUpdate = ctx.updatevalue.getText().replaceAll("\"", "");
                String updatevalue = stack.pop().toString().replaceAll("\"", "");
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
                    throw new ParseCancellationException("Update não executado");
                }
            }
        }
    }

    static class EvalVisitor extends GramaticaAtividadeAutomaticaBaseVisitor<Value> {

        public static final double SMALL_VALUE = 0.00000000001;

        private Map<String, Value> memory = new HashMap<>();
        private String userEmail;
        List<String> formAnswers;
        List<String> formApproved;

        public EvalVisitor(String userEmail, List<String> formAnswers, List<String> formApproved) {
            this.userEmail = userEmail;
            this.formAnswers = formAnswers;
            this.formApproved = formApproved;
        }

        @Override
        public Value visitGramatica(GramaticaAtividadeAutomaticaParser.GramaticaContext ctx) {
            visitChildren(ctx);
            return new Value("Ok");
        }

        @Override
        public Value visitInicializacaoIdent(GramaticaAtividadeAutomaticaParser.InicializacaoIdentContext ctx) {
            String id = ctx.identidade().getText();
            return memory.put(id, Value.VOID);
        }

        @Override
        public Value visitAtr_variavelExpr(GramaticaAtividadeAutomaticaParser.Atr_variavelExprContext ctx) {
            String id = ctx.identidade().getText();
            Value value = this.visit(ctx.expr());
            String cameFrom = ctx.getParent().getRuleContext().getChild(0).getText();
            if (!memory.containsKey(id) && !verifyInitialization(cameFrom))
                throw new ParseCancellationException(String.format("Variavel %s não inicializada", id));
            return memory.put(id, value);
        }

        public boolean verifyInitialization(String where) {
            try {
                Value.Tipo value = Value.Tipo.valueOf(where);
            } catch (IllegalArgumentException e) {
                return false;
            }
            return true;
        }

        @Override
        public Value visitAtr_variavelVariavel(GramaticaAtividadeAutomaticaParser.Atr_variavelVariavelContext ctx) {
            try {
                Element element = this.visit(ctx.nomeElemento).asElement();
                String what = ctx.what.getText();
                Node node = element.getElementsByTagName(what).item(0);
                Element resultElement = (Element) node;
                Value result = new Value(resultElement.getTextContent());
                return memory.put(ctx.nomeVar.getText(), result);
            } catch (Exception e) {
                throw new ParseCancellationException("Elemento xml não encontrado");
            }
        }

        @Override
        public Value visitAtr_variavelForm(GramaticaAtividadeAutomaticaParser.Atr_variavelFormContext ctx) {
            String id = ctx.identidade().getText();
            Value value = this.visit(ctx.formulario_informacao());
            String cameFrom = ctx.getParent().getRuleContext().getChild(0).getText();
            if (!memory.containsKey(id) && !verifyInitialization(cameFrom))
                throw new ParseCancellationException(String.format("Variavel %s não inicializada", id));
            return memory.put(id, value);
        }

        @Override
        public Value visitFormApprov(GramaticaAtividadeAutomaticaParser.FormApprovContext ctx) {
            int index = Integer.parseInt(ctx.dados.getText()) - 1;
            if (index >= this.formApproved.size())
                throw new ParseCancellationException(String.format("Indice fora dos limites: %d", index));
            return new Value(this.formApproved.get(index));
        }

        @Override
        public Value visitFormAnswer(GramaticaAtividadeAutomaticaParser.FormAnswerContext ctx) {
            int index = Integer.parseInt(ctx.dados.getText()) - 1;
            if (index >= this.formAnswers.size())
                throw new ParseCancellationException(String.format("Indice fora dos limites: %d.", index));
            return new Value(this.formAnswers.get(index));
        }

        @Override
        public Value visitIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx) {
            String id = ctx.getText();
            Value temp = memory.get(id);
            if (temp == null)
                throw new ParseCancellationException(String.format("Variavel %s não inicializada", id));
            return temp;
        }

        @Override
        public Value visitTp_integer(GramaticaAtividadeAutomaticaParser.Tp_integerContext ctx) {
            return new Value(ctx.getText());
        }

        @Override
        public Value visitTp_ident(GramaticaAtividadeAutomaticaParser.Tp_identContext ctx) {
            String id = ctx.identidade().getText();
            Value temp = memory.get(id);
            if (temp == null)
                throw new ParseCancellationException(String.format("Variavel %s não inicializada", id));
            return temp;
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
            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);

            if (left.isString() || right.isString())
                throw new ParseCancellationException("Não foi possivel fazer a operação");

            return new Value(Math.pow(left.asDouble(), right.asDouble()));
        }

        @Override
        public Value visitMulDivModExpr(GramaticaAtividadeAutomaticaParser.MulDivModExprContext ctx) {
            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);

            if (left.isString() || right.isString())
                throw new ParseCancellationException("Não foi possivel fazer a operação");

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.MULT:
                    return new Value(left.asDouble() * right.asDouble());
                case GramaticaAtividadeAutomaticaParser.DIV:
                    return new Value(left.asDouble() / right.asDouble());
                case GramaticaAtividadeAutomaticaParser.MOD:
                    return new Value(left.asDouble() % right.asDouble());
                default:
                    throw new ParseCancellationException("Operação não reconhecida");
            }
        }

        @Override
        public Value visitSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx) {
            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);

            switch (ctx.op.getType()) {
                case GramaticaAtividadeAutomaticaParser.MAIS:
                    if (left.isDouble() && right.isDouble())
                        return new Value(left.asDouble() + right.asDouble());

                    if (left.isInteger() && right.isInteger())
                        return new Value(left.asInteger() + right.asInteger());

                    if (left.isString() || right.isString())
                        return new Value(left.asString() + right.asString());

                    throw new ParseCancellationException("Não foi possivel fazer a operação");
                case GramaticaAtividadeAutomaticaParser.MENOS:

                    if (left.isString() || right.isString())
                        throw new ParseCancellationException("Não foi possivel fazer a operação");

                    return left.isDouble() && right.isDouble() ?
                            new Value(left.asDouble() - right.asDouble()) :
                            new Value(left.asInteger() - right.asInteger());
                default:
                    throw new ParseCancellationException("Operação não reconhecida");
            }
        }

        @Override
        public Value visitRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx) {

            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);

            if (left.isString() || right.isString())
                throw new ParseCancellationException("Não foi possivel fazer a operação");

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
                    throw new ParseCancellationException("Operação não reconhecida");
            }
        }

        @Override
        public Value visitEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx) {

            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);

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
                    throw new ParseCancellationException("Operação não reconhecida");
            }
        }

        @Override
        public Value visitAndExpr(GramaticaAtividadeAutomaticaParser.AndExprContext ctx) {
            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);
            return new Value(left.asBoolean() && right.asBoolean());
        }

        @Override
        public Value visitOrExpr(GramaticaAtividadeAutomaticaParser.OrExprContext ctx) {
            Value left = this.visit(ctx.left);
            Value right = this.visit(ctx.right);
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
        public Value visitEmailAtributosDefaultEmail(GramaticaAtividadeAutomaticaParser.EmailAtributosDefaultEmailContext ctx) {
            String assunto = this.visit(ctx.assunto).asString().replaceAll("\"", "");
            String corpo = this.visit(ctx.corpo).asString().replaceAll("\"", "");
            EmailSender.sendEmail(this.userEmail, assunto, corpo);
            return Value.VOID;
        }

        @Override
        public Value visitEmailStringDefaultEmail(GramaticaAtividadeAutomaticaParser.EmailStringDefaultEmailContext ctx) {
            String assunto = ctx.assunto.getText().replaceAll("\"", "");
            String corpo = ctx.corpo.getText().replaceAll("\"", "");
            EmailSender.sendEmail(this.userEmail, assunto, corpo);
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
                throw new ParseCancellationException("Ficheiro xml não reconhecido");
            }
        }

        private Node getSomethingByID(Document doc, XPath xpath, String what, String id, String idValue) {
            try {
                XPathExpression expr = xpath.compile("//" + what + "[@" + id + "='" + idValue + "']");
                Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
                Element element = (Element) node;
                return element;
            } catch (XPathExpressionException e) {
                throw new ParseCancellationException("Atributo xml não encontrado");
            }
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
                throw new ParseCancellationException("Update não executado");
            }
            return Value.VOID;
        }


    }
}
