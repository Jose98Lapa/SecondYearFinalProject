package eapli.base.ticket.DTO;


import eapli.base.service.DTO.ServiceDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class TicketDTO {

	public String solicitedOn;
	public String deadLine;
	public String completedOn;
	public String status;
	public String file;
	public String urgency;
	public ServiceDTO serviceDTO;
	public String requestedBy;
	public String id;

	public TicketDTO ( String solicitedOn, String deadLine, String completedOn,
					   String status, String file, String urgency, ServiceDTO serviceID, String requestedBy ) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.completedOn = completedOn;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
		this.serviceDTO = serviceID;
		this.requestedBy = requestedBy;
	}

	public TicketDTO(String solicitedOn, String deadLine, String file, String urgency) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.file = file;
		this.urgency = urgency;
	}

	public TicketDTO(String solicitedOn, String deadLine, String status, String file, String urgency, ServiceDTO serviceDTO,String requestedBy, String ID) {
		this.solicitedOn = solicitedOn;
		this.deadLine = deadLine;
		this.status = status;
		this.file = file;
		this.urgency = urgency;
		this.requestedBy = requestedBy;
		this.serviceDTO = serviceDTO;
		this.id = ID;
	}

	@Override
	public String toString() {
		return "Ticket:\n"+ "DeadLine-> "+deadLine+"\nSolicitatedOn-> "+solicitedOn
				+"\nStatus-> "+status+"\nFile-> "+file+"Urgency-> "+urgency;
	}
}
