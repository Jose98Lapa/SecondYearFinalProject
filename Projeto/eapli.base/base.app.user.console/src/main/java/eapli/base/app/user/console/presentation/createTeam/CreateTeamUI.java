package eapli.base.app.user.console.presentation.createTeam;

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
    private final Logger LOGGER =  LoggerFactory.getLogger(CreateTeamUI.class);

    private final CreateTeamController createTeamController = new CreateTeamController();


    @Override
    protected boolean doShow() {
        String equipaID = Console.readLine("Insira o ID da equipa");
        String acronimo = Console.readLine("Insira o Acrónimo da Equipa");
        String descricao = Console.readLine("Insira a descricao");
        List<TeamTypeDTO> equipaDTOList = new ArrayList<>(20);
        for (TeamTypeDTO teamTypeDTO : createTeamController.getTipoEquipaDTO()){
            equipaDTOList.add(teamTypeDTO);
        }
        TeamTypeDTO teamTypeDTO = null;
        boolean continueLoop = true;
        while (continueLoop){
            for (int i=0;i<equipaDTOList.size();i++){
                System.out.printf("%d %s \n",i+1,equipaDTOList.get(i));
            }
            int posicao = Console.readInteger("Insira uma posição válida");
            if (posicao<0||posicao>equipaDTOList.size()){
                System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

            }else{
                continueLoop = false;
                teamTypeDTO = equipaDTOList.get(posicao-1);
            }
        }
        CollaboratorDTO collaboratorDTO = null;
        List<CollaboratorDTO> collaboratorDTOList = new ArrayList<>(20);
        for (CollaboratorDTO collaboratorDTOl : createTeamController.getColaboradorDTO()){
            collaboratorDTOList.add(collaboratorDTOl);
        }
        continueLoop = true;


        while (continueLoop){
            for (int i = 0; i< collaboratorDTOList.size(); i++){
                System.out.printf("%d %s \n",i+1, collaboratorDTOList.get(i));
            }
            int posicao = Console.readInteger("Insira uma posição válida");
            if (posicao<0||posicao> collaboratorDTOList.size()){
                System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

            }else{
                continueLoop = false;
                collaboratorDTO = collaboratorDTOList.get(posicao-1);
            }
        }




        TeamDTO teamDTO = new TeamDTO(descricao,acronimo,equipaID, teamTypeDTO, collaboratorDTO);

        try {
            this.createTeamController.registo(teamDTO);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("Error performing the operation", e);
            System.out.println("Erro inesperado na aplicação. " +
                    "Por favor tentar novamente.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
}
