package eapli.base.team.DTO;

import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.collaborator.dto.CollaboratorDTO;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {
    public String descricao;
    public String acronimo;
    public String teamID;
    public List<CollaboratorDTO> responsaveis = new ArrayList<>();
    public TeamTypeDTO teamTypeDTO;
    public List<CollaboratorDTO> membrosDaEquipa= new ArrayList<>();
    public CollaboratorDTO collaboratorDTO;

    public TeamDTO(String descricao, String acronimo, String equipaID, List<CollaboratorDTO> responsaveis, TeamTypeDTO teamTypeDTO, List<CollaboratorDTO> membrosDaEquipa) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.teamID = equipaID;
        this.responsaveis.addAll(responsaveis);
        this.teamTypeDTO = teamTypeDTO;
        this.membrosDaEquipa.addAll(membrosDaEquipa);
    }

    public TeamDTO(String descricao, String acronimo, String equipaID, TeamTypeDTO teamTypeDTO, CollaboratorDTO collaboratorDTO) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.teamID = equipaID;
        this.teamTypeDTO = teamTypeDTO;
        this.collaboratorDTO = collaboratorDTO;
    }

    @Override
    public String toString() {
        return "Equipa" +
                " descricao='" + descricao  +
                " acronimo='" + acronimo +
                " equipaID='" + teamID;
    }
}
