package eapli.base.ticket.application;


import eapli.base.Application;
import eapli.base.catalogue.application.ListCatalogueService;
import eapli.base.catalogue.domain.Catalogue;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.catalogue.dto.CatalogueDTOParser;
import eapli.base.collaborator.application.ListCollaboratorService;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.dasboard.application.TcpClient;
import eapli.base.form.DTO.FormDTO;
import eapli.base.form.DTO.FormDTOParser;
import eapli.base.form.application.FormService;
import eapli.base.form.domain.Form;
import eapli.base.form.domain.FormID;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.service.Application.ServiceListService;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.service.DTO.ServiceDTOParser;
import eapli.base.service.domain.Service;
import eapli.base.team.application.TeamListService;
import eapli.base.team.domain.Team;
import eapli.base.ticket.DTO.TicketDTO;
import eapli.base.ticket.builder.TicketBuilder;
import eapli.base.ticket.domain.Constants;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.domain.TicketWorkflow;
import eapli.base.ticket.repository.TicketRepository;
import eapli.base.ticketTask.application.TicketTaskService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import gramatica.formulario.GramaticaFormulario;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CreateTicketController {

	private final TicketBuilder builder;
	private final TicketRepository ticketRepository;
	private Service service;
	private TicketService ticketService = new TicketService();
	private TcpClient tcpClient;

	public CreateTicketController ( ) {

		this.builder = new TicketBuilder( );
		ticketRepository = PersistenceContext.repositories( ).tickets( );
		tcpClient = new TcpClient( );
	}

	public List< CatalogueDTO > requestableCatalogues ( ) {

		ListCatalogueService catalogueService = new ListCatalogueService( );
		ListCollaboratorService listCollaboratorService = new ListCollaboratorService( );
		TeamListService teamListService = new TeamListService( );

		String email = getEmail( );
		Collaborator currentColaborator = listCollaboratorService.getCollaboratorByEmail( email );
		Set< Team > teams = teamListService.getACollaboratorTeams( currentColaborator );

		return catalogueService.requestableCataloguesByTeams( teams );
	}

	private String getEmail ( ) {

		AuthorizationService authorizationService = AuthzRegistry.authorizationService( );
		return authorizationService
				.session( )
				.get( )
				.authenticatedUser( )
				.email( )
				.toString( );
	}

	public List< ServiceDTO > getServicesByCatalogue ( CatalogueDTO chosenCatalogueDTO ) {

		ServiceListService servicesService = new ServiceListService( );
		Catalogue chosenCatalogue = new ListCatalogueService().getCatalogueByID(chosenCatalogueDTO.identity);
		return servicesService.getServiceDTOListByCatalogue( chosenCatalogue );

	}

	public void selectService ( ServiceDTO selectedService ) {

		this.service = new ServiceListService().getServiceByID(selectedService.id);
		this.builder.withService( service );
	}

	public boolean answeringForm ( FormDTO formDTO ) {

		Form form = new FormDTOParser( ).valueOf( formDTO );
		File script =ticketService.getFIleFromServer(service.form());
		String type = Application.settings().getGRAMMARFORMTYPE();
		boolean result;
		if( type.equals("VISITOR")){
			result=GramaticaFormulario.parseWithVisitor(script.getName(), form).equals("");
		}else{
			result=GramaticaFormulario.parseWithListener(script.getName(), form).equals("");
		}
		script.delete();
		this.builder.withForm( form );

		return result;
	}

	public boolean createTicket ( TicketDTO ticketDTO, boolean confirmation ) {

		Service service = new ServiceListService().getServiceByID( ticketDTO.serviceDTO.id );
		Ticket ticket = builder
				.solicitedOn( ticketDTO.solicitedOn )
				.withDeadLine( ticketDTO.deadLine )
				.completedOn( ticketDTO.completedOn )
				.withStatus( confirmation ? Constants.PENDING : Constants.INCOMPLETE )
				.withPossibleFile( ticketDTO.file )
				.withService(service)
				.withUrgency( ticketDTO.urgency )
				.requestedBy( ticketDTO.requestedBy )
				.build( );

		Ticket persistedTicket = this.ticketRepository.save( ticket );

		if ( confirmation ) {

			this.tcpClient.startConnection( Application.settings().getIpWorkflow() );
			this.tcpClient.dispatchTicket( persistedTicket.identity() );
			this.tcpClient.stopConnection();
		}

		return true;
	}

	public boolean finishTicket ( TicketDTO ticketDTO, boolean confirmation ) {

		Service service = new ServiceListService().getServiceByID( ticketDTO.serviceDTO.id );
		Ticket remote = ticketRepository.ofIdentity( ticketDTO.id ).get();

		Ticket ticket = builder
				.solicitedOn( ticketDTO.solicitedOn )
				.withDeadLine( ticketDTO.deadLine )
				.completedOn( ticketDTO.completedOn )
				.withStatus( confirmation ? Constants.PENDING : Constants.INCOMPLETE )
				.withPossibleFile( ticketDTO.file )
				.withForm( remote.ticketForm( ) )
				.withService( service )
				.withService(service)
				.withUrgency( ticketDTO.urgency )
				.requestedBy( ticketDTO.requestedBy )
				.build( );

		Ticket persistedTicket = this.ticketRepository.save( ticket );

		if ( confirmation ) {

			this.tcpClient.startConnection( Application.settings().getIpWorkflow() );
			this.tcpClient.dispatchTicket( persistedTicket.identity() );
			this.tcpClient.stopConnection();
		}

		return true;
	}


	public List< TicketDTO > incompleteTickets ( ) {

		String email = getEmail( );
		List< Ticket > ticketList = ticketRepository.getIncomplete();
		List< TicketDTO > dtoList = ticketList
				.stream()
				.filter( ticket -> ticket.requestedBy().equals( email ) )
				.map( Ticket::toDTO )
				.collect( Collectors.toList() );

		return dtoList;
	}

	public FormDTO getFormDTOByID ( String ID ) {

		return ( new FormService( ).getFormFromID( FormID.valueOf( ID ) ).toDTO( ) );
	}

}
