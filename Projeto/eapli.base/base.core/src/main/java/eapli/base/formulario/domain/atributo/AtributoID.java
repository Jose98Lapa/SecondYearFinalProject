package eapli.base.formulario.domain.atributo;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class AtributoID implements ValueObject, Comparable<AtributoID>, Serializable {

    private String id;
    @Transient
    private String regex = "^[a-zA-Z0-9-]{1,10}$";

    public AtributoID(final String ID) {
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

    protected AtributoID() {

    }

    @Override
    public String toString() {
        return id;
    }

    public static AtributoID valueOf(String string) {
        return new AtributoID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributoID that = (AtributoID) o;
        return Objects.equals(id, that.id) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regex);
    }

    @Override
    public int compareTo(AtributoID o) {
        return this.id.compareTo(o.id);
    }

}
