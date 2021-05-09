package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;

@Embeddable
public class DescricaoCompleta implements ValueObject {
    private String completeDescription;


    public DescricaoCompleta(String completeDescription) {
        Preconditions.nonEmpty(completeDescription, "Description should neither be null nor empty");
        this.completeDescription = completeDescription;
    }

    public DescricaoCompleta() {
        //vazio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescricaoCompleta that = (DescricaoCompleta) o;
        return Objects.equals(completeDescription, that.completeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completeDescription);
    }

    @Override
    public String toString() {
        return this.completeDescription;
    }
}
