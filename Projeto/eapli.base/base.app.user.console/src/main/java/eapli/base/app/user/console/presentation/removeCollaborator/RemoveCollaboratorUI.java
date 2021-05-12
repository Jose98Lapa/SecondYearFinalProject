package eapli.base.app.user.console.presentation.removeCollaborator;

import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.base.team.DTO.TeamDTOParser;
import eapli.base.team.application.RemoverColaboradorController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class RemoveCollaboratorUI extends AbstractUI {

    private final RemoverColaboradorController removerColaboradorController = new RemoverColaboradorController();

    @Override
    protected boolean doShow() {

        System.out.println( "Escolha uma equipa\n" );
        List<TeamDTO> equipas = new ArrayList<>();
        int opcaoEquipa, opcaoColaborador;

        removerColaboradorController.getEquipas().forEach( equipas::add );

        for ( int i = 0; i < equipas.size() ; i++) {
            TeamDTO atual = equipas.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.acronimo, atual.equipaID, atual.descricao );
        }

        opcaoEquipa = Console.readOption( 0, equipas.size(), 0);

        System.out.println( "Escolha um colaborador\n" );
        List<CollaboratorDTO> colaboradores = new ArrayList<>();
        removerColaboradorController.getColaboradores(
                new TeamDTOParser()
                        .valueOf( equipas.get( opcaoEquipa ) ) )
                .forEach( colaboradores::add );

        for ( int i = 0; i < colaboradores.size() ; i++) {
            CollaboratorDTO atual = colaboradores.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.mNumber, atual.nomeCompleto, atual.email  );
        }

        opcaoColaborador = Console.readOption( 0, colaboradores.size(), 0 );

        TeamDTO equipa = equipas.get( opcaoEquipa );


        return removerColaboradorController.save( equipa.membrosDaEquipa.get(opcaoColaborador),equipa );
    }

    @Override
    public String headline() {
        return "Remover Colaborador";
    }
}

