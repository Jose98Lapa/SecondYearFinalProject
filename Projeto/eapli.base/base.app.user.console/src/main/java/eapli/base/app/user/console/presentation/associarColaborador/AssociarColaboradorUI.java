package eapli.base.app.user.console.presentation.associarColaborador;

import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.equipa.application.ListEquipaService;

public class AssociarColaboradorUI {

    public static void doShow() {
        System.out.println( "Escolha uma equipa\n" );


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
