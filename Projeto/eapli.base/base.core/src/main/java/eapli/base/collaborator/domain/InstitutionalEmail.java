package eapli.base.collaborator.domain;


import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class InstitutionalEmail implements ValueObject {

    private String email;

    public InstitutionalEmail(final String email){
        if (email==null ||email.isEmpty()||!email.matches(""))
            throw new IllegalArgumentException("Contact does not fit the criteria");
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionalEmail that = (InstitutionalEmail) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return this.email;
    }
}
