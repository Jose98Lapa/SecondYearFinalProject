package eapli.base.app.user.console.presentation.dashboard.application;

import eapli.base.app.user.console.presentation.dashboard.HttpServerAjax;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class DashboardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final HttpServerAjax server = new HttpServerAjax();

    public void showCollaborator() {
        String email = authz.session().get().authenticatedUser().email().toString();
        ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
        Collaborator colab = listCollaboratorService.getCollaboratorByEmail(email);
        server.setColab(colab.toDTO());
        server.start();
    }
}
