// Generated from S:/data/2ano/2Semestre/LAPR4/lei20_21_s4_2dl_1/Projeto/eapli.base/base.core/src/main/java/gramatica/formulario\GramaticaFormulario.g4 by ANTLR 4.9.1
package gramatica.formulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaFormularioParser}.
 */
public interface GramaticaFormularioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void enterGramatica(GramaticaFormularioParser.GramaticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void exitGramatica(GramaticaFormularioParser.GramaticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(GramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(GramaticaFormularioParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoIdent(GramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoIdent(GramaticaFormularioParser.InicializacaoIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoAtribuicao(GramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaFormularioParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoAtribuicao(GramaticaFormularioParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao_atributo(GramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#atribuicao_atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao_atributo(GramaticaFormularioParser.Atribuicao_atributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atr_atributo}
	 * labeled alternative in {@link GramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atr_atributo}
	 * labeled alternative in {@link GramaticaFormularioParser#get_atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtr_atributo(GramaticaFormularioParser.Atr_atributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelExpr(GramaticaFormularioParser.VariavelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelVariavel(GramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelVariavel(GramaticaFormularioParser.VariavelVariavelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelAtr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelAtr}
	 * labeled alternative in {@link GramaticaFormularioParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelAtr(GramaticaFormularioParser.VariavelAtrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(GramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(GramaticaFormularioParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(GramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(GramaticaFormularioParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(GramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(GramaticaFormularioParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(GramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(GramaticaFormularioParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumDifExpr(GramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumDifExpr(GramaticaFormularioParser.SumDifExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(GramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(GramaticaFormularioParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(GramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(GramaticaFormularioParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(GramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(GramaticaFormularioParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_ident(GramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_ident(GramaticaFormularioParser.Tp_identContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_integer(GramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_integer(GramaticaFormularioParser.Tp_integerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_float(GramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_float(GramaticaFormularioParser.Tp_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_stringe(GramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_stringe}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_stringe(GramaticaFormularioParser.Tp_stringeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_data(GramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_data}
	 * labeled alternative in {@link GramaticaFormularioParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_data(GramaticaFormularioParser.Tp_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GramaticaFormularioParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void enterFloate(GramaticaFormularioParser.FloateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#floate}.
	 * @param ctx the parse tree
	 */
	void exitFloate(GramaticaFormularioParser.FloateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(GramaticaFormularioParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(GramaticaFormularioParser.DataContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void enterIdentidade(GramaticaFormularioParser.IdentidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#identidade}.
	 * @param ctx the parse tree
	 */
	void exitIdentidade(GramaticaFormularioParser.IdentidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(GramaticaFormularioParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(GramaticaFormularioParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(GramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(GramaticaFormularioParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(GramaticaFormularioParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaFormularioParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(GramaticaFormularioParser.Stat_blockContext ctx);
}