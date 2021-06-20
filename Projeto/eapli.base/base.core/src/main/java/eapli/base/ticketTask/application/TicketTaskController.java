package eapli.base.ticketTask.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketExecutionTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.core.OrderComparator;
import org.springframework.data.util.Pair;

import javax.xml.transform.stream.StreamSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TicketTaskController {

	private final TicketTaskRepository ticketTaskRepository;
	private final TicketRepository ticketRepository;
	private final CollaboratorRepository collaboratorRepository;

	public TicketTaskController ( ) {

		this.ticketTaskRepository = PersistenceContext.repositories( ).ticketTasks( );
		this.collaboratorRepository = PersistenceContext.repositories( ).collaborators( );
		this.ticketRepository = PersistenceContext.repositories( ).tickets( );
	}

	public List< TicketApprovalTask > approvalTasksPending ( ) {

		return ticketTaskRepository
				.pendingApproval( sessionEmail() )
				.stream()
				.filter( ticketExecutionTask ->
						ticketExecutionTask.status().equals( "INCOMPLETE" ) && ticketExecutionTask.taskType().equals( "APPROVAL" ) )
				.map( ticketApprovalTask ->
						new TicketApprovalTask( ticketApprovalTask.transition(),
								ticketApprovalTask.mainReference(),
								ticketApprovalTask.form() ,
								LocalDate.parse( ticketApprovalTask.deadline( )
								)
						)
				)
				.collect( Collectors.toList() );
	}

	public List< TicketExecutionTask > executionTasksPending ( ) {

		return ticketTaskRepository
				.pendingExecution( sessionEmail() )
				.stream()
				.filter( ticketExecutionTask -> ticketExecutionTask.status().equals( "INCOMPLETE" )
						&& ticketExecutionTask.taskType().equals( "EXECUTION" ) )
				.map( ticketExecutionTask ->
						new TicketExecutionTask( ticketExecutionTask.transition(),
								ticketExecutionTask.mainReference(),
								ticketExecutionTask.form(),
								ticketExecutionTask.collaborator(),
								LocalDate.parse( ticketExecutionTask.deadline() )
						)
				)
				.collect( Collectors.toList() );
	}

	public Pair< Ticket, TicketApprovalTask > ticketOfTaskApproval ( TicketApprovalTask task, int filter ) {

		Pair< Ticket, TicketApprovalTask > pair = null;

		switch ( filter ) {
			case 1 -> {
				Ticket chosen = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "reduzida" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen, task );
			}
			case 2 -> {
				Ticket chosen2 = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "moderado" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen2, task );
			}
			case 3 -> {
				Ticket chosen3 = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "urgente" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen3, task );
			}
			default -> {
				Ticket chosenDefault = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosenDefault, task );
			}
		}

		return pair;
	}

	public List< Pair< Ticket, TicketApprovalTask > > listTicketsByApprovalTask ( List< TicketApprovalTask > tasks,
																					 int order, int filter ) {

		List< Pair< Ticket, TicketApprovalTask > > tickets = new ArrayList<>();

		for ( TicketApprovalTask task : tasks ) {
			tickets.add( ticketOfTaskApproval( task, filter ) );
		}

		switch ( order ) {
			case 1 -> tickets.sort( Comparator.comparing( o -> o.getFirst( ).urgency( ) ) );
			case 2 -> tickets.sort( Comparator.comparing( o -> o.getFirst( ).deadline( ) ) );
			case 3 -> tickets.sort( ( o1, o2 ) -> o1.getFirst( ).compareBySolicitedOn( o2.getFirst( ) ) );
		}

		return tickets;
	}

	public Pair< Ticket, TicketExecutionTask > ticketOfExecutionTask ( TicketExecutionTask task, int filter ) {

		Pair< Ticket, TicketExecutionTask > pair = null;

		switch ( filter ) {
			case 1 -> {
				Ticket chosen = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "reduzida" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen, task );
			}
			case 2 -> {
				Ticket chosen2 = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "moderado" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen2, task );
			}
			case 3 -> {
				Ticket chosen3 = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task )
								&& ticket.urgency( ).toString( ).equals( "urgente" ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosen3, task );
			}
			default -> {
				Ticket chosenDefault = StreamSupport.stream( ticketRepository.findAll( ).spliterator( ), false )
						.filter( ticket -> ticket.checkIfTicketTaskBelongsToTicket( task ) )
						.findFirst( )
						.get( );
				pair = Pair.of( chosenDefault, task );
			}
		}

		return pair;
	}

	public List< Pair< Ticket, TicketExecutionTask > > listTicketsByExecutionTask ( List< TicketExecutionTask > tasks,
																					   int order, int filter ) {

		List< Pair< Ticket, TicketExecutionTask > > tickets = new ArrayList<>();

		for ( TicketExecutionTask task : tasks ) {
			tickets.add( ticketOfExecutionTask( task, filter ) );
		}

		switch ( order ) {
			case 1 -> tickets.sort( Comparator.comparing( o -> o.getFirst( ).urgency( ) ) );
			case 2 -> tickets.sort( Comparator.comparing( o -> o.getFirst( ).deadline( ) ) );
			case 3 -> tickets.sort( ( o1, o2 ) -> o1.getFirst( ).compareBySolicitedOn( o2.getFirst( ) ) );
		}

		return tickets;
	}

	private Collaborator sessionEmail ( ) {

		AuthorizationService authorizationService = AuthzRegistry.authorizationService( );

		String email = authorizationService
				.session( )
				.get( )
				.authenticatedUser( )
				.email( )
				.toString( );

		return this.collaboratorRepository.
				getColaboradorByEmail( InstituionalEmail.valueOf( email ) )
				.get();
	}
}
