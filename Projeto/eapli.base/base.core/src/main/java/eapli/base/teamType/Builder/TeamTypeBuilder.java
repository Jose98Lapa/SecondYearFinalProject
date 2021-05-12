package eapli.base.teamType.Builder;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.Domain.TeamTypeID;
import eapli.base.colour.Domain.Colour;
import eapli.framework.domain.model.DomainFactory;

public class TeamTypeBuilder implements DomainFactory<TeamType> {
    private TeamTypeID teamTypeID;
    private String descricao;
    private Colour colour;

    public TeamTypeBuilder tipoEquipaID(String tipoEquipaID){
        this.teamTypeID = TeamTypeID.valueOf(tipoEquipaID);
        return this;
    }

    public TeamTypeBuilder descricao (String descricao){
        this.descricao = descricao;
        return this;
    }

    public TeamTypeBuilder cor (Colour colour){
        this.colour = colour;
        return this;
    }

    @Override
    public TeamType build(){
        return new TeamType(teamTypeID,descricao, colour);
    }

}
