package eapli.base.app.backoffice.console.presentation.associateCollaborator;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.application.AssociateCollaboratorController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class AssociateCollaboratorUI extends AbstractUI {

    private AssociateCollaboratorController associateCollaboratorController = new AssociateCollaboratorController();

    @Override
    protected boolean doShow() {

        System.out.println("Escolha uma equipa\n");
        List<TeamDTO> equipas = new ArrayList<>();
        int opcaoEquipa, opcaoColaborador;

        associateCollaboratorController.getEquipas().forEach(equipas::add);

        for (int i = 0; i < equipas.size(); i++) {
            TeamDTO atual = equipas.get(i);
            System.out.printf(" %d - %s | %s |%s\n", i, atual.acronimo, atual.equipaID, atual.descricao);
        }

        opcaoEquipa = Console.readOption(0, equipas.size() - 1, -1);

        System.out.println("Escolha um colaborador\n");
        List<CollaboratorDTO> colaboradores = new ArrayList<>();
        associateCollaboratorController.getColaboradores().forEach(colaboradores::add);

        for (int i = 0; i < colaboradores.size(); i++) {
            CollaboratorDTO atual = colaboradores.get(i);
            System.out.printf(" %d - %s | %s |%s\n", i, atual.mNumber, atual.nomeCompleto, atual.email);
        }

        opcaoColaborador = Console.readOption(0, colaboradores.size() - 1, 0);
        try {
            CollaboratorDTO colaborador = colaboradores.get(opcaoColaborador);
            TeamDTO equipa = equipas.get(opcaoEquipa);
            equipa.membrosDaEquipa.add(colaborador);

            return associateCollaboratorController.save(equipa, colaboradores.get(opcaoColaborador));
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Associar Colaborador";
    }
}
