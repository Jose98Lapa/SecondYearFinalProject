package eapli.base.ticket.DTO;

import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.representations.dto.DTOParser;

public class TicketDTOParser implements DTOParser<ticketDTO, Ticket> {
    @Override
    public Ticket valueOf(ticketDTO dto) {
        return new TicketBuilder().withId(dto.id).withFicheiro(dto.ficheiro).withStatus(dto.status).withSolicitedOn(dto.solicitedOn).withUrgencia(dto.urgencia).withDeadLine(dto.deadLine).build();
    }
}
