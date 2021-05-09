package eapli.base.app.user.console.presentation.associarColaborador;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.application.AssociarColaboradorController;
import eapli.base.equipa.application.CriarEquipaController;
import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

public class AssociarColaboradorUI {

    private AssociarColaboradorController associarColaboradorController;
    private CriarEquipaController equipaController;

    public void doShow() {

        System.out.println( "Escolha uma equipa\n" );
        List<EquipaDTO> equipas = new ArrayList<>();
        int opcaoEquipa, opcaoColaborador;

        associarColaboradorController.getEquipas().forEach( equipas::add );

        for ( int i = 0; i < equipas.size() ; i++) {
            EquipaDTO atual = equipas.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.acronimo, atual.equipaID, atual.descricao );
        }

        opcaoEquipa = Console.readOption( 0, equipas.size() - 1, -1 );

        System.out.println( "Escolha um colaborador\n" );
        List<ColaboradorDTO> colaboradores = new ArrayList<>();
        associarColaboradorController.getColaboradores().forEach( colaboradores::add );

        for ( int i = 0; i < colaboradores.size() ; i++) {
            ColaboradorDTO atual = colaboradores.get( i );
            System.out.printf( " %d - %s | %s |%s\n", i, atual.mNumber, atual.nomeCompleto, atual.email  );
        }

        opcaoColaborador = Console.readOption( 0, colaboradores.size() - 1, 0 );

        ColaboradorDTO colaborador = colaboradores.get( opcaoColaborador );
        EquipaDTO equipa = equipas.get( opcaoEquipa );
        equipa.membrosDaEquipa.add( colaborador );

        equipaController.registo( equipa );
    }
}