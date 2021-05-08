package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class NumPorta implements ValueObject {

    private String numPorta;

    public NumPorta(String numPorta) {
        if (numPorta==null ||numPorta.isEmpty()||!numPorta.matches("^\\d{0,4}$"))
            throw new IllegalArgumentException("Numero de porta nao cumpre os critérios");
        this.numPorta = numPorta;
    }

    protected NumPorta(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumPorta numPorta1 = (NumPorta) o;
        return numPorta.equals(numPorta1.numPorta);
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
