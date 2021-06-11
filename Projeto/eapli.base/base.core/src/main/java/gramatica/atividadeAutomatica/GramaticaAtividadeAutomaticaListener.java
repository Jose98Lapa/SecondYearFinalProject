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
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void enterInicializacao_tipo_ficheiro(GramaticaAtividadeAutomaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_tipo_ficheiro}.
	 * @param ctx the parse tree
	 */
	void exitInicializacao_tipo_ficheiro(GramaticaAtividadeAutomaticaParser.Inicializacao_tipo_ficheiroContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 */
	void enterInicializacao_elemento(GramaticaAtividadeAutomaticaParser.Inicializacao_elementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#inicializacao_elemento}.
	 * @param ctx the parse tree
	 */
	void exitInicializacao_elemento(GramaticaAtividadeAutomaticaParser.Inicializacao_elementoContext ctx);
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
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_inicializacao(GramaticaAtividadeAutomaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_inicializacao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_inicializacao(GramaticaAtividadeAutomaticaParser.Expressao_inicializacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_atribuicao(GramaticaAtividadeAutomaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#expressao_atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_atribuicao(GramaticaAtividadeAutomaticaParser.Expressao_atribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExprMulDiv(GramaticaAtividadeAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExprSumDif(GramaticaAtividadeAutomaticaParser.OpExprSumDifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaAtividadeAutomaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExprSumDif(GramaticaAtividadeAutomaticaParser.OpExprSumDifContext ctx);
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
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEnviar_email(GramaticaAtividadeAutomaticaParser.Enviar_emailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEnviar_email(GramaticaAtividadeAutomaticaParser.Enviar_emailContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 */
	void enterEstrutura_condicional(GramaticaAtividadeAutomaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#estrutura_condicional}.
	 * @param ctx the parse tree
	 */
	void exitEstrutura_condicional(GramaticaAtividadeAutomaticaParser.Estrutura_condicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#ife}.
	 * @param ctx the parse tree
	 */
	void enterIfe(GramaticaAtividadeAutomaticaParser.IfeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#ife}.
	 * @param ctx the parse tree
	 */
	void exitIfe(GramaticaAtividadeAutomaticaParser.IfeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elsee}.
	 * @param ctx the parse tree
	 */
	void enterElsee(GramaticaAtividadeAutomaticaParser.ElseeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaAtividadeAutomaticaParser#elsee}.
	 * @param ctx the parse tree
	 */
	void exitElsee(GramaticaAtividadeAutomaticaParser.ElseeContext ctx);
}