package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class BriefDescription implements ValueObject {
    private String briefDesc;
    @Transient
    private String regex = "^[a-zA-Z ]{1,30}$";

    public BriefDescription(String desc) {
        if (StringPredicates.isNullOrEmpty(desc)) {
            throw new IllegalArgumentException("Brief Description should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(desc);

        if (m.matches()) {
            this.briefDesc = desc;
        } else {
            throw new IllegalArgumentException("Brief Description does not fit the criteria");
        }
    }

    protected BriefDescription() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BriefDescription that = (BriefDescription) o;
        return Objects.equals(briefDesc, that.briefDesc) && Objects.equals(regex, that.regex);
    }

    public static BriefDescription valueOf(String string) {
        return new BriefDescription(string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(briefDesc, regex);
    }

    @Override
    public String toString() {
        return briefDesc;
    }

}
