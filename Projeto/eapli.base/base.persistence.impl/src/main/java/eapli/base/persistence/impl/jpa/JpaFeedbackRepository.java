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


}
