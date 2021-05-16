package eapli.base.app.backoffice.console.presentation.specifyCollaborator;

import eapli.base.collaborator.application.SpecifyCollaboratorController;
import eapli.base.collaborator.application.PasswordGenerator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.function.DTO.FunctionDTO;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SpecifyCollaboratorUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecifyCollaboratorUI.class);
    private final SpecifyCollaboratorController controller = new SpecifyCollaboratorController();
    private final SignupController signupController = new SignupController();

    @Override
    protected boolean doShow() {
        final CollaboratorDataWidget cdw = new CollaboratorDataWidget();
        System.out.println("Insira a informação necessária para o Colaborador");
        cdw.show();
        try {
            CollaboratorDTO collaboratorDTO = new CollaboratorDTO(cdw.placeOfResidence(), cdw.contact(), cdw.fullName(), cdw.institutionalEmail(), cdw.mecanographicNumber(), cdw.nickname(), cdw.dateOfBirth());
            controller.method(collaboratorDTO);


            List<FunctionDTO> lstFunc = new ArrayList<>();
            FunctionDTO selectedF;
            this.controller.getFunctionList().forEach(lstFunc::add);
            int index = 1;

            while (index != 0) {
                System.out.printf("%n%s%n", "Lista de Funcoes:");
                for (FunctionDTO funcao : lstFunc)
                    System.out.printf("#%d - %s%n", index++, funcao.toString());
                index = Console.readInteger("\nSelecione a funcao que deseja associar ao Colaborador (0 - fim): ");

                if (index > 0 && index - 1 < lstFunc.size()) {
                    controller.defineFunction(selectedF = lstFunc.get(index - 1));
                    index = 0;
                    if (lstFunc.isEmpty())
                        index = 0;
                } else {
                    System.out.println("Opção inválida");
                    index = 1;
                }
            }

            //Colab
            List<CollaboratorDTO> lstColab = new ArrayList<>();
            CollaboratorDTO selectedC;
            this.controller.getCollaboratorList().forEach(lstColab::add);
            index = 1;
            while (index != 0) {
                System.out.printf("%n%s%n", "Lista de Colaboradores:");
                for (CollaboratorDTO colab : lstColab)
                    System.out.printf("#%d - %s%n", index++, colab.toString());
                index = Console.readInteger("Selecione o supervisor do Colaborador (0 - fim): ");

                if (index > 0 && index - 1 < lstColab.size()) {
                    controller.defineSupervisor(selectedC = lstColab.get(index - 1));
                    index = 0;
                    if (lstColab.isEmpty())
                        index = 0;
                } else {
                    System.out.println("Opção inválida");
                    index = 1;
                }
            }

            CollaboratorDTO colaborador = controller.registerCollaborator();

            System.out.println(colaborador.toString());
            boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
            if (answer) {
                controller.saveCollaborator(colaborador);
                String[] name = cdw.fullName().split(" ");
                PasswordGenerator pwrdGenerator = new PasswordGenerator();
                signupController.signup(cdw.nickname(), pwrdGenerator.getPassword(7), name[0], name[name.length - 1], cdw.institutionalEmail(), cdw.mecanographicNumber());
            } else
                return false;
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Colaborador";
    }
}