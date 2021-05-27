package eapli.base.service.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class ServiceStatus implements ValueObject , Serializable {
    private String status;
    @Transient
    private String regex = "ATIVO|INATIVO|INCOMPLETO";

    public ServiceStatus(String status) {
        if (StringPredicates.isNullOrEmpty(status)) {
            throw new IllegalArgumentException("Service status should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(status);

        if (m.matches()) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Service status does not fit the criteria");
        }
    }

    protected ServiceStatus() {

    }

    @Override
    public String toString() {
        return status;
    }

    public static ServiceStatus valueOf(String string) {
        return new ServiceStatus(string);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceStatus that = (ServiceStatus) o;
        return Objects.equals(status, that.status) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, regex);
    }
}
