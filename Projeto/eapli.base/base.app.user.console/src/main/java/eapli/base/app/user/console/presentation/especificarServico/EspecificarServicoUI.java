package eapli.base.app.user.console.presentation.EspecificarServico;

import eapli.base.app.user.console.presentation.formulario.FormularioUI;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.servico.Application.EspecificarServicoController;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarServicoUI.class);

    private final EspecificarServicoController theController = new EspecificarServicoController();

    @Override
    protected boolean doShow() {
        final ServicoDataWidget ifo = new ServicoDataWidget();
        System.out.println("Escolha um catalogo para adicionar o servico criado");
        int i = 0;
        boolean incomplete = false;
        ServicoDTO dto;
        ArrayList<CatalogoDTO> catalogos = theController.catalogList();

        for (CatalogoDTO cat : theController.catalogList()) {
            System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
            System.out.println(cat);
        }
        String index = Console.readLine("Index");
        System.out.println("Insira a informação necessária para o servico");
        ifo.show();
        String s = " ";
        Set<String> keys = new HashSet<>();
        s = (Console.readLine("Keyword - Exit to stop"));
        while (!(s.equalsIgnoreCase("Exit"))) {
            keys.add(s);
            s = Console.readLine("Keyword - Exit to stop");
        }
        keys.remove("Exit");
        if (ifo.id().equalsIgnoreCase("none") || ifo.title().equalsIgnoreCase("none")) {
            System.out.println("O id e o titulo sao obrigatórios");
            return false;
        } else {
            if (ifo.icon().equalsIgnoreCase("none")) {
                ifo.icon=null;
                incomplete = true;
            }
            if (ifo.title().equalsIgnoreCase("none")) {
                ifo.title=null;
                incomplete = true;
            }
            if (ifo.briefDesc().equalsIgnoreCase("none")) {
                ifo.briefDesc=null;
                incomplete = true;
            }
            if (ifo.compDesc().equalsIgnoreCase("none")) {
                ifo.compDesc=null;
                incomplete = true;
            }
            if (incomplete){
                dto = new ServicoDTO(ifo.title(), ifo.id(), ifo.icon(), keys, "INCOMPLETO", ifo.type(), ifo.briefDesc(), ifo.compDesc(),catalogos.get(Integer.parseInt(index)) , null);
            }else{
                 dto = new ServicoDTO(ifo.title(), ifo.id(), ifo.icon(), keys, "INATIVO", ifo.type(), ifo.briefDesc(), ifo.compDesc(), catalogos.get(Integer.parseInt(index)), null);
            }
            theController.registo(dto);
        }

        if (ifo.type().equalsIgnoreCase("AUTOMATICO")) {
            String script = Console.readLine("Script:");
            theController.automatic(script);
        } else if (ifo.type().equalsIgnoreCase("MANUAL")) {
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
