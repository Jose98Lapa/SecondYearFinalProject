package eapli.base.formulario.domain;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioID {
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

    @Override
    public String toString() {
        return "FormularioID{" +
                "ID='" + ID + '\'' +
                ", regex='" + regex + '\'' +
                '}';
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
}
