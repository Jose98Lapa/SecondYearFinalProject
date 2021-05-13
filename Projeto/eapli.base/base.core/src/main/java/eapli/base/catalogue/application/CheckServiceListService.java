package eapli.base.catalogue.application;


import eapli.base.catalogue.domain.Catalogue;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.team.application.TeamListService;
import javassist.compiler.ast.Keyword;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CheckServiceListService {
    List<Catalogue> catalogueList = new ArrayList<>();
    private String query = "Select e From eapli.base.service.domain.Service e where e.catalogue =: catalogue";
    ServiceListService serviceListService = new ServiceListService();

    public void getCompatibleCatalogueOfACollaborator(String collaboratorEmail){
        TeamListService teamListService = new TeamListService();
        ListCatalogueService catalogueService = new ListCatalogueService();

        ListCollaboratorService collaboratorService = new ListCollaboratorService();

        this.catalogueList = catalogueService.allCompatibleCatalogo(teamListService.getACollaboratorTeams(collaboratorService.getCollaboratorByEmail(collaboratorEmail)));
    }


    public List<ServiceDTO> getServicesDTO(String value,int parameter){
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        switch (parameter){
            case 1 -> {
                query += " and e.title =: parameter";
                for (Catalogue catalogue:catalogueList){
                    serviceDTOList.addAll(serviceListService.getServiceDTOByCatalogueAndTitle(catalogue,query,value));
                }
            }
            case 2 -> {
                query += " and e.id =:parameter";
                for (Catalogue catalogue:catalogueList){
                    serviceDTOList.addAll(serviceListService.getServiceDTOByCatalogueAndID(catalogue,query,value));
                }
            }
            case 3 -> {
                query += " and e.status =:parameter";
                for (Catalogue catalogue:catalogueList){
                    serviceDTOList.addAll(serviceListService.getServiceDTOByCatalogueAndStatus(catalogue,query,value));
                }
            }
        }
        return serviceDTOList;
    }

    public List<ServiceDTO> getServicesDTO(){
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        for (Catalogue catalogue:catalogueList){
            serviceDTOList.addAll(serviceListService.getServiceDTOByCatalogue(catalogue,query));
        }
        return serviceDTOList;
    }

    public List<ServiceDTO> getServicesDTO(Set<String> keywords){
        List<ServiceDTO> serviceDTOList = getServicesDTO();
        for (ServiceDTO serviceDTO:serviceDTOList){
            boolean remove = true;
            for (String keyword:serviceDTO.keywords){
                if (keywords.contains(keyword)){
                    remove = false;
                    break;
                }
            }
            if (remove){
                serviceDTOList.remove(serviceDTO);
            }
        }
        return serviceDTOList;

    }




}
