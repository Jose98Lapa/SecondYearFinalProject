package eapli.base.app.user.console.presentation.requestService;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.attribute.AttributeDTO;
import eapli.base.form.application.FormService;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.domain.FormName;
import eapli.base.form.domain.FormScript;
import eapli.base.form.domain.attribute.*;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.CreateTicketController;
import eapli.base.utils.GenerateRandomStringID;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

import java.time.LocalDate;
import java.util.*;

public class RequestServiceUI extends AbstractUI {

    private final CreateTicketController ticketController = new CreateTicketController();

    @Override
    protected boolean doShow() {


        FormService formService = new FormService();

        List<CatalogueDTO> availableCatalogues = ticketController.requestableCatalogues();
        int catalogueIndex = Utils.showAndSelectIndex(availableCatalogues, "Escolha o catalogo que deseja");
        CatalogueDTO chosenCatalogueDTO = availableCatalogues.get(catalogueIndex);

        List<ServiceDTO> availableServices = this.ticketController.getServiceDTOByCatalogue(chosenCatalogueDTO);
        int serviceIndex = Utils.showAndSelectIndex(availableServices, "Escolha o serviço que deseja");


        FormDTO form = ticketController.getFormDTOByID(availableServices.get(serviceIndex).form.identity().toString());


        Set<Attribute> attributes = new HashSet<>();

        int number = 0;

        for (AttributeDTO attribute : form.atrDTO) {


            System.out.println(attribute.label);

            Attribute answerAttribute = new Attribute(
                    new AtributteName("Resposta"),
                    new AttributeLabel(attribute.label),
                    new AttributeDescription(Utils.readLineFromConsole("Resposta completa: ")),
                    new AttributeRegex(attribute.regex),
                    new AttributeType(attribute.tipo),
                    new AttributeID(UUID.randomUUID().toString()),
                    ++number
            );

            attributes.add(answerAttribute);
        }

        TicketDTO ticketDTO = new TicketDTO(LocalDate.now().toString(), Utils.readLineFromConsole("DeadLine (AAAA-MM-DD)"), "", "", Utils.readLineFromConsole("File Path: "), Utils.readLineFromConsole("Urgency: "));

        ticketController.createTicket(
                ticketDTO, availableServices.get(serviceIndex), attributes
        );


        return false;
    }

    @Override
    public String headline() {
        return "Solicitar servico";
    }


}
