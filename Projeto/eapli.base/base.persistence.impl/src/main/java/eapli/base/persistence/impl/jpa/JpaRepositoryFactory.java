package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.form.repository.FormRepository;
import eapli.base.function.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.ticket.repository.TicketRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}


	@Override
	public JpaTeamRepository teams(final TransactionalContext autoTx) {
		return new JpaTeamRepository(autoTx);
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
	public ColourRepository cores() {
		return new JpaColourRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ColourRepository cores(TransactionalContext autoTx) {
		return new JpaColourRepository(autoTx);
	}

	@Override
	public TeamTypeRepository tiposDeEquipa() {
		return new JpaTeamTypeRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TeamTypeRepository tiposDeEquipa(TransactionalContext autoTx) {
		return new JpaTeamTypeRepository(autoTx);
	}


	@Override
	public JpaTeamRepository teams() {
		return new JpaTeamRepository(Application.settings().getPersistenceUnitName());
	}


	@Override
	public CollaboratorRepository collaborators() {
		return new JpaCollaboratorRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CollaboratorRepository collaborators(TransactionalContext autoTx) {
		return new JpaCollaboratorRepository(autoTx);
	}

	@Override
	public FunctionRepository funcao(TransactionalContext autoTx) {
		return new JpaFunctionReposiory(Application.settings().getPersistenceUnitName());
	}

	@Override
	public FunctionRepository funcao() {
		return new JpaFunctionReposiory(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CriticalityRepository criticidade() {
		return new JpaCriticalityRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CriticalityRepository criticidade(TransactionalContext autoTx) {
		return new JpaCriticalityRepository(autoTx);
	}

	@Override
	public CatalogueRepository catalogs() {
		return new JpaCatalogueRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public CatalogueRepository catalogs(TransactionalContext autoTx) {
		return new JpaCatalogueRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ServiceRepository servico(TransactionalContext autoTx) {
		return new JpaServiceRepository(autoTx);
	}

	@Override
	public ServiceRepository servico() {
		return new JpaServiceRepository(Application.settings().getPersistenceUnitName());	}

	@Override
	public FormRepository form(final TransactionalContext autoTx) {
		return new JpaFormRepository(autoTx);
	}

	@Override
	public FormRepository form() {
		return new JpaFormRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TicketRepository tickets(final TransactionalContext autoTx) {
		return new JpaTicketRepository(autoTx);
	}

	@Override
	public TicketRepository tickets() {
		return new JpaTicketRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
