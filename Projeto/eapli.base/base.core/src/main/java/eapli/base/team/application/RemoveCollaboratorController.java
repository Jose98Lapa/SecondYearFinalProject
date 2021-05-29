package eapli.base.team.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.builder.TeamBuilder;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class RemoveCollaboratorController {

    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final TeamBuilder teamBuilder = new TeamBuilder();

    public Iterable<TeamDTO> getEquipas() {
        TeamListService servicoListarEquipas = new TeamListService();
        return servicoListarEquipas.allTeams();
    }

    public Iterable<CollaboratorDTO> getColaboradores(Team team) {
        ListCollaboratorService servicoListarColaboradores = new ListCollaboratorService();
        return servicoListarColaboradores.getColadorDumEquipas(team);
    }

    public boolean save(CollaboratorDTO collaboratorDTO, TeamDTO teamDTO) {
//        Colaborador colaborador = new ColaboradorDTOParser().valueOf(equipaDTO.colaboradorDTO);
//        TipoEquipa tipoEquipa = new TipoEquipaDTOParser().valueOf(equipaDTO.tipoEquipaDTO);
//
//        if ( equipaRepository.canIAddTheColaborador(colaborador, tipoEquipa) ) {
//            List<Colaborador> colaboradorList = new ArrayList<>();
//            colaboradorList.add(colaborador);
//
//            Equipa equipa = equipaBuilder
//                    .designacao(equipaDTO.descricao)
//                    .acronimo(equipaDTO.acronimo)
//                    .equipaID(equipaDTO.equipaID)
//                    .responsaveis(colaboradorList)
//                    .tipoDeEquipa(tipoEquipa)
//                    .build();
//
//           return equipaRepository.save(equipa) != null;
//        }
//
//        return false;
        Optional<Team> optionalEquipa = teamRepository.ofIdentity(TeamID.valueOf(teamDTO.teamID));
        if (optionalEquipa.isPresent()){
            Team team = optionalEquipa.get();
            team.removeColaborador(collaboratorRepository.ofIdentity(MecanographicNumber.valueOf(collaboratorDTO.mNumber)).get());
            teamRepository.save(team);
            return true;
        }


        return false;
    }
}
