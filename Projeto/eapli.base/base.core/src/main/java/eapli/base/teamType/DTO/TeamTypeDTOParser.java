package eapli.base.teamType.DTO;

import eapli.base.teamType.Builder.TeamTypeBuilder;
import eapli.base.teamType.Domain.TeamType;
import eapli.base.colour.DTO.ColourDTOParser;
import eapli.framework.representations.dto.DTOParser;

public class TeamTypeDTOParser implements DTOParser<TeamTypeDTO, TeamType> {
    @Override
    public TeamType valueOf(TeamTypeDTO dto) {
        TeamTypeBuilder teamTypeBuilder = new TeamTypeBuilder();
        return teamTypeBuilder.tipoEquipaID(dto.code).descricao(dto.descricao).cor(new ColourDTOParser().valueOf(dto.colourDTO)).build();
    }
}
