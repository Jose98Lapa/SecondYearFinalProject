package eapli.base.form.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class FormName implements ValueObject, Serializable {
    private String nome;
    @Transient
    private String regex = "^[a-zA-Z ]{1,50}$";

    public FormName(String nome) {
        if (StringPredicates.isNullOrEmpty(nome)) {
            throw new IllegalArgumentException("Nome should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nome);

        if (m.matches()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome Title does not fit the criteria");
        }
    }

    protected FormName() {

    }

    @Override
    public String toString() {
        return nome;
    }

    public static FormName valueOf(String string) {
        return new FormName(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormName that = (FormName) o;
        return Objects.equals(nome, that.nome) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, regex);
    }
}
