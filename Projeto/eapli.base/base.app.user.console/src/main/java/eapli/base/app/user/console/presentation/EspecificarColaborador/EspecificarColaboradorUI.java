package eapli.base.app.user.console.presentation.EspecificarColaborador;

import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.funcao.domain.Funcao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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


            List<Funcao> lstFunc = new ArrayList<>();
            this.controller.getFunctionList().forEach(lstFunc::add);
            int index = 1;

            while (index != 0) {
                System.out.printf("%n%s%n","Lista de Funcoes:");
                for (Funcao funcao : lstFunc)
                    System.out.printf("#%d - %s%n", index++, funcao.toString());
                    index = Console.readInteger("\nSelecione a funcao que deseja associar ao Colaborador (0 - fim): ");

                    if (index > 0 && index - 1 < lstFunc.size()) {
                        controller.defineFunction(lstFunc.get(index-1));
                        index=0;
                        if (lstFunc.isEmpty())
                            index = 0;
                    }else {System.out.println("Opção inválida");}
            }

        List<Colaborador> lstColab = new ArrayList<>();
        this.controller.getCollaboratorList().forEach(lstColab::add);
        index=1;
        while (index != 0) {
            System.out.printf("%n%s%n","Lista de Colaboradores:");
            for (Colaborador colab : lstColab)
                System.out.printf("#%d - %s%n", index++, colab.toString());
            index = Console.readInteger("Selecione o supervisor do Colaborador (0 - fim): ");

            if (index > 0 && index - 1 < lstFunc.size()) {
                controller.defineSupervisor(lstColab.get(index-1));
                index=0;
                if (lstColab.isEmpty())
                    index = 0;
            }else {System.out.println("Opção inválida");}
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