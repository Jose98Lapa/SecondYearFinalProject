package eapli.base.app.user.console.presentation.createTeamType;

import eapli.base.teamType.Application.CreateTeamTypeController;
import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.app.user.console.presentation.createTeam.CreateTeamUI;
import eapli.base.colour.DTO.ColourDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTeamTypeUI extends AbstractUI {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateTeamUI.class);
    private CreateTeamTypeController createTeamTypeController = new CreateTeamTypeController();

    @Override
    protected boolean doShow() {
        List<ColourDTO> colourDTOList = new ArrayList<>(30);
        String ID = Console.readLine("Insira o ID do tipo de Equipa");
        String descricao = Console.readLine("Insira a descrição");
        for (ColourDTO colourDTO : createTeamTypeController.getCores()) {
            colourDTOList.add(colourDTO);
        }

        int position;
        boolean continueLoop = true;
        ColourDTO colourDTO = null;
        try {
            while (continueLoop) {
                for (int i = 0; i < colourDTOList.size(); i++) {
                    System.out.printf("%d -> %s \n", i + 1, colourDTOList.get(i).nome);
                }
                position = Console.readInteger("Insira a cor pretendida");
                if (position < 0 || position > colourDTOList.size()) {
                    System.out.println("A posição está errada por isso será necessário reintroduzir o valor da posição dentro dos limites");

                } else {
                    continueLoop = false;
                    colourDTO = colourDTOList.get(position - 1);
                }
            }
            TeamTypeDTO teamTypeDTO = new TeamTypeDTO(ID, descricao, colourDTO);
            createTeamTypeController.registo(teamTypeDTO);
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return false;
    }


    @Override
    public String headline() {
        return "Criar Tipo Equipa";
    }
}
