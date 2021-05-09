package eapli.base.equipa.application;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTOParser;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class CriarEquipaControllerBootstrap {
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().teams();
    private final EquipaBuilder equipaBuilder = new EquipaBuilder();

    public void registo(EquipaDTO equipaDTO) {
        List<Colaborador> colaboradorList = new ArrayList<>();
        equipaDTO.responsaveis.forEach(colaboradorDTO -> colaboradorList.add(new ColaboradorDTOParser().valueOf(colaboradorDTO)));
        List<Colaborador> membros = new ArrayList<>();
        equipaDTO.membrosDaEquipa.forEach(colaboradorDTO -> membros.add(new ColaboradorDTOParser().valueOf(colaboradorDTO)));
        Equipa equipa = equipaBuilder.designacao(equipaDTO.descricao).acronimo(equipaDTO.acronimo).equipaID(equipaDTO.equipaID).responsaveis(colaboradorList).tipoDeEquipa(new TipoEquipaDTOParser().valueOf(equipaDTO.tipoEquipaDTO)).colaboradores(membros).build();
        equipaRepository.save(equipa);
    }
}
