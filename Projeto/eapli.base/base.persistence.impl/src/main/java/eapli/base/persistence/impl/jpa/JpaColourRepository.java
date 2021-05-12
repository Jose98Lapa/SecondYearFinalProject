package eapli.base.persistence.impl.jpa;

import eapli.base.colour.Domain.Colour;
import eapli.base.colour.Domain.Hexadecimal;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class JpaColourRepository extends JpaAutoTxRepository<Colour, Hexadecimal,Hexadecimal> implements ColourRepository {
    public JpaColourRepository(TransactionalContext tx) {
        super(tx,"CorID");
    }

    public JpaColourRepository(String persistenceUnitName) {
        super(persistenceUnitName, "CorID");
    }


    @Override
    public Optional<Colour> ofIdentity(Hexadecimal id) {
        final TypedQuery<Colour> q = createQuery("Select e From eapli.base.colour.Domain.Colour e where e.hexadecimalValue =:id ", Colour.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst();
    }
}
