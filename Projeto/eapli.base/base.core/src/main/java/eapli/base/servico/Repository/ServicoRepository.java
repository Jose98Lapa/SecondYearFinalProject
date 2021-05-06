package eapli.base.servico.Repository;

import eapli.base.servico.Domain.Servico;
import eapli.base.servico.Domain.ServicoID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ServicoRepository extends DomainRepository<ServicoID, Servico> {
    Optional<Servico> findByServicoID(ServicoID number);
}
