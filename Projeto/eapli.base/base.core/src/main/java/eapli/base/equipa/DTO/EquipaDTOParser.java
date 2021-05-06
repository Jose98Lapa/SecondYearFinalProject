package eapli.base.equipa.DTO;

import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.representations.dto.DTOParser;

public class EquipaDTOParser implements DTOParser<EquipaDTO, Equipa> {
    @Override
    public Equipa valueOf(EquipaDTO dto) {
        EquipaBuilder equipaBuilder = new EquipaBuilder();
        return equipaBuilder.designacao(dto.descricao).acronimo(dto.acronimo).equipaID(dto.equipaID).build();
    }
}
