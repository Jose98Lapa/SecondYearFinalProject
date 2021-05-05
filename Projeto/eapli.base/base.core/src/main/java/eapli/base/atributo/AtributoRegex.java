package eapli.base.atributo;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class AtributoRegex implements ValueObject {
    private String RegString;

    public AtributoRegex(String RegString) {
        if (StringPredicates.isNullOrEmpty(RegString)) {
            throw new IllegalArgumentException("RegString should neither be null nor empty");
        }
            this.RegString = RegString;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributoRegex that = (AtributoRegex) o;
        return Objects.equals(RegString, that.RegString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RegString);
    }

    @Override
    public String toString() {
        return "AtributoRegex{" +
                "RegString='" + RegString + '\'' +
                '}';
    }
}
