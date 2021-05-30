package eapli.base.app.backoffice.console.presentation.checkActivityFlux;

import eapli.base.app.backoffice.console.presentation.checkActivityFlux.application.CheckActivityFluxController;
import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CheckActivityFluxUI extends AbstractUI {
    CheckActivityFluxController theController = new CheckActivityFluxController();

    @Override
    protected boolean doShow() {
        theController.showCollaborator();
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
