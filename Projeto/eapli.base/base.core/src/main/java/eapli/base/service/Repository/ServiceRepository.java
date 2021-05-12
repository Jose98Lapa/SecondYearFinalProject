package eapli.base.service.Repository;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends DomainRepository<ServiceID, Service> {
    Optional<Service> findByServicoID(ServiceID number);
    Iterable<Service> incompleteServico();

    void ativar(String servicoId);

    void desativar(String servicoId);
    // Servico getServicoById(String id);

    List<Service> getServicoListByCatalogo(Catalogue catalogue);

    Optional<Form> getFormById(FormID formid);
}
