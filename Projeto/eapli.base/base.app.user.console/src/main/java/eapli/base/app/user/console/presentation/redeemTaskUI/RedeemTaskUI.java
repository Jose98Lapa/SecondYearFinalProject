package eapli.base.app.user.console.presentation.redeemTaskUI;


import eapli.base.app.user.console.presentation.Utils;
import eapli.base.ticket.DTO.TicketDTO;

import eapli.base.ticketTask.application.RedeemTaskController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class RedeemTaskUI extends AbstractUI {
    RedeemTaskController redeemTaskController = new RedeemTaskController();

    @Override
    protected boolean doShow() {
        //Apresenta os tickets
        List<TicketDTO> ticketDTOList = redeemTaskController.getPendingTasks();
        List<TicketDTO> chooseTicket = new ArrayList<>();
        int i=0;
        System.out.println("Tarefas de Aprovação:\n");
        for (TicketDTO ticketDTO: ticketDTOList){
            if (ticketDTO.status.equals("PENDING")){
                System.out.println(i + "->" + ticketDTO);
                i++;
                chooseTicket.add(ticketDTO);
            }

        }
        System.out.println("Tarefas de Execuçao:\n");
        for (TicketDTO ticketDTO: ticketDTOList){
            if (ticketDTO.status.equals("PENDING_EXECUTION")) {
                System.out.println(i + "->" + ticketDTO);
                i++;
                chooseTicket.add(ticketDTO);
            }
        }

        //Escolhe o ticket que deseja reivindicar
        TicketDTO choosenTicketDTO;


        int option = Utils.selectIndex(chooseTicket,"Escolha o ticket que quer reinvidicar");

        if (option == -1)
            return false;

        choosenTicketDTO = chooseTicket.get(option);

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
