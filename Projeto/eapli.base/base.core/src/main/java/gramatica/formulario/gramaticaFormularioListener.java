// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\gramaticaFormulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaFormularioParser}.
 */
public interface gramaticaFormularioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#gramaica}.
	 * @param ctx the parse tree
	 */
	void enterGramaica(gramaticaFormularioParser.GramaicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#gramaica}.
	 * @param ctx the parse tree
	 */
	void exitGramaica(gramaticaFormularioParser.GramaicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(gramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(gramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoIdent(gramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoIdent(gramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoAtribuicao(gramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoAtribuicao(gramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao_atributo(gramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao_atributo(gramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void enterGet_atributo(gramaticaFormularioParser.Get_atributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void exitGet_atributo(gramaticaFormularioParser.Get_atributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelExpr(gramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelExpr(gramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelVariavel(gramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelVariavel(gramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(gramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(gramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(gramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(gramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(gramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(gramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(gramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(gramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumDifExpr(gramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumDifExpr(gramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(gramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(gramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(gramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(gramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(gramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(gramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_ident(gramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_ident(gramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_integer(gramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_integer(gramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_float(gramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_float(gramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_stringe(gramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_stringe(gramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_data(gramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_data(gramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(gramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(gramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void enterFloate(gramaticaFormularioParser.FloateContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void exitFloate(gramaticaFormularioParser.FloateContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(gramaticaFormularioParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(gramaticaFormularioParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void enterIdentidade(gramaticaFormularioParser.IdentidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void exitIdentidade(gramaticaFormularioParser.IdentidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(gramaticaFormularioParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(gramaticaFormularioParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(gramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(gramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(gramaticaFormularioParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(gramaticaFormularioParser.Stat_blockContext ctx);
}