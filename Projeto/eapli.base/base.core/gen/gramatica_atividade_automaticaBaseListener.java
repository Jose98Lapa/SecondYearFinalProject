// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/resources\gramatica_atividade_automatica.g4 by ANTLR 4.9.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

/**
 * This class provides an empty implementation of {@link gramatica_atividade_automaticaListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class gramatica_atividade_automaticaBaseListener implements gramatica_atividade_automaticaListener {

    private final Stack<Integer> stack = new Stack<>();

    public int getResult() {
        return stack.peek();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterGramatica(gramatica_atividade_automaticaParser.GramaticaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitGramatica(gramatica_atividade_automaticaParser.GramaticaContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInstrucao(gramatica_atividade_automaticaParser.InstrucaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInstrucao(gramatica_atividade_automaticaParser.InstrucaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInicializacao_tipo_ficheiro(gramatica_atividade_automaticaParser.Inicializacao_tipo_ficheiroContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInicializacao_tipo_ficheiro(gramatica_atividade_automaticaParser.Inicializacao_tipo_ficheiroContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInicializacao_elemento(gramatica_atividade_automaticaParser.Inicializacao_elementoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInicializacao_elemento(gramatica_atividade_automaticaParser.Inicializacao_elementoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAtribuicao_elemento(gramatica_atividade_automaticaParser.Atribuicao_elementoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAtribuicao_elemento(gramatica_atividade_automaticaParser.Atribuicao_elementoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpressao_inicializacao(gramatica_atividade_automaticaParser.Expressao_inicializacaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpressao_inicializacao(gramatica_atividade_automaticaParser.Expressao_inicializacaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpressao_atribuicao(gramatica_atividade_automaticaParser.Expressao_atribuicaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpressao_atribuicao(gramatica_atividade_automaticaParser.Expressao_atribuicaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExpr(gramatica_atividade_automaticaParser.ExprContext ctx) {
        stack.push(Integer.valueOf(ctx.atom.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExpr(gramatica_atividade_automaticaParser.ExprContext ctx) {
        int right = stack.pop();
        int left = stack.pop();
        int result;
        char op = ctx.op.getText().charAt(0);
        switch (op) {
            case '+' -> result = left + right;
            case '-' -> result = left - right;
            case '/' -> result = left / right;
            case '*' -> result = left * right;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        }
        stack.push(result);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTipo_dados(gramatica_atividade_automaticaParser.Tipo_dadosContext ctx) {
        stack.push(Integer.valueOf(ctx.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTipo_dados(gramatica_atividade_automaticaParser.Tipo_dadosContext ctx) {
        //String data = stack.pop();
        //stack.push(result);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInteger(gramatica_atividade_automaticaParser.IntegerContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInteger(gramatica_atividade_automaticaParser.IntegerContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFloate(gramatica_atividade_automaticaParser.FloateContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFloate(gramatica_atividade_automaticaParser.FloateContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIdentidade(gramatica_atividade_automaticaParser.IdentidadeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIdentidade(gramatica_atividade_automaticaParser.IdentidadeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEstrutura_xml(gramatica_atividade_automaticaParser.Estrutura_xmlContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEstrutura_xml(gramatica_atividade_automaticaParser.Estrutura_xmlContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEnviar_email(gramatica_atividade_automaticaParser.Enviar_emailContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEnviar_email(gramatica_atividade_automaticaParser.Enviar_emailContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterUpdate_informacao(gramatica_atividade_automaticaParser.Update_informacaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitUpdate_informacao(gramatica_atividade_automaticaParser.Update_informacaoContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEstrutura_condicional(gramatica_atividade_automaticaParser.Estrutura_condicionalContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEstrutura_condicional(gramatica_atividade_automaticaParser.Estrutura_condicionalContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIfe(gramatica_atividade_automaticaParser.IfeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIfe(gramatica_atividade_automaticaParser.IfeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterElsee(gramatica_atividade_automaticaParser.ElseeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitElsee(gramatica_atividade_automaticaParser.ElseeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
    }
}