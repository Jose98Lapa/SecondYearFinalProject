package eapli.base.criticidade.repository;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.ValorCriticidade;
import eapli.framework.domain.repositories.DomainRepository;

public interface CriticidadeRepository extends DomainRepository<ValorCriticidade, Criticidade> {

    Iterable<Criticidade> findAll();

}
