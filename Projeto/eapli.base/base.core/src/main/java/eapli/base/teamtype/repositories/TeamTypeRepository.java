package eapli.base.teamtype.repositories;

import eapli.base.teamtype.domain.TeamType;
import eapli.base.teamtype.domain.TeamTypeID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface TeamTypeRepository extends DomainRepository<TeamTypeID, TeamType> {

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @param number
     * @return
     */
    default Optional<TeamType> findByTeamTypeID(TeamTypeID number) {
        return ofIdentity(number);
    }


    Iterable<TeamType> findAll();

}
