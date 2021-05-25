package eapli.base.ticket.domain;

import eapli.base.ticket.DTO.ticketDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author 1190731
 */
@Entity
public class Ticket implements AggregateRoot<TicketID>, DTOable<ticketDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    private LocalDate solicitedOn,deadLine;
    @EmbeddedId
    private TicketID id;
    private TicketStatus status;
    private AttachedFile ficheiro;
    private Urgencia urgencia;

    public Ticket( LocalDate solicitedOn, LocalDate deadLine, TicketID id, TicketStatus status, AttachedFile ficheiro, Urgencia urgencia) {
        this.solicitedOn = solicitedOn;
        this.deadLine = deadLine;
        this.id = id;
        this.status = status;
        this.ficheiro = ficheiro;
        this.urgencia = urgencia;
    }

    protected Ticket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(solicitedOn, ticket.solicitedOn) && Objects.equals(deadLine, ticket.deadLine) && Objects.equals(id, ticket.id) && Objects.equals(status, ticket.status) && Objects.equals(ficheiro, ticket.ficheiro) && Objects.equals(urgencia, ticket.urgencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitedOn, deadLine, id, status, ficheiro, urgencia);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public TicketID identity() {
        return id;
    }

    @Override
    public ticketDTO toDTO() {
        return new ticketDTO(solicitedOn.toString(),deadLine.toString(),id.toString(),status.toString(),ficheiro.toString(),urgencia.toString());
    }


}
