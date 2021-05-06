package eapli.base.servico.DTO;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.builder.ServiceBuilder;
import eapli.framework.representations.dto.DTOParser;

public class ServicoDTOParser implements DTOParser<ServicoDTO, Servico> {
    @Override
    public Servico valueOf(ServicoDTO dto) {
        ServiceBuilder svb = new ServiceBuilder();
        return svb.Icon(dto.icon).Id(dto.id).Keywords(dto.keywords).Status(dto.status).Title(dto.title).build();
    }

    public Servico valueOfIncomplete(ServicoDTO dto) {
        ServiceBuilder svb = new ServiceBuilder();
        return svb.Icon(dto.icon).Id(dto.id).build();
    }
}
