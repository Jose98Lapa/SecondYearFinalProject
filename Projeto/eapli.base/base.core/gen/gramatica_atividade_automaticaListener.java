// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/resources\gramatica_atividade_automatica.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramatica_atividade_automaticaParser}.
 */
public interface gramatica_atividade_automaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void enterGramatica(gramatica_atividade_automaticaParser.GramaticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void exitGramatica(gramatica_atividade_automaticaParser.GramaticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(gramatica_atividade_automaticaParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(gramatica_atividade_automaticaParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void enterInicializacao_tipo_ficheiro(gramatica_atividade_automaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void exitInicializacao_tipo_ficheiro(gramatica_atividade_automaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 */
	void enterInicializacao_elemento(gramatica_atividade_automaticaParser.Inicializacao_elementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 */
	void exitInicializacao_elemento(gramatica_atividade_automaticaParser.Inicializacao_elementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao_elemento(gramatica_atividade_automaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao_elemento(gramatica_atividade_automaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_inicializacao(gramatica_atividade_automaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_inicializacao(gramatica_atividade_automaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_atribuicao(gramatica_atividade_automaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_atribuicao(gramatica_atividade_automaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gramatica_atividade_automaticaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gramatica_atividade_automaticaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTipo_dados(gramatica_atividade_automaticaParser.Tipo_dadosContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTipo_dados(gramatica_atividade_automaticaParser.Tipo_dadosContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(gramatica_atividade_automaticaParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(gramatica_atividade_automaticaParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#floate}.
	 * @param ctx the parse tree
	 */
	void enterFloate(gramatica_atividade_automaticaParser.FloateContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#floate}.
	 * @param ctx the parse tree
	 */
	void exitFloate(gramatica_atividade_automaticaParser.FloateContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#identidade}.
	 * @param ctx the parse tree
	 */
	void enterIdentidade(gramatica_atividade_automaticaParser.IdentidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#identidade}.
	 * @param ctx the parse tree
	 */
	void exitIdentidade(gramatica_atividade_automaticaParser.IdentidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 */
	void enterEstrutura_xml(gramatica_atividade_automaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 */
	void exitEstrutura_xml(gramatica_atividade_automaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEnviar_email(gramatica_atividade_automaticaParser.Enviar_emailContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEnviar_email(gramatica_atividade_automaticaParser.Enviar_emailContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_informacao(gramatica_atividade_automaticaParser.Update_informacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_informacao(gramatica_atividade_automaticaParser.Update_informacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 */
	void enterEstrutura_condicional(gramatica_atividade_automaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 */
	void exitEstrutura_condicional(gramatica_atividade_automaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#ife}.
	 * @param ctx the parse tree
	 */
	void enterIfe(gramatica_atividade_automaticaParser.IfeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#ife}.
	 * @param ctx the parse tree
	 */
	void exitIfe(gramatica_atividade_automaticaParser.IfeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_atividade_automaticaParser#elsee}.
	 * @param ctx the parse tree
	 */
	void enterElsee(gramatica_atividade_automaticaParser.ElseeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_atividade_automaticaParser#elsee}.
	 * @param ctx the parse tree
	 */
	void exitElsee(gramatica_atividade_automaticaParser.ElseeContext ctx);
}