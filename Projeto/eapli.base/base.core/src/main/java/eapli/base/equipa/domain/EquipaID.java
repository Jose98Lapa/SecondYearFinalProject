package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
public class EquipaID implements ValueObject, Comparable<EquipaID> {
    private String ID;
    public EquipaID(String ID){
        if (ID==null||ID.isEmpty()||!ID.matches("^[a-zA-Z0-9]{5}$")){
            throw new IllegalArgumentException("ID de Equipa Inválido");
        }
        this.ID = ID;
    }

    protected EquipaID() {

    }

    public String ID(){
        return this.ID;
    }

    public static EquipaID valueOf(final String ID) {
        return new EquipaID(ID);
    }


    @Override
    public int compareTo(EquipaID o) {
        return this.ID.compareTo(o.ID());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipaID equipaID = (EquipaID) o;
        return Objects.equals(ID, equipaID.ID);
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
