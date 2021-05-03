package eapli.base.Servico.Domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicoID implements ValueObject {
    private String serviceID;
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
        return "ServicoID{" +
                "seviceID=" + serviceID +
                '}';
    }
}
