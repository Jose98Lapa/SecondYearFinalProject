package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Estrada implements ValueObject {
    private String estrada;

    public Estrada(String estrada) {
        if (estrada==null ||estrada.isEmpty()||!estrada.matches("^[A-zÀ-ú\\.\\- ]+$"))
            throw new IllegalArgumentException("Estrada nao cumpre os critérios");
        this.estrada = estrada;
    }

    protected Estrada(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estrada estrada1 = (Estrada) o;
        return estrada.equals(estrada1.estrada);
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
