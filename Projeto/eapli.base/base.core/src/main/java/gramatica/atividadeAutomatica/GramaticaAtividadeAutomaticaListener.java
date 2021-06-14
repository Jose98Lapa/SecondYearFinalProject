// Generated from C:/Users/tigas/OneDrive/Ambiente de Trabalho/LAPR/Projeto/eapli.base/base.core/src/main/java/gramatica/atividadeAutomatica\GramaticaAtividadeAutomatica.g4 by ANTLR 4.9.1
package gramatica.atividadeAutomatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaAtividadeAutomaticaParser}.
 */
public interface GramaticaAtividadeAutomaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void enterGramatica(GramaticaAtividadeAutomaticaParser.GramaticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#gramatica}.
	 * @param ctx the parse tree
	 */
	void exitGramatica(GramaticaAtividadeAutomaticaParser.GramaticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void enterInstrucao(GramaticaAtividadeAutomaticaParser.InstrucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#instrucao}.
	 * @param ctx the parse tree
	 */
	void exitInstrucao(GramaticaAtividadeAutomaticaParser.InstrucaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 */
	void enterEstrutura_xml(GramaticaAtividadeAutomaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_xml}.
	 * @param ctx the parse tree
	 */
	void exitEstrutura_xml(GramaticaAtividadeAutomaticaParser.Estrutura_xmlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ficheiroIdent}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void enterFicheiroIdent(GramaticaAtividadeAutomaticaParser.FicheiroIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ficheiroIdent}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void exitFicheiroIdent(GramaticaAtividadeAutomaticaParser.FicheiroIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ficheiroNomeFicheiro}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void enterFicheiroNomeFicheiro(GramaticaAtividadeAutomaticaParser.FicheiroNomeFicheiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ficheiroNomeFicheiro}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void exitFicheiroNomeFicheiro(GramaticaAtividadeAutomaticaParser.FicheiroNomeFicheiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elemento}.
	 * @param ctx the parse tree
	 */
	void enterElemento(GramaticaAtividadeAutomaticaParser.ElementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elemento}.
	 * @param ctx the parse tree
	 */
	void exitElemento(GramaticaAtividadeAutomaticaParser.ElementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#atribuicao_elemento}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao_elemento(GramaticaAtividadeAutomaticaParser.Atribuicao_elementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoIdent(GramaticaAtividadeAutomaticaParser.InicializacaoIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoIdent}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoIdent(GramaticaAtividadeAutomaticaParser.InicializacaoIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoAtribuicao(GramaticaAtividadeAutomaticaParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicializacaoAtribuicao}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoAtribuicao(GramaticaAtividadeAutomaticaParser.InicializacaoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelExpr(GramaticaAtividadeAutomaticaParser.VariavelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelExpr(GramaticaAtividadeAutomaticaParser.VariavelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterVariavelVariavel(GramaticaAtividadeAutomaticaParser.VariavelVariavelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variavelVariavel}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitVariavelVariavel(GramaticaAtividadeAutomaticaParser.VariavelVariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(GramaticaAtividadeAutomaticaParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(GramaticaAtividadeAutomaticaParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(GramaticaAtividadeAutomaticaParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(GramaticaAtividadeAutomaticaParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(GramaticaAtividadeAutomaticaParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(GramaticaAtividadeAutomaticaParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(GramaticaAtividadeAutomaticaParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(GramaticaAtividadeAutomaticaParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(GramaticaAtividadeAutomaticaParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(GramaticaAtividadeAutomaticaParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(GramaticaAtividadeAutomaticaParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(GramaticaAtividadeAutomaticaParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sumDifExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumDifExpr(GramaticaAtividadeAutomaticaParser.SumDifExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(GramaticaAtividadeAutomaticaParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpr(GramaticaAtividadeAutomaticaParser.EqualExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(GramaticaAtividadeAutomaticaParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(GramaticaAtividadeAutomaticaParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_ident(GramaticaAtividadeAutomaticaParser.Tp_identContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_ident}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_ident(GramaticaAtividadeAutomaticaParser.Tp_identContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_integer(GramaticaAtividadeAutomaticaParser.Tp_integerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_integer}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_integer(GramaticaAtividadeAutomaticaParser.Tp_integerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void enterTp_float(GramaticaAtividadeAutomaticaParser.Tp_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tp_float}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#tipo_dados}.
	 * @param ctx the parse tree
	 */
	void exitTp_float(GramaticaAtividadeAutomaticaParser.Tp_floatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GramaticaAtividadeAutomaticaParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GramaticaAtividadeAutomaticaParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#floate}.
	 * @param ctx the parse tree
	 */
	void enterFloate(GramaticaAtividadeAutomaticaParser.FloateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#floate}.
	 * @param ctx the parse tree
	 */
	void exitFloate(GramaticaAtividadeAutomaticaParser.FloateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#identidade}.
	 * @param ctx the parse tree
	 */
	void enterIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#identidade}.
	 * @param ctx the parse tree
	 */
	void exitIdentidade(GramaticaAtividadeAutomaticaParser.IdentidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(GramaticaAtividadeAutomaticaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(GramaticaAtividadeAutomaticaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emailAtributos}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEmailAtributos(GramaticaAtividadeAutomaticaParser.EmailAtributosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emailAtributos}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEmailAtributos(GramaticaAtividadeAutomaticaParser.EmailAtributosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emailString}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEmailString(GramaticaAtividadeAutomaticaParser.EmailStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emailString}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEmailString(GramaticaAtividadeAutomaticaParser.EmailStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_informacao(GramaticaAtividadeAutomaticaParser.Update_informacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#update_informacao}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_informacao(GramaticaAtividadeAutomaticaParser.Update_informacaoContext ctx);
}