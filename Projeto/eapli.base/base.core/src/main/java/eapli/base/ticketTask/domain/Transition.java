package eapli.base.ticketTask.domain;

import eapli.base.task.domain.Task;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class Transition implements ValueObject, Comparable< Transition >, Serializable {

	@OneToOne
	private Task previousTask;

	@OneToOne
	private Task nextTask;

	protected Transition ( ) {
	}

	public Transition ( Task previousTask, Task nextTask ) {
		this.previousTask = previousTask;
		this.nextTask = nextTask;
	}

	@Override
	public int compareTo ( Transition transition ) {
		return 0;
	}

	public Task previousTask ( ) {
		return previousTask;
	}

	public boolean hasPreviousTask (  ) {
		return this.previousTask != null;

	}

	public Task nextTask ( ) {
		return nextTask;
	}

	public boolean hasNextTask ( ) {
		return this.nextTask != null;
	}

}
