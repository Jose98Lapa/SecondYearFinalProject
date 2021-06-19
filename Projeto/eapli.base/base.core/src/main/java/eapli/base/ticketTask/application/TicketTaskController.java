package eapli.base.ticketTask.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.stream.Collectors;

public class TicketTaskController {

	private final TicketTaskRepository ticketTaskRepository;

	public TicketTaskController ( ) {

		this.ticketTaskRepository = PersistenceContext.repositories( ).ticketTasks( );
	}

	public List< TicketApprovalTaskDTO > approvalTasksPending ( ) {
		//TODO: tasks por acabar

		return ticketTaskRepository
				.pendingApproval( sessionEmail() )
				.stream()
				.map( ticketApprovalTask ->
						new TicketApprovalTaskDTO( String.valueOf( ticketApprovalTask.identity() ),
								null,
								ticketApprovalTask.collaborator()
								)
				)
				.collect( Collectors.toList() );
	}

	public List< TicketExecutionTaskDTO > executionTasksPending ( ) {
		//TODO: tasks por acabar

		return ticketTaskRepository
				.pendingExecution( sessionEmail() )
				.stream()
				.map( ticketExecutionTask ->
						new TicketExecutionTaskDTO( String.valueOf( ticketExecutionTask.identity() ),
								null,
								ticketExecutionTask.collaborator()
						)
				)
				.collect( Collectors.toList() );
	}

	private String sessionEmail ( ) {

		AuthorizationService authorizationService = AuthzRegistry.authorizationService( );

		return authorizationService
				.session( )
				.get( )
				.authenticatedUser( )
				.email( )
				.toString( );
	}
}
