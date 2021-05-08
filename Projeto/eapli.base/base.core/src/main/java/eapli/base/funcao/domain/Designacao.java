package eapli.base.funcao.domain;

import eapli.base.formulario.domain.atributo.AtributoLabel;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Designacao implements ValueObject {

    private String designation;

    public Designacao(final String designation){
        if (designation==null ||designation.isEmpty()||!designation.matches("^[ a-zA-Z]{1,30}$"))
            throw new IllegalArgumentException("The designation does not fit the criteria");
        this.designation = designation;
    }

    protected Designacao() {

    }

    public static Designacao valueOf(String string) {
        return new Designacao(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designacao that = (Designacao) o;
        return designation.equals(that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }

    @Override
    public String toString() {
        return this.designation;
    }
}
