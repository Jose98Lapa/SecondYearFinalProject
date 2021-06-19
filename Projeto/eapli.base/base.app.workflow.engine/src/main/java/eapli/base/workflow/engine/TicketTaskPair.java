package eapli.base.workflow.engine;

import eapli.base.ticketTask.domain.*;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

public class TicketTaskPair {

	private final TicketTask first;
	private final TicketTask second;

	private TicketTaskPair ( TicketTask first, TicketTask second ) {

		this.first = first;
		this.second = second;
	}

	public static TicketTaskPair of ( TicketTask first, TicketTask second ) {

		return new TicketTaskPair( first, second );
	}

	public boolean hasFirst ( ) {

		return this.first != null;
	}

	public TicketTask getFirst ( ) {

		return this.first;
	}

	public boolean hasSecond ( ) {

		return this.second != null;
	}

	public TicketTask getSecond ( ) {

		return this.second;
	}

	public boolean hasApprovalTask () {

		boolean hasApproval = false;

		if ( this.first != null &&
				this.first instanceof TicketApprovalTask ) {
			hasApproval = true;
		}

		if ( this.second != null &&
				this.second instanceof TicketApprovalTask ){
			hasApproval = true;
		}

		return hasApproval;
	}

	public boolean hasAutomaticTask () {

		boolean hasAutomatic = false;

		if ( this.first != null &&
				this.first instanceof TicketAutomaticTask ) {
			hasAutomatic = true;
		}

		if ( this.second != null &&
				this.second instanceof TicketAutomaticTask ){
			hasAutomatic = true;
		}

		return hasAutomatic;
	}

	public boolean hasExecutionTask () {

		boolean hasExecution = false;

		if ( this.first != null &&
				this.first instanceof TicketExecutionTask ) {
			hasExecution = true;
		}

		if ( this.second != null &&
				this.second instanceof TicketExecutionTask ){
			hasExecution = true;
		}

		return hasExecution;
	}

	public TicketApprovalTask ticketApprovalTask () {

		TicketApprovalTask approval = null;

		if ( this.first != null &&
				this.first instanceof TicketApprovalTask ) {
			approval = ( TicketApprovalTask ) this.first ;
		}

		if ( this.second != null &&
				this.second instanceof TicketApprovalTask ){
			approval = ( TicketApprovalTask ) this.second ;
		}

		return approval;
	}

	public TicketAutomaticTask ticketAutomaticTask () {

		TicketAutomaticTask automatic = null;

		if ( this.first != null &&
				this.first instanceof TicketAutomaticTask ) {
			automatic = ( TicketAutomaticTask ) this.first;
		}

		if ( this.second != null &&
				this.second instanceof TicketAutomaticTask ){
			automatic = ( TicketAutomaticTask ) this.second;
		}

		return automatic;
	}

	public TicketExecutionTask ticketExecutionTask () {

		TicketExecutionTask execution = null;

		if ( this.first != null &&
				this.first instanceof TicketExecutionTask ) {
			execution = ( TicketExecutionTask ) this.first;
		}

		if ( this.second != null &&
				this.second instanceof TicketExecutionTask ){
			execution = ( TicketExecutionTask ) this.second;
		}

		return execution;
	}

	@Override
	public boolean equals ( @NonNull Object o ) {

		if ( this == o ) return true;
		if ( getClass( ) != o.getClass( ) ) return false;
		TicketTaskPair that = ( TicketTaskPair ) o;
		return first.equals( that.first ) && second.equals( that.second );
	}

	public int hashCode ( ) {

		int result = ObjectUtils.nullSafeHashCode( this.first );
		result = 31 * result + ObjectUtils.nullSafeHashCode( this.second );
		return result;
	}

	public String toString ( ) {

		return String.format( "%s->%s", this.first, this.second );
	}

}
