package eapli.base.service.DTO;

import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.form.repository.FormRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.domain.Service;
import eapli.base.service.builder.ServiceBuilder;
import eapli.framework.representations.dto.DTOParser;

public class ServiceDTOParser implements DTOParser<ServiceDTO, Service> {
    @Override
    public Service valueOf(ServiceDTO dto) {
        ServiceBuilder svb = new ServiceBuilder();

        return svb.Icon(dto.icon).Id(dto.id).Keywords(dto.keywords).Status(dto.status).Title(dto.title).buildManual();
    }

    public Service valueOfIncomplete(ServiceDTO dto) {
        ServiceBuilder svb = new ServiceBuilder();
        return svb.Title(dto.title).Id(dto.id).buildManual();
    }

    public Service valueOfFormId(final ServiceDTO dto) {
        FormRepository repo = PersistenceContext.repositories().form();
        final Form form = repo.ofIdentity(FormID.valueOf(dto.id))
                .orElseThrow(() -> new IllegalArgumentException("Formulario desconhecido: " + dto.id));

        Service service = valueOf(dto);
        return service;
    }
}
