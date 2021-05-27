package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaceOfResidence implements ValueObject, Serializable {
    private String placeOfResidence;

    public PlaceOfResidence(final String placeOfResidence){
        if (placeOfResidence==null ||placeOfResidence.isEmpty()||!placeOfResidence.matches("^[A-zÀ-ú ,\\-0-9]+$"))
            throw new IllegalArgumentException("Local de residência nao cumpre os critérios");
        this.placeOfResidence = placeOfResidence;
    }

    protected PlaceOfResidence(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceOfResidence that = (PlaceOfResidence) o;
        return placeOfResidence.equals(that.placeOfResidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeOfResidence);
    }

    @Override
    public String toString() {
        return this.placeOfResidence;
    }
}
