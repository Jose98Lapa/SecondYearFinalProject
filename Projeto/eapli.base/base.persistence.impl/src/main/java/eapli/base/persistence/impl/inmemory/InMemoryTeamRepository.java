package eapli.base.persistence.impl.inmemory;

import eapli.base.teamType.Domain.TeamType;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.domain.Acronym;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.team.repositories.TeamRepository;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;


public class InMemoryTeamRepository extends InMemoryDomainRepository<Team, TeamID>
        implements TeamRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public boolean isAcronimoValid(Acronym acronym) {
        return false;
    }

    @Override
    public boolean canIAddTheColaborador(Collaborator collaborator, TeamType teamType) {
        return false;
    }
}
