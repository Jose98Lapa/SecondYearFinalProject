package eapli.base.persistence.impl.jpa;

import eapli.base.criticality.domain.ApprovalObjective;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.CriticalityValue;
import eapli.base.criticality.domain.ResolutionObjective;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaCriticalityRepository extends JpaAutoTxRepository<Criticality, Long, Long> implements CriticalityRepository {

    public JpaCriticalityRepository(TransactionalContext tx) {
        super(tx,"id");
    }

    public JpaCriticalityRepository(String persistenceUnitName) {
        super(persistenceUnitName, "id");
    }

    public Optional<ApprovalObjective> ofApprovalObjective(String tempoMaximoA, String tempoMedioA) {
        final TypedQuery<ApprovalObjective> q = createQuery("Select e From eapli.base.criticality.domain.ApprovalObjective e where e.tempoMaximoA =:TEMPOMAXIMO and e.tempoMedioA =:TEMPOMEDIO ", ApprovalObjective.class);
        q.setParameter("TEMPOMAXIMO", tempoMaximoA);
        q.setParameter("TEMPOMEDIO", tempoMedioA);
        return q.getResultStream().findFirst();
    }

    public Iterable<Criticality> findAllGlobal() {
        final TypedQuery<Criticality> q = createQuery("Select e From eapli.base.criticality.domain.Criticality e where e.isGlobal =:GLOBAL ", Criticality.class);
        q.setParameter("GLOBAL", true);
        return q.getResultStream().collect(Collectors.toList());
    }

    public Optional<ResolutionObjective> ofResolutionObjective(String tempoMaximoR, String tempoMedioR) {
        final TypedQuery<ResolutionObjective> q = createQuery("Select e From eapli.base.criticality.domain.ResolutionObjective e where e.tempoMaximoR =:TEMPOMAXIMO and e.tempoMedioR =:TEMPOMEDIO ", ResolutionObjective.class);
        q.setParameter("TEMPOMAXIMO", tempoMaximoR);
        q.setParameter("TEMPOMEDIO", tempoMedioR);
        return q.getResultStream().findFirst();
    }

}
