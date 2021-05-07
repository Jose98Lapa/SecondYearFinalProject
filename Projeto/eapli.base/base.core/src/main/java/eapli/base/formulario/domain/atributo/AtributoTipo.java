package eapli.base.formulario.domain.atributo;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable

public class AtributoTipo implements ValueObject {
    private String tipo;
    @Transient
    private String regex = "String|int|boolean|char|float|double";
    
    public AtributoTipo(String tipo) {
        if (StringPredicates.isNullOrEmpty(tipo)) {
            throw new IllegalArgumentException("Type should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(tipo);

        if (m.matches()) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Type does not fit the criteria");
        }
    }

    protected AtributoTipo() {

    }

    public static AtributoTipo valueOf(String string) {
        return new AtributoTipo(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtributoTipo that = (AtributoTipo) o;
        return Objects.equals(tipo, that.tipo) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, regex);
    }

    @Override
    public String toString() {
        return "AtributoTipo{" +
                "tipo='" + tipo + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }
}
