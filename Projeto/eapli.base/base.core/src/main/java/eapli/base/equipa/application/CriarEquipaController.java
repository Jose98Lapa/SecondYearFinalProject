package eapli.base.equipa.application;

import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CriarEquipaController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository= PersistenceContext.repositories().teams();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final EquipaBuilder equipaBuilder = new EquipaBuilder();

    public void registo(EquipaDTO equipaDTO){
        authz.ensureAuthenticatedUserHasAnyOf();
        collaboratorRepository.ofIdentity(NumeroMecanografico.valueOf(equipaDTO.numeroMecanografico));
        Equipa equipa = equipaBuilder.designacao(equipaDTO.descricao).acronimo(equipaDTO.acronimo).equipaID(equipaDTO.equipaID).build();
        equipaRepository.save(equipa);
    }
}
