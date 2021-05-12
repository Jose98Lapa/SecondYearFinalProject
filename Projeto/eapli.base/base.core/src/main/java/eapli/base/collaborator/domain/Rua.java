package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Rua implements ValueObject {
    private String estrada;

    public Rua(String estrada) {
        if (estrada==null ||estrada.isEmpty()||!estrada.matches("^[A-zÀ-ú\\.\\- ]+$"))
            throw new IllegalArgumentException("Estrada nao cumpre os critérios");
        this.estrada = estrada;
    }

    protected Rua(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rua rua1 = (Rua) o;
        return estrada.equals(rua1.estrada);
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
