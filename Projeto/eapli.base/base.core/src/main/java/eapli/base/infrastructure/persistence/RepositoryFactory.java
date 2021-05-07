/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.catalogo.repositories.CatalogRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.base.servico.Repository.ServicoRepository;
import eapli.base.teamtype.repositories.TeamTypeRepository;
import eapli.base.formulario.repository.FormularioRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {


	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	ServicoRepository servico(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ServicoRepository servico();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	FormularioRepository form(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FormularioRepository form();

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamTypeRepository teamTypes();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamTypeRepository teamTypes(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */


	EquipaRepository teams();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	EquipaRepository teams(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */



	CollaboratorRepository collaborators();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FuncaoRepository funcao(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FuncaoRepository funcao();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CollaboratorRepository collaborators(TransactionalContext autoTx);
	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CatalogRepository catalogs();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CatalogRepository catalogs(TransactionalContext autoTx);

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

}
