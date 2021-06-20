package eapli.base.ticket.domain;

import eapli.base.feedback.domain.Feedback;
import eapli.base.form.domain.Form;
import eapli.base.service.domain.Service;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.application.GenerateTicketID;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticketTask.domain.TicketTask;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author 1190731
 */
@Entity
public class Ticket implements AggregateRoot<String>, DTOable<TicketDTO>, Serializable {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    private LocalDate solicitedOn, deadLine, completedOn;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @GenericGenerator(
            name = "ticket_seq",
            strategy = "eapli.base.ticket.application.GenerateTicketID",
            parameters = {@org.hibernate.annotations.Parameter(name = GenerateTicketID.INCREMENT_PARAM, value = "1")})
    private String ID;

    private TicketStatus status;
    private AttachedFile file;
    private Urgency urgency;

    @OneToOne
    private Service service;

    @OneToOne(cascade = CascadeType.ALL)
    private Form ticketForm;

    private TicketWorkflow workflow;

    @Transient
    private TicketBuilder builder;

    @OneToOne
    private Feedback feedback;

    private String requestedBy;


    public Ticket(LocalDate solicitedOn, LocalDate deadLine,
                  TicketStatus status, AttachedFile file,
                  Urgency urgency, Service service, TicketWorkflow workflow,
                  Form ticketForm, String requestedBy ) {

        this.solicitedOn = solicitedOn;
        this.deadLine = deadLine;
        this.completedOn = null;
        this.status = status;
        this.file = file;
        this.urgency = urgency;
        this.service = service;
        this.workflow = workflow;
        this.ticketForm = ticketForm;
        this.requestedBy = requestedBy;
        this.status = new TicketStatus( "PENDING" );
        this.builder = new TicketBuilder();
    }

    protected Ticket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(solicitedOn, ticket.solicitedOn) && Objects.equals(deadLine, ticket.deadLine)
                && Objects.equals(ID, ticket.ID) && Objects.equals(status, ticket.status)
                && Objects.equals(file, ticket.file) && Objects.equals(urgency, ticket.urgency);
    }

    public TicketWorkflow workflow() {
        return workflow;
    }

    public void setWorkflow ( TicketWorkflow ticketWorkflow ) {
        this.workflow = ticketWorkflow;
    }

    public Service service() {
        return service;
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitedOn, deadLine, ID, status, file, urgency);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String identity() {
        return ID;
    }

    public String requestedBy() {
        return requestedBy;
    }

    @Override
    public TicketDTO toDTO() {
        return new TicketDTO(solicitedOn.toString(), deadLine.toString(),
                status.toString(), file.toString(), urgency.toString(), service.toDTO(), requestedBy, identity());
    }

    public LocalDate deadline ( ) {
        return this.deadLine;
    }

    public TicketStatus status() {
        return this.status;
    }

    public void statusPending() {
        status = new TicketStatus("PENDING");
    }

    public void statusWaitingApproval() {
        status = new TicketStatus("WAITING_APPROVAL");
    }

    public void statusApproved() {
        status = new TicketStatus("APPROVED");
    }

    public void statusNotApproved() {
        status = new TicketStatus("NOT_APPROVED");
    }

    public void statusPendingExecution() {
        status = new TicketStatus("PENDING_EXECUTION");
    }

    public void statusExecuting() {
        status = new TicketStatus("EXECUTING");
    }

    public void statusConcluded() {
        status = new TicketStatus("CONCLUDED");
    }

    public void statusFailed() {
        status = new TicketStatus("FAILED");
    }

    public boolean checkIfTicketTaskBelongsToTicket(TicketTask ticketTask) {
        return checkIfTicketTaskBelongsToTicket(ticketTask, this.workflow.starterTask());
    }

    private boolean checkIfTicketTaskBelongsToTicket(TicketTask ticketTask, TicketTask starterTask) {
        if (starterTask == null)
            return false;
        if (starterTask.sameAs(ticketTask)) {
            return true;
        } else {
            if (starterTask.transition() == null)
                return false;
            return checkIfTicketTaskBelongsToTicket(ticketTask, starterTask.transition().nextTask());
        }
    }

    public Form ticketForm() {
        return this.ticketForm;
    }

    public void approveTicket() {
        this.status = TicketStatus.valueOf("APPROVED");
    }

    public void disapproveTicket() {
        this.status = TicketStatus.valueOf("DISAPPROVED");
        this.completedOn = LocalDate.now();
    }

    public void pendingExecutingTicket() {
        this.status = TicketStatus.valueOf("PENDING_EXECUTION");
    }

    public void endTicket() {
        this.status = TicketStatus.valueOf("CONCLUDED");
        this.completedOn = LocalDate.now();
    }

    public int compareBySolicitedOn(Ticket other) {
        return this.solicitedOn.compareTo(other.solicitedOn);
    }

    public String displayInfoForList() {
        String completed;
        if (completedOn!=null){
            completed="Completed on "+completedOn.toString();
        }else{
            completed = "Not Completed yet";
        }
        return "Ticket -> " + "Solicited on " + solicitedOn + ", Deadline " + deadLine + ", " + completed + ", ID '" + ID + '\'' + ", status " + status + ", service " + service.toDTO().title;
    }

    public String displayInfo(){
        return  "Ticket -> "  + "Solicited on " + solicitedOn + ", ID '" + ID  + ", service " + service.toDTO().title;
    }

    public void reviewed(Feedback feedback){
        this.status = TicketStatus.valueOf("REVIEWED");
        this.feedback = feedback;
    }

    public Feedback feedback(){
        return this.feedback;
    }

    public Urgency urgency(){
        return this.urgency;
    }

    public LocalDate solictedOn (){
        return this.solicitedOn;
    }
}
