package eapli.base.app.backoffice.console.presentation.task;

import eapli.base.app.backoffice.console.presentation.form.FormUI;
import eapli.base.function.DTO.FunctionDTO;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.task.DTO.ApprovalTaskDTO;
import eapli.base.task.DTO.AutomaticTaskDTO;
import eapli.base.task.DTO.ExecutionTaskDTO;
import eapli.base.task.application.CreateTaskController;
import eapli.base.team.DTO.TeamDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskUI extends AbstractUI {

	private static final Logger LOGGER = LoggerFactory.getLogger( FormUI.class );


	CreateTaskController createTaskController = new CreateTaskController( );

	private String formID ( ) {

		FormUI formUi = new FormUI( );
		formUi.show( );
		return formUi.formId;
	}

	public String createApprovalTask ( ) {

		String formId = formID( );
		boolean continueLoop = true;
		List< FunctionDTO > functionDTOList = createTaskController.getFunctionsDTO( );
		FunctionDTO functionDTO = null;
		while ( continueLoop ) {
			for ( int i = 0; i < functionDTOList.size( ); i++ ) {
				System.out.println( "Posição " + i + " " + functionDTOList.get( i ) );
			}
			int posicao = Console.readInteger( "Insira uma posição válida para uma função" );
			if ( posicao < 0 || posicao > functionDTOList.size( ) ) {
				System.out.println( "O valor inserido está fora dos limites.\nPor favor re insira uma posição válida" );

			} else {
				continueLoop = false;
				functionDTO = functionDTOList.get( posicao );
			}
		}
		ApprovalTaskDTO approvalTaskDTO = new ApprovalTaskDTO( formId, functionDTO );
		return this.createTaskController.registerApprovalTask( approvalTaskDTO );

	}

	public String createExecutionTask ( ) {

		String formId = formID( );
		List< TeamDTO > teamDTOList = new ArrayList<>( );
		for ( TeamDTO teamDTO : this.createTaskController.getTeamDTO( ) ) {
			teamDTOList.add( teamDTO );
		}
		List< TeamDTO > teamList = new ArrayList<>( Collections.emptyList( ) );
		boolean continueLoop = true;

			for ( int i = 0; i < teamDTOList.size( ); i++ ) {
				System.out.println( "Posição " + i + " " + teamDTOList.get( i ) );
			}

			int posicao = 0;

			do {
				posicao = Console.readInteger( "Insira uma posição válida para a(s) equipa(s) que quer escolher. " +
						"Introduza -1 para terminar. " );

				if ( posicao < -1 || posicao > teamDTOList.size( ) ) {
					System.out.println( "O valor inserido está fora dos limites.\nPor favor re-insira uma posição válida" );
				} else {
					teamList.add( teamDTOList.get( posicao ) );
				}

			} while ( posicao != -1 );


		ExecutionTaskDTO executionTaskDTO = new ExecutionTaskDTO( formId, teamList );
		return this.createTaskController.registerManualTask( executionTaskDTO );

	}

	public String createAutomaticTask ( ) {

		String scriptPath = Console.readLine( "Insira o path do script" );
		AutomaticTaskDTO automaticTaskDTO = new AutomaticTaskDTO( "", scriptPath );
		return this.createTaskController.registerAutomaticTask( automaticTaskDTO );
	}


	@Override
	protected boolean doShow ( ) {

		System.out.println( "Insira 1 para criar uma tarefa de aprovação" );
		System.out.println( "Insira 2 para criar uma tarefa de execução" );
		System.out.println( "Insira 3 para criar uma tarefa de automatico" );
		int id;
		do {
			id = Console.readInteger( "Insira o id válido" );
		} while ( id < 1 || id > 3 );
		switch ( id ) {
			case 1 -> {
				createApprovalTask( );
			}
			case 2 -> {
				createExecutionTask( );
			}
			default -> createAutomaticTask( );
		}

		return false;
	}

	@Override
	public String headline ( ) {

		return "Create Task";
	}

}
