package eapli.base.collaborator.repositories;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.domain.InstituionalEmail;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.function.domain.Function;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CollaboratorRepository extends DomainRepository<MecanographicNumber, Collaborator> {

    Iterable<Collaborator> findAll();


    Iterable<Collaborator> getCollaboratorsByRole(Function function);


    Optional<Collaborator> ofIdentity(MecanographicNumber id);

    Optional<Collaborator> getColaboradorByEmail(InstituionalEmail email);


}
