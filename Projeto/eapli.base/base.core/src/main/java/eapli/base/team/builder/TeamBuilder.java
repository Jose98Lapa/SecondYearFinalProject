package eapli.base.team.builder;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.domain.Acronym;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;

import java.util.*;

public class TeamBuilder {
    private String designacao;
    private TeamID teamID;

    private Acronym acronym;



    private TeamType teamType;

    private Set<Collaborator> colaboradores = new HashSet<>();
    private List<Collaborator> responsaveis = new ArrayList<>();


    public TeamBuilder() {
            //vazio
    }

    public TeamBuilder designacao(String designacao){
        this.designacao = designacao;
        return this;
    }

    public TeamBuilder equipaID(String ID){
        this.teamID = TeamID.valueOf(ID);
        return this;
    }
    public TeamBuilder acronimo(String acronimo){
        this.acronym = Acronym.valueOf(acronimo);
        return this;
    }


    public TeamBuilder colaboradores(List<Collaborator> collaborator){
        this.colaboradores.addAll(collaborator);
        return this;
    }

    public TeamBuilder responsaveis(List<Collaborator> responsaveis){
        this.responsaveis.addAll(responsaveis);
        return this;
    }

    public TeamBuilder tipoDeEquipa(TeamType teamType){
        this.teamType = teamType;
        return this;
    }


    public Team build(){
        Team e = new Team(designacao, acronym, teamID,responsaveis.remove(0), teamType);
        for (Collaborator collaborator :colaboradores){
            e.addTeamMembers(collaborator);
        }
        for (Collaborator collaborator :responsaveis){
            e.addColaboradorResponsible(collaborator);
        }
        return e;
    }

}
