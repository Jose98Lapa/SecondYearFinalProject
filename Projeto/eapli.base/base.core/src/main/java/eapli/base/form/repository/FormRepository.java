package eapli.base.form.repository;

import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.framework.domain.repositories.DomainRepository;

public interface FormRepository extends DomainRepository<FormID, Form> {
}
