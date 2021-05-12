package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.service.Repository.ServiceRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;

    public class InMemoryServiceRepository
            extends InMemoryDomainRepository<Service, ServiceID>
            implements ServiceRepository {

        static {
            InMemoryInitializer.init();
        }

        @Override
        public Optional<Service> findByServicoID(ServiceID number) {
            return Optional.of(data().get(number));
        }

        @Override
        public Iterable<Service> incompleteServico() {
            return null;
        }

        @Override
        public void ativar(String servicoId) {

        }

        @Override
        public void desativar(String servicoId) {

        }

        @Override
        public List<Service> getServicoListByCatalogo(Catalogue catalogue) {
            return null;
        }

        @Override
        public Optional<Form> getFormById(FormID formid) {
            return null;
        }


    }
