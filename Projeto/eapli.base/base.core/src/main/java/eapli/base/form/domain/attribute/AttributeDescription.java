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
public class AttributeDescription implements ValueObject , Serializable {
    private String descricao;
    @Transient
    private String regex = "^[a-zA-Z0-9,!? \n\t]{1,50}$";

    public AttributeDescription(String descricao) {
        if (StringPredicates.isNullOrEmpty(descricao)) {
            throw new IllegalArgumentException("Service title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(descricao);

        if (m.matches()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("Service Title does not fit the criteria");
        }
    }

    protected AttributeDescription() {
    }

    public static AttributeDescription valueOf(String string) {
        return new AttributeDescription(string);
    }

    public String descricao () {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeDescription that = (AttributeDescription) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, regex);
    }

    @Override
    public String toString() {
        return "AtributoDescricao{" +
                "descricao='" + descricao + '\'' +
                ", regex='" + regex + '\'' +
                '}';
    }
}
