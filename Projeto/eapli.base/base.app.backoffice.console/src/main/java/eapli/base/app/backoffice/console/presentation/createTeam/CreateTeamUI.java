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
        String teamID = Console.readLine("Insert team ID");
        String acronym = Console.readLine("Insert Team Acronym");
        String description = Console.readLine("Insert Description");
        List<TeamTypeDTO> teamDTOList = new ArrayList<>(20);
        for (TeamTypeDTO teamTypeDTO : createTeamController.getTeamTypeDTO()) {
            teamDTOList.add(teamTypeDTO);
        }
        TeamTypeDTO teamTypeDTO = null;
        boolean continueLoop = true;

        try {
            while (continueLoop) {
                for (int i = 0; i < teamDTOList.size(); i++) {
                    System.out.printf("%d %s \n", i + 1, teamDTOList.get(i));
                }
                int posicao = Console.readInteger("Insert a valid position");
                if (posicao < 0 || posicao > teamDTOList.size()) {
                    System.out.println("The inserted value is out of bounds. Please re-insert a valid position");

                } else {
                    continueLoop = false;
                    teamTypeDTO = teamDTOList.get(posicao - 1);
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
                int posicao = Console.readInteger("Insert a valid position");
                if (posicao < 0 || posicao > collaboratorDTOList.size()) {
                    System.out.println("The inserted value is out of bounds. Please re-insert a valid position");

                } else {
                    continueLoop = false;
                    collaboratorDTO = collaboratorDTOList.get(posicao - 1);
                }
            }


            TeamDTO teamDTO = new TeamDTO(description, acronym, teamID, teamTypeDTO, collaboratorDTO);

            this.createTeamController.registerTeam(teamDTO);
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Unfortunately there was an unexpected error in the application. %s%n", e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Create Team";
    }
}
