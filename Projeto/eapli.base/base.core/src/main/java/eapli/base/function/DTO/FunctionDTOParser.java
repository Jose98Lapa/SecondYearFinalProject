package eapli.base.function.DTO;

import eapli.base.function.domain.Function;
import eapli.base.function.builder.FunctionBuilder;
import eapli.framework.representations.dto.DTOParser;

public class FunctionDTOParser implements DTOParser<FunctionDTO, Function> {
    @Override
    public Function valueOf(FunctionDTO dto) {
        FunctionBuilder functionBuilder = new FunctionBuilder();
        return functionBuilder.withIdFuncao(dto.idFunction).withDesignacao(dto.designation).build();
    }
}
