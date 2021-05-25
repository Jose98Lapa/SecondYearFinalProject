package eapli.base.ticket.DTO;

import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.representations.dto.DTOParser;

public class TicketDTOParser implements DTOParser<ticketDTO, Ticket> {
    @Override
    public Ticket valueOf(ticketDTO dto) {
        return new TicketBuilder().withId(dto.id).withPossibleFile(dto.file ).withStatus(dto.status).solicitedOn(dto.solicitedOn).withUrgency(dto.urgency ).withDeadLine(dto.deadLine).build();
    }
}
