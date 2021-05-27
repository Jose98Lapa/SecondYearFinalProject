package eapli.base.function.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class Designation implements ValueObject, Serializable {

    private String designation;

    public Designation(final String designation){
        if (designation==null ||designation.isEmpty()||!designation.matches("^[ a-zA-Z]{1,30}$"))
            throw new IllegalArgumentException("The designation does not fit the criteria");
        this.designation = designation;
    }

    protected Designation() {

    }

    public static Designation valueOf(String string) {
        return new Designation(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designation that = (Designation) o;
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
