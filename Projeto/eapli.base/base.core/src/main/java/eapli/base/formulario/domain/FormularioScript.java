package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FormularioScript implements ValueObject {
    private String script;

    public FormularioScript(String script) {
        if (StringPredicates.isNullOrEmpty(script)) {
            throw new IllegalArgumentException("Script should neither be null nor empty");
        }
        this.script = script;
    }

    protected FormularioScript() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormularioScript that = (FormularioScript) o;
        return Objects.equals(script, that.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script);
    }

    public static FormularioScript valueOf(String string) {
        return new FormularioScript(string);
    }

    @Override
    public String toString() {
        return  script ;
    }
}
