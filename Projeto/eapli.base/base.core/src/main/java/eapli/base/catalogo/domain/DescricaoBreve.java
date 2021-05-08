package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class DescricaoBreve implements ValueObject{
    private String briefDescription;
    @Transient
    private final String regex = "^[ a-zA-Z]{1,50}$";

    public DescricaoBreve(String briefDescription) {
        if (StringPredicates.isNullOrEmpty(briefDescription)) {
            throw new IllegalArgumentException("Catalog title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(briefDescription);

        if (m.matches()) {
            this.briefDescription = briefDescription;
        } else {
            throw new IllegalArgumentException("Catalog Title does not fit the criteria");
        }
    }

    public DescricaoBreve() {
        //vazio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescricaoBreve that = (DescricaoBreve) o;
        return Objects.equals(briefDescription, that.briefDescription) && Objects.equals(regex, that.briefDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefDescription, regex);
    }

    @Override
    public String toString() {
        return this.briefDescription;
    }
}
