package eapli.base.app.user.console.presentation.dashboard;

import eapli.base.dasboard.application.DashboardController;
import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ShowDashboardUI extends AbstractUI {
    DashboardController theController = new DashboardController();

    @Override
    protected boolean doShow() {
        theController.showCollaborator();
        URI uri;
        try {
            uri = new URI("https://localhost:55128");
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
