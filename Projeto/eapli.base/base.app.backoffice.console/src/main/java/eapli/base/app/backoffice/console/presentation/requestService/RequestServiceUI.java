package eapli.base.app.backoffice.console.presentation.requestService;

import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
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

		List< CatalogueDTO > availableCatalogues = requestableCatalogues();


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
