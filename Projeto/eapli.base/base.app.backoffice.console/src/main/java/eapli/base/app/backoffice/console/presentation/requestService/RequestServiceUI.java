package eapli.base.app.backoffice.console.presentation.requestService;

import eapli.base.service.Application.ServiceListService;
import eapli.base.ticket.application.CreateTicketController;
import eapli.framework.presentation.console.AbstractUI;

public class RequestServiceUI extends AbstractUI {

	private CreateTicketController ticketController;

	@Override
	protected boolean doShow ( ) {


		return false;
	}

	@Override
	public String headline ( ) {
		return "Solicitar servico";
	}

}
