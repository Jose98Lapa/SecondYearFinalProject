package eapli.base.catalogue.application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.criticality.application.CriticalityListService;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.criticality.dto.CriticalityDTOParser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.*;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class AssignCriticalityLevelController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListCatalogueService listCatalogueSvc = new ListCatalogueService();
    private final CriticalityListService listCriticidadesSvc = new CriticalityListService();
    private final CatalogueRepository catalogRepo = PersistenceContext.repositories().catalogs();

    public Iterable<CatalogueDTO> getCatalogueLst(){
        return listCatalogueSvc.allCatalogos();
    }

    public Iterable<CriticalityDTO> getCriticalityLst(){
        return listCriticidadesSvc.criticidades();
    }

    public CatalogueDTO changeCriticalityLevel(CatalogueDTO catDto, CriticalityDTO critDto){
        Catalogue temp = new CatalogueDTOParser().valueOf(catDto);
        temp.changeCriticalityLevelTo(new CriticalityDTOParser().valueOf(critDto));
        return temp.toDTO();
    }

    public void saveCatalog(CatalogueDTO dto){
        Optional<Catalogue> catalogueOptional = catalogRepo.ofIdentity(dto.identity);

        if (catalogueOptional.isPresent()) {
            Catalogue catalogue = catalogueOptional.get();
            catalogue.changeCriticalityLevelTo(new CriticalityDTOParser().valueOf(dto.nivelCriticidade));
            catalogRepo.save(catalogue);
        }
    }


}
