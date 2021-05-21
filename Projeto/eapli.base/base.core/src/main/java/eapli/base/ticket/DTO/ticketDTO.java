package eapli.base.ticket.DTO;


import eapli.framework.representations.dto.DTO;

@DTO
public class ticketDTO {
    public String solicitedOn;
    public String deadLine;
    public String id;
    public String status;
    public String ficheiro;
    public String urgencia;

    public ticketDTO(String solicitedOn, String deadLine, String id, String status, String ficheiro, String urgencia) {
        this.solicitedOn = solicitedOn;
        this.deadLine = deadLine;
        this.id = id;
        this.status = status;
        this.ficheiro = ficheiro;
        this.urgencia = urgencia;
    }

}
