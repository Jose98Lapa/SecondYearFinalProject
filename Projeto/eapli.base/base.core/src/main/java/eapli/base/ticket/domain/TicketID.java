package eapli.base.ticket.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class TicketID implements ValueObject, Comparable< TicketID >, Serializable {

	private String ticketID;


	public TicketID ( final String ID ) {
		if ( StringPredicates.isNullOrEmpty( ID ) ) {
			throw new IllegalArgumentException( "Ticket ID should neither be null nor empty" );
		}
		this.ticketID = ID;

	}

	protected TicketID ( ) {

	}

	public static TicketID valueOf ( String string ) {
		return new TicketID( string );
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		TicketID ticketID1 = ( TicketID ) o;
		return Objects.equals( ticketID, ticketID1.ticketID );
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( ticketID);
	}

	@Override
	public String toString ( ) {
		return ticketID;
	}

	@Override
	public int compareTo ( TicketID o ) {
		return ticketID.compareTo( o.toString( ) );
	}

}
