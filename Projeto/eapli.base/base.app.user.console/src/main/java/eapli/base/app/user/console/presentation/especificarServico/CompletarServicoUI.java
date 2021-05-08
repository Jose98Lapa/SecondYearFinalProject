package eapli.base.app.user.console.presentation.especificarServico;

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
import java.util.Scanner;
import java.util.Set;

public class CompletarServicoUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarServicoUI.class);

    private final EspecificarServicoController theController = new EspecificarServicoController();

    private ServicoDTO toComplete;
    ArrayList<ServicoDTO> incomplete = new ArrayList();

    @Override
    protected boolean doShow() {
        System.out.println("Lista de Servicos incompletos");
        int i = 0;
        incomplete = theController.getIncomplete();
        for (ServicoDTO s : incomplete) {
            System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
            System.out.println(s);
        }
        String index = Console.readLine("Index");

        toComplete = incomplete.get(Integer.parseInt(index));
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!(s.equalsIgnoreCase("Exit"))) {
            menu();
            s = Console.readLine("O que deseja alterar? - Exit para sair");
            switch (Integer.parseInt(s)) {
                case 1: {
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")) {
                        System.out.println("Para introduzir o Script o servico tem de ser do tipo Automatico");
                    } else {
                        toComplete.script = scanner.nextLine();
                        System.out.println("Alterado com sucesso");
                    }
                }
                case 2: {
        /*            String opcao = scanner.nextLine();
                    toComplete.tipo=opcao;
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")&&opcao.equalsIgnoreCase("AUTOMATICO")){
                        System.out.println("O servico foi alterado de Manual para Automatico ");
                        toComplete.tipo="AUTOMATICO";
                    }else if(toComplete.tipo.equalsIgnoreCase("AUTOMATICO")&&opcao.equalsIgnoreCase("MANUAL")){
                        System.out.println("O servico foi alterado de Automatico para Manual ");
                        toComplete.tipo="MANUAL";
                    }else{
                        System.out.println("Alteracao invalida");
                    }*/

                }
                case 3: {
                    toComplete.title = scanner.nextLine();
                    System.out.println("Alterado com sucesso");
                }
                case 4: { //Formulario
                    if (toComplete.tipo.equalsIgnoreCase("MANUAL")) {
                        FormularioUI formUi = new FormularioUI();
                        formUi.show();
                        theController.registo(toComplete);
                        theController.manual(formUi.formId);
                        System.out.println("Alterado com sucesso");
                    } else {
                        System.out.println("Apenas é permitido alterar o Formulario em Servicos do tipo Manual");
                    }
                }
                case 5: {
                    toComplete.icon = scanner.nextLine();
                }
                case 6: {
                    System.out.println("Escolha um catalogo para adicionar o servico criado");

                    for (CatalogoDTO cat : theController.catalogList()) {
                        System.out.println("-------------------------------- | Index : " + i + " | -------------------------------------------");
                        System.out.println(cat);
                    }
                    String index2 = Console.readLine("Index");
                    toComplete.catalogo = theController.catalogList().get(Integer.parseInt(index2));
                    System.out.println("Alterado com sucesso");

                }
                case 7: {
                    String string = " ";
                    Set<String> keys = new HashSet<>();
                    string = (Console.readLine("Keyword - Exit to stop"));
                    while (!(string.equalsIgnoreCase("Exit"))) {
                        string = Console.readLine("Keyword - Exit to stop");
                        keys.add(string);
                    }
                    toComplete.keywords.addAll(keys);
                    System.out.println("Alterado com sucesso");
                }

            }
        }
        theController.confirms();
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
    }

    @Override
    public String headline() {
        return "Completar Servico";
    }

}
