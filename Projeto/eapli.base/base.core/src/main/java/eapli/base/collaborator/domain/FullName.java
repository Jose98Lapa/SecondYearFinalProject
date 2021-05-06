package eapli.base.collaborator.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullName implements ValueObject {

    private String name;

    public FullName(final String name) {
        if (name == null || name.isEmpty() || !name.matches("^([A-Z]{1}[A-zÀ-ú\\- ]{1,15}){3,5}$"))
            throw new IllegalArgumentException("Full Name does not fit the criteria");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName1 = (FullName) o;
        return name.equals(fullName1.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
