package eapli.base.criticality.repository;

import eapli.base.criticality.domain.ApprovalObjective;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.ResolutionObjective;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CriticalityRepository extends DomainRepository<Long, Criticality> {

    Iterable<Criticality> findAll();

    Iterable<Criticality> findAllGlobal();

    Optional<ApprovalObjective> ofApprovalObjective(String tempoMaximoA, String tempoMedioA);


    Optional<ResolutionObjective> ofResolutionObjective(String tempoMaximoR, String tempoMedioR);

}
