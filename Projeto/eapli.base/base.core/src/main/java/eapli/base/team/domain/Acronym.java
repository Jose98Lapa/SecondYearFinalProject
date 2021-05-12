package eapli.base.team.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Acronym implements ValueObject  {
    private String acronimo;

    public Acronym(String acronimo) {
        if (acronimo==null ||acronimo.isEmpty()||!acronimo.matches("^[A-Z0-9]{1,6}$"))
            throw new IllegalArgumentException("Acronimo Invalido");
        this.acronimo = acronimo;
    }

    protected Acronym(){

    }

    public static Acronym valueOf(final String acronimo) {
        return new Acronym(acronimo);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronym acronym1 = (Acronym) o;
        return Objects.equals(acronimo, acronym1.acronimo);
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
