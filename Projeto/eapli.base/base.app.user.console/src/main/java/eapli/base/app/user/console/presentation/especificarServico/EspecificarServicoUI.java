package eapli.base.app.user.console.presentation.EspecificarServico;

import eapli.base.app.user.console.presentation.formulario.FormularioUI;
import eapli.base.servico.Application.EspecificarServicoController;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarServicoUI.class);

    private final EspecificarServicoController theController = new EspecificarServicoController();

    @Override
    protected boolean doShow() {
        final ServicoDataWidget ifo = new ServicoDataWidget();
        System.out.println("Insira a informação necessária para o servico");
        ifo.show();
        String s=" ";
        Set<String> keys = new HashSet<>();
        s = (Console.readLine("Keyword - Exit to stop"));
        while (!(s.equalsIgnoreCase("Exit"))) {
            s= Console.readLine("Keyword - Exit to stop");
            keys.add(s);
        }
        if (ifo.id().equalsIgnoreCase("none") || ifo.title().equalsIgnoreCase("none")) {
            System.out.println("O id e o titulo sao obrigatórios");
            return false;
        } else {
            ServicoDTO dto = new ServicoDTO(ifo.title(), ifo.id(),ifo.icon(), keys,"INATIVO" , ifo.type(),ifo.briefDesc(),ifo.compDesc());
            theController.registo(dto);
        }

        if (ifo.type().equalsIgnoreCase("AUTOMATICO")){
            String script = Console.readLine("Script:");
            theController.automatic(script);
        }else {
            FormularioUI servicoUi = new FormularioUI();
            servicoUi.show();
            theController.manual(servicoUi.formId);
        }
        theController.confirms();

        return true;
    }

    @Override
    public String headline() {
        return "Especificar Servico";
    }

}
