package eapli.base.colaborador.repositories;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.MecanographicNumber;
import eapli.framework.domain.repositories.DomainRepository;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber, Colaborador> {

    Iterable<Colaborador> findAll();
}
