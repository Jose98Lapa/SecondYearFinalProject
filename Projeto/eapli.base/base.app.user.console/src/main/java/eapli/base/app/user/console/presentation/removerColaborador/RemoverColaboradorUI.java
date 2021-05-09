package eapli.base.app.user.console.presentation.removerColaborador;

import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.equipa.application.ListEquipaService;

public class RemoverColaboradorUI {

    public static void doShow() {
        System.out.println( "Escolha uma equipa\n" );
        ListEquipaService servicoListarEquipas = new ListEquipaService();

        servicoListarEquipas
                .allTeams()
                .forEach(
                        team -> System.out.printf( "Id: %s\tTipo: %s|\t%s\n",
                                team.equipaID, team.tipoEquipaDTO.toString(), team.descricao )
                );

        System.out.println( "Escolha um colaborador\n" );
        ListColaboradorService servicoListarColaboradores = new ListColaboradorService();

        servicoListarColaboradores
                .colaboradores()
                .forEach(
                        colaborador -> System.out.printf( "Numero: %s\tNome: %s\tEmail:%s\n",
                                colaborador.mNumber, colaborador.nomeCompleto, colaborador.email)
                );
    }
}
