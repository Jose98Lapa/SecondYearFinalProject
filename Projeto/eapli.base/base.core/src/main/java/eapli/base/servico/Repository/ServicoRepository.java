package eapli.base.servico.Repository;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ServicoRepository extends DomainRepository<ServicoID, Servico> {
    Optional<Servico> findByServicoID(ServicoID number);
    Iterable<Servico> incompleteServico();
   // Servico getServicoById(String id);
    }
