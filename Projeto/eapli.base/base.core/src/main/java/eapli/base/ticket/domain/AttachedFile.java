package eapli.base.ticket.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttachedFile implements ValueObject , Serializable {

	private String file;

	protected AttachedFile ( ) {

	}

	public AttachedFile ( String file ) {
		if ( StringPredicates.isNullOrEmpty( file ) ) {
			throw new IllegalArgumentException( "File should neither be null nor empty" );
		}
		this.file = file;
	}


	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass( ) != o.getClass( ) ) return false;
		AttachedFile that = ( AttachedFile ) o;
		return Objects.equals( file, that.file );
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash( file );
	}

	public static AttachedFile valueOf ( String string ) {
		return new AttachedFile( string );
	}

	@Override
	public String toString ( ) {
		return file;
	}

}