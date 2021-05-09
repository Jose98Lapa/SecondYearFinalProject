package eapli.base.app.user.console.presentation.ConsultarServicosUI;

import eapli.base.catalogo.application.ConsultarServicosController;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarServicosUI extends AbstractUI {
    ConsultarServicosController consultarServicosController = new ConsultarServicosController();
    @Override
    protected boolean doShow() {
        int tipo = Console.readInteger("Insira 1 para o titulo\n Insira 2 para o ID\n Insira 3 para procurar por status\n Insira 4 para mostrar todos");

        String valor = "";
        if (tipo!=4){
            valor = Console.readLine("Insira o valor");
        }

        List<ServicoDTO> servicoDTOList = consultarServicosController.procuraServico(tipo,valor);
        for (ServicoDTO servicoDTO:servicoDTOList){
            if (servicoDTO.status.equals("INCOMPLETO")){
                System.out.printf("O servico com o ID %s estará brevemente disponivel\n",servicoDTO.id);
            }else if (servicoDTO.status.equals("ATIVO")){
                System.out.println(servicoDTO);
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Servicos";
    }
}
