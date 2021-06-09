package eapli.base.app.user.console.presentation.completeTaskUI;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.application.CompleteTaskController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class CompleteTaskUI extends AbstractUI {
    private final CompleteTaskController completeTaskController = new CompleteTaskController();

    @Override
    protected boolean doShow() {
        String ticketTaskID;
        if (Console.readBoolean("Deseja ver as tarefas de aprovação?\nSenão respoder não, verá as tarefas de execução")){
            List<TicketApprovalTaskDTO> list = completeTaskController.getListOfTicketApprovalTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de aprovação");
            TicketApprovalTaskDTO ticketApprovalTaskDTO = list.get(option);
            ticketTaskID = ticketApprovalTaskDTO.ticketTaskID;

        }else{
            List<TicketExecutionTaskDTO> list = completeTaskController.getListOfTicketExecutionTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de execução");
            TicketExecutionTaskDTO ticketExecutionTaskDTO = list.get(option);
            ticketTaskID = ticketExecutionTaskDTO.ticketTaskID;
        }
        System.out.println(completeTaskController.getTickedDTOByTask(ticketTaskID).id);




        return false;
    }


    @Override
    public String headline() {
        return "Completar Task UI";
    }
}
