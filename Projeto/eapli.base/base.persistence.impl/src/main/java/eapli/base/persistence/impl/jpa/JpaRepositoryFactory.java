package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalog.repositories.CatalogRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
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
	public JpaTeamTypeRepository teamTypes() {
		return new JpaTeamTypeRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public JpaTeamTypeRepository teamTypes(final TransactionalContext autoTx) {
		return new JpaTeamTypeRepository(autoTx);
	}

	@Override
	public CollaboratorRepository collaborators() {
		return null;
	}

	@Override
	public CollaboratorRepository collaborators(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public CatalogRepository catalogs() {
		return null;
	}

	@Override
	public CatalogRepository catalogs(TransactionalContext autoTx) {
		return null;
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
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
