package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class ServicoID implements ValueObject, Comparable<ServicoID> {
    private String serviceID;
    @Transient
    private String regex = "^[a-zA-Z0-9-]{1,10}$";

    public ServicoID(final String ID) {
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

    protected ServicoID() {

    }

    public static ServicoID valueOf(String string) {
        return new ServicoID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoID servicoID = (ServicoID) o;
        return serviceID == servicoID.serviceID;
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
    public int compareTo(ServicoID o) {
        return serviceID.compareTo(o.serviceID);
    }
}
