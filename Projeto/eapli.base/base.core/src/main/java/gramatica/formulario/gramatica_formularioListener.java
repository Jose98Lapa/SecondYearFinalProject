// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\gramatica_formulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramatica_formularioParser}.
 */
public interface gramatica_formularioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void enterGramatica(gramatica_formularioParser.GramaticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void exitGramatica(gramatica_formularioParser.GramaticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(gramatica_formularioParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(gramatica_formularioParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoIdent(gramatica_formularioParser.InicializacaoIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoIdent(gramatica_formularioParser.InicializacaoIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoAtribuicao(gramatica_formularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link gramatica_formularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoAtribuicao(gramatica_formularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao_atributo(gramatica_formularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao_atributo(gramatica_formularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void enterGet_atributo(gramatica_formularioParser.Get_atributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void exitGet_atributo(gramatica_formularioParser.Get_atributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelExpr(gramatica_formularioParser.VariavelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelExpr(gramatica_formularioParser.VariavelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelVariavel(gramatica_formularioParser.VariavelVariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link gramatica_formularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelVariavel(gramatica_formularioParser.VariavelVariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(gramatica_formularioParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(gramatica_formularioParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(gramatica_formularioParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(gramatica_formularioParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(gramatica_formularioParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(gramatica_formularioParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(gramatica_formularioParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(gramatica_formularioParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumDifExpr(gramatica_formularioParser.SumDifExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumDifExpr(gramatica_formularioParser.SumDifExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(gramatica_formularioParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(gramatica_formularioParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(gramatica_formularioParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(gramatica_formularioParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(gramatica_formularioParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link gramatica_formularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(gramatica_formularioParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_ident(gramatica_formularioParser.Tp_identContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_ident(gramatica_formularioParser.Tp_identContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_integer(gramatica_formularioParser.Tp_integerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_integer(gramatica_formularioParser.Tp_integerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_float(gramatica_formularioParser.Tp_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_float(gramatica_formularioParser.Tp_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_stringe(gramatica_formularioParser.Tp_stringeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_stringe(gramatica_formularioParser.Tp_stringeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_data(gramatica_formularioParser.Tp_dataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link gramatica_formularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_data(gramatica_formularioParser.Tp_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(gramatica_formularioParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(gramatica_formularioParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void enterFloate(gramatica_formularioParser.FloateContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void exitFloate(gramatica_formularioParser.FloateContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(gramatica_formularioParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(gramatica_formularioParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void enterIdentidade(gramatica_formularioParser.IdentidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void exitIdentidade(gramatica_formularioParser.IdentidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(gramatica_formularioParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(gramatica_formularioParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(gramatica_formularioParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(gramatica_formularioParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramatica_formularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(gramatica_formularioParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramatica_formularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(gramatica_formularioParser.Stat_blockContext ctx);
}