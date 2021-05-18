package eapli.base.catalogue.application;


import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.team.application.TeamListService;


import java.util.*;

public class CheckServiceListService {
    List<Catalogue> catalogueList = new ArrayList<>();
    private String query = "Select e From eapli.base.service.domain.Service e where e.catalogue =: catalogue";
    ServiceListService serviceListService = new ServiceListService();

    public void getCompatibleCatalogueOfACollaborator(String collaboratorEmail) {
        TeamListService teamListService = new TeamListService();
        ListCatalogueService catalogueService = new ListCatalogueService();

        ListCollaboratorService collaboratorService = new ListCollaboratorService();

        this.catalogueList = catalogueService.allCompatibleCatalogo(teamListService.getACollaboratorTeams(collaboratorService.getCollaboratorByEmail(collaboratorEmail)));
    }


    public Map<CatalogueDTO, List<ServiceDTO>> getServicesDTO(String value, int parameter) {
        Map<CatalogueDTO, List<ServiceDTO>> catalogueDTOListHashMap = new HashMap<>();
        switch (parameter) {
            case 1 -> {
                query += " and e.title =: parameter";
                for (Catalogue catalogue : catalogueList) {
                    catalogueDTOListHashMap.put(catalogue.toDTO(), serviceListService.getServiceDTOByCatalogueAndTitle(catalogue, query, value));
                }
            }
            case 2 -> {
                query += " and e.id =:parameter";
                for (Catalogue catalogue : catalogueList) {
                    catalogueDTOListHashMap.put(catalogue.toDTO(), serviceListService.getServiceDTOByCatalogueAndID(catalogue, query, value));
                }
            }
            case 3 -> {
                query += " and e.status =:parameter";
                for (Catalogue catalogue : catalogueList) {
                    catalogueDTOListHashMap.put(catalogue.toDTO(), serviceListService.getServiceDTOByCatalogueAndStatus(catalogue, query, value));
                }
            }
        }
        return catalogueDTOListHashMap;
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServicesDTO() {
        Map<CatalogueDTO, List<ServiceDTO>> catalogueDTOListHashMap = new HashMap<>();
        for (Catalogue catalogue : catalogueList) {
            catalogueDTOListHashMap.put(catalogue.toDTO(), serviceListService.getServiceDTOByCatalogue(catalogue, query));
        }
        return catalogueDTOListHashMap;
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServicesDTO(Set<String> keywords) {
        Map<CatalogueDTO, List<ServiceDTO>> catalogueDTOListHashMap = getServicesDTO();
        for (Map.Entry<CatalogueDTO, List<ServiceDTO>> catalogueDTOListEntry : catalogueDTOListHashMap.entrySet()) {

            List<ServiceDTO> serviceDTOList = catalogueDTOListEntry.getValue();
            for (ServiceDTO serviceDTO : serviceDTOList) {
                boolean remove = true;
                for (String keyword : serviceDTO.keywords) {
                    if (keywords.contains(keyword)) {
                        remove = false;
                        break;
                    }
                }
                if (remove) {
                    serviceDTOList.remove(serviceDTO);
                    if (serviceDTOList.size()==0) break;

                }
            }
            catalogueDTOListEntry.setValue(serviceDTOList);

        }
        return catalogueDTOListHashMap;

    }


}
