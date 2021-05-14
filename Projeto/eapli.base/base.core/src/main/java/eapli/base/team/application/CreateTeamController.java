package eapli.base.team.application;

import eapli.base.teamType.Application.TeamTypeListService;
import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.teamType.DTO.TeamTypeDTOParser;
import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.Domain.TeamTypeID;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.*;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.builder.TeamBuilder;
import eapli.base.team.domain.Acronym;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamController {

    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final TeamTypeRepository teamTypeRepository = PersistenceContext.repositories().tiposDeEquipa();
    private final TeamBuilder teamBuilder = new TeamBuilder();

    public void registerTeam(TeamDTO teamDTO) {
        Collaborator collaborator = collaboratorRepository.ofIdentity(MecanographicNumber.valueOf(teamDTO.collaboratorDTO.mNumber)).get();
        TeamType teamType = teamTypeRepository.ofIdentity(TeamTypeID.valueOf(teamDTO.teamTypeDTO.code)).get();
        TeamListService teamListService = new TeamListService();
        teamListService.canIAddTheCollaborator(collaborator,teamType);
        if (teamRepository.isAcronimoValid(Acronym.valueOf(teamDTO.acronimo))) {
            List<Collaborator> collaboratorList = new ArrayList<>();
            collaboratorList.add(collaborator);
            Team team = teamBuilder.designacao(teamDTO.descricao).acronimo(teamDTO.acronimo).equipaID(teamDTO.equipaID).responsaveis(collaboratorList).tipoDeEquipa(teamType).build();
            teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Acronym must be unique");
        }
    }

    public Iterable<TeamTypeDTO> getTeamTypeDTO() {
        TeamTypeListService teamTypeListService = new TeamTypeListService();
        return teamTypeListService.tipoEquipaDTOS();
    }

    public Iterable<CollaboratorDTO> getCollaboratorDTO() {
        ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
        return listCollaboratorService.colaboradores();
    }
}
