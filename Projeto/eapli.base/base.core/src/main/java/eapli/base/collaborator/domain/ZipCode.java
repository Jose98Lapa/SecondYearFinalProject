package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZipCode implements ValueObject, Serializable {

    private String codPostal;

    public ZipCode(final String codPostal){
        if (codPostal==null ||codPostal.isEmpty()||!codPostal.matches("^[0-9]{4}-[0-9]{3}$"))
            throw new IllegalArgumentException("Codigo Postal nao cumpre os critérios");
        this.codPostal = codPostal;
    }

    protected ZipCode() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return codPostal.equals(zipCode1.codPostal);
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
