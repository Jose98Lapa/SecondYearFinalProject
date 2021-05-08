package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class CodPostal implements ValueObject {

    private String codPostal;

    public CodPostal(final String codPostal){
        if (codPostal==null ||codPostal.isEmpty()||!codPostal.matches("^[0-9]{4}-[0-9]{3}$"))
            throw new IllegalArgumentException("Codigo Postal nao cumpre os critérios");
        this.codPostal = codPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodPostal codPostal1 = (CodPostal) o;
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
