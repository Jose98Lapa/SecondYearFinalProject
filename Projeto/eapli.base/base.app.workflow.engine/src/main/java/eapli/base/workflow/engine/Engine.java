package eapli.base.workflow.engine;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.ticketTask.repository.TicketTaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Engine {

	public static void main( String[] args ) {

		TicketRepository ticketRepository = PersistenceContext.repositories( ).tickets( );
		Timer timer = new Timer( );
		List< TicketTask > previousState = null ;


		timer.scheduleAtFixedRate( new TimerTask( ) {

			@Override
			public void run ( ) {
				moveFlow( ticketRepository, previousState );
			}
		}, 0, 1000 );
	}

	private static void moveFlow ( TicketRepository ticketRepository, List< TicketTask > previousState ) {

		List< Ticket > currentState = new ArrayList<>( );
		ticketRepository.findAll().forEach( currentState::add );



	}

}
