package eapli.base.app.user.console.presentation.ConsultarServicosUI;

import eapli.base.catalogo.application.ConsultarServicosController;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ConsultarServicosUI extends AbstractUI {
    ConsultarServicosController consultarServicosController = new ConsultarServicosController();
    @Override
    protected boolean doShow() {
        int tipo = 0;
        String valor = "";

        List<ServicoDTO> servicoDTOList = consultarServicosController.procuraServico(tipo,valor);
        for (ServicoDTO servicoDTO:servicoDTOList){
            System.out.println(servicoDTO);
        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Servicos";
    }
}
