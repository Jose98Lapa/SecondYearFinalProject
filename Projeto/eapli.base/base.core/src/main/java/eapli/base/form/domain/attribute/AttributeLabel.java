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
public class AttributeLabel implements ValueObject, Serializable {
    private String label;
    @Transient
    private String regex = "^[a-zA-Z0-9,!? \n\t]{1,50}$";

    public AttributeLabel(String label) {
        if (StringPredicates.isNullOrEmpty(label)) {
            throw new IllegalArgumentException("Label should neither be null nor empty");
        }

       /* Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(label);

        if (m.matches()) {*/
            this.label = label;
       // } else {
         //   throw new IllegalArgumentException("Label does not fit the criteria");
      //  }
    }

    protected AttributeLabel() {
    }

    public static AttributeLabel valueOf(String string) {
        return new AttributeLabel(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeLabel that = (AttributeLabel) o;
        return Objects.equals(label, that.label) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, regex);
    }

    @Override
    public String toString() {
        return label;
    }
}
