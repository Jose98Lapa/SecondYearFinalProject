package eapli.base.formulario.domain;

import eapli.base.atributo.domain.AtributoNome;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class FormularioID implements Comparable<FormularioID>, Serializable {
    private String ID;
    private String regex = "^[a-zA-Z0-9-]{1,10}$";

    public FormularioID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            throw new IllegalArgumentException("Formulario ID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ID);

        if (m.matches()) {
            this.ID = ID;
        } else {
            throw new IllegalArgumentException("Formulario ID does not fit the criteria");
        }
    }

    protected FormularioID() {

    }

    @Override
    public String toString() {
        return ID;
    }

    public static FormularioID valueOf(String string) {
        return new FormularioID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormularioID that = (FormularioID) o;
        return Objects.equals(ID, that.ID) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, regex);
    }

    @Override
    public int compareTo(FormularioID o) {
        return ID.compareTo(o.ID);
    }
}
