package eapli.base.persistence.impl.jpa;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.service.domain.ServiceStatus;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaServiceRepository extends JpaAutoTxRepository<Service, ServiceID, ServiceID> implements ServiceRepository {
    public JpaServiceRepository(TransactionalContext tx) {
        super(tx,"ServicoID");
    }

    public JpaServiceRepository(String persistenceUnitName) {
        super(persistenceUnitName, "ServicoID");
    }

    @Override
    public Optional<Service> findByServicoID(ServiceID number) {
        return Optional.empty();
    }

    @Override
    public Optional<Service> ofIdentity(ServiceID serviceID){
        final TypedQuery<Service> q = createQuery("Select e From eapli.base.service.domain.Service e where e.id =: id ", Service.class);
        q.setParameter("id", serviceID);
        return q.getResultStream().findFirst();
    }

    public Iterable<Service> incompleteServico(){
        final TypedQuery<Service> q = createQuery("Select e From eapli.base.service.domain.Service e where e.status =: status ", Service.class);
        q.setParameter("status", ServiceStatus.valueOf("INCOMPLETO"));
        return q.getResultList();
    }

    @Modifying
    @Override
    public void ativar(String servicoId) {
        final TypedQuery<Service> q = createQuery("Update eapli.base.servico.domain.Servico t SET t.status=:status WHERE t.id=:id", Service.class);
        q.setParameter("status", ServiceStatus.valueOf("ATIVO"));
        q.setParameter("id",servicoId );
    }

    @Modifying
    @Override
    public void desativar(String servicoId) {
        final TypedQuery<Service> q = createQuery("Update eapli.base.servico.domain.Servico t SET t.status=:status WHERE t.id=:id", Service.class);
        q.setParameter("status", ServiceStatus.valueOf("INATIVO"));
        q.setParameter("id",servicoId );
    }

    @Override
    public List<Service> getServicoListByCatalogo(Catalogue catalogue) {
        final TypedQuery<Service> q = createQuery("Select e From eapli.base.service.domain.Service e where e.catalogue =: status ", Service.class);
        q.setParameter("status", catalogue);
        return q.getResultList();
    }
    @Override
    public Optional<Form> getFormById(FormID formId) {
        final TypedQuery<Form> q = createQuery("Select e From eapli.base.form.domain.Form e where e.FormID =: formId ", Form.class);
        q.setParameter("formId", formId);
        return q.getResultStream().findFirst();
    }



   /* public Servico updateServicoForm(String idServ,String idForm){
        final TypedQuery<Servico> q = createQuery("Update e From Service e where e.Form_FormularioID =: idForm ",Servico.class);
        q.setParameter("idForm",idForm);
        return q.getSingleResult();
    }*/
}