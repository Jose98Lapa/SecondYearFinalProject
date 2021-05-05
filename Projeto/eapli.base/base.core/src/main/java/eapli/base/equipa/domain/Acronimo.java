package eapli.base.equipa.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Acronimo implements ValueObject, Comparable<Acronimo> {
    private String acronimo;

    public Acronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    protected Acronimo(){

    }

    public static Acronimo valueOf(final String acronimo) {
        return new Acronimo(acronimo);
    }

    @Override
    public int compareTo(Acronimo o) {
        return 0;
    }
}
