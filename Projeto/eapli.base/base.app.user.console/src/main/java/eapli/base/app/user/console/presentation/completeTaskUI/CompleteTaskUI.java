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
    private CompleteTaskController completeTaskController;

    @Override
    protected boolean doShow() {
        if (Console.readBoolean("Deseja ver as tarefas de aprovação?\nSenão respoder não verá as tarefas de execução")){
            List<TicketApprovalTaskDTO> list = completeTaskController.getListOfTicketApprovalTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de aprovação");
            TicketApprovalTaskDTO ticketApprovalTaskDTO = list.get(option);
            System.out.println(completeTaskController.getTickedDTOByTask(ticketApprovalTaskDTO).id);
        }else{
            List<TicketExecutionTaskDTO> list = completeTaskController.getListOfTicketExecutionTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de execução");
            TicketExecutionTaskDTO ticketExecutionTaskDTO = list.get(option);
            System.out.println(completeTaskController.getTickedDTOByTask(ticketExecutionTaskDTO).id);
        }




        return false;
    }


    @Override
    public String headline() {
        return "Completar Task UI";
    }
}
