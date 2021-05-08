package eapli.base.cor.Domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Hexadecimal implements ValueObject,Comparable<Hexadecimal> {
    private String valorHexadecimal;

    public Hexadecimal(String valorHexadecimal) {
        if (StringPredicates.isNullOrEmpty(valorHexadecimal)||!valorHexadecimal.matches("^[0-9A-F]{6}$"))
            throw new IllegalArgumentException("Valor Inválido para valor Hexadecimal");
        this.valorHexadecimal = valorHexadecimal;
    }

    protected Hexadecimal() {

    }

    public static Hexadecimal valueOf(final String valorHexadecimal){
        return new Hexadecimal(valorHexadecimal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hexadecimal that = (Hexadecimal) o;
        return Objects.equals(valorHexadecimal, that.valorHexadecimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorHexadecimal);
    }

    @Override
    public String toString() {
        return valorHexadecimal;
    }

    @Override
    public int compareTo(Hexadecimal o) {
        return this.valorHexadecimal.compareTo(o.valorHexadecimal);
    }
}
