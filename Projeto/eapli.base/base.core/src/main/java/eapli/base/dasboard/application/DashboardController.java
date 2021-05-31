package eapli.base.dasboard.application;

import eapli.base.Application;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.LinkedList;

public class DashboardController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    LinkedList<DashboardInfoDTO> dashboardInfo = new LinkedList<>();
    DashboardService service = new DashboardService();

    public void showCollaborator() {
        HttpServerAjax server = new HttpServerAjax();
        String email = authz.session().get().authenticatedUser().email().toString();
        ListCollaboratorService listCollaboratorService = new ListCollaboratorService();
        Collaborator colab = listCollaboratorService.getCollaboratorByEmail(email);
        HttpServerAjax.setColab(colab.toDTO());
        server.start();
    }

    public void receiveInfoFromServer(String email) {
        TcpClient tcpClient = new TcpClient();
        tcpClient.startConnection(Application.settings().getIpWorkflow());
        try {
            dashboardInfo = service.prepareInformation(tcpClient.TaskInfoList(email));
        } catch (IOException e) {
            e.printStackTrace();
            tcpClient.stopConnection();
        }
    }

    public LinkedList<DashboardInfoDTO> infoByUrgency() {
        return service.sortDashboardInfoByUrgency(dashboardInfo);
    }

    public LinkedList<DashboardInfoDTO> infoByCriticality() {
        return service.sortDashboardInfoByCriticality(dashboardInfo);
    }
}
