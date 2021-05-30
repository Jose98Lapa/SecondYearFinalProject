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
public class TicketStatus implements ValueObject, Serializable {

	private String status;

	@Transient
	private String regex = "[a-zA-Z]+";

    protected TicketStatus ( ) {

    }

	public TicketStatus ( String status ) {
		if ( StringPredicates.isNullOrEmpty( status ) ) {
			throw new IllegalArgumentException( "Ticket Status should neither be null nor empty" );
		}

		Pattern p = Pattern.compile( regex );
		Matcher m = p.matcher( status );

		if ( m.matches( ) ) {
			this.status = status;
		} else {
			throw new IllegalArgumentException( "Ticket Status does not fit the criteria" );
		}
	}

	@Override
	public String toString ( ) {
		return status;
	}

	public static TicketStatus valueOf ( String string ) {
		return new TicketStatus( string );
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		TicketStatus that = ( TicketStatus ) o;
		return Objects.equals( status, that.status );
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( status, regex );
	}

}