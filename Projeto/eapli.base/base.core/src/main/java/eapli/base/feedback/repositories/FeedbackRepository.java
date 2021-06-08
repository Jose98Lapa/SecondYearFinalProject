package eapli.base.feedback.repositories;


import eapli.base.feedback.domain.Feedback;
import eapli.framework.domain.repositories.DomainRepository;

import java.time.LocalDate;
import java.util.List;

public interface FeedbackRepository extends DomainRepository<Long, Feedback> {
    public List<Feedback> getFeedbackBetweenDatesFromACliente(String client, LocalDate localDateStart,LocalDate localDateEnd);

}
