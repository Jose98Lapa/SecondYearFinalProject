package eapli.base.app.user.console.presentation.dashboard;

import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ShowDashboardUI extends AbstractUI {
    private final HttpServerAjax server = new HttpServerAjax();
    DashboardController theController = new DashboardController();

    @Override
    protected boolean doShow() {
        server.setColab(theController.getAuthenticatedCollaborator());
        server.start();
        URI uri;
        try {
            uri = new URI("http://localhost:55128");
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Dashboard";
    }
}
