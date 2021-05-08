package eapli.base.persistence.impl.jpa;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.net.ServerSocket;
import java.util.Optional;

public class JpaServicoRepository extends JpaAutoTxRepository<Servico, ServicoID,ServicoID> implements ServicoRepository {
    public JpaServicoRepository(TransactionalContext tx) {
        super(tx,"ServicoID");
    }

    public JpaServicoRepository(String persistenceUnitName) {
        super(persistenceUnitName, "ServicoID");
    }

    @Override
    public Optional<Servico> findByServicoID(ServicoID number) {
        return Optional.empty();
    }

    public Iterable<Servico> incompleteServico(){
        final TypedQuery<Servico> q = createQuery("Select e From Servico e where e.status =: status ",Servico.class);
        q.setParameter("status","INCOMPLETE" );
        return q.getResultList();
    }

    @Override
    public void ativar(String servicoId) {
        final TypedQuery<Servico> q = createQuery("Update Servico t SET t.status=:status WHERE t.id=:id",Servico.class);
        q.setParameter("status","ATIVO" );
        q.setParameter("id",servicoId );
    }

    @Override
    public void desativar(String servicoId) {
        final TypedQuery<Servico> q = createQuery("Update Servico t SET t.status=:status WHERE t.id=:id",Servico.class);
        q.setParameter("status","INATIVO" );
        q.setParameter("id",servicoId );
    }

   /* public Servico updateServicoForm(String idServ,String idForm){
        final TypedQuery<Servico> q = createQuery("Update e From Service e where e.Form_FormularioID =: idForm ",Servico.class);
        q.setParameter("idForm",idForm);
        return q.getSingleResult();
    }*/
}