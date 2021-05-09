package eapli.base.equipa.application;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTOParser;
import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class RemoverColaboradorController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().teams();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final EquipaBuilder equipaBuilder = new EquipaBuilder();

    public Iterable<EquipaDTO> getEquipas() {
        ListEquipaService servicoListarEquipas = new ListEquipaService();
        return servicoListarEquipas.allTeams();
    }

    public Iterable<ColaboradorDTO> getColaboradores( Equipa equipa) {
        ListColaboradorService servicoListarColaboradores = new ListColaboradorService();
        return servicoListarColaboradores.getColadorDumEquipas( equipa );
    }

    public boolean save( EquipaDTO equipaDTO ) {
        Colaborador colaborador = new ColaboradorDTOParser().valueOf(equipaDTO.colaboradorDTO);
        TipoEquipa tipoEquipa = new TipoEquipaDTOParser().valueOf(equipaDTO.tipoEquipaDTO);

        if ( equipaRepository.canIAddTheColaborador(colaborador, tipoEquipa) ) {
            List<Colaborador> colaboradorList = new ArrayList<>();
            colaboradorList.add(colaborador);

            Equipa equipa = equipaBuilder
                    .designacao(equipaDTO.descricao)
                    .acronimo(equipaDTO.acronimo)
                    .equipaID(equipaDTO.equipaID)
                    .responsaveis(colaboradorList)
                    .tipoDeEquipa(tipoEquipa)
                    .build();

           return equipaRepository.save(equipa) != null;
        }

        return false;
    }
}
