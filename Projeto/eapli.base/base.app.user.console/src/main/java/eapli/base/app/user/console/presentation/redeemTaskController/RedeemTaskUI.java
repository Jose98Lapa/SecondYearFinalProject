package eapli.base.app.user.console.presentation.redeemTaskController;

import eapli.base.catalogue.application.CheckServicesController;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticketTask.application.RedeemTaskController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class RedeemTaskUI extends AbstractUI {
    RedeemTaskController redeemTaskController = new RedeemTaskController();

    @Override
    protected boolean doShow() {
        //Apresenta os tickets
        List<TicketDTO> ticketDTOList = redeemTaskController.getPendingTasks();
        for (TicketDTO ticketDTO: ticketDTOList)
            System.out.println(ticketDTO.toString());

        //Escolhe o ticket que deseja reivindicar
        TicketDTO choosenTicketDTO=null;
        while (choosenTicketDTO==null) {
            String choice = Console.readLine("Insira o ID da tarefa que deseja realizar");
            for (TicketDTO ticketDTO : ticketDTOList) {
                if (choice.equals(ticketDTO.id))
                    choosenTicketDTO = ticketDTO;
            }
            if (choosenTicketDTO==null)
                System.out.println("ID inválido\n\n");
        }

        //Alterar a tarefa
        if (!redeemTaskController.redeemTask(choosenTicketDTO)) {
            System.out.println("Ocorreu um erro na base de dados");
            return false;
        }
        System.out.println("Tarefa reivindicada com sucesso!");
        return true;
    }

    @Override
    public String headline() {
        return "Reivindicar Tarefa";
    }
}
