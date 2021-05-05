package eapli.base.atributo;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtributoNome implements ValueObject {
    private String nome;
    private String regex = "^[a-zA-Z]{1,50}$";

    public AtributoNome(String nome) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributoNome that = (AtributoNome) o;
        return Objects.equals(nome, that.nome) && Objects.equals(regex, that.regex);
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
}
