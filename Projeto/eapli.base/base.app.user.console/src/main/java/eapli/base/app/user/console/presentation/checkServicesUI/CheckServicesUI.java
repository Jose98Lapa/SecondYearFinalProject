package eapli.base.app.user.console.presentation.checkServicesUI;

import eapli.base.catalogue.application.CheckServicesController;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CheckServicesUI extends AbstractUI {
    CheckServicesController checkServicesController = new CheckServicesController();

    @Override
    protected boolean doShow() {
        checkServicesController.getCollaboratorCatalogues();


        int type = Console.readInteger("Insira 1 para o titulo\nInsira 2 para o ID\nInsira 3 para procurar por status\nInsira 4 para procurar por keywords\nInsira 5 para mostrar todos");
        while (type < 1 || type > 5) {
            type = Console.readInteger("Insira 1 para o titulo\nInsira 2 para o ID\nInsira 3 para procurar por status\nInsira 4 para procurar por keywords\nInsira 5 para mostrar todos");
        }
        Map<CatalogueDTO, List<ServiceDTO>> catalogueDTOListHashMap;
        switch (type) {
            case 1 -> {
                String title = Console.readLine("Insira o título a procurar");
                catalogueDTOListHashMap = checkServicesController.getServiceDTOByTitle(title);
            }
            case 2 -> {
                String id = Console.readLine("Insira o ID a procurar");
                catalogueDTOListHashMap = checkServicesController.getServiceDTOById(id);
            }
            case 3 -> {
                String status = Console.readLine("Insira o status a procurar");
                catalogueDTOListHashMap = checkServicesController.getServiceDTOByStatus(status);
            }
            case 4 -> {
                boolean continueLooping = true;
                Set<String> keywordSet = new HashSet<>();
                while (continueLooping) {
                    keywordSet.add(Console.readLine("Insira a keyword a procurar"));
                    continueLooping = Console.readBoolean("Deseja continuar a escrever?(s/n)");
                }
                catalogueDTOListHashMap = checkServicesController.getServiceDTOByKeywords(keywordSet);
            }
            default -> catalogueDTOListHashMap = checkServicesController.getServiceDTO();
        }
        int position = 0;
        List<ServiceDTO> listServiceDTO = new ArrayList<>();

        try {
            for (CatalogueDTO catalogueDTO : catalogueDTOListHashMap.keySet()) {
                if (catalogueDTOListHashMap.get(catalogueDTO).size()>0){
                    System.out.println(catalogueDTO);
                    for (ServiceDTO serviceDTO : catalogueDTOListHashMap.get(catalogueDTO)) {
                        listServiceDTO.add(serviceDTO);
                        if (serviceDTO.status.equals("INCOMPLETO")) {
                            System.out.printf("O servico com o ID %s estará brevemente disponivel\n", serviceDTO.id);
                        } else if (serviceDTO.status.equals("ATIVO")) {
                            System.out.println(position + "-> " + serviceDTO.id + " " + serviceDTO.title);
                        }

                    }
                }
            }
            if (catalogueDTOListHashMap.size()>0){
                System.out.println();
                boolean continueLooping = true;
                ServiceDTO serviceDTO;
                int solution;
                while (continueLooping){
                    solution = Console.readInteger("Insira o Serviço pelo qual pretenda mais informações");
                    if (solution>=0&&solution<=position){
                        continueLooping = false;
                    }
                }
                serviceDTO = listServiceDTO.get(position);
                System.out.println(serviceDTO);
            }
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Consultar Servicos";
    }
}
