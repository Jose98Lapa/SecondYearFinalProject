package eapli.base.ticket.application;

import eapli.base.ticket.domain.Constants;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketStatus;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.util.*;

public class ManageTicketListsService {


    public LinkedList<String> prepareInformation(List<Ticket> list) {
        AnsiConsole.systemInstall();
        LinkedList<String> toReturn = new LinkedList<>();
        LinkedList<Ticket> sortedInput = sortTicketsByDate(list);
        for (Ticket ticket:sortedInput) {
            Ansi line =null;
            String str = "";
            if(ticket.status().equals(TicketStatus.valueOf( Constants.COMPLETE ))){
                str=ticket.displayInfoForList();
                line = ansi().fg(GREEN).a(str).reset();
            }else{
                str=ticket.displayInfoForList();
                line = ansi().fg(DEFAULT).a(str).reset();
            }
            toReturn.add(line.toString());
        }
        return toReturn;

    }

    private LinkedList<Ticket> sortTicketsByDate(List<Ticket> list) {
        list.sort(Ticket::compareBySolicitedOn);
        Collections.reverse(list);
        return new LinkedList<>(list);
    }
}
