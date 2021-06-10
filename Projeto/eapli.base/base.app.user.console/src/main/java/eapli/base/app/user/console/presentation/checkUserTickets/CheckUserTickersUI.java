package eapli.base.app.user.console.presentation.checkUserTickets;

import eapli.base.ticket.application.CheckUserTicketsController;
import eapli.framework.presentation.console.AbstractUI;

public class CheckUserTickersUI extends AbstractUI {
    CheckUserTicketsController theController = new CheckUserTicketsController();


    @Override
    protected boolean doShow() {
        theController.loadInformation();
        return true;
    }

    @Override
    public String headline() {
        return "Check User Tickets";
    }
}
