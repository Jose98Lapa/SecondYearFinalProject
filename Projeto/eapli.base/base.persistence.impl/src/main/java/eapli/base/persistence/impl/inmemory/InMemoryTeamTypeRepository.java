package eapli.base.persistence.impl.inmemory;

import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeID;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryTeamTypeRepository
        extends InMemoryDomainRepository<TeamType, TeamTypeID>
        implements TeamTypeRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<TeamType> findByTeamTypeID(TeamTypeID number) {
        return Optional.of(data().get(number));
    }

}
