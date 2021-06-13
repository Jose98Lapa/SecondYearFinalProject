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
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#tipo_ficheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_ficheiro(GramaticaAtividadeAutomaticaParser.Tipo_ficheiroContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemento(GramaticaAtividadeAutomaticaParser.ElementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoIdent(GramaticaAtividadeAutomaticaParser.InicializacaoIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoAtribuicao(GramaticaAtividadeAutomaticaParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelExpr(GramaticaAtividadeAutomaticaParser.VariavelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelVariavel(GramaticaAtividadeAutomaticaParser.VariavelVariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(GramaticaAtividadeAutomaticaParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(GramaticaAtividadeAutomaticaParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(GramaticaAtividadeAutomaticaParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(GramaticaAtividadeAutomaticaParser.AndExprContext ctx);
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
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(GramaticaAtividadeAutomaticaParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(GramaticaAtividadeAutomaticaParser.Stat_blockContext ctx);
}