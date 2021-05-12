package eapli.base.persistence.impl.inmemory;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.Domain.TeamTypeID;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeamTypeRepository extends InMemoryDomainRepository<TeamType, TeamTypeID> implements TeamTypeRepository {
    static {
        InMemoryInitializer.init();
    }

}
