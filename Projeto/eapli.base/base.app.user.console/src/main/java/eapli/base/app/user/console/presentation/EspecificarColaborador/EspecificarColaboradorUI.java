package eapli.base.app.user.console.presentation.EspecificarColaborador;

import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.application.PasswordGenerator;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.base.myclientuser.application.SignupController;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.infrastructure.authz.domain.model.Role;
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
    private final SignupController signupController = new SignupController();

    @Override
    protected boolean doShow() {
        final ColaboradorDataWidget cdw = new ColaboradorDataWidget();
        System.out.println("Insira a informação necessária para o Colaborador");
        cdw.show();

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO(cdw.street(), cdw.doorNumber(), cdw.floor(), cdw.location(), cdw.postalCod(),
                cdw.contact(), cdw.fullName(), cdw.institutionalEmail(), cdw.mecanographicNumber(), cdw.nickname(), cdw.dateOfBirth());
        controller.method(colaboradorDTO);


            List<Funcao> lstFunc = new ArrayList<>();
            Funcao selectedF;
            this.controller.getFunctionList().forEach(lstFunc::add);
            int index = 1;

            while (index != 0) {
                System.out.printf("%n%s%n","Lista de Funcoes:");
                for (Funcao funcao : lstFunc)
                    System.out.printf("#%d - %s%n", index++, funcao.toString());
                    index = Console.readInteger("\nSelecione a funcao que deseja associar ao Colaborador (0 - fim): ");

                    if (index > 0 && index - 1 < lstFunc.size()) {
                        controller.defineFunction(selectedF=lstFunc.get(index-1));
                        index=0;
                        if (lstFunc.isEmpty())
                            index = 0;
                    }else {
                        System.out.println("Opção inválida");
                        index=1;}
            }

            //Colab
        List<Colaborador> lstColab = new ArrayList<>();
        Colaborador selectedC;
        this.controller.getCollaboratorList().forEach(lstColab::add);
        index=1;
        while (index != 0) {
            System.out.printf("%n%s%n","Lista de Colaboradores:");
            for (Colaborador colab : lstColab)
                System.out.printf("#%d - %s%n", index++, colab.toString());
            index = Console.readInteger("Selecione o supervisor do Colaborador (0 - fim): ");

            if (index > 0 && index - 1 < lstColab.size()) {
                controller.defineSupervisor(selectedC=lstColab.get(index-1));
                index=0;
                if (lstColab.isEmpty())
                    index = 0;
            }else {
                System.out.println("Opção inválida");
                index=1;}
        }

        Colaborador colaborador = controller.registerCollaborator();

        boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
        if (answer) {
            controller.saveCollaborator(colaborador);
            String[] name = cdw.fullName().split(" ");
            PasswordGenerator pwrdGenerator = new PasswordGenerator();
            signupController.signup(cdw.nickname(),pwrdGenerator.getPassword(7), name[0],name[name.length-1], cdw.institutionalEmail(),cdw.mecanographicNumber());
        }else
            return false;
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Colaborador";
    }
}