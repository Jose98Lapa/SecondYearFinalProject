package eapli.base.app.backoffice.console.presentation.requestService;

import eapli.base.app.backoffice.console.Utils;
import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.DTO.ServiceDTOParser;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.application.CreateTicketController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Set;

public class RequestServiceUI extends AbstractUI {

	private CreateTicketController ticketController;

	@Override
	protected boolean doShow ( ) {

		ServiceListService servicesService = new ServiceListService();
		ServiceDTOParser dtoParser = new ServiceDTOParser();

		List< CatalogueDTO > availableCatalogues = requestableCatalogues();
		int catalogueIndex = Utils.showAndSelectIndex( availableCatalogues,"Escolha o catalogo que deseja");
		CatalogueDTO chosenCatalogueDTO = availableCatalogues.get( catalogueIndex );
		Catalogue chosenCatalogue = new CatalogueDTOParser().valueOf( chosenCatalogueDTO );

		List< ServiceDTO > availableServices = servicesService.getServiceDTOListByCatalogue( chosenCatalogue );
		int serviceIndex = Utils.showAndSelectIndex( availableCatalogues,"Escolha o serviço que deseja");

		//servicesService.retrieveServiceForm(  );

		return false;
	}

	@Override
	public String headline ( ) {
		return "Solicitar servico";
	}


	public List<CatalogueDTO> requestableCatalogues () {

		ListCatalogueService catalogueService = new ListCatalogueService();
		ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
		TeamListService teamListService = new TeamListService();
		AuthorizationService authorizationService = AuthzRegistry.authorizationService( );

		String email = authorizationService
				.session()
				.get()
				.authenticatedUser()
				.email()
				.toString();

		Collaborator currentColaborator = listCollaboratorService.getCollaboratorByEmail( email );
		Set< Team > teams = teamListService.getACollaboratorTeams( currentColaborator );
		List< CatalogueDTO > catalogues = catalogueService.requestableCataloguesByTeams( teams );

		return catalogues;
	}

}
