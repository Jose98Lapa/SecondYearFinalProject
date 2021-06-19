package eapli.base.workflow.engine;

import eapli.base.Application;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.task.repository.TaskRepository;
import eapli.base.team.domain.Team;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.domain.*;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.workflow.engine.client.TcpExecuterClient;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.util.*;

public class EngineV2 {

    private final TicketRepository ticketRepository;
    private final ServiceRepository serviceRepository;
    private final CreateTaskController ticketTaskController;
    static TreeMap<Date, Collaborator> historyExecution = new TreeMap<>();
    static TreeMap<Date, Collaborator> historyApproval = new TreeMap<>();
    static TreeMap<Date, String> historyAutomaticTask = new TreeMap<>();

	public EngineV2 ( ) {

		this.ticketRepository = PersistenceContext.repositories( ).tickets( );
		this.serviceRepository = PersistenceContext.repositories( ).servico( );
		this.ticketTaskController = new CreateTaskController( );

		AuthzRegistry.configure( PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder() );
	}

	public void processIncomingTicket ( byte[] payload ) {

		Optional< Ticket > ticketOptional = ticketRepository.ofIdentity( new String( payload ) );
		Ticket ticket;

		if ( ticketOptional.isPresent( ) ) {

			ticket = ticketOptional.get( );
			createWorkFlow( ticket );
			processStatusChange( ticket, ticket.status().toString() );
		}

	}

	public void processStatusChange ( Ticket ticket, String action ) {

		Optional< Ticket > processedTicket = Optional.empty();

		switch ( action ) {
			case "PENDING":
				System.out.println( "PENDING TICKET DELEGATION" );
				ticket.statusPending( );
				processedTicket = Optional.of( delegateTask( ticket ) );
				break;
			case "APPROVED":
				System.out.println( "APPROVED TICKET DELEGATION" );
				ticket.statusApproved( );
				processedTicket = Optional.of( delegateTask( ticket ) );
				break;
			case "NOT_APPROVED":
				ticket.statusNotApproved( );
				break;
			case "CONCLUDED":
				ticket.statusConcluded( );
				break;
			case "FAILED":
				ticket.statusFailed( );
				break;
		}

		processedTicket.ifPresent( ticketRepository::save );
	}

	private void createWorkFlow ( Ticket ticket ) {

		System.out.println( ticket.service().identity().toString() );
		Service service = serviceRepository.ofIdentity( ticket.service().identity() ).get();

		List< Task > taskList = new ArrayList<>(  );
		taskList.add( service.workflow().starterTask() );

		if ( service.workflow().starterTask().hasAfterTask() ) {
			taskList.add( service.workflow().starterTask().afterTask() );
		}

		TicketTaskPair ticketTaskPair;
		TicketWorkflow workflow;

		if ( taskList.size( ) == 2 ) {

			ticketTaskPair = TicketTaskPair.of( createTask( ticket, taskList.get( 0 ) ), createTask( ticket, taskList.get( 1 ) ) );
			TicketApprovalTask approvalTask = ticketTaskPair.ticketApprovalTask( );

			if ( ticketTaskPair.hasAutomaticTask( ) ) {

				approvalTask.addAfterTask( ticketTaskPair.ticketAutomaticTask( ) );
				ticketTaskController.registerApprovalTask( approvalTask );
				ticketTaskController.registerAutomaticTask( ticketTaskPair.ticketAutomaticTask( ) );

			} else {

				approvalTask.addAfterTask( ticketTaskPair.ticketExecutionTask( ) );
				ticketTaskController.registerApprovalTask( approvalTask );
				ticketTaskController.registerExecutionTask( ticketTaskPair.ticketExecutionTask( ) );
			}

			workflow = new TicketWorkflow( approvalTask );

		} else {

			ticketTaskPair = TicketTaskPair.of( createTask( ticket, taskList.get( 0 ) ), null );

			if ( ticketTaskPair.hasAutomaticTask( ) ) {

				workflow = new TicketWorkflow( ticketTaskPair.ticketAutomaticTask( ) );
				ticketTaskController.registerAutomaticTask( ticketTaskPair.ticketAutomaticTask( ) );

			} else {
				workflow = new TicketWorkflow( ticketTaskPair.ticketExecutionTask( ) );
				ticketTaskController.registerExecutionTask( ticketTaskPair.ticketExecutionTask( ) );

			}
		}

		System.out.println( "SAVING WORKFLOW" );
		ticket.setWorkflow( workflow );
		ticketRepository.save( ticket );
	}

	private TicketTask createTask ( Ticket ticket, Task task ) {

		TicketTask ticketTask;

		if ( task instanceof ApprovalTask ) {

			ApprovalTask approvalTask = ( ApprovalTask ) task;
			ticketTask = new TicketApprovalTask(
					new Transition( null, null ),
					approvalTask,
					approvalTask.form( ),
					ticket.deadline( )
			);
		} else if ( task instanceof AutomaticTask ) {

			AutomaticTask automaticTask = ( AutomaticTask ) task;
			ticketTask = new TicketAutomaticTask(
					new Transition( null, null ),
					automaticTask,
					automaticTask.scriptPath( )
			);
		} else {

			ExecutionTask executionTask = ( ExecutionTask ) task;
			ticketTask = new TicketExecutionTask(
					new Transition( null, null ),
					executionTask,
					executionTask.form( ),
					null,
					ticket.deadline( )
			);

		}

		return ticketTask;
	}

	private Ticket delegateTask ( Ticket ticket ) {

		Ticket delegated = ticket;

		switch ( Application.settings( ).getCollaboratorAssignerAlgorithm( ) ) {
			case "FCFS":
				System.out.println( "FCFS" );
				delegated = FCFSTicket( ticket );
				break;
				//TODO: CHANGE NAMING
			case "COMPLEX":
				break;
		}

		return delegated;
	}

    public Ticket FCFSTicket(Ticket ticket) {

        Collaborator selected = null;

        if (ticket.status().toString().equals("PENDING")) {

            if (ticket.workflow().starterTask() instanceof TicketApprovalTask) {
                selected = assignCollaboratorApproval(ticket);
                ((TicketApprovalTask) ticket.workflow().starterTask()).setApprovedBy(selected);
            }
            if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketApprovalTask) {
                selected = assignCollaboratorApproval(ticket);
                ((TicketApprovalTask) ticket.workflow().starterTask()).setApprovedBy(selected);
            }
        }

        if (ticket.status().toString().equals("APPROVED")) {

            if (ticket.workflow().starterTask() instanceof TicketExecutionTask) {
                selected = assignCollaboratorExecution(ticket);
                ((TicketExecutionTask) ticket.workflow().starterTask()).setExecutedBy(selected);
            }
            if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketExecutionTask) {
                selected = assignCollaboratorExecution(ticket);
                ((TicketExecutionTask) ticket.workflow().starterTask()).setExecutedBy(selected);
            }

			if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
				FCFSAutomaticTask(ticket);
			}

			if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
				FCFSAutomaticTask(ticket);
			}
        }

        return ticket;
    }

    public Ticket FCFSAutomaticTask(Ticket ticket) {

        String selected = "";
        try {
            if (ticket.status().toString().equals("PENDING")) {
                if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
                    selected = assignServer();
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
                if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
                    selected = assignServer();
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
            }

            if (ticket.status().toString().equals("APPROVED")) {
                if (ticket.workflow().starterTask() instanceof TicketAutomaticTask) {
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
                if (ticket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask) {
                    TcpExecuterClient client = new TcpExecuterClient();
                    client.startConnection(selected);
                    client.executeAutomaticTask(ticket);
                    client.stopConnection();
                }
            }
        } catch (IOException e) {
            System.out.println("An error ocorred");
        }

        return ticket;
    }

    public synchronized String assignServer() {

        String theChosenOne = "";
        List<String> serverList = new LinkedList<>();
        serverList.add("172.17.0.3");
        serverList.add("172.17.0.4");
        serverList.add("172.17.0.5");
        serverList.add("172.17.0.6");

        for (Date date : historyAutomaticTask.keySet()) {
            if (!serverList.contains(historyAutomaticTask.get(date))) {   //se algum colaborador for removido retira do historico
                historyAutomaticTask.remove(date);
            }
        }

        for (String server : serverList) { //verificar se existe algum que ainda nao tenha feito nada
            if (!historyAutomaticTask.containsValue(server)) {
                theChosenOne = server;
                historyAutomaticTask.put(new Date(), server);
            }
        }

        if (theChosenOne.equals("")) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo
            for (Date date : historyAutomaticTask.keySet()) {
                if (serverList.contains(historyAutomaticTask.get(date))) {
                    theChosenOne = historyAutomaticTask.get(date);
                    historyAutomaticTask.put(new Date(), historyAutomaticTask.remove(date));
                }
            }
        }
        return theChosenOne;
    }

    public synchronized Collaborator assignCollaboratorExecution(Ticket ticket) {

		TeamRepository teamRepository = PersistenceContext.repositories( ).teams( );

		Collaborator theChosenOne = null;
		ArrayList< Collaborator > collaborators = new ArrayList<>( );
		ArrayList< Team > execTeams = new ArrayList<>( );
		ArrayList< Team > execTeamsUpdated = new ArrayList<>( );
		Service svr = ticket.service( );

		if ( svr.workflow( ).starterTask( ) instanceof ExecutionTask ) {
			execTeams.addAll( ( ( ExecutionTask ) svr.workflow( ).starterTask( ) ).executingTeams( ) );
		}
		for ( Team t : execTeams ) { //update teams
			execTeamsUpdated.add( teamRepository.ofIdentity( t.identity( ) ).get( ) );
		}
		execTeams.clear( );// delete old list
		for ( Team t : execTeamsUpdated ) { //save updated collaborators
			collaborators.addAll( t.teamMembers( ) );
		}
		for ( Collaborator collab : collaborators ) { //verificar se existe algum que ainda nao tenha feito nada
			if ( !historyExecution.containsValue( collab ) ) {
				theChosenOne = collab;
				historyExecution.put( new Date( ), collab );
			}
		}
		for ( Date date : historyExecution.keySet( ) ) {
			if ( !collaborators.contains( historyExecution.get( date ) ) ) {//se algum colaborador for removido retira do historico
				historyExecution.remove( date );
			}
		}
		if ( theChosenOne == null ) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo
			for ( Date date : historyExecution.keySet( ) ) {
				if ( collaborators.contains( historyExecution.get( date ) ) ) {
					theChosenOne = historyExecution.get( date );
					historyExecution.put( new Date( ), historyExecution.remove( date ) );
				}
			}
		}
		return theChosenOne;
	}

	public synchronized Collaborator assignCollaboratorApproval ( Ticket ticket ) {

		CollaboratorRepository collaboratorRepository = PersistenceContext.repositories( ).collaborators( );

		Collaborator theChosenOne = null;
		ArrayList< Collaborator > collaborators = new ArrayList<>( );
		Service svr = ticket.service( );

		if ( svr.workflow( ).starterTask( ) instanceof ApprovalTask ) {
			collaborators.addAll( ( Collection< ? extends Collaborator > ) collaboratorRepository.getCollaboratorsByRole(
					( ( ApprovalTask ) svr.workflow( ).starterTask( ) ).necessaryRoleForApproval( ) )
			); // base de dados colab by role
		}

		for ( Date date : historyApproval.keySet( ) ) {
			if ( !collaborators.contains( historyApproval.get( date ) ) ) {//se algum colaborador for removido retira do historico
				historyApproval.remove( date );
			}
		}
		for ( Collaborator collab : collaborators ) { //verificar se existe algum que ainda nao tenha feito nada
			if ( !historyApproval.containsValue( collab ) ) {
				theChosenOne = collab;
				historyApproval.put( new Date( ), collab );
			}
		}
		if ( theChosenOne == null ) { //se todos ja tiverem feito pelo menos um, vai verificar o que fez ha mais tempo que tem permissoes
			for ( Date date : historyApproval.keySet( ) ) {
				if ( collaborators.contains( historyApproval.get( date ) ) ) {
					theChosenOne = historyApproval.get( date );
					historyApproval.put( new Date( ), historyApproval.remove( date ) );
				}
			}
		}
		return theChosenOne;
	}

}
