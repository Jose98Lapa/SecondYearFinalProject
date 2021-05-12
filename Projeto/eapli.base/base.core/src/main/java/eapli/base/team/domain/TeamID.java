package eapli.base.team.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class TeamID implements ValueObject, Comparable<TeamID> {
    private String ID;
    public TeamID(String ID){
        if (ID==null||ID.isEmpty()||!ID.matches("^[0-9]{1,5}$")){
            throw new IllegalArgumentException("ID de Equipa Inválido");
        }
        this.ID = ID;
    }

    protected TeamID() {

    }

    public String ID(){
        return this.ID;
    }

    public static TeamID valueOf(final String ID) {
        return new TeamID(ID);
    }


    @Override
    public int compareTo(TeamID o) {
        return this.ID.compareTo(o.ID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamID teamID = (TeamID) o;
        return Objects.equals(ID, teamID.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return this.ID;
    }
}
