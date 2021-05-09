package eapli.base.app.user.console.presentation.removerColaborador;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.DTO.EquipaDTOParser;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.base.equipa.application.RemoverColaboradorController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class RemoverColaboradorUI extends AbstractUI {

    private final RemoverColaboradorController removerColaboradorController = new RemoverColaboradorController();

    @Override
    protected boolean doShow() {

        System.out.println( "Escolha uma equipa\n" );
        List<EquipaDTO> equipas = new ArrayList<>();
        int opcaoEquipa, opcaoColaborador;

        removerColaboradorController.getEquipas().forEach( equipas::add );

        for ( int i = 0; i < equipas.size() ; i++) {
            EquipaDTO atual = equipas.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.acronimo, atual.equipaID, atual.descricao );
        }

        opcaoEquipa = Console.readOption( 0, equipas.size(), 0);

        System.out.println( "Escolha um colaborador\n" );
        List<ColaboradorDTO> colaboradores = new ArrayList<>();
        removerColaboradorController.getColaboradores(
                new EquipaDTOParser()
                        .valueOf( equipas.get( opcaoEquipa ) ) )
                .forEach( colaboradores::add );

        for ( int i = 0; i < colaboradores.size() ; i++) {
            ColaboradorDTO atual = colaboradores.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.mNumber, atual.nomeCompleto, atual.email  );
        }

        opcaoColaborador = Console.readOption( 0, colaboradores.size(), 0 );

        EquipaDTO equipa = equipas.get( opcaoEquipa );


        return removerColaboradorController.save( equipa.membrosDaEquipa.get(opcaoColaborador),equipa );
    }

    @Override
    public String headline() {
        return "Remover Colaborador";
    }
}

