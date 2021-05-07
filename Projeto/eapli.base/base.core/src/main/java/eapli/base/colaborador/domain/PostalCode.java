package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class PostalCode implements ValueObject {

    String codPostal;

    public PostalCode(final String codPostal){
        if (codPostal==null ||codPostal.isEmpty()||!codPostal.matches("^[0-9]{4}-[0-9]{3}$"))
            throw new IllegalArgumentException("Postal Code does not fit the criteria");
        this.codPostal = codPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode codPostal1 = (PostalCode) o;
        return codPostal.equals(codPostal1.codPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPostal);
    }

    @Override
    public String toString() {
        return this.codPostal;
    }
}
