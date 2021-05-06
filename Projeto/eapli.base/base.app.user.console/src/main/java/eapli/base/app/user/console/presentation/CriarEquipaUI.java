package eapli.base.app.user.console.presentation;

import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class CriarEquipaUI extends AbstractUI {
    private final Logger LOGGER =  LoggerFactory.getLogger(CriarEquipaUI.class);

    private final CriarEquipaController criarEquipaController = new CriarEquipaController();


    @Override
    protected boolean doShow() {
        String equipaID = Console.readLine("Insira o ID da equipa");
        String acronimo = Console.readLine("Insira o Acrónimo da Equipa");
        String descricao = Console.readLine("Insira a descricao");
        EquipaDTO equipaDTO = new EquipaDTO(equipaID,acronimo,descricao);

        try {
            this.criarEquipaController.registo(equipaDTO);
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
