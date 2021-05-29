package eapli.base.app.backoffice.console.presentation.specifyService;

import eapli.base.app.backoffice.console.presentation.SFTPClient;
import eapli.base.app.backoffice.console.presentation.form.FormUI;
import eapli.base.app.backoffice.console.presentation.task.TaskUI;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.service.Application.SpecifyServiceController;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CompleteServiceUI extends AbstractUI {
    //private static final Logger LOGGER = LoggerFactory.getLogger(SpecifyServiceUI.class);

    private final SpecifyServiceController theController = new SpecifyServiceController();

    private ServiceDTO toComplete;
    ArrayList<ServiceDTO> incomplete = new ArrayList();

    @Override
    protected boolean doShow() {
        System.out.println("Lista de Servicos incompletos");
        int i = 0;
        incomplete = theController.getIncomplete();
        if (incomplete.size()==0) {
            System.out.println("Nao existem servicos");
            return false;
        }
        for (ServiceDTO s : incomplete) {
            System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
            System.out.println(s);
            i++;
        }
        String index = Console.readLine("Index");

        toComplete = incomplete.get(Integer.parseInt(index));
        Scanner scanner = new Scanner(System.in);
        String s = "";
            menu();
            s = Console.readLine("O que deseja alterar? - 0 para sair");
            switch (Integer.parseInt(s)) {
                case 1: {
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")) {
                        System.out.println("Para introduzir o Script o servico tem de ser do tipo Automatico");
                    } else {
                        SFTPClient server = new SFTPClient();
                        toComplete.script = server.choseAndUploadScript(toComplete.id);
                        System.out.println("Alterado com sucesso");
                    }
                    theController.update(toComplete);
                    break;

                }
                case 2: {
                /*  String opcao = scanner.nextLine();
                    toComplete.tipo=opcao;
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")&&opcao.equalsIgnoreCase("AUTOMATICO")){
                        System.out.println("O servico foi alterado de Manual para Automatico ");
                        toComplete.tipo="AUTOMATICO";
                    }else if(toComplete.tipo.equalsIgnoreCase("AUTOMATICO")&&opcao.equalsIgnoreCase("MANUAL")){
                        System.out.println("O servico foi alterado de Automatico para Manual ");
                        toComplete.tipo="MANUAL";
                    }else{
                        System.out.println("Alteracao invalida");

                    theController.confirms();
                    break;
                    }*/

                }
                case 3: {
                    toComplete.title = scanner.nextLine();
                    theController.update(toComplete);
                    System.out.println("Alterado com sucesso");
                    break;
                }
                case 4: { //Formulario
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")) {
                        FormUI formUi = new FormUI();
                        formUi.show();
                        theController.updateForm(formUi.formId,toComplete);
                        System.out.println("Alterado com sucesso");
                    } else {
                        System.out.println("Apenas é permitido alterar o Formulario em Servicos do tipo Manual");
                    }
                    break;
                }
                case 5: {
                    SFTPClient server = new SFTPClient();
                    toComplete.icon = server.choseAndUploadImage(toComplete.id);
                    theController.update(toComplete);

                    break;
                }
                case 6: {
                    System.out.println("Escolha um catalogo para adicionar o servico criado");

                    for (CatalogueDTO cat : theController.catalogList()) {
                        System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
                        System.out.println(cat);
                    }
                    String index2 = Console.readLine("Index");
                    toComplete.catalogo = theController.catalogList().get(Integer.parseInt(index2));
                    System.out.println("Alterado com sucesso");

                    theController.update(toComplete);
                    break;

                }
                case 7: {
                    String string = " ";
                    Set<String> keys = new HashSet<>();
                    string = (Console.readLine("Keyword - Exit to stop"));
                    while (!(string.equalsIgnoreCase("Exit"))) {
                        keys.add(string);
                        string = Console.readLine("Keyword - Exit to stop");
                    }
                    keys.remove("Exit");
                    toComplete.keywords.addAll(keys);
                    System.out.println("Alterado com sucesso");

                    theController.update(toComplete);
                    break;
                }
                case 8:{
                    String workflowID = Console.readLine("Insira o id do workflow");
                    List<String> stringList = new ArrayList<>();
                    TaskUI taskUI = new TaskUI();

                    if (Console.readBoolean("Esta atividade requer aprovação")){
                        stringList.add(taskUI.createApprovalTask());
                    }

                    if (Console.readBoolean("A tarefa é manual")){
                        stringList.add(taskUI.createExecutionTask());
                    }else{
                        stringList.add(taskUI.createAutomaticTask());
                    }
                    theController.addWorkflowToService(workflowID,stringList,toComplete);


                }

                case 0: {
                    break;


            }
        }
        return true;
    }

    private void menu() {
        System.out.println("1 - Alterar o Script");
        // System.out.println("2 - Alterar o Tipo");
        System.out.println("3 - Alterar o Titulo");
        System.out.println("4 - Alterar o Formulario");
        System.out.println("5 - Alterar o Icon");
        System.out.println("6 - Alterar o Catalogo");
        System.out.println("7 - Adicionar  Keywords");
        System.out.println("8 - Adicionar Workflow");
    }

    @Override
    public String headline() {
        return "Completar Servico";
    }

}
