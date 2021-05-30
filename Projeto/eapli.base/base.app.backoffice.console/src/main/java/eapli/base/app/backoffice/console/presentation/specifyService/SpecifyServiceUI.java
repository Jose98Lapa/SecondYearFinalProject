package eapli.base.app.backoffice.console.presentation.specifyService;

import eapli.base.app.backoffice.console.presentation.SFTPClient;
import eapli.base.app.backoffice.console.presentation.form.FormUI;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.service.Application.SpecifyServiceController;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SpecifyServiceUI extends AbstractUI {
    //private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarServicoUI.class);

    private final SpecifyServiceController theController = new SpecifyServiceController();

    @Override
    protected boolean doShow() {
        final ServiceDataWidget ifo = new ServiceDataWidget();
        System.out.println("Escolha um catalogo para adicionar o servico criado");
        int i = 0;
        boolean incomplete = false;
        ServiceDTO dto;
        ArrayList<CatalogueDTO> catalogos = theController.catalogList();

        try {
            for (CatalogueDTO cat : theController.catalogList()) {
                System.out.println("-------------------------------- | Index : " + i++ + " | -------------------------------------------");
                System.out.printf("%s - %s - %s%n",cat.catalogTitle, cat.briefDesc , cat.nivelCriticidade.label);
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
                    ifo.icon = null;
                    incomplete = true;
                }
                if (ifo.title().equalsIgnoreCase("none")) {
                    ifo.title = null;
                    incomplete = true;
                }
                if (ifo.briefDesc().equalsIgnoreCase("none")) {
                    ifo.briefDesc = null;
                    incomplete = true;
                }
                if (ifo.compDesc().equalsIgnoreCase("none")) {
                    ifo.compDesc = null;
                    incomplete = true;
                }
                if (incomplete) {
                    dto = new ServiceDTO(ifo.title(), ifo.id(), ifo.icon(), keys, "INCOMPLETO", ifo.type(), ifo.briefDesc(), ifo.compDesc(), catalogos.get(Integer.parseInt(index)), null,null);
                } else {
                    dto = new ServiceDTO(ifo.title(), ifo.id(), ifo.icon(), keys, "INATIVO", ifo.type(), ifo.briefDesc(), ifo.compDesc(), catalogos.get(Integer.parseInt(index)), null,null);
                }
               theController.create(dto);
            }

            if (ifo.type().equalsIgnoreCase("AUTOMATICO")) {
                System.out.println("Script");
                SFTPClient sftp = new SFTPClient();
                theController.automatic(sftp.choseAndUploadScript(ifo.id));
            } else if (ifo.type().equalsIgnoreCase("MANUAL")) {
                FormUI servicoUi = new FormUI();
                servicoUi.show();
                theController.manual(servicoUi.formId);
            }
            theController.confirms();
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Servico";
    }

}

