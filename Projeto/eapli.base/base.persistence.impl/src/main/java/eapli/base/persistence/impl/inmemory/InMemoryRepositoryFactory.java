package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.teamtype.repositories.TeamTypeRepository;
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
	public TeamTypeRepository teamTypes(final TransactionalContext tx) {

		return new InMemoryTeamTypeRepository();
	}


	@Override
	public EquipaRepository teams() {

		return teams(null);
	}

	@Override
	public EquipaRepository teams(final TransactionalContext tx) {

		return new InMemoryEquipaRepository();
	}

	@Override
	public TeamTypeRepository teamTypes() {
		return teamTypes(null);
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
	public CatalogRepository catalogs (final TransactionalContext tx) {

		return new InMemoryCatalogRepository();
	}

	@Override
	public CatalogRepository catalogs() {
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
	public FormularioRepository form(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public FormularioRepository form() {
		return form(null);
	}

	@Override
	public ServicoRepository servico(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public ServicoRepository servico() {
		return servico(null);
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}


}
