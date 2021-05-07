package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ServicoScript implements ValueObject {
    private String script;

    public ServicoScript(String script) {
        if (StringPredicates.isNullOrEmpty(script)) {
            throw new IllegalArgumentException("Script should neither be null nor empty");
        }
        this.script = script;
    }

    protected ServicoScript() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoScript that = (ServicoScript) o;
        return Objects.equals(script, that.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script);
    }

    public static ServicoScript valueOf(String string) {
        return new ServicoScript(string);
    }

    @Override
    public String toString() {
        return  script ;
    }
}
