package eapli.base.servico.domain;

import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class StatusServico {
    private String status;
    private String regex = "ACTIVE|INACTIVE|UNFINISHED";

    public StatusServico(String status) {
        if (StringPredicates.isNullOrEmpty(status)) {
            throw new IllegalArgumentException("Service ID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(status);

        if (m.matches()) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Service ID does not fit the criteria");
        }
    }

    protected StatusServico() {

    }

    @Override
    public String toString() {
        return status;
    }

    public static StatusServico valueOf(String string) {
        return new StatusServico(string);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusServico that = (StatusServico) o;
        return Objects.equals(status, that.status) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, regex);
    }
}
