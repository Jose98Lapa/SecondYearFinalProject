package eapli.base.funcao.DTO;

import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.builder.FuncaoBuilder;
import eapli.framework.representations.dto.DTOParser;

public class FuncaoDTOParser implements DTOParser<FuncaoDTO, Funcao> {
    @Override
    public Funcao valueOf(FuncaoDTO dto) {
        FuncaoBuilder funcaoBuilder = new FuncaoBuilder();
        return funcaoBuilder.withIdFuncao(dto.IdFuncao).withDesignacao(dto.designacao).build();
    }
}
