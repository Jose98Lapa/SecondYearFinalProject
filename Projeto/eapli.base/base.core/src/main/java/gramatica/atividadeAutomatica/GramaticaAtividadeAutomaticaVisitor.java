// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package gramatica.atividadeAutomatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaAtividadeAutomaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaAtividadeAutomaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#gramatica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramatica(GramaticaAtividadeAutomaticaParser.GramaticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(GramaticaAtividadeAutomaticaParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacao_tipo_ficheiro(GramaticaAtividadeAutomaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacao_elemento(GramaticaAtividadeAutomaticaParser.Inicializacao_elementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao_inicializacao(GramaticaAtividadeAutomaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao_atribuicao(GramaticaAtividadeAutomaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprSumDif(GramaticaAtividadeAutomaticaParser.OpExprSumDifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_ident(GramaticaAtividadeAutomaticaParser.Tp_identContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_integer(GramaticaAtividadeAutomaticaParser.Tp_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_float(GramaticaAtividadeAutomaticaParser.Tp_floatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(GramaticaAtividadeAutomaticaParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#floate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloate(GramaticaAtividadeAutomaticaParser.FloateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#identidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutura_xml(GramaticaAtividadeAutomaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviar_email(GramaticaAtividadeAutomaticaParser.Enviar_emailContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_informacao(GramaticaAtividadeAutomaticaParser.Update_informacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutura_condicional(GramaticaAtividadeAutomaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#ife}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfe(GramaticaAtividadeAutomaticaParser.IfeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elsee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsee(GramaticaAtividadeAutomaticaParser.ElseeContext ctx);
}