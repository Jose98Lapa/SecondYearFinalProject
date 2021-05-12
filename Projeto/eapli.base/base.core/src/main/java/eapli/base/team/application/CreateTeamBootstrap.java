package eapli.base.team.application;

import eapli.base.teamType.DTO.TeamTypeDTOParser;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.builder.TeamBuilder;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamBootstrap {
    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();
    private final TeamBuilder teamBuilder = new TeamBuilder();

    public void registo(TeamDTO teamDTO) {
        List<Collaborator> collaboratorList = new ArrayList<>();
        teamDTO.responsaveis.forEach(colaboradorDTO -> collaboratorList.add(new CollaboratorDTOParser().valueOf(colaboradorDTO)));
        List<Collaborator> membros = new ArrayList<>();
        teamDTO.membrosDaEquipa.forEach(colaboradorDTO -> membros.add(new CollaboratorDTOParser().valueOf(colaboradorDTO)));
        Team team = teamBuilder.designacao(teamDTO.descricao).acronimo(teamDTO.acronimo).equipaID(teamDTO.equipaID).responsaveis(collaboratorList).tipoDeEquipa(new TeamTypeDTOParser().valueOf(teamDTO.teamTypeDTO)).colaboradores(membros).build();
        teamRepository.save(team);
    }
}
