package eapli.base.funcao.DTO;

import eapli.base.funcao.domain.Designacao;
import eapli.base.funcao.domain.IdFuncao;

public class FuncaoDTO {
    public String designacao;
    public String IdFuncao;

    public FuncaoDTO(String idFuncao, String designacao) {
        this.designacao = designacao;
        this.IdFuncao = idFuncao;
    }

    public FuncaoDTO(IdFuncao idFuncao, Designacao designacao){
        this.IdFuncao=idFuncao.toString();
        this.designacao=designacao.toString();
    }
}
