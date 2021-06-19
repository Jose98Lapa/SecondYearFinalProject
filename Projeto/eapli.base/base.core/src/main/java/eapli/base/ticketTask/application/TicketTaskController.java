package eapli.base.ticketTask.application;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.repository.TicketTaskRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TicketTaskController {

	private final TicketTaskRepository ticketTaskRepository;
	private final CollaboratorRepository collaboratorRepository;

	public TicketTaskController ( ) {

		this.ticketTaskRepository = PersistenceContext.repositories( ).ticketTasks( );
		this.collaboratorRepository = PersistenceContext.repositories( ).collaborators( );
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
