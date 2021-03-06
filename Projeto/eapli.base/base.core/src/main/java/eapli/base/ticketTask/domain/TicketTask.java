package eapli.base.ticketTask.domain;

import eapli.base.task.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class TicketTask implements DomainEntity< Long >, AggregateRoot< Long >, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long ticketTaskID;

	@Embedded
	private Transition transition;

	@OneToOne
	private Task mainReference;

	private String status;

	private LocalDateTime dateStarted, dateEnded;

	private String taskType;

	protected TicketTask ( ) {
	}

	public TicketTask ( Transition transition, Task mainReference, String taskType ) {
		this.transition = transition;
		this.status = "INCOMPLETE";
		this.mainReference = mainReference;
		this.taskType = taskType;
	}

	@Override
	public Long identity ( ) {
		return ticketTaskID;
	}

	@Override
	public boolean sameAs ( Object other ) {
		return DomainEntities.areEqual( this, other );
	}

	public Transition transition ( ) {
		if (transition==null)
			transition = new Transition();
		return transition;
	}


	public String status(){
		return this.status;
	}

	public Task mainReference(){
		return this.mainReference;
	}

	public void addAfterTask(TicketTask afterTask){
		if (transition==null)
			this.transition = new Transition();
		this.transition.setNextTask(afterTask);
	}

	public void addBeforeTask(TicketTask beforeTask){
		if (transition==null)
			this.transition = new Transition();
		this.transition.setPreviousTask(beforeTask);
	}

	public TicketTask getFirstIncompleteTask(){
		return getFirstIncompleteTask(this);
	}

	private TicketTask getFirstIncompleteTask(TicketTask ticketTask){
		if (ticketTask.transition==null) return ticketTask;
		if (ticketTask.status.equals("INCOMPLETE"))
			return ticketTask;
		else
			return getFirstIncompleteTask(ticketTask.transition().nextTask());

	}

	public void redeemTask() {
		dateStarted = LocalDateTime.now();
	}

	public void completeTask(){
		this.status = "COMPLETE";
		dateEnded = LocalDateTime.now();
	}

	public long getTimeInMinutesOfExecution(){
		return dateStarted.until(dateEnded, ChronoUnit.MINUTES);
	}

	public String taskType () {
		return taskType;
	}

	public long completionTime(){
		return ChronoUnit.MINUTES.between(dateStarted,dateEnded);
	}

	@Override
	public String toString() {
		return "TicketTask{" +
				"ticketTaskID=" + ticketTaskID +
				", transition=" + transition +
				", mainReference=" + mainReference +
				", status='" + status + '\'' +
				", dateStarted=" + dateStarted +
				", dateEnded=" + dateEnded +
				", taskType='" + taskType + '\'' +
				'}';
	}
}
