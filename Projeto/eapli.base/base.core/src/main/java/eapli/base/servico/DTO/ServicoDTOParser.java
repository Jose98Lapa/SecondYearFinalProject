package eapli.base.servico.DTO;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.framework.representations.dto.DTOParser;

public class ServicoDTOParser implements DTOParser<ServicoDTO, Servico> {
    @Override
    public Servico valueOf(ServicoDTO dto) {
        ServicoBuilder svb = new ServicoBuilder();
        return svb.Icon(dto.icon).Id(dto.id).Keywords(dto.keywords).Status(dto.status).Title(dto.title).buildManual();
    }

    public Servico valueOfIncomplete(ServicoDTO dto) {
        ServicoBuilder svb = new ServicoBuilder();
        return svb.Title(dto.title).Id(dto.id).buildManual();
    }
}
