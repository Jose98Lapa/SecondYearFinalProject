package eapli.base.ticket.DTO;


import eapli.framework.representations.dto.DTO;

@DTO
public class ticketDTO {

	public String solicitedOn;
	public String deadLine;
	public String id;
	public String status;
	public String file;
	public String urgency;

	public ticketDTO ( String solicitedOn, String deadLine, String id, String status, String file, String urgency ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.id = id;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
	}

}
