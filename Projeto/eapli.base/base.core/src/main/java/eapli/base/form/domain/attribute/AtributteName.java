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
public class AtributteName implements ValueObject, Comparable<AtributteName> , Serializable {
    private String nome;
    @Transient
    private String regex = "^[a-zA-Z]{1,50}$";

    public AtributteName(String nome) {
        if (StringPredicates.isNullOrEmpty(nome)) {
            throw new IllegalArgumentException("Service title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nome);

        if (m.matches()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Service Title does not fit the criteria");
        }
    }

    protected AtributteName() {

    }

    public static AtributteName valueOf(String string) {
        return new AtributteName(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributteName that = (AtributteName) o;
        return Objects.equals(nome, that.nome) && Objects.equals(regex, that.regex);
    }

    public String nome ( ) {

        return nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, regex);
    }

    @Override
    public String toString() {
        return "AtributoNome{" +
                "nome='" + nome + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }

    @Override
    public int compareTo(AtributteName o) {
        return 0;
    }
}
