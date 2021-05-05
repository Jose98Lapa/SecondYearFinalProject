package eapli.base.servico.Domain;

import eapli.base.atributo.domain.AtributoNome;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatusServico {
    private String status;
    private String regex = "ACTIVE|INACTIVE";

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

    @Override
    public String toString() {
        return "StatusServico{" +
                "status='" + status + '\'' +
                ", regex='" + regex + '\'' +
                '}';
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
