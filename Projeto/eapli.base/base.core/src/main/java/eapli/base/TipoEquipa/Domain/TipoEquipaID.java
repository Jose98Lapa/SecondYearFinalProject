package eapli.base.TipoEquipa.Domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class TipoEquipaID implements ValueObject,Comparable<TipoEquipaID> {
    private String tipoEquipaID;

    public TipoEquipaID(String tipoEquipaID) {
        if (StringPredicates.isNullOrEmpty(tipoEquipaID)||!tipoEquipaID.matches("^[0-9A-Z]{5}")){
            throw new IllegalArgumentException("ID do tipo de equipa inválido");
        }
        this.tipoEquipaID = tipoEquipaID;
    }

    protected TipoEquipaID(){

    }

    public static TipoEquipaID valueOf(String tipoEquipaID){
        return new TipoEquipaID(tipoEquipaID);
    }

    @Override
    public int compareTo(TipoEquipaID o) {
        return this.tipoEquipaID.compareTo(o.tipoEquipaID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoEquipaID that = (TipoEquipaID) o;
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
