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
    @Transient
    private String regex = "^[0-9]{1,10}$";

    public AttributeID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            throw new IllegalArgumentException("AtributoID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ID);

        if (m.matches()) {
            this.id = ID;
        } else {
            throw new IllegalArgumentException("AtributoID does not fit the criteria");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeID that = (AttributeID) o;
        return Objects.equals(id, that.id) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regex);
    }

    @Override
    public int compareTo(AttributeID o) {
        return this.id.compareTo(o.id);
    }

}
