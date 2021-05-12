package eapli.base.persistence.impl.inmemory;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCollaboratorRepository
        extends InMemoryDomainRepository<Collaborator, MecanographicNumber>
        implements CollaboratorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Collaborator> getColaboradorByEmail(InstituionalEmail email) {
        return Optional.empty();
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
