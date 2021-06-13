package eapli.base.app.user.console.presentation.requestService;

import eapli.framework.io.util.Console;

public class AttributesDataWidget {
    private String nome;
    private String desc;

    public void show( int number ) {

        System.out.println( "Attribute\t" + number );
        this.nome = Console.readLine("Nome");
        this.desc = Console.readLine("Descrição");
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

}
