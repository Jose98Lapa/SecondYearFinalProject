package eapli.base.colaborador.repositories;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CollaboratorRepository extends DomainRepository<NumeroMecanografico, Colaborador> {

    Iterable<Colaborador> findAll();

    Optional<Colaborador> ofIdentity(NumeroMecanografico id);

    Optional<Colaborador> getColaboradorByEmail(String email);
}
