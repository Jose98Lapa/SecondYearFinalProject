package eapli.base.atributo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtributoLabel implements ValueObject {
    private String label;
    private String regex = "^[a-zA-Z]{1,50}$";

    public AtributoLabel(String label) {
        if (StringPredicates.isNullOrEmpty(label)) {
            throw new IllegalArgumentException("Label should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(label);

        if (m.matches()) {
            this.label = label;
        } else {
            throw new IllegalArgumentException("Label Title does not fit the criteria");
        }
    }

    public static AtributoLabel valueOf(String string) {
        return new AtributoLabel(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributoLabel that = (AtributoLabel) o;
        return Objects.equals(label, that.label) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, regex);
    }

    @Override
    public String toString() {
        return "AtributoLabel{" +
                "label='" + label + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }
}
