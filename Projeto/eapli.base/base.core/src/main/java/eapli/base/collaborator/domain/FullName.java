package eapli.base.collaborator.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class FullName implements ValueObject {

    private String name;

    public FullName(final String name) {
        if (name == null || name.isEmpty() || !name.matches("^([A-zÀ-ú]+ ){2,}[A-zÀ-ú]+$"))
            throw new IllegalArgumentException("Nome completo nao cumpre os critérios");
        this.name = name;
    }

    protected FullName() {}

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
