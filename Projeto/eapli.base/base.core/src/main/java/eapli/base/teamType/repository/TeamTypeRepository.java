package eapli.base.teamType.repository;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.Domain.TeamTypeID;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamTypeRepository extends DomainRepository<TeamTypeID, TeamType> {
    Iterable<TeamType> findAll();
}
