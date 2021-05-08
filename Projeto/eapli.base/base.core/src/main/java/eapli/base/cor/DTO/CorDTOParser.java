package eapli.base.cor.DTO;

import eapli.base.cor.Builder.CorBuilder;
import eapli.base.cor.Domain.Cor;
import eapli.framework.representations.dto.DTOParser;

public class CorDTOParser implements DTOParser<CorDTO, Cor> {
    @Override
    public Cor valueOf(CorDTO dto) {
        CorBuilder corBuilder = new CorBuilder();
        corBuilder.nome(dto.nome).valorHexadecimal(dto.valorHexadecimal);
        return corBuilder.builder();
    }
}
