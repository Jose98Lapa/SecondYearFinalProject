package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;

    public class InMemoryServiceRepository
            extends InMemoryDomainRepository<Servico, ServicoID>
            implements ServicoRepository {

        static {
            InMemoryInitializer.init();
        }

        @Override
        public Optional<Servico> findByServicoID(ServicoID number) {
            return Optional.of(data().get(number));
        }

        @Override
        public Iterable<Servico> incompleteServico() {
            return null;
        }

        @Override
        public void ativar(String servicoId) {

        }

        @Override
        public void desativar(String servicoId) {

        }

        @Override
        public List<Servico> getServicoListByCatalogo(Catalogo catalogo) {
            return null;
        }

    }
