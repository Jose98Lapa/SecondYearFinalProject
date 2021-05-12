package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class DoorNumber implements ValueObject {

    private String numPorta;

    public DoorNumber(String numPorta) {
        if (numPorta==null ||numPorta.isEmpty()||!numPorta.matches("^\\d{0,4}$"))
            throw new IllegalArgumentException("Numero de porta nao cumpre os critérios");
        this.numPorta = numPorta;
    }

    protected DoorNumber(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoorNumber doorNumber1 = (DoorNumber) o;
        return numPorta.equals(doorNumber1.numPorta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPorta);
    }

    @Override
    public String toString() {
        return this.numPorta;
    }
}
