package eapli.base.team.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class TeamListService {
    private final TeamRepository teamRepo = PersistenceContext.repositories().teams();

    public Iterable<TeamDTO> allTeams(){
        Set<TeamDTO> equipas = new HashSet<>();
        teamRepo.findAll().forEach(equipa -> equipas.add(equipa.toDTO()));
        return equipas;
    }

    public Set<Team> getACollaboratorTeams(Collaborator collaborator){
        Set<Team> teamHashSet = new HashSet<>();
        for (Team team : teamRepo.findAll()){
            if (team.containsTeamMember(collaborator)){
                teamHashSet.add(team);
            }
        }
        return teamHashSet;
    }
}
