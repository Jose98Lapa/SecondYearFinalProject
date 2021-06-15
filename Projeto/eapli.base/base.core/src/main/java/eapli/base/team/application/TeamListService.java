package eapli.base.team.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamType.Domain.TeamType;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TeamListService {
    private final TeamRepository teamRepository = PersistenceContext.repositories().teams();

    public Iterable<TeamDTO> allTeams(){
        Set<TeamDTO> equipas = new HashSet<>();
        teamRepository.findAll().forEach(equipa -> equipas.add(equipa.toDTO()));
        return equipas;
    }

    public Team getTeam(String teamID){
        Optional<Team> teamOptional = teamRepository.ofIdentity(TeamID.valueOf(teamID));
        if (teamOptional.isEmpty())
            throw new IllegalArgumentException("ID de equipa inválido");
        return teamOptional.get();
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

    public Set<Collaborator> getCollaboratorByTeams(Set<Team> teamList){
        Set<Collaborator> toReturn = new HashSet<>();
        for (Team team:teamList){
            toReturn.addAll(team.teamMembers());
        }
        return toReturn;

    }

    public void canIAddTheCollaborator(Collaborator collaborator, TeamType teamType){
        if (!teamRepository.canIAddTheColaborador(collaborator, teamType)){
            throw new IllegalArgumentException("Este colaborador já gere uma equipa deste tipo");
        }

    }
}
