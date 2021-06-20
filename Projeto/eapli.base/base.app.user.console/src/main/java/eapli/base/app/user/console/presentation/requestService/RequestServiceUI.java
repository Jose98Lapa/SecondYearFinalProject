package eapli.base.app.user.console.presentation.requestService;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.app.backoffice.console.presentation.form.FormDataWidget;
import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.form.Builder.AttributeBuilder;
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
import eapli.base.service.domain.Service;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.CreateTicketController;
import eapli.base.ticket.application.TicketService;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Constants;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.springframework.boot.web.servlet.server.Session;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RequestServiceUI extends AbstractUI {

	private final CreateTicketController ticketController;


	public RequestServiceUI ( ) {
		ticketController = new CreateTicketController();
	}

	@Override
	protected boolean doShow ( ) {

		List< CatalogueDTO > requestableCatalogues = ticketController.requestableCatalogues();

		int selectedCatalogueIndex = Utils.showAndSelectIndex( requestableCatalogues, "Escolha o catalogo que deseja" );
		CatalogueDTO chosenCatalogueDTO = requestableCatalogues.get( selectedCatalogueIndex );

		List< ServiceDTO > requestableServices =
				ticketController.getServicesByCatalogue( chosenCatalogueDTO );

		int selectedServiceIndex = Utils.showAndSelectIndex( requestableServices, "Escolha o serviço que deseja" );
		ServiceDTO selectedService = requestableServices.get( selectedServiceIndex );
		this.ticketController.selectService( selectedService );

		FormDTO serviceForm = ticketController.getFormDTOByID( selectedService.form.identity().toString() );
		Set< AttributeDTO > answers = fillInServiceForm ( serviceForm );

		FormDTO answerForm = new FormDTO(
				serviceForm.script,
				UUID.randomUUID().toString(),
				"Resposta a " + serviceForm.nome,
				answers
		);
		boolean grammarValidation = ticketController.answeringForm( answerForm );

		if ( grammarValidation ) {
			TicketDTO ticket = new TicketDTO(
					LocalDate.now().toString(),
					Utils.readLineFromConsole( " Introduza a deadline do ticket ( ex: 2021-03-31 )" ),
					selectedService.script,
					Utils.readLineFromConsole( " Introduza a urgencia do ticket ( reduzida / moderada / urgente)" ),
					selectedService,
					sessionEmail()
			);


			boolean confirmation = Console.readBoolean( "Confirma os dados introduzidos? ( y / n )" );
			ticketController.createTicket( ticket , confirmation );

			return true;
		} else {
			System.out.println( "| WARNING: Ticket nao foi criado                                                      |");
			return false;
		}

	}

	@Override
	public String headline ( ) {
		return "Solicitar servico";
	}

	private String sessionEmail ( ) {

		AuthorizationService authorizationService = AuthzRegistry.authorizationService( );

		return authorizationService
				.session( )
				.get( )
				.authenticatedUser( )
				.email( )
				.toString( );
	}

	public Set< AttributeDTO > fillInServiceForm ( FormDTO serviceFormDTO ) {

		Set< AttributeDTO > answers = new HashSet<>( );
		AttributeDTO answer;
		int answerNumber = 0;

		ArrayList< AttributeDTO > attributeDTOList = new ArrayList<>( serviceFormDTO.atrDTO );
		attributeDTOList.sort( Comparator.comparing( attributeDTO -> attributeDTO.number ) );

		for ( AttributeDTO question : attributeDTOList ) {

			System.out.println( "+=====================================================================================+" );
			System.out.println( "\tQuestão " + question.number + ":\t" + question.nome + "\n"
							  + "\tDescrição:\t" + question.desc );
			System.out.println( "*-------------------------------------------------------------------------------------*" );

			answer = new AttributeDTO(
					question.nome,
					Utils.readLineFromConsole( "\tIntroduza a sua resposta: " ),
					question.desc,
					question.regex,
					question.tipo,
					UUID.randomUUID().toString(),
					question.number
			);

			answers.add( answer );
		}

		return answers;
	}

}
