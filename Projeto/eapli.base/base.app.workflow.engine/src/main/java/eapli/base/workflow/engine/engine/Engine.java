package eapli.base.workflow.engine.engine;

import eapli.base.Application;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.domain.CatalogueID;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.domain.Service;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.workflow.engine.client.Constants;
import eapli.base.workflow.engine.client.TcpExecuterClient;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;



public class Engine {

	private HashMap<Catalogue,Queue<Team>> FCFSApproval = new HashMap();
	private HashMap<TeamID,Queue<Collaborator>> FCFSApprovalAux = new HashMap();


	public static void main ( String[] args ) {

		AuthzRegistry.configure(PersistenceContext.repositories().users(),
				new BasePasswordPolicy(),
				new PlainTextEncoder());

		TicketRepository ticketRepository = PersistenceContext.repositories( ).tickets( );
		Timer timer = new Timer( );
		List< Ticket > previousState = new ArrayList<>( );
		ticketRepository.findAll( ).forEach( previousState::add );


			timer.scheduleAtFixedRate( new TimerTask( ) {

				@Override
				public void run ( ) {
					engine( ticketRepository, previousState );
				}
			}, 0, 1000 );

	}

	private static void engine ( TicketRepository ticketRepository, List< Ticket > previousState ) {

		ticketRepository = PersistenceContext.repositories( ).tickets( );
		List< Ticket > currentState = new ArrayList<>( );
		List< Ticket > lambdaPreviousState = previousState;
		ticketRepository.findAll( ).forEach( currentState::add );
		AtomicInteger modCount = new AtomicInteger( );

		currentState.forEach( currentStateTicket ->
						lambdaPreviousState.forEach(
								previousStateTicket ->
								{
									if ( !( previousStateTicket
											.status( )
											.equals( currentStateTicket.status( ) ) ) ) {
										moveStateFlow( currentStateTicket );
										modCount.getAndIncrement( );
									}
								}
						)
		);

		currentState.forEach( ticketRepository::save );

		previousState = currentState;
	}

	private static void moveStateFlow ( Ticket currentStateTicket ) {

		switch ( currentStateTicket.status().toString() ) {
			case Constants.PENDING:
				System.out.println( "Pending->WAITING" );
				currentStateTicket.setStatus( new TicketStatus( Constants.WAITING_APPROVAL ) );
				break;

			case Constants.APPROVED:
				System.out.println( "Approved->PENDINGEX" );

				currentStateTicket.setStatus( new TicketStatus( Constants.PENDING_EXECUTION ) );
				break;

			case Constants.NOT_APPROVED:
				System.out.println( "NOT_APPROVED" );

				currentStateTicket.setStatus( new TicketStatus( Constants.FAILED ) );
				break;

			case Constants.PENDING_EXECUTION:
				System.out.println("pendeexe" );
				currentStateTicket.setStatus( new TicketStatus( Constants.EXECUTING ) );
				break;
			case Constants.EXECUTING:
				System.out.println("exe" );
				if ( currentStateTicket.workflow().starterTask() instanceof TicketAutomaticTask ) {
					try {
						TcpExecuterClient client = new TcpExecuterClient();
						client.startConnection( Application.settings().getIpAutomatictaskExecutor() );
						client.executeAutomaticTask( ( ( TicketAutomaticTask ) currentStateTicket.workflow().starterTask() ).scriptPath().toString() );
						client.stopConnection();

					} catch ( IOException e ) {
						e.printStackTrace( );
					}
				} else if ( currentStateTicket.workflow().starterTask().transition() != null &&
						currentStateTicket.workflow().starterTask().transition().hasNextTask()
						&& currentStateTicket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask ) {
					try {
						TcpExecuterClient client = new TcpExecuterClient();
						client.startConnection( Application.settings().getIpAutomatictaskExecutor() );
						client.executeAutomaticTask( ( ( TicketAutomaticTask ) currentStateTicket.workflow().starterTask() ).scriptPath().toString() );
						client.stopConnection();

					} catch ( IOException e ) {
						e.printStackTrace( );
					}
				}
				break;
		}
	}

	public synchronized void FCFS(Ticket ticket){
		TicketTask ticketTask = ticket.workflow().starterTask();
		ArrayList<Collaborator> collabs = new ArrayList<>();
		Service svr = ticket.service();
		Catalogue cat = svr.catalogo();
		ArrayList<Team> equipas = new ArrayList<>(cat.accessCriteria());
		for (Team t :equipas) {
			collabs.addAll(t.collaboratorResponsaveisSet);
		}
	}

	public Collaborator selectCollaborator (){


		return null;
	}

	public synchronized void fillFCFSInfo(){
		CatalogueRepository catalogRepo = PersistenceContext.repositories().catalogs();

		for (Catalogue cat: catalogRepo.findAll()) {
			Queue<Team> teamQueue = new PriorityQueue();
			for (Team t :cat.accessCriteria()) {
				teamQueue.add(t);
				Queue<Collaborator> memberQueue = new PriorityQueue();
				memberQueue.addAll(t.teamMembers);
				FCFSApprovalAux.put(t.identity(),memberQueue);
			}
			FCFSApproval.put(cat,teamQueue);
		}
	}

}
