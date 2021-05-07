package eapli.base.funcao.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class Designation implements ValueObject {

    private String designation;

    public Designation(final String designation){
        if (designation==null ||designation.isEmpty()||!designation.matches("^\\w{1,30}$"))
            throw new IllegalArgumentException("The function ID does not fit the criteria");
        this.designation = designation;
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
