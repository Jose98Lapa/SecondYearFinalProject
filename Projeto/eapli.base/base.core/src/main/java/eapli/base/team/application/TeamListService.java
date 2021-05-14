package eapli.base.team.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamType.Domain.TeamType;

import java.util.HashSet;
import java.util.Set;

public class TeamListService {
    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();

    public Iterable<TeamDTO> allTeams(){
        Set<TeamDTO> equipas = new HashSet<>();
        teamRepository.findAll().forEach(equipa -> equipas.add(equipa.toDTO()));
        return equipas;
    }

    public Set<Team> getACollaboratorTeams(Collaborator collaborator){
        Set<Team> teamHashSet = new HashSet<>();
        for (Team team : teamRepository.findAll()){
            if (team.containsTeamMember(collaborator)){
                teamHashSet.add(team);
            }
        }
        return teamHashSet;
    }

    public boolean canIAddTheCollaborator(Collaborator collaborator, TeamType teamType){
        if (teamRepository.canIAddTheColaborador(collaborator, teamType)){
            return true;
        }else{
            throw new IllegalArgumentException("This collaborator already manages a team of this type");
        }

    }
}
