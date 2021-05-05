package eapli.base.formulario.domain;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioScript {
    private String script;

    public FormularioScript(String script) {
        if (StringPredicates.isNullOrEmpty(script)) {
            throw new IllegalArgumentException("Nome should neither be null nor empty");
        }
        this.script = script;
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

    @Override
    public String toString() {
        return "FormularioScript{" +
                "script='" + script + '\'' +
                '}';
    }
}
