package eapli.base.catalogue.application;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.criticality.application.CriticalityListService;
import eapli.base.criticality.application.SpecifyCriticalityController;
import eapli.base.criticality.builder.CriticalityBuilder;
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

    public CriticalityDTO createNonGlobalCriticalityLevel(CriticalityDTO dto) {
        CriticalityBuilder criticalityBuilder = new CriticalityBuilder();
        return criticalityBuilder.withLabel(dto.label).withValorCriticidade(dto.valorCriticidade).withObjetivoDeAprovacao(dto.tempoMaximoA, dto.tempoMedioA)
                .withObjetivoDeResolucao(dto.tempoMaximoR, dto.tempoMedioR).isGlobal(false).build().toDTO();
    }

    public void saveNonGlobalCriticity(CriticalityDTO dto){
        SpecifyCriticalityController criticalityController = new SpecifyCriticalityController();
        criticalityController.save(dto);
    }

    public void saveCatalog(CatalogueDTO dto){
        Optional<Catalogue> catalogueOptional = catalogRepo.ofIdentity(dto.identity);
        SpecifyCriticalityController criticalityController = new SpecifyCriticalityController();

        if (catalogueOptional.isPresent()) {
            Catalogue catalogue = catalogueOptional.get();
            catalogue.changeCriticalityLevelTo(criticalityController.save(dto.nivelCriticidade));
            catalogRepo.save(catalogue);
        }
    }


}
