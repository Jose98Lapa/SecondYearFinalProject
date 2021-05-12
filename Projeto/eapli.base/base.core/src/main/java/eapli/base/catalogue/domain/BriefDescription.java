package eapli.base.catalogue.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class BriefDescription implements ValueObject{
    private String briefDescription;

    public BriefDescription(String briefDescription) {
        Preconditions.nonEmpty(briefDescription, "Description should neither be null nor empty");

        if(briefDescription.length()>50)
            throw new IllegalArgumentException("Descrição demasiado grande.");

        this.briefDescription = briefDescription;
    }

    public BriefDescription() {
        //vazio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BriefDescription that = (BriefDescription) o;
        return Objects.equals(briefDescription, that.briefDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefDescription);
    }

    @Override
    public String toString() {
        return this.briefDescription;
    }
}
