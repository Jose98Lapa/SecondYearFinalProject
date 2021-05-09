package eapli.base.persistence.impl.jpa;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.servico.domain.StatusServico;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.TypedQuery;
import java.net.ServerSocket;
import java.util.List;
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

    @Override
    public Optional<Servico> ofIdentity(ServicoID servicoID){
        final TypedQuery<Servico> q = createQuery("Select e From eapli.base.servico.domain.Servico e where e.id =: id ",Servico.class);
        q.setParameter("id", servicoID);
        return q.getResultStream().findFirst();
    }

    public Iterable<Servico> incompleteServico(){
        final TypedQuery<Servico> q = createQuery("Select e From eapli.base.servico.domain.Servico e where e.status =: status ",Servico.class);
        q.setParameter("status", StatusServico.valueOf("INCOMPLETO"));
        return q.getResultList();
    }

    @Modifying
    @Override
    public void ativar(String servicoId) {
        final TypedQuery<Servico> q = createQuery("Update eapli.base.servico.domain.Servico t SET t.status=:status WHERE t.id=:id",Servico.class);
        q.setParameter("status",StatusServico.valueOf("ATIVO"));
        q.setParameter("id",servicoId );
    }

    @Modifying
    @Override
    public void desativar(String servicoId) {
        final TypedQuery<Servico> q = createQuery("Update eapli.base.servico.domain.Servico t SET t.status=:status WHERE t.id=:id",Servico.class);
        q.setParameter("status",StatusServico.valueOf("INATIVO"));
        q.setParameter("id",servicoId );
    }

    @Override
    public List<Servico> getServicoListByCatalogo(Catalogo catalogo) {
        final TypedQuery<Servico> q = createQuery("Select e From eapli.base.servico.domain.Servico e where e.catalogo =: status ",Servico.class);
        q.setParameter("status", catalogo);
        return q.getResultList();
    }



   /* public Servico updateServicoForm(String idServ,String idForm){
        final TypedQuery<Servico> q = createQuery("Update e From Service e where e.Form_FormularioID =: idForm ",Servico.class);
        q.setParameter("idForm",idForm);
        return q.getSingleResult();
    }*/
}