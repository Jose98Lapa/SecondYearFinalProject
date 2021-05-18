package eapli.base.catalogue.application;

import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.team.application.TeamListService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.*;

public class CheckServicesController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CheckServiceListService checkServiceListService = new CheckServiceListService();

    public void getCollaboratorCatalogues() {
        String email = authz.session().get().authenticatedUser().email().toString();
        checkServiceListService.getCompatibleCatalogueOfACollaborator(email);
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServiceDTO() {
        return checkServiceListService.getServicesDTO();
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServiceDTOByTitle(String title) {
        return checkServiceListService.getServicesDTO(title, 1);
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServiceDTOById(String ID) {
        return checkServiceListService.getServicesDTO(ID, 2);
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServiceDTOByStatus(String status) {
        return checkServiceListService.getServicesDTO(status, 3);
    }

    public Map<CatalogueDTO, List<ServiceDTO>> getServiceDTOByKeywords(Set<String> keywords) {
        return checkServiceListService.getServicesDTO(keywords);
    }

}
