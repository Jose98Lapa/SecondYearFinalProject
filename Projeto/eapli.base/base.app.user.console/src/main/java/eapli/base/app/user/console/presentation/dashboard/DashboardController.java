package eapli.base.app.user.console.presentation.dashboard;

import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class DashboardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public CollaboratorDTO getAuthenticatedCollaborator() {
        String email = authz.session().get().authenticatedUser().email().toString();
        ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
        Collaborator colab = listCollaboratorService.getCollaboratorByEmail(email);
        return colab.toDTO();
    }
}
