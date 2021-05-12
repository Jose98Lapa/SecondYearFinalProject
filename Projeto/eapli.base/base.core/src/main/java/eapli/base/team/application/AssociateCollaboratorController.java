package eapli.base.team.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.builder.TeamBuilder;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class AssociateCollaboratorController {

    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();
    private final TeamBuilder teamBuilder = new TeamBuilder();

    public Iterable<TeamDTO> getEquipas() {
        TeamListService servicoListarEquipas = new TeamListService();
        return servicoListarEquipas.allTeams();
    }

    public Iterable<CollaboratorDTO> getColaboradores() {
        ListCollaboratorService servicoListarColaboradores = new ListCollaboratorService();
        return servicoListarColaboradores.colaboradores();
    }

    public boolean save(TeamDTO teamDTO, CollaboratorDTO collaboratorDTO) {
        /*Colaborador colaborador = new ColaboradorDTOParser().valueOf(equipaDTO.colaboradorDTO);
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
        }*/

        Optional<Collaborator> optionalColaborador = PersistenceContext.repositories().collaborators().ofIdentity(MecanographicNumber.valueOf(collaboratorDTO.mNumber));
        Optional<Team> equipa = teamRepository.ofIdentity(TeamID.valueOf(teamDTO.equipaID));
        if (optionalColaborador.isPresent()&&equipa.isPresent()){
            Collaborator collaborator = optionalColaborador.get();
            Team team1 = equipa.get();
            team1.addTeamMembers(collaborator);
            teamRepository.save(team1);
            return true;
        }


        return false;
    }
}