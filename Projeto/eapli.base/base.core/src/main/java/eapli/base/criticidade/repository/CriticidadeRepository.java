package eapli.base.criticidade.repository;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.Label;
import eapli.framework.domain.repositories.DomainRepository;

public interface CriticidadeRepository extends DomainRepository<Label, Criticidade> {

    Iterable<Criticidade> findAll();

}
