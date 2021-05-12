package eapli.base.catalogue.application;

import eapli.base.catalogue.builder.CatalogueBuilder;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.criticality.application.CriticalityListService;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.criticality.dto.CriticalityDTOParser;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.DTO.TeamDTOParser;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.Set;

public class CreateCatalogueController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TeamListService listEquipasSvc = new TeamListService();
    private final ListCollaboratorService listCollabsSvc = new ListCollaboratorService();
    private final CriticalityListService listCriticidadesSvc = new CriticalityListService();
    private final CatalogueRepository catalogRepo = PersistenceContext.repositories().catalogs();
    private final CatalogueBuilder catalogueBuilder = new CatalogueBuilder();

    public void insertBasicData( String title, String icone, String briefDesc, String completeDesc){
        //authz.ensureAuthenticatedUserHasAnyOf();
        catalogueBuilder.withTitle(title).withIcon(icone)
                .withBriefDesc(briefDesc).withCompleteDesc(completeDesc);
    }

    public Iterable<TeamDTO> getTeams(){
        return listEquipasSvc.allTeams();
    }

    public void defineAccessCriteria(Set<TeamDTO> dtos){
        final Set<Team> accessCriteria = new HashSet<>();
        dtos.forEach(dto -> accessCriteria.add(new TeamDTOParser().valueOf(dto)));
        catalogueBuilder.withAccessCriteria(accessCriteria);
    }

    public Iterable<CollaboratorDTO> getCollabs(){
        return listCollabsSvc.colaboradores();
    }

    public void defineResponsibleCollaborator(Set<CollaboratorDTO> dtos){
        final Set<Collaborator> responsableCollabs = new HashSet<>();
        dtos.forEach(dto -> responsableCollabs.add(new CollaboratorDTOParser().valueOf(dto)));
        catalogueBuilder.withResponsableCollabs(responsableCollabs);
    }

    public Iterable<CriticalityDTO> getCriticidades(){
        return listCriticidadesSvc.criticidades();
    }

    public void defineCriticidade(CriticalityDTO dto){
        Criticality criticality = new CriticalityDTOParser().valueOf(dto);
        catalogueBuilder.withNivelCriticidade(criticality);
    }

    public CatalogueDTO registerCatalog(){
        return catalogueBuilder.build().toDTO();
    }

    public void saveCatalog(CatalogueDTO dto){
        catalogRepo.save(new CatalogueDTOParser().valueOf(dto));
    }

}
