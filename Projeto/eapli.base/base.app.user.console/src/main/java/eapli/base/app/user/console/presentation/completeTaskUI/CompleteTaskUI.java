package eapli.base.app.user.console.presentation.completeTaskUI;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.domain.attribute.*;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.application.CompleteTaskController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CompleteTaskUI extends AbstractUI {
    private final CompleteTaskController completeTaskController = new CompleteTaskController();

    @Override
    protected boolean doShow() {
        String ticketTaskID;
        boolean resposta = Console.readBoolean("Deseja ver as tarefas de aprovação?\nSenão respoder não, verá as tarefas de execução");
        if (resposta){
            List<TicketApprovalTaskDTO> list = completeTaskController.getListOfTicketApprovalTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de aprovação");
            if (option == -1) return false;
            TicketApprovalTaskDTO ticketApprovalTaskDTO = list.get(option);
            ticketTaskID = ticketApprovalTaskDTO.ticketTaskID;

        }else{
            List<TicketExecutionTaskDTO> list = completeTaskController.getListOfTicketExecutionTasks();
            int option = Utils.showAndSelectIndex(list,"Escolha a tarefa de execução");
            if (option == -1) return false;
            TicketExecutionTaskDTO ticketExecutionTaskDTO = list.get(option);
            ticketTaskID = ticketExecutionTaskDTO.ticketTaskID;
        }
        completeTaskController.getTickedByTask(ticketTaskID);

        FormDTO ticketForm = completeTaskController.getTicketsFormDTO();

        for (AttributeDTO atrDTO: ticketForm.atrDTO){
            System.out.println(atrDTO);
        }


        FormDTO form = completeTaskController.getTaskFormDTO();

        Set<AttributeDTO> attributes = new HashSet<>();

        int number = 0;

        for (AttributeDTO attribute : form.atrDTO) {
            System.out.println(attribute.label);
            AttributeDTO answerAttribute = new AttributeDTO(
                   "Resposta",
                    attribute.label,
                    Utils.readLineFromConsole("Resposta completa: "),
                    attribute.regex,
                    attribute.tipo,
                    UUID.randomUUID().toString(),
                    ++number
            );

            attributes.add(answerAttribute);
        }

        completeTaskController.updateTaskWithForm(attributes);

        if (resposta){
            completeTaskController.approveOrDisapproveTicket(Console.readBoolean("Deseja aprovar?"));
        }


        return false;
    }


    @Override
    public String headline() {
        return "Completar Task UI";
    }
}
