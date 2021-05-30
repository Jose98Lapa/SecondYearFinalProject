package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.service.Application.ServiceListService;
import eapli.base.ticket.application.CreateTicketController;
import eapli.framework.actions.Action;

public class TicketRequestBoostrapper implements Action {

	@Override
	public boolean execute ( ) {

		CreateTicketController controller = new CreateTicketController();

		System.out.println( new ServiceListService().getServiceByID( "1"));
		controller.createTicket(
				"10-05-2010",
				"234567",
				"",
				new ServiceListService().getServiceByID( "1" ),
				"1"
				);

		return true;
	}

}
