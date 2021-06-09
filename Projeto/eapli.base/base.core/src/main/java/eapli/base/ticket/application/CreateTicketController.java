package eapli.base.ticket.application;


import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.application.FormService;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.FormName;
import eapli.base.form.domain.attribute.Attribute;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.domain.Service;
import eapli.base.task.domain.ApprovalTask;
import eapli.base.task.domain.AutomaticTask;
import eapli.base.task.domain.ExecutionTask;
import eapli.base.task.domain.Task;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.CreateTaskController;
import eapli.base.ticketTask.application.TicketTaskService;
import eapli.base.ticketTask.domain.*;
import eapli.base.utils.GenerateRandomStringID;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class CreateTicketController {

    private final TicketBuilder builder = new TicketBuilder();
    private CreateTaskController ticketTaskController;
    private final TicketRepository ticketRepository = PersistenceContext.repositories().tickets();

    public CreateTicketController() {
    }


    public void createTicket(TicketDTO ticketDTO, ServiceDTO serviceDTO, Set<Attribute> attributeSet) {
        TicketTaskService ticketTaskService = new TicketTaskService();
        this.ticketTaskController = new CreateTaskController();
        Service service = new ServiceListService().getServiceByID(serviceDTO.id);

        if (service.workflow() != null && service.workflow().starterTask() != null) {
            String deadline = ticketDTO.deadLine;

            Task starter = service.workflow().starterTask();

            TicketTask starterTicketTask = ticketTaskService.createTicketTask(deadline, starter);

            String status;

            if (starterTicketTask.getClass()==TicketApprovalTask.class){
                status = "PENDING";
            }else{
                status = "PENDING_EXECUTION";
            }

            TicketWorkflow workflow = new TicketWorkflow(
                    LocalDate.now(),
                    starterTicketTask
            );

            Form form = new Form(service.form().script(), FormID.valueOf(GenerateRandomStringID.generateRandomStringID()), FormName.valueOf("temp"),attributeSet);


            Ticket ticket = builder.solicitedOn(LocalDate.now().toString())
                    .withDeadLine(deadline)
                    .withPossibleFile(ticketDTO.file)
                    .withService(service)
                    .withStatus(status)
                    .withUrgency(ticketDTO.urgency)
                    .withWorkFlow(workflow)
                    .withForm( form )
                    .build();

            ticketRepository.save(ticket);
        }
    }



    public List<CatalogueDTO> requestableCatalogues ( ) {

        ListCatalogueService catalogueService = new ListCatalogueService( );
        ListCollaboratorService listCollaboratorService = new ListCollaboratorService( );
        TeamListService teamListService = new TeamListService( );
        AuthorizationService authorizationService = AuthzRegistry.authorizationService( );

        String email = authorizationService
                .session( )
                .get( )
                .authenticatedUser( )
                .email( )
                .toString( );

        Collaborator currentColaborator = listCollaboratorService.getCollaboratorByEmail( email );
        Set<Team> teams = teamListService.getACollaboratorTeams( currentColaborator );
        return catalogueService.requestableCataloguesByTeams( teams );
    }

    public List<ServiceDTO> getServiceDTOByCatalogue(CatalogueDTO chosenCatalogueDTO){
        ServiceListService servicesService = new ServiceListService( );
        return servicesService.getServiceDTOListByCatalogue( new ListCatalogueService().getCatalogueByID(chosenCatalogueDTO.identity) );
    }

    public FormDTO getFormDTOByID(String ID){
        return new FormService().getFormFromID(FormID.valueOf(ID)).toDTO();
    }

    /*private TicketTask createTicketTask(String deadline, TicketTask starter) {
        if (starter instanceof TicketApprovalTask) {
            TicketApprovalTask approvalTask = new TicketApprovalTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null), ((TicketApprovalTask) starter).form(),
                    LocalDate.parse(deadline));

            this.ticketTaskController.registerApprovalTask(approvalTask);
            return approvalTask;
        }

        if (starter instanceof TicketExecutionTask) {
            TicketExecutionTask executionTask = new TicketExecutionTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null),
                    ((TicketExecutionTask) starter).form(),
                    null,
                    LocalDate.parse(deadline));

            this.ticketTaskController.registerExecutionTask(executionTask);
            return executionTask;
        }

        if (starter instanceof TicketAutomaticTask) {
            TicketAutomaticTask automaticTask = new TicketAutomaticTask(
                    new TicketTaskID(starter.identity().toString()),
                    new Transition(null, null),
                    ((TicketAutomaticTask) starter).scriptPath()
            );

            this.ticketTaskController.registerAutomaticTask(automaticTask);
            return automaticTask;
        }

        return null;
    }*/

}
