// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\gramatica_formulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramatica_formularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramatica_formularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#gramatica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramatica(gramatica_formularioParser.GramaticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(gramatica_formularioParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoIdent(gramatica_formularioParser.InicializacaoIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoAtribuicao(gramatica_formularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_atributo(gramatica_formularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#get_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet_atributo(gramatica_formularioParser.Get_atributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelExpr(gramatica_formularioParser.VariavelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelVariavel(gramatica_formularioParser.VariavelVariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(gramatica_formularioParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(gramatica_formularioParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(gramatica_formularioParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(gramatica_formularioParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDifExpr(gramatica_formularioParser.SumDifExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(gramatica_formularioParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(gramatica_formularioParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(gramatica_formularioParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_ident(gramatica_formularioParser.Tp_identContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_integer(gramatica_formularioParser.Tp_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_float(gramatica_formularioParser.Tp_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_stringe(gramatica_formularioParser.Tp_stringeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_data(gramatica_formularioParser.Tp_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(gramatica_formularioParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#floate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloate(gramatica_formularioParser.FloateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(gramatica_formularioParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#identidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentidade(gramatica_formularioParser.IdentidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(gramatica_formularioParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(gramatica_formularioParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramatica_formularioParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(gramatica_formularioParser.Stat_blockContext ctx);
}