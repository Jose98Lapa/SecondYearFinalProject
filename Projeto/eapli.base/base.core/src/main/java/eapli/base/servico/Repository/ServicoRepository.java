package eapli.base.servico.Repository;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends DomainRepository<ServicoID, Servico> {
    Optional<Servico> findByServicoID(ServicoID number);
    Iterable<Servico> incompleteServico();

    void ativar(String servicoId);

    void desativar(String servicoId);
    // Servico getServicoById(String id);

    List<Servico> getServicoListByCatalogo(Catalogo catalogo);

    }
