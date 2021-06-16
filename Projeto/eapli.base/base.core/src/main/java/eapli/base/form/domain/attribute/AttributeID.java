package eapli.base.form.domain.attribute;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class AttributeID implements ValueObject, Comparable<AttributeID>, Serializable {

    private String id;

    public AttributeID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID))
            throw new IllegalArgumentException("AtributoID should neither be null nor empty");
        this.id = ID;
    }

    protected AttributeID() {

    }

    @Override
    public String toString() {
        return id;
    }

    public static AttributeID valueOf(String string) {
        return new AttributeID(string);
    }

    public String id () {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeID that = (AttributeID) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(AttributeID o) {
        return this.id.compareTo(o.id);
    }

}
