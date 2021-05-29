package eapli.base.team.DTO;

import eapli.base.teamType.DTO.TeamTypeDTOParser;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.team.builder.TeamBuilder;
import eapli.base.team.domain.Team;
import eapli.framework.representations.dto.DTOParser;

import java.util.*;

public class TeamDTOParser implements DTOParser<TeamDTO, Team> {
    @Override
    public Team valueOf(TeamDTO dto) {
        TeamBuilder teamBuilder = new TeamBuilder();
        LinkedList<Collaborator> responsaveis = new LinkedList<>();
        dto.responsaveis.forEach(dtoColab -> responsaveis.add(new CollaboratorDTOParser().valueOf(dtoColab)));
        List<Collaborator> membrosDeEquipa = new ArrayList<>();
        dto.membrosDaEquipa.forEach(dtoColab -> membrosDeEquipa.add(new CollaboratorDTOParser().valueOf(dtoColab)));

        return teamBuilder.designacao(dto.descricao).acronimo(dto.acronimo).equipaID(dto.teamID).colaboradores(membrosDeEquipa).tipoDeEquipa(new TeamTypeDTOParser().valueOf(dto.teamTypeDTO)).responsaveis(responsaveis).build();
    }
}
