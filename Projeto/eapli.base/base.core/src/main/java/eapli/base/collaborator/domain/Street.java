package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Street implements ValueObject, Serializable {
    private String estrada;

    public Street(String estrada) {
        if (estrada==null ||estrada.isEmpty()||!estrada.matches("^[A-zÀ-ú\\.\\- ]+$"))
            throw new IllegalArgumentException("Estrada nao cumpre os critérios");
        this.estrada = estrada;
    }

    protected Street(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street1 = (Street) o;
        return estrada.equals(street1.estrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estrada);
    }

    @Override
    public String toString() {
        return this.estrada;
    }
}
