package eapli.base.equipa.application;

import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AssociarColaboradorController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().teams();

    public Iterable<EquipaDTO> getEquipas() {
        ListEquipaService servicoListarEquipas = new ListEquipaService();
        return servicoListarEquipas.allTeams();
    }

    public Iterable<ColaboradorDTO> getColaboradores() {
        ListColaboradorService servicoListarColaboradores = new ListColaboradorService();
        return servicoListarColaboradores.colaboradores();
    }

    public void adicionarColaborador( Colaborador colaborador, Equipa equipa ) {
        equipa.addTeamMembers( colaborador );
        equipaRepository.save( equipa );
    }
}
