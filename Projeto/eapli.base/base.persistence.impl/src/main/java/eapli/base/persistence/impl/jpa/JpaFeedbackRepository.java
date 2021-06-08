package eapli.base.persistence.impl.jpa;

import eapli.base.feedback.domain.Feedback;
import eapli.base.feedback.repositories.FeedbackRepository;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class JpaFeedbackRepository extends JpaAutoTxRepository<Feedback, Long, Long> implements FeedbackRepository {
    public JpaFeedbackRepository(TransactionalContext tx) {
        super(tx,"Feedback");
    }

    public JpaFeedbackRepository(String persistenceUnitName) {
        super(persistenceUnitName, "Feedback");
    }

    @Override
    public List<Feedback> getFeedbackBetweenDatesFromACliente(String client, LocalDate localDateStart, LocalDate localDateEnd) {
        final TypedQuery<Feedback> q = createQuery("SELECT e FROM eapli.base.feedback.domain.Feedback e WHERE e.clientEmail=:id and e.dateCreated between :localDateStart and :localDateEnd ", Feedback.class);
        q.setParameter("id",client);
        q.setParameter("localDateStart",localDateStart);
        q.setParameter("localDateEnd",localDateEnd);
        return q.getResultList();
    }
}
