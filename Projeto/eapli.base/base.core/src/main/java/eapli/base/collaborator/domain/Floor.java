package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Floor implements ValueObject, Serializable {

    private String andar;

    public Floor(String andar) {
        if (andar==null ||andar.isEmpty()||!andar.matches("^\\d{0,3}$"))
            throw new IllegalArgumentException("Andar nao cumpre os critérios");
        this.andar = andar;
    }

    protected Floor(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor1 = (Floor) o;
        return andar.equals(floor1.andar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(andar);
    }

    @Override
    public String toString() {
        return this.andar;
    }
}
