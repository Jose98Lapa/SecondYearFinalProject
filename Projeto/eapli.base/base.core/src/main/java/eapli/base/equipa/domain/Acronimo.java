package eapli.base.equipa.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Acronimo implements ValueObject  {
    private String acronimo;

    public Acronimo(String acronimo) {
        if (acronimo==null ||acronimo.isEmpty()||!acronimo.matches("^[A-Z0-9]{1,6}$"))
            throw new IllegalArgumentException("Acronimo Invalido");
        this.acronimo = acronimo;
    }

    protected Acronimo(){

    }

    public static Acronimo valueOf(final String acronimo) {
        return new Acronimo(acronimo);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronimo acronimo1 = (Acronimo) o;
        return Objects.equals(acronimo, acronimo1.acronimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronimo);
    }

    @Override
    public String toString() {
        return acronimo;
    }
}
