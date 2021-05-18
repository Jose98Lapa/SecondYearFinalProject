package eapli.base.app.user.console.presentation.dashboard;

import eapli.framework.presentation.console.AbstractUI;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ShowDashboardUI  extends AbstractUI  {
    @Override
    protected boolean doShow() {
        HttpServerAjax server = new HttpServerAjax();
        server.start();
        URI uri;
        try {
            uri = new URI("http://localhost:55127");
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
