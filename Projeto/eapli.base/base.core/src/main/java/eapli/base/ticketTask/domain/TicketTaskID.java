package eapli.base.ticketTask.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TicketTaskID implements ValueObject, Comparable< TicketTaskID >, Serializable {

	private String ticketTaskID;

	protected TicketTaskID ( ) {
	}

	public TicketTaskID ( String ticketTaskID ) {

		if ( StringPredicates.isNullOrEmpty( ticketTaskID ) ) {
			throw new IllegalArgumentException( "O ID não pode ser null ou vazio" );
		}
		if ( ticketTaskID.matches( "[tT]\\d{1,6}" ) ) {
			throw new IllegalArgumentException( "Este ID não é válido" );
		}

		this.ticketTaskID = ticketTaskID;
	}

	public static TicketTaskID valueOf( String ticketTaskID ){
		return new TicketTaskID( ticketTaskID );
	}


	@Override
	public int compareTo ( TicketTaskID ticketTaskID ) {
		return this.ticketTaskID.compareTo( ticketTaskID.ticketTaskID );
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		TicketTaskID that = ( TicketTaskID ) o;
		return Objects.equals( ticketTaskID, that.ticketTaskID );
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( ticketTaskID );
	}

	@Override
	public String toString ( ) {
		return ticketTaskID;
	}

}
