package eapli.base.app.user.console.presentation.createColour;


import eapli.base.app.user.console.presentation.createTeam.CreateTeamUI;
import eapli.base.colour.Application.CreateColourController;
import eapli.base.colour.DTO.ColourDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateColourUI extends AbstractUI {
    private final Logger LOGGER =  LoggerFactory.getLogger(CreateTeamUI.class);
    private final CreateColourController createColourController = new CreateColourController();

    @Override
    protected boolean doShow() {
        String nome = Console.readLine("Insira o nome da cor");
        String hexadecimal = Console.readLine("Insira o hexadecimal");
        ColourDTO colourDTO = new ColourDTO(hexadecimal,nome);
        try {
            this.createColourController.registo(colourDTO);
        }catch (final IntegrityViolationException | ConcurrencyException e){
            LOGGER.error("Error performing the operation", e);
            System.out.println("Erro inesperado na aplicação. " +
                    "Por favor tentar novamente.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Criar Cor";
    }


}
