package eapli.base.ticket.builder;

import eapli.base.ticket.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;

public class TicketBuilder implements DomainFactory<Ticket> {
    private LocalDate solicitedOn,deadLine;
    private TicketID id;
    private TicketStatus status;
    private FicheiroAnexado ficheiro;
    private Urgencia urgencia;

    public TicketBuilder withSolicitedOn(String solicitedOn) {
        this.solicitedOn = LocalDate.parse(solicitedOn);
        return this;
    }

    public TicketBuilder withDeadLine(String deadLine) {
        this.deadLine = LocalDate.parse(deadLine);
        return this;

    }

    public TicketBuilder withId(String id) {
        this.id =TicketID.valueOf(id);
        return this;

    }

    public TicketBuilder withStatus(String status) {
        this.status = TicketStatus.valueOf(status);
        return this;

    }

    public TicketBuilder withFicheiro(String ficheiro) {
        this.ficheiro = FicheiroAnexado.valueOf(ficheiro);
        return this;

    }

    public TicketBuilder withUrgencia(String urgencia) {
        this.urgencia = Urgencia.valueOf(urgencia);
        return this;

    }

    @Override
    public Ticket build(){
        return new Ticket(solicitedOn,  deadLine,  id,  status,  ficheiro,  urgencia);
    }

}
