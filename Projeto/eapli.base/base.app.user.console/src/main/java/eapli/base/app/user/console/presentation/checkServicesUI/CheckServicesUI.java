package eapli.base.app.user.console.presentation.checkServicesUI;

import eapli.base.catalogue.application.CheckServicesController;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class CheckServicesUI extends AbstractUI {
    CheckServicesController checkServicesController = new CheckServicesController();
    @Override
    protected boolean doShow() {
        int tipo = Console.readInteger("Insira 1 para o titulo\n Insira 2 para o ID\n Insira 3 para procurar por status\n Insira 4 para mostrar todos");

        String valor = "";
        if (tipo!=4){
            valor = Console.readLine("Insira o valor");
        }

        List<ServiceDTO> serviceDTOList = checkServicesController.procuraServico(tipo,valor);
        for (ServiceDTO serviceDTO : serviceDTOList){
            if (serviceDTO.status.equals("INCOMPLETO")){
                System.out.printf("O servico com o ID %s estará brevemente disponivel\n", serviceDTO.id);
            }else if (serviceDTO.status.equals("ATIVO")){
                System.out.println(serviceDTO);
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Servicos";
    }
}
