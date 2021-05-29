package eapli.base.app.backoffice.console.presentation.checkActivityFlux.application;

import eapli.base.app.backoffice.console.presentation.checkActivityFlux.HttpServerAjax;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class DashboardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final HttpServerAjax server = new HttpServerAjax();

    public void showCollaborator() {
        // TODO
        server.setStatus("Joaooooooooooooooooo");
        server.start();
    }
}
