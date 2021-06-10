package gramatica.atividade.automatica;// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/resources\gramatica_atividade_automatica.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramatica_atividade_automaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramatica_atividade_automaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#gramatica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramatica(gramatica_atividade_automaticaParser.GramaticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(gramatica_atividade_automaticaParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacao_tipo_ficheiro(gramatica_atividade_automaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacao_elemento(gramatica_atividade_automaticaParser.Inicializacao_elementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_elemento(gramatica_atividade_automaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao_inicializacao(gramatica_atividade_automaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao_atribuicao(gramatica_atividade_automaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(gramatica_atividade_automaticaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_dados(gramatica_atividade_automaticaParser.Tipo_dadosContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(gramatica_atividade_automaticaParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#floate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloate(gramatica_atividade_automaticaParser.FloateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#identidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentidade(gramatica_atividade_automaticaParser.IdentidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutura_xml(gramatica_atividade_automaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviar_email(gramatica_atividade_automaticaParser.Enviar_emailContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_informacao(gramatica_atividade_automaticaParser.Update_informacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutura_condicional(gramatica_atividade_automaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#ife}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfe(gramatica_atividade_automaticaParser.IfeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_atividade_automaticaParser#elsee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsee(gramatica_atividade_automaticaParser.ElseeContext ctx);
}