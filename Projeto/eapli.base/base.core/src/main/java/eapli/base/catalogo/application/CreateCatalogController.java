package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogBuilder;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;
import java.util.Set;

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

    public void defineAccessCriteria(Set<Equipa> accessCriteria){
        catalogBuilder.withAccessCriteria(accessCriteria);
    }

    public Iterable<Colaborador> getCollabs(){
        return collabRepo.findAll();
    }

    public void defineResponsibleCollaborator(Set<Colaborador> responsableCollabs){
        catalogBuilder.withResponsableCollabs(responsableCollabs);
    }

    public Catalogo registerCatalog(){
        return catalogBuilder.build();
    }

    public void saveCatalog(Catalogo catalogo){
        catalogRepo.save(catalogo);
    }

}
