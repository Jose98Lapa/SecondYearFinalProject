package eapli.base.app.backoffice.console.presentation.specifyService;


import eapli.base.service.Application.ServiceListService;
import eapli.base.service.Application.SpecifyServiceController;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ToggleService  extends AbstractUI {
    //private static final Logger LOGGER = LoggerFactory.getLogger(FormUI.class);
    private final SpecifyServiceController theController = new SpecifyServiceController();
    ArrayList<ServiceDTO> sservices = new ArrayList<>();

    @Override
    protected boolean doShow() {
        System.out.println("Lista de Servicos");
        int i = 0;
        sservices = new ServiceListService().allServices();
        if (sservices.size()==0) {
            System.out.println("Nao existem servicos");
            return false;
        }
        for (ServiceDTO s : sservices) {
            System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
            System.out.println(s);
            i++;
        }
        String index = Console.readLine("Selecione o index");
        String opt = Console.readLine("Insira 1 para Ativar e 0 para Desativar");

        if (Integer.parseInt(opt)==1){
            theController.activateService(sservices.get(Integer.parseInt(index)));

        }else if (Integer.parseInt(opt)==0){
            theController.deactivateService(sservices.get(Integer.parseInt(index)));
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
