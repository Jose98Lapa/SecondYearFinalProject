package eapli.base.app.user.console.presentation.EspecificarServico;

import eapli.base.app.user.console.presentation.formulario.FormularioUI;
import eapli.base.formulario.application.FormularioController;
import eapli.base.servico.Application.EspecificarServicoController;
import eapli.base.servico.Application.ListServicoService;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class AtivarDesativarServico extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(FormularioUI.class);
    private final EspecificarServicoController theController = new EspecificarServicoController();
    ArrayList<ServicoDTO> sservices = new ArrayList();

    @Override
    protected boolean doShow() {
        System.out.println("Lista de Servicos");
        int i = 0;
        sservices = new ListServicoService().allServices();
        if (sservices.size()==0) {
            System.out.println("Nao existem servicos");
            return false;
        }
        for (ServicoDTO s : sservices) {
            System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
            System.out.println(s);
        }
        String index = Console.readLine("Selecione o index");
        String opt = Console.readLine("Insira 1 para Ativar e 0 para Desativar");
        
        if (Integer.parseInt(opt)==1){
            theController.ativarServico(sservices.get(Integer.parseInt(index)).id);
        }else if (Integer.parseInt(opt)==0){
            theController.desativarServico(sservices.get(Integer.parseInt(index)).id);
        }else {
            System.out.println("Error");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Ativar/Desativar Servico";
    }
}
