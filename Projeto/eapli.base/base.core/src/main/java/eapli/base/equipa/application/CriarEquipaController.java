package eapli.base.equipa.application;

import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CriarEquipaController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository= PersistenceContext.repositories().teams();
    private final EquipaBuilder equipaBuilder = new EquipaBuilder();

    public void registo(String descricao, String acronimo, String equipaID){
        authz.ensureAuthenticatedUserHasAnyOf();
        Equipa equipa = equipaBuilder.designacao(descricao).acronimo(acronimo).equipaID(equipaID).build();
        equipaRepository.save(equipa);
    }
}
