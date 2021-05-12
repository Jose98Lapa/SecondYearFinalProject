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
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    public List<ServiceDTO> procuraServico(int parametro, String valor){
        String email = authz.session().get().authenticatedUser().email().toString();
        Optional<Collaborator> optionalColaborador = collaboratorRepository.getColaboradorByEmail(InstituionalEmail.valueOf(email));
        if (optionalColaborador.isPresent()){
            Collaborator collaborator = optionalColaborador.get();
            ListCatalogueService listCatalogueService = new ListCatalogueService();
            TeamListService teamListService = new TeamListService();
            ServiceListService serviceListService = new ServiceListService();
            Set<String> equipaDTO = new HashSet<>();
            teamListService.getEquipasDumColaborador(collaborator).forEach(equipaDTO1 -> equipaDTO.add(equipaDTO1.equipaID));
            List<ServiceDTO> serviceDTOList = new ArrayList<>();
            for (CatalogueDTO catalogueDTO : listCatalogueService.allCompatibleCatalogo(equipaDTO)){
                serviceDTOList.addAll(serviceListService.getServicoDTOByCatalogo(new CatalogueDTOParser().valueOf(catalogueDTO)));
            }
            if (parametro!=4){
                switch (parametro){
                    case 1:
                        serviceDTOList.removeIf(servicoDTO -> !servicoDTO.title.equals(valor));
                        break;
                    case 2:
                        serviceDTOList.removeIf(servicoDTO -> !servicoDTO.id.equals(valor));
                        break;
                    default:
                        serviceDTOList.removeIf(servicoDTO -> !servicoDTO.status.equals(valor));
                }
            }
            return serviceDTOList;
        }else{
            throw new IllegalArgumentException("Colaborador Inválido");
        }
    }

}
