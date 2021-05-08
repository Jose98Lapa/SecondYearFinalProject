package eapli.base.app.user.console.presentation.CriarCor;


import eapli.base.app.user.console.presentation.CriarEquipa.CriarEquipaUI;
import eapli.base.cor.Application.CriarCorController;
import eapli.base.cor.DTO.CorDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriarCorUI extends AbstractUI {
    private final Logger LOGGER =  LoggerFactory.getLogger(CriarEquipaUI.class);
    private final CriarCorController criarCorController = new CriarCorController();

    @Override
    protected boolean doShow() {
        String nome = Console.readLine("Insira o nome da cor");
        String hexadecimal = Console.readLine("Insira o hexadecimal");
        CorDTO corDTO = new CorDTO(hexadecimal,nome);
        try {
            this.criarCorController.registo(corDTO);
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
