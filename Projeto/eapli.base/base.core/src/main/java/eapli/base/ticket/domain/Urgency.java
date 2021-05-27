package eapli.base.ticket.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Urgency implements ValueObject, Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	private String urgency;

	public Urgency ( String urgency ) {
		if ( urgency == null || urgency.isEmpty( ) || !urgency.matches( "^\\d+$" ) ) {
			throw new IllegalArgumentException( "Valor da urgencia nao cumpre os critérios" );
		}

		this.urgency = urgency;
	}

	protected Urgency ( ) {
	}

	public String urgency ( ) {
		return this.urgency;
	}

	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		Urgency urgency = ( Urgency ) o;
		return Objects.equals( this.urgency, urgency.urgency );
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( urgency );
	}

	@Override
	public String toString ( ) {
		return this.urgency;
	}

	public static Urgency valueOf ( String string ) {
		return new Urgency( string );
	}

}
