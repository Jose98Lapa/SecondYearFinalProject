package eapli.base.form.domain.attribute;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable

public class AttributeRegex implements ValueObject, Serializable {
    private String RegString;

    public AttributeRegex(String RegString) {
        if (StringPredicates.isNullOrEmpty(RegString)) {
            throw new IllegalArgumentException("RegString should neither be null nor empty");
        }
            this.RegString = RegString;

    }

    protected AttributeRegex() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeRegex that = (AttributeRegex) o;
        return Objects.equals(RegString, that.RegString);
    }
    public static AttributeRegex valueOf(String string) {
        return new AttributeRegex(string);
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
