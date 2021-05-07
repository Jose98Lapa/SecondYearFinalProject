package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CompleteDescription implements ValueObject {
    private String desc;
    @Transient
    private String regex = "^[a-zA-Z]{20,60}$";

    public CompleteDescription(String desc) {
        if (StringPredicates.isNullOrEmpty(desc)) {
            throw new IllegalArgumentException("Complete Description should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(desc);

        if (m.matches()) {
            this.desc = desc;
        } else {
            throw new IllegalArgumentException("Complete Description does not fit the criteria");
        }
    }

    protected CompleteDescription() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteDescription that = (CompleteDescription) o;
        return Objects.equals(desc, that.desc) && Objects.equals(regex, that.regex);
    }

    public static CompleteDescription valueOf(String string) {
        return new CompleteDescription(string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc, regex);
    }

    @Override
    public String toString() {
        return desc;
    }

}
