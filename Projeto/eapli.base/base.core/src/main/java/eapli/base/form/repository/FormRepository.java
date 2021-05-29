package eapli.base.form.repository;

import eapli.base.form.DTO.FormDTO;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.service.domain.Service;
import eapli.base.service.domain.ServiceID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface FormRepository extends DomainRepository<FormID, Form> {

	Optional< FormDTO > findByFormID( FormID formID );
}
