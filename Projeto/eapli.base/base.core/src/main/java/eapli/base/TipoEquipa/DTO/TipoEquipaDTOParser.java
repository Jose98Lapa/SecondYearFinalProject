package eapli.base.TipoEquipa.DTO;

import eapli.base.TipoEquipa.Builder.TipoEquipaBuilder;
import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.framework.representations.dto.DTOParser;

public class TipoEquipaDTOParser implements DTOParser<TipoEquipaDTO, TipoEquipa> {
    @Override
    public TipoEquipa valueOf(TipoEquipaDTO dto) {
        TipoEquipaBuilder tipoEquipaBuilder = new TipoEquipaBuilder();
        return tipoEquipaBuilder.tipoEquipaID(dto.code).descricao(dto.descricao).build();
    }
}