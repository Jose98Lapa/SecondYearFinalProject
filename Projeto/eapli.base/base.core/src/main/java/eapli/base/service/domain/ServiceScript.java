package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ServiceScript implements ValueObject {
    private String script;

    public ServiceScript(String script) {
        if (StringPredicates.isNullOrEmpty(script)) {
            throw new IllegalArgumentException("Script should neither be null nor empty");
        }
        this.script = script;
    }

    protected ServiceScript() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceScript that = (ServiceScript) o;
        return Objects.equals(script, that.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(script);
    }

    public static ServiceScript valueOf(String string) {
        return new ServiceScript(string);
    }

    @Override
    public String toString() {
        return  script ;
    }
}
