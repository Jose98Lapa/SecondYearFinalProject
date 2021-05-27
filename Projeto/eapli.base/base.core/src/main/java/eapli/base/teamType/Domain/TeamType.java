package eapli.base.teamType.Domain;

import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.colour.Domain.Colour;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TeamType implements AggregateRoot<TeamTypeID>, DTOable<TeamTypeDTO>, Serializable {
    @EmbeddedId
    private TeamTypeID teamTypeID;
    private String descricao;
    @OneToOne
    private Colour colour;

    public TeamType(TeamTypeID teamTypeID, String descricao, Colour colour) {
        this.teamTypeID = teamTypeID;
        this.descricao = descricao;
        this.colour = colour;
    }

    protected TeamType(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamType that = (TeamType) o;
        return Objects.equals(teamTypeID, that.teamTypeID) && Objects.equals(descricao, that.descricao) && Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamTypeID, descricao, colour);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public TeamTypeID identity() {
        return teamTypeID;
    }

    @Override
    public TeamTypeDTO toDTO() {
        return new TeamTypeDTO(teamTypeID.toString(),descricao, colour.toDTO());
    }


    @Override
    public String toString() {
        return "TipoEquipa{" +
                "tipoEquipaID=" + teamTypeID +
                ", descricao='" + descricao + '\'' +
                ", cor=" + colour +
                '}';
    }
}
