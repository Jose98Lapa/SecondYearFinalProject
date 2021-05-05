package eapli.base.catalog.application;

import eapli.base.catalog.domain.AccessCriteriaFormat;
import eapli.base.catalog.domain.Catalog;
import eapli.base.catalog.domain.CatalogBuilder;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.catalog.repositories.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import java.util.Map;

public class CreateCatalogController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamTypeRepository teamTypeRepo = PersistenceContext.repositories().teamTypes();
    private final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
    private final CatalogRepository catalogRepo = PersistenceContext.repositories().catalogs();
    private final CatalogBuilder catalogBuilder = new CatalogBuilder();

    public void method(String id, String title, String icone, String briefDesc, String completeDesc){
        authz.ensureAuthenticatedUserHasAnyOf();
        catalogBuilder.withIdentity(id).withTitle(title).withIcon(icone)
                .withBriefDesc(briefDesc).withCompleteDesc(completeDesc);
    }

    public Iterable<TeamType> getTeamType(){
        return teamTypeRepo.findAll();
    }

    public void defineAccessCriteria(Map<Integer, AccessCriteriaFormat> lstAccessCriteria){
        catalogBuilder.withAccessCriteria(lstAccessCriteria);
    }

    public Iterable<Collaborator> getCollabs(){
        return collabRepo.findAll();
    }

    public void defineResponsibleCollaborator(MecanographicNumber mecanographicNumber){
        catalogBuilder.withResponsibleCollaborator(mecanographicNumber);
    }

    public Catalog registerCatalog(){
        return catalogBuilder.build();
    }

    public void saveCatalog(Catalog catalog){
        catalogRepo.save(catalog);
    }


}
