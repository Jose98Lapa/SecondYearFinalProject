package eapli.base.form.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FormScript implements ValueObject {
    private String script;

    public FormScript(String script) {
        if (StringPredicates.isNullOrEmpty(script)) {
            throw new IllegalArgumentException("Script should neither be null nor empty");
        }
        this.script = script;
    }

    protected FormScript() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormScript that = (FormScript) o;
        return Objects.equals(script, that.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script);
    }

    public static FormScript valueOf(String string) {
        return new FormScript(string);
    }

    @Override
    public String toString() {
        return  script ;
    }
}
