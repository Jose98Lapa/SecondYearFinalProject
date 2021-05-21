package eapli.base.ticket.domain;

import eapli.base.service.domain.ServiceID;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class TicketID implements ValueObject, Comparable<TicketID>{
    private String ticketID;
    @Transient
    private String regex = "^[0-9]{1,10}$";

    public TicketID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            throw new IllegalArgumentException("Ticket ID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ID);

        if (m.matches()) {
            this.ticketID = ID;
        } else {
            throw new IllegalArgumentException("Ticket ID does not fit the criteria");
        }

        //check if already exists
    }

    protected TicketID() {

    }

    public static TicketID valueOf(String string) {
        return new TicketID(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketID ticketID1 = (TicketID) o;
        return Objects.equals(ticketID, ticketID1.ticketID) && Objects.equals(regex, ticketID1.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, regex);
    }

    @Override
    public String toString() {
        return ticketID;
    }

    @Override
    public int compareTo(TicketID o) {
        return ticketID.compareTo(o.toString());
    }
}
