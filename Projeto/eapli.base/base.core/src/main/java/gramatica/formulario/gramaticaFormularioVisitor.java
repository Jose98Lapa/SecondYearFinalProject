// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\gramaticaFormulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramaticaFormularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramaticaFormularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#gramaica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramaica(gramaticaFormularioParser.GramaicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(gramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoIdent(gramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoAtribuicao(gramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_atributo(gramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGet_atributo(gramaticaFormularioParser.Get_atributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelExpr(gramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelVariavel(gramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(gramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(gramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(gramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(gramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDifExpr(gramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(gramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(gramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(gramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_ident(gramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_integer(gramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_float(gramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_stringe(gramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_data(gramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(gramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloate(gramaticaFormularioParser.FloateContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(gramaticaFormularioParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentidade(gramaticaFormularioParser.IdentidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(gramaticaFormularioParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(gramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(gramaticaFormularioParser.Stat_blockContext ctx);
}