package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servico.Repository.ServicoRepository;
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
	public JpaEquipaRepository teams(final TransactionalContext autoTx) {
		return new JpaEquipaRepository(autoTx);
	}


	@Override
	public JpaEquipaRepository teams() {
		return new JpaEquipaRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public JpaTeamTypeRepository teamTypes(final TransactionalContext autoTx) {
		return new JpaTeamTypeRepository(autoTx);
	}

	@Override
	public CollaboratorRepository collaborators() {
		return new JpaCollaboratorRepository(Application.settings().getPersistenceUnitName());
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
	public ServicoRepository servico(TransactionalContext autoTx) {
		return new JpaServicoRepository(autoTx);
	}

	@Override
	public ServicoRepository servico() {
		return new JpaServicoRepository(Application.settings().getPersistenceUnitName());	}

	@Override
	public FormularioRepository form(final TransactionalContext autoTx) {
		return new JpaFormularioRepository(autoTx);
	}

	@Override
	public FormularioRepository form() {
		return new JpaFormularioRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


}
