package eapli.base.workflow.engine.engine;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketAutomaticTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.workflow.engine.client.Constants;
import eapli.base.workflow.engine.client.TcpExecuterClient;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Engine {

	public static void main ( String[] args ) {

		AuthzRegistry.configure(PersistenceContext.repositories().users(),
				new BasePasswordPolicy(),
				new PlainTextEncoder());

		TicketRepository ticketRepository = PersistenceContext.repositories( ).tickets( );
		Timer timer = new Timer( );
		List< Ticket > previousState = new ArrayList<>( );
		ticketRepository.findAll( ).forEach( previousState::add );

		while ( true ) {
			timer.scheduleAtFixedRate( new TimerTask( ) {

				@Override
				public void run ( ) {
					engine( ticketRepository, previousState );
				}
			}, 0, 40000 );
		}
	}

	private static void engine ( TicketRepository ticketRepository, List< Ticket > previousState ) {

		ticketRepository = PersistenceContext.repositories( ).tickets( );
		List< Ticket > currentState = new ArrayList<>( );
		List< Ticket > lambdaPreviousState = previousState;
		ticketRepository.findAll( ).forEach( currentState::add );
		AtomicInteger modCount = new AtomicInteger( );

		previousState.forEach( x-> System.out.println(x.status().toString() ) );
		currentState.forEach( x-> System.out.println(x.status().toString() ) );

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
				currentStateTicket.setStatus( new TicketStatus( Constants.WAITING_APPROVAL ) );
				break;

			case Constants.APPROVED:
				currentStateTicket.setStatus( new TicketStatus( Constants.PENDING_EXECUTION ) );
				break;

			case Constants.NOT_APPROVED:
				currentStateTicket.setStatus( new TicketStatus( Constants.FAILED ) );
				break;

			case Constants.PENDING_EXECUTION:
				currentStateTicket.setStatus( new TicketStatus( Constants.EXECUTING ) );
				break;
			case Constants.EXECUTING:
				if ( currentStateTicket.workflow().starterTask() instanceof TicketAutomaticTask ) {
					try {
						TcpExecuterClient client = new TcpExecuterClient();
						client.executeAutomaticTask( ( ( TicketAutomaticTask ) currentStateTicket.workflow().starterTask() ).scriptPath().toString() );
						client.stopConnection();

					} catch ( IOException e ) {
						e.printStackTrace( );
					}
				} else if ( currentStateTicket.workflow().starterTask().transition().hasNextTask()
						&& currentStateTicket.workflow().starterTask().transition().nextTask() instanceof TicketAutomaticTask ) {
					try {
						TcpExecuterClient client = new TcpExecuterClient();
						client.executeAutomaticTask( ( ( TicketAutomaticTask ) currentStateTicket.workflow().starterTask() ).scriptPath().toString() );
						client.stopConnection();

					} catch ( IOException e ) {
						e.printStackTrace( );
					}
				}
				break;
		}
	}

}
