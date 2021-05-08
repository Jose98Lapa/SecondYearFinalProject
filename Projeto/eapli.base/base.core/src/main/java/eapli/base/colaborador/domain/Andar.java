package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Andar implements ValueObject {

    private String andar;

    public Andar(String andar) {
        if (andar==null ||andar.isEmpty()||!andar.matches("^\\d{0,3}$"))
            throw new IllegalArgumentException("Andar nao cumpre os critérios");
        this.andar = andar;
    }

    protected Andar(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Andar andar1 = (Andar) o;
        return andar.equals(andar1.andar);
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
