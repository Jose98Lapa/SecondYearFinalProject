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
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.DTO.ServiceDTOParser;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.application.CreateTicketController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class RequestServiceUI extends AbstractUI {

	private final CreateTicketController ticketController=new CreateTicketController();

	@Override
	protected boolean doShow ( ) {

		ServiceListService servicesService = new ServiceListService( );
		FormService formService = new FormService( );

		List< CatalogueDTO > availableCatalogues = requestableCatalogues( );
		int catalogueIndex = Utils.showAndSelectIndex( availableCatalogues, "Escolha o catalogo que deseja" );
		CatalogueDTO chosenCatalogueDTO = availableCatalogues.get( catalogueIndex );

		List< ServiceDTO > availableServices = servicesService.getServiceDTOListByCatalogue( new ListCatalogueService().getCatalogueByID(chosenCatalogueDTO.identity) );
		int serviceIndex = Utils.showAndSelectIndex( availableServices, "Escolha o serviço que deseja" );


		Optional< FormDTO > serviceFormDTO = formService.retrieveFormByID( availableServices.get(serviceIndex).form.identity() );
		FormDTO form;

		if ( serviceFormDTO.isPresent( ) ) {
			form = serviceFormDTO.get( );
			Set< Attribute > attributes = new HashSet<>( );

			int number = 0;

			for ( AttributeDTO attribute : form.atrDTO ) {
				Utils.readLineFromConsole( attribute.label );

				//System.out.println(attribute.tipo );

				Attribute answerAttribute = new Attribute(
						new AtributteName( "Resposta" ),
						new AttributeLabel( Utils.readLineFromConsole( "Resposta a pergunta: " ) ),
						new AttributeDescription( Utils.readLineFromConsole( "Resposta completa: " ) ),
						new AttributeRegex( attribute.regex ),
						new AttributeType( attribute.tipo ),
						new AttributeID( UUID.randomUUID( ).toString( ) ),
						++number
				);
			}

			Form answerForm = new Form(
					new FormScript( form.script ),
					new FormID( Utils.readLineFromConsole( "Introduza o id do formulario: " ) ),
					new FormName( "TicketAnswer" ),
					attributes );

			ticketController.createTicket(
					Utils.readLineFromConsole( "DeadLine (AAAA-MM-DDTHH:mm:ss)" ),
					UUID.randomUUID().toString().substring(0,4),
					Utils.readLineFromConsole( "File Path: " ),
					new ServiceListService().getServiceByID(availableServices.get(serviceIndex).id),
					Utils.readLineFromConsole( "Urgency: " )
					);
		}

		return false;
	}

	@Override
	public String headline ( ) {
		return "Solicitar servico";
	}


	public List< CatalogueDTO > requestableCatalogues ( ) {

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
		Set< Team > teams = teamListService.getACollaboratorTeams( currentColaborator );
		List< CatalogueDTO > catalogues = catalogueService.requestableCataloguesByTeams( teams );

		return catalogues;
	}

}
