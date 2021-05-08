package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.CatalogBuilder;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.dto.CatalogoDTOParser;
import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.criticidade.dto.CriticidadeDTOParser;
import eapli.base.criticidade.repository.ListCriticidadeService;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.DTO.EquipaDTOParser;
import eapli.base.equipa.application.ListEquipaService;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.Set;

public class CreateCatalogController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListEquipaService listEquipasSvc = new ListEquipaService();
    private final ListColaboradorService listCollabsSvc = new ListColaboradorService();
    private final ListCriticidadeService listCriticidadesSvc = new ListCriticidadeService();
    private final CatalogRepository catalogRepo = PersistenceContext.repositories().catalogs();
    private final CatalogBuilder catalogBuilder = new CatalogBuilder();

    public void insertBasicData(String identificadorUnico, String title, String icone, String briefDesc, String completeDesc){
        //authz.ensureAuthenticatedUserHasAnyOf();
        catalogBuilder.withIdentity(identificadorUnico).withTitle(title).withIcon(icone)
                .withBriefDesc(briefDesc).withCompleteDesc(completeDesc);
    }

    public Iterable<EquipaDTO> getTeams(){
        return listEquipasSvc.allTeams();
    }

    public void defineAccessCriteria(Set<EquipaDTO> dtos){
        final Set<Equipa> accessCriteria = new HashSet<>();
        dtos.forEach(dto -> accessCriteria.add(new EquipaDTOParser().valueOf(dto)));
        catalogBuilder.withAccessCriteria(accessCriteria);
    }

    public Iterable<ColaboradorDTO> getCollabs(){
        return listCollabsSvc.colaboradores();
    }

    public void defineResponsibleCollaborator(Set<ColaboradorDTO> dtos){
        final Set<Colaborador> responsableCollabs = new HashSet<>();
        dtos.forEach(dto -> responsableCollabs.add(new ColaboradorDTOParser().valueOf(dto)));
        catalogBuilder.withResponsableCollabs(responsableCollabs);
    }

    public Iterable<CriticidadeDTO> getCriticidades(){
        return listCriticidadesSvc.criticidades();
    }

    public void defineCriticidade(CriticidadeDTO dto){
        Criticidade criticidade = new CriticidadeDTOParser().valueOf(dto);
        catalogBuilder.withNivelCriticidade(criticidade);
    }

    public CatalogoDTO registerCatalog(){
        return catalogBuilder.build().toDTO();
    }

    public void saveCatalog(CatalogoDTO dto){
        catalogRepo.save(new CatalogoDTOParser().valueOf(dto));
    }

}
