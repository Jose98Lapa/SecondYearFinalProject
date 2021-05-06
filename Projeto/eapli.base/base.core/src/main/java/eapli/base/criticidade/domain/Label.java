package eapli.base.criticidade.domain;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Label implements Comparable<Label> {
    private String label;
    private String regex = "^[ a-zA-Z]{1,50}$";

    public Label(String label) {
        if (StringPredicates.isNullOrEmpty(label)) {
            throw new IllegalArgumentException("Label não pode ser vazia.");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(label);

        if (m.matches()) {
            this.label = label;
        } else {
            throw new IllegalArgumentException("Limite de carateres atingido.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label that = (Label) o;
        return Objects.equals(label, that.label) && Objects.equals(regex, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, regex);
    }

    @Override
    public String toString() {
        return this.label;
    }

    @Override
    public int compareTo(Label o) {
        return 0;
    }
}
