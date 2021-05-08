package eapli.base.colaborador.dto;

import eapli.base.colaborador.domain.Morada;
import eapli.framework.representations.dto.DTOParser;

public class MoradaDTOParser implements DTOParser<MoradaDTO, Morada> {

    @Override
    public Morada valueOf(MoradaDTO dto) {
        return new Morada(dto.estrada, dto.numPorta, dto.andar, dto.localizacao, dto.codPostal);
    }
}
