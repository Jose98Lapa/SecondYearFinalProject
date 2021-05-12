package eapli.base.function.DTO;

import eapli.base.function.domain.Designation;
import eapli.base.function.domain.IdFunction;
import eapli.framework.representations.dto.DTO;

@DTO
public class FunctionDTO {
    public String designacao;
    public String IdFuncao;

    public FunctionDTO(String idFuncao, String designacao) {
        this.designacao = designacao;
        this.IdFuncao = idFuncao;
    }

    public FunctionDTO(IdFunction idFunction, Designation designation){
        this.IdFuncao= idFunction.toString();
        this.designacao= designation.toString();
    }

    @Override
    public String toString() {
        return "Designacao: "+designacao;
    }
}
