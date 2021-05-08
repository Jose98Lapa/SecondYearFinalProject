package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class DescricaoCompleta implements ValueObject {
    private String completeDescription;
    @Transient
    private final String regex = "^[ a-zA-Z]{1,100}$";

    public DescricaoCompleta(String completeDescription) {
        if (StringPredicates.isNullOrEmpty(completeDescription)) {
            throw new IllegalArgumentException("Catalog title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(completeDescription);

        if (m.matches()) {
            this.completeDescription = completeDescription;
        } else {
            throw new IllegalArgumentException("Catalog Title does not fit the criteria");
        }
    }

    public DescricaoCompleta() {
        //vazio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescricaoCompleta that = (DescricaoCompleta) o;
        return Objects.equals(completeDescription, that.completeDescription) && Objects.equals(regex, that.completeDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completeDescription, regex);
    }

    @Override
    public String toString() {
        return this.completeDescription;
    }
}
