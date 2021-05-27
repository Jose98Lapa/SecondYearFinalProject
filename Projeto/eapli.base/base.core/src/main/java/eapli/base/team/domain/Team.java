package eapli.base.team.domain;

import javax.persistence.*;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import java.io.Serializable;
import java.util.*;

@Entity
public class Team implements AggregateRoot<TeamID>, DTOable<TeamDTO>, Serializable {



    @EmbeddedId
    private TeamID teamID;
    private String designation;
    private Acronym acronym;
    @OneToOne
    private TeamType teamType;

    @OneToMany
    @JoinTable
            (name="TEAM_RESPONSABLES",
                    joinColumns = @JoinColumn(name="EQUIPA_ID")
            )
    private final Set<Collaborator> collaboratorResponsaveisSet = new HashSet<>();

    @OneToMany
    @JoinTable
            (name="TEAM_TEAM_MEMBERS",
                    joinColumns = @JoinColumn(name="EQUIPA_ID")
            )
    private final Set<Collaborator> teamMembers = new HashSet<>();

    public Team(String designation, Acronym acronym, TeamID teamID, Collaborator collaboratorResponsible, TeamType teamType) {
        this.designation = designation;
        this.acronym = acronym;
        this.teamID = teamID;
        this.collaboratorResponsaveisSet.add(collaboratorResponsible);
        this.teamType = teamType;
    }

    public Team(String designation, Acronym acronym, TeamID teamID, Set<Collaborator> colaboradores, TeamType teamType, List<Collaborator> responsaveis) {
        this.designation = designation;
        this.acronym = acronym;
        this.teamID = teamID;
        this.teamMembers.addAll(colaboradores);
        this.collaboratorResponsaveisSet.addAll(responsaveis);
        this.teamType = teamType;
    }

    protected Team(){

    }

    public void addColaboradorResponsible(Collaborator collaborator){
        collaboratorResponsaveisSet.add(collaborator);
    }

    public void addTeamMembers(Collaborator collaborator){
        teamMembers.add(collaborator);
    }

    public boolean containsResponsavel(Collaborator collaborator){
        for (Collaborator collaborator1 : collaboratorResponsaveisSet){
            if (collaborator1.identity().toString().equals(collaborator.identity().toString()))
                return true;
        }
        return false;
    }

    public boolean containsTeamMember(Collaborator collaborator){
        for (Collaborator collaborator1 : teamMembers){
            if (collaborator1.identity().toString().equals(collaborator.identity().toString()))
                return true;
        }
        return false;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public TeamID identity() {
        return this.teamID;
    }

    public Acronym acronimo() {
        return this.acronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(designation, team.designation) && Objects.equals(acronym, team.acronym) && Objects.equals(teamID, team.teamID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation, acronym, teamID);
    }

    @Override
    public TeamDTO toDTO() {
        List<CollaboratorDTO> responsaveis = new ArrayList<>();
        collaboratorResponsaveisSet.forEach(collab -> responsaveis.add(collab.toDTO()));
        List<CollaboratorDTO> membros = new ArrayList<>();
        teamMembers.forEach(collab -> membros.add(collab.toDTO()));
        return new TeamDTO(designation, acronym.toString(), teamID.toString(), responsaveis, teamType.toDTO(),membros);
    }

    public void removeColaborador(Collaborator collaborator){
        teamMembers.removeIf(col -> col.identity().equals(collaborator.identity()));
    }
}
