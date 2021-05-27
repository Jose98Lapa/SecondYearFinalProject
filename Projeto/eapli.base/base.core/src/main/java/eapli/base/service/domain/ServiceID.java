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
public class ServiceID implements ValueObject, Comparable<ServiceID>, Serializable {
    private String serviceID;
    @Transient
    private String regex = "^[0-9]{1,10}$";

    public ServiceID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            throw new IllegalArgumentException("Service ID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ID);

        if (m.matches()) {
            this.serviceID = ID;
        } else {
            throw new IllegalArgumentException("Service ID does not fit the criteria");
        }

        //check if already exists
    }

    protected ServiceID() {

    }

    public static ServiceID valueOf(String string) {
        return new ServiceID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceID serviceID = (ServiceID) o;
        return this.serviceID.equals(serviceID.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID);
    }

    @Override
    public String toString() {
        return serviceID;
    }

    @Override
    public int compareTo(ServiceID o) {
        return serviceID.compareTo(o.serviceID);
    }
}
