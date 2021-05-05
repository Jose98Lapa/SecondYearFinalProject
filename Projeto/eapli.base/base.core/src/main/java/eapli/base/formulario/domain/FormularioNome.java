package eapli.base.formulario.domain;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioNome {
    private String nome;
    private String regex = "^[a-zA-Z]{1,50}$";

    public FormularioNome(String nome) {
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

    @Override
    public String toString() {
        return "FormularioNome{" +
                "nome='" + nome + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormularioNome that = (FormularioNome) o;
        return Objects.equals(nome, that.nome) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, regex);
    }
}
