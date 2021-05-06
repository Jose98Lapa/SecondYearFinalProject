package eapli.base.persistence.impl.jpa;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoID;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

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
}