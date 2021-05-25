/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.task.repository.TaskRepository;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.catalogue.repositories.CatalogueRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.team.repositories.TeamRepository;
import eapli.base.function.repositories.FunctionRepository;
import eapli.base.service.Repository.ServiceRepository;
import eapli.base.form.repository.FormRepository;
import eapli.base.ticket.repository.TicketRepository;
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
	TicketRepository tickets(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TicketRepository tickets();


	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	ServiceRepository servico(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ServiceRepository servico();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	FormRepository form(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FormRepository form();

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
	TeamRepository teams();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamRepository teams(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CriticalityRepository criticidades();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CriticalityRepository criticidades(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */



	ColourRepository cores();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ColourRepository cores(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */

	TaskRepository tasks();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TaskRepository tasks(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */


	TeamTypeRepository tiposDeEquipa();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamTypeRepository tiposDeEquipa(TransactionalContext autoTx);

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
	FunctionRepository funcao(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FunctionRepository funcao();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CriticalityRepository criticidade(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CriticalityRepository criticidade();

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
	CatalogueRepository catalogs();

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	CatalogueRepository catalogs(TransactionalContext autoTx);

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
