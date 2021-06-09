package eapli.base.ticketTask.application;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;

import eapli.base.form.application.FormController;
import eapli.base.form.domain.Form;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.task.domain.ManualTask;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.CreateTicketController;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.DTO.TicketApprovalTaskDTO;
import eapli.base.ticketTask.DTO.TicketExecutionTaskDTO;
import eapli.base.ticketTask.domain.TicketApprovalTask;
import eapli.base.ticketTask.domain.TicketManualTask;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.base.utils.GenerateRandomStringID;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Set;

public class CompleteTaskController {
    private final TicketTaskService ticketTaskService = new TicketTaskService();
    private final ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private Ticket workingTicket;
    public TicketManualTask currentWorkingTask;

    public List<TicketApprovalTaskDTO> getListOfTicketApprovalTasks(){
        return ticketTaskService.getPendingApprovalTasksByCollaborator(listCollaboratorService.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
    }

    public List<TicketExecutionTaskDTO> getListOfTicketExecutionTasks(){
        return ticketTaskService.getPendingExecutionTasksByCollaborator(listCollaboratorService.getCollaboratorByEmail(authz.session().get().authenticatedUser().email().toString()));
    }

    public void getTickedByTask(String ticketID){
        currentWorkingTask = (TicketManualTask) ticketTaskService.getTicketTaskByID(ticketID);
        workingTicket = ticketTaskService.getTicketDTOByTicketTask(currentWorkingTask);
    }

    public FormDTO getTicketsFormDTO(){
        return this.workingTicket.ticketForm().toDTO();
    }

    public FormDTO getTaskFormDTO(){
        ManualTask manualTask = (ManualTask) this.currentWorkingTask.mainReference();
        return manualTask.form().toDTO();
    }

    public void updateTaskWithForm(Set<AttributeDTO> attributeSet){
        ManualTask manualTask = (ManualTask) this.currentWorkingTask.mainReference();
        FormDTO manualTaskFormDTO = manualTask.form().toDTO();
        FormDTO formDTO = new FormDTO(manualTaskFormDTO.script, GenerateRandomStringID.generateRandomStringID(),"Formulario da Atividade "+ manualTaskFormDTO.id, attributeSet);
        FormController formController = new FormController();
        formController.registerForm(formDTO);
        Form form = formController.save();
        currentWorkingTask.updateForm(form);
        this.ticketTaskService.updateTask(currentWorkingTask);
        CreateTaskController createTaskController = new CreateTaskController();
        currentWorkingTask.completeTask();
        createTaskController.registerTask(currentWorkingTask);
    }

    public void approveOrDisapproveTicket(boolean approve){
        if (approve){
            workingTicket.approveTicket();
        }else{
            workingTicket.disapproveTicket();
        }
        TicketRepository ticketRepository = PersistenceContext.repositories().tickets();
        ticketRepository.save(workingTicket);
    }





}
