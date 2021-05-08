package eapli.base.app.user.console.presentation.EspecificarColaborador;

import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        boolean functionSelected = true;
        while (functionSelected) {
            System.out.println("Lista de funcoes:");
            for (Funcao funcao : controller.getFunctionList()) {
                System.out.println(funcao.toString());
            }


            List<Funcao> lstFunc = new ArrayList<>();
            this.controller.getFunctionList().forEach(lstFunc::add);
            final Set<Funcao> accessCriteria = new HashSet<>();
            int index = 1;

            System.out.printf("%n%s%n","Lista de Funcoes:");
            while (index != 0) {
                for (Funcao funcao : lstFunc)
                    System.out.printf("#%d - %s%n", index++, funcao.toString());
                index = Console.readInteger("Insira o numero da funcao que deseja associar ao Colaborador (0 - fim): ");

                if (index > 0 && index-1 < lstFunc.size() ) {
                    accessCriteria.add(lstFunc.get(index-1));
                    lstFunc.remove(index-1);
                    if(lstFunc.isEmpty())
                        index = 0;
                }
            }


            String choosenFunction = Console.readLine("Escolha uma funcao:");

            for (Funcao funcao : controller.getFunctionList()) {
                if (funcao.identity().toString().equals(choosenFunction)) {
                    controller.defineFunction(funcao);
                    functionSelected = false;
                    break;
                }
            }
            if (!functionSelected) {
                System.out.println("Funcao Invalida\n");
            }
        }

        boolean supervisorSelected = true;
        while (supervisorSelected) {
            System.out.println("Lista de Supervisores:\n");
            for (Colaborador colaborador : controller.getCollaboratorList()) {
                System.out.println(colaborador);
            }

            String choosenSupervisor = Console.readLine("Escolha um supervisor(ID):");

            for (Colaborador colaborador : controller.getCollaboratorList()) {
                if (colaborador.identity().toString().equals(choosenSupervisor)) {
                    controller.defineSupervisor(colaborador);
                    supervisorSelected = false;
                    break;
                }
            }
            if (!supervisorSelected) {
                System.out.println("Supervisor inválido\n");
            }
        }

        Colaborador colaborador = controller.registerCollaborator();

        boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
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