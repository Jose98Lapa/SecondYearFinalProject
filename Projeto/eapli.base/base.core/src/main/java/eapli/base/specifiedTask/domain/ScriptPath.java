package eapli.base.specifiedTask.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ScriptPath implements ValueObject {
    private String scriptPath;

    public ScriptPath(String scriptPath) {
        if (StringPredicates.isNullOrEmpty(scriptPath)) {
            throw new IllegalArgumentException("A path do Script não pode ser nula ou vazia");
        }
        this.scriptPath = scriptPath;
    }


    protected ScriptPath() {
        // For ORM
    }

    public static ScriptPath valueOf(String scriptPath) {
        return new ScriptPath(scriptPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptPath that = (ScriptPath) o;
        return Objects.equals(scriptPath, that.scriptPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptPath);
    }

    @Override
    public String toString() {
        return scriptPath;
    }
}
