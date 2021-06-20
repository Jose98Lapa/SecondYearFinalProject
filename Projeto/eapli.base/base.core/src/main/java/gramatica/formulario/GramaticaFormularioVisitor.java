// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaFormularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaFormularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#gramatica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramatica(GramaticaFormularioParser.GramaticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucao(GramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code validationFail}
	 * labeled alternative in {@link GramaticaFormularioParser#fail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidationFail(GramaticaFormularioParser.ValidationFailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code validationPass}
	 * labeled alternative in {@link GramaticaFormularioParser#fail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidationPass(GramaticaFormularioParser.ValidationPassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoIdent(GramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoAtribuicao(GramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao_atributo(GramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atr_atributo}
	 * labeled alternative in {@link GramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code match_regex}
	 * labeled alternative in {@link GramaticaFormularioParser#matchregex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_regex(GramaticaFormularioParser.Match_regexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code match_regex_atribut}
	 * labeled alternative in {@link GramaticaFormularioParser#matchregexatribut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch_regex_atribut(GramaticaFormularioParser.Match_regex_atributContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelVariavel(GramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavelAtr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(GramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(GramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(GramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumDifExpr(GramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(GramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(GramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_ident(GramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_integer(GramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_float(GramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_stringe(GramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTp_data(GramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(GramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloate(GramaticaFormularioParser.FloateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData(GramaticaFormularioParser.DataContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variavel}
	 * labeled alternative in {@link GramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(GramaticaFormularioParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link GramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(GramaticaFormularioParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senao}
	 * labeled alternative in {@link GramaticaFormularioParser#senao_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenao(GramaticaFormularioParser.SenaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code entao}
	 * labeled alternative in {@link GramaticaFormularioParser#entao_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntao(GramaticaFormularioParser.EntaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(GramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(GramaticaFormularioParser.Stat_blockContext ctx);
}