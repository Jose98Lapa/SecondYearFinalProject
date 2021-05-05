package eapli.base.catalog.application;

import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.catalog.repositories.CatalogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teamtype.repositories.TeamTypeRepository;

public class CreateCatalogController {

    private final TeamTypeRepository teamTypeRepo = PersistenceContext.repositories().teamTypes();
    private final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
    private final CatalogRepository catalogRepo = PersistenceContext.repositories().catalogs();


}
