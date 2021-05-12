package eapli.base.teamType.Domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class TeamTypeID implements ValueObject,Comparable<TeamTypeID> {
    private String tipoEquipaID;

    public TeamTypeID(String tipoEquipaID) {
        if (StringPredicates.isNullOrEmpty(tipoEquipaID)||!tipoEquipaID.matches("^[0-9A-Z]{1,5}")){
            throw new IllegalArgumentException("ID do tipo de equipa inválido");
        }
        this.tipoEquipaID = tipoEquipaID;
    }

    protected TeamTypeID(){

    }

    public static TeamTypeID valueOf(String tipoEquipaID){
        return new TeamTypeID(tipoEquipaID);
    }

    @Override
    public int compareTo(TeamTypeID o) {
        return this.tipoEquipaID.compareTo(o.tipoEquipaID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamTypeID that = (TeamTypeID) o;
        return Objects.equals(tipoEquipaID, that.tipoEquipaID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoEquipaID);
    }

    @Override
    public String toString(){
        return tipoEquipaID;
    }
}
