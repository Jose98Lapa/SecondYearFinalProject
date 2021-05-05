package eapli.base.collaborator.repositories;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.framework.domain.repositories.DomainRepository;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber, Collaborator> {

    Iterable<Collaborator> findAll();
}
