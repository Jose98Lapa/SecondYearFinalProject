package eapli.base.ticket.DTO;


import eapli.framework.representations.dto.DTO;

@DTO
public class TicketDTO {

	public String solicitedOn;
	public String deadLine;
	public String completedOn;
	public String status;
	public String file;
	public String urgency;
	public String serviceID;
	public String requestedBy;

	public TicketDTO ( String solicitedOn, String deadLine, String completedOn,
					   String status, String file, String urgency, String serviceID, String requestedBy ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.completedOn = completedOn;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
		this.serviceID = serviceID;
		this.requestedBy = requestedBy;
	}

	@Override
	public String toString() {
		return "Ticket:\n"+ "DeadLine-> "+deadLine+"\nSolicitatedOn-> "+solicitedOn
				+"\nStatus-> "+status+"\nFile-> "+file+"Urgency-> "+urgency;
	}
}
