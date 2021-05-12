package eapli.base.persistence.impl.jpa;


import eapli.base.teamType.Domain.TeamType;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.domain.Acronym;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.base.team.repositories.TeamRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.Optional;

public class JpaTeamRepository extends JpaAutoTxRepository<Team, TeamID, TeamID> implements TeamRepository {
    public JpaTeamRepository(TransactionalContext tx) {
        super(tx,"EquipaID");
    }

    public JpaTeamRepository(String persistenceUnitName) {
        super(persistenceUnitName, "EquipaID");
    }

    @Override
    public Optional<Team> ofIdentity(TeamID id) {
        final TypedQuery<Team> q = createQuery("SELECT e FROM eapli.base.team.domain.Team e WHERE e.teamID=:id", Team.class);
        q.setParameter("id",id);
        return q.getResultStream().findFirst();
    }

    @Override
    public boolean isAcronimoValid(Acronym acronym) {
        final TypedQuery<Long> q = createQuery("SELECT COUNT(*)  FROM eapli.base.team.domain.Team e WHERE e.acronym = :id",Long.class);
        q.setParameter("id", acronym);
        Long count=q.getResultStream().findFirst().get();
        return count==0;
    }

    @Override
    public boolean canIAddTheColaborador(Collaborator collaborator, TeamType teamType) {
        final TypedQuery<Team> q = createQuery("SELECT e FROM eapli.base.team.domain.Team e WHERE e.teamType=:id", Team.class);
        q.setParameter("id", teamType);
        for (Iterator<Team> it = q.getResultStream().iterator(); it.hasNext(); ) {
            Team team = it.next();
            if (team.containsResponsavel(collaborator)){
                return false;
            }
        }
        return true;
    }
}
