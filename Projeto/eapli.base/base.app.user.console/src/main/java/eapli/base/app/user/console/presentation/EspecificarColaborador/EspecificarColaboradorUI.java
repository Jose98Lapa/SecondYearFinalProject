package eapli.base.app.user.console.presentation.EspecificarColaborador;

import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EspecificarColaboradorUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarColaboradorUI.class);
    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();

    @Override
    protected boolean doShow() {
        final ColaboradorDataWidget cdw = new ColaboradorDataWidget();
        System.out.println("Insira a informação necessária para o Colaborador");
        cdw.show();

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(cdw.street(), cdw.doorNumber(), cdw.floor(), cdw.location(), cdw.postalCod(),
                cdw.contact(), cdw.fullName(), cdw.institutionalEmail(), cdw.mecanographicNumber(), cdw.nickname(), cdw.dateOfBirth());
        controller.method(colaboradorDTO);

        boolean functionSelected = false;
        while (functionSelected) {
            System.out.println("Function List:\n");
            for (Funcao funcao : controller.getFunctionList()) {
                System.out.println(funcao.toString());
            }

            String choosenFunction = Console.readLine("Choose a function:");

            for (Funcao funcao : controller.getFunctionList()) {
                if (funcao.toString().equals(choosenFunction)) {
                    controller.defineFunction(funcao);
                    functionSelected = false;
                    break;
                }
            }
            if (!functionSelected) {
                System.out.println("Invalid function\n");
            }
        }

        boolean supervisorSelected = false;
        while (supervisorSelected) {
            System.out.println("Supervisor List:\n");
            for (Colaborador colaborador : controller.getCollaboratorList()) {
                System.out.println(colaborador);
            }

            String choosenSupervisor = Console.readLine("Choose a supervisor(ID):");

            for (Colaborador colaborador : controller.getCollaboratorList()) {
                if (colaborador.identity().toString().equals(choosenSupervisor)) {
                    controller.defineSupervisor(colaborador);
                    supervisorSelected = false;
                    break;
                }
            }
            if (!supervisorSelected) {
                System.out.println("Invalid supervisor\n");
            }
        }

        Colaborador colaborador = controller.registerCollaborator();

        boolean answer = Console.readBoolean("Is all the info correct?(Y/N)");
        if (answer)
            controller.saveCollaborator(colaborador);
        else
            return false;
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Colaborador";
    }
}