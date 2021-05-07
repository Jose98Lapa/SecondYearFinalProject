package eapli.base.persistence.impl.inmemory;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.MecanographicNumber;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCollaboratorRepository
        extends InMemoryDomainRepository<Colaborador, MecanographicNumber>
        implements CollaboratorRepository {

    static {
        InMemoryInitializer.init();
    }
/*
    @Override
    public Optional<ClientUser> findByUsername(Username name) {
        //TODO
        return Optional.empty();
    }

    @Override
    public Optional<ClientUser> findByMecanographicNumber(MecanographicNumber number) {
        //TODO
        return Optional.empty();
    }
*/
}
