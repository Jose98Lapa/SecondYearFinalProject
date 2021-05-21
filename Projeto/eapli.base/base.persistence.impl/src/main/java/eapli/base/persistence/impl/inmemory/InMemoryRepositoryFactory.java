package eapli.base.persistence.impl.inmemory;

import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.form.repository.FormRepository;
import eapli.base.function.repositories.FunctionRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}

	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {

		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}


	@Override
	public TeamRepository teams() {

		return teams(null);
	}

	@Override
	public TeamRepository teams(final TransactionalContext tx) {

		return new InMemoryTeamRepository();
	}


	@Override
	public ColourRepository cores() {

		return cores(null);
	}

	@Override
	public ColourRepository cores(final TransactionalContext tx) {

		return new InMemoryColourRepository();
	}


	@Override
	public TeamTypeRepository tiposDeEquipa() {

		return tiposDeEquipa(null);
	}

	@Override
	public TeamTypeRepository tiposDeEquipa(final TransactionalContext tx) {

		return new InMemoryTeamTypeRepository();
	}


	@Override
	public CriticalityRepository criticidades() {
		return null;
	}

	@Override
	public CriticalityRepository criticidades(TransactionalContext autoTx) {
		return null;
	}


	@Override
	public CollaboratorRepository collaborators (final TransactionalContext tx) {
		return new InMemoryCollaboratorRepository();
	}

	@Override
	public CollaboratorRepository collaborators() {
		return collaborators(null);
	}

	@Override
	public FunctionRepository funcao(TransactionalContext autoTx) {
		return new InMemoryFunctionRepository();
	}

	@Override
	public FunctionRepository funcao() {return funcao(null);}

	@Override
	public CriticalityRepository criticidade(TransactionalContext autoTx) {
		return new InMemoryCriticalityRepository();
	}

	@Override
	public CriticalityRepository criticidade() {
		return criticidade(null);
	}

	@Override
	public CatalogueRepository catalogs (final TransactionalContext tx) {

		return new InMemoryCatalogueRepository();
	}

	@Override
	public CatalogueRepository catalogs() {
		return catalogs(null);
	}


	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}

	@Override
	public FormRepository form(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public FormRepository form() {
		return form(null);
	}

	@Override
	public TicketRepository tickets(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TicketRepository tickets() {
		return null;
	}

	@Override
	public ServiceRepository servico(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public ServiceRepository servico() {
		return servico(null);
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}


}
