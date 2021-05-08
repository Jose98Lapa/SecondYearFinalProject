package eapli.base.equipa.DTO;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTOParser;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.representations.dto.DTOParser;

import java.util.LinkedList;

public class EquipaDTOParser implements DTOParser<EquipaDTO, Equipa> {
    @Override
    public Equipa valueOf(EquipaDTO dto) {
        EquipaBuilder equipaBuilder = new EquipaBuilder();
        LinkedList<Colaborador> responsaveis = new LinkedList<>();
        dto.responsaveis.forEach(dtoColab -> responsaveis.add(new ColaboradorDTOParser().valueOf(dtoColab)));
        Colaborador colaborador = responsaveis.removeFirst();
        return equipaBuilder.designacao(dto.descricao).acronimo(dto.acronimo).equipaID(dto.equipaID).tipoDeEquipa(new TipoEquipaDTOParser().valueOf(dto.tipoEquipaDTO)).colaborador(colaborador).build();
    }
}
