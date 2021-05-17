package eapli.base.app.backoffice.console.presentation.createTeam;

import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.application.CreateTeamController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreateTeamUI extends AbstractUI {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateTeamUI.class);

    private final CreateTeamController createTeamController = new CreateTeamController();


    @Override
    protected boolean doShow() {
        String teamID = Console.readLine("Insira o ID da Equipa");
        String acronym = Console.readLine("Insira o Acrónimo da Equipa");
        String description = Console.readLine("Insira a descrição");
        List<TeamTypeDTO> teamTypeDTOList = new ArrayList<>(20);
        for (TeamTypeDTO teamTypeDTO : createTeamController.getTeamTypeDTO()) {
            teamTypeDTOList.add(teamTypeDTO);
        }
        TeamTypeDTO teamTypeDTO = null;
        boolean continueLoop = true;

        try {
            while (continueLoop) {
                for (int i = 0; i < teamTypeDTOList.size(); i++) {
                    System.out.printf("%d %s \n", i + 1, teamTypeDTOList.get(i));
                }
                int posicao = Console.readInteger("Insira uma posição válida para escolher o tipo da equipa");
                if (posicao < 0 || posicao > teamTypeDTOList.size()) {
                    System.out.println("O valor inserido está fora dos limites.\nPor favor re insira uma posição válida");

                } else {
                    continueLoop = false;
                    teamTypeDTO = teamTypeDTOList.get(posicao - 1);
                }
            }
            CollaboratorDTO collaboratorDTO = null;
            List<CollaboratorDTO> collaboratorDTOList = new ArrayList<>(20);
            for (CollaboratorDTO collaboratorDTOl : createTeamController.getCollaboratorDTO()) {
                collaboratorDTOList.add(collaboratorDTOl);
            }
            continueLoop = true;


            while (continueLoop) {
                for (int i = 0; i < collaboratorDTOList.size(); i++) {
                    System.out.printf("%d %s \n", i + 1, collaboratorDTOList.get(i));
                }
                int posicao = Console.readInteger("Insira uma posição válida para escolher um colaborador gestor da equipa");
                if (posicao < 0 || posicao > collaboratorDTOList.size()) {
                    System.out.println("O valor inserido está fora dos limites.\nPor favor re insira uma posição válida");

                } else {
                    continueLoop = false;
                    collaboratorDTO = collaboratorDTOList.get(posicao - 1);
                }
            }


            TeamDTO teamDTO = new TeamDTO(description, acronym, teamID, teamTypeDTO, collaboratorDTO);

            this.createTeamController.registerTeam(teamDTO);
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro inesperado na aplicação. %s%n", e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
}
