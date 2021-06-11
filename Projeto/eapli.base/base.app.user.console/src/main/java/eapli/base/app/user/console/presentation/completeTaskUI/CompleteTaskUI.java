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
        boolean resposta;

        System.out.println("Tarefas de Aprovação:\n");
        List<TicketApprovalTaskDTO> list = completeTaskController.getListOfTicketApprovalTasks();
        int i;
        for (i=0;i<list.size();i++){
            System.out.println( "-------------------------------- | Index : " + i +1 + " | -------------------------------------------" );
            System.out.println(list.get(i));
        }

        int breakpoint = i;





        System.out.println("Tarefas de Execuçao:\n");
        List<TicketExecutionTaskDTO> list1 = completeTaskController.getListOfTicketExecutionTasks();

        for (i=breakpoint;i<list1.size()+breakpoint;i++){
            System.out.println( "-------------------------------- | Index : " + i + 1 + " | -------------------------------------------" );
            System.out.println(list1.get(i));
        }

        System.out.println("0- cancel");

        int option = eapli.base.app.user.console.presentation.Utils.selectIndex(i,"Escolha o ticket")-1;
        if (option == -1){
            return false;
        }
        if (option<breakpoint){
            ticketTaskID = list.get(option).ticketTaskID;
            resposta = true;
        }else{
            ticketTaskID = list1.get(option-breakpoint).ticketTaskID;
            resposta = false;
        }


        completeTaskController.getTickedByTask(ticketTaskID);

        FormDTO ticketForm = completeTaskController.getTicketsFormDTO();

        for (AttributeDTO atrDTO : ticketForm.atrDTO) {
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

        if (resposta) {
            completeTaskController.approveOrDisapproveTicket(Console.readBoolean("Deseja aprovar?"));
        }


        return false;
    }


    @Override
    public String headline() {
        return "Completar Task UI";
    }
}
