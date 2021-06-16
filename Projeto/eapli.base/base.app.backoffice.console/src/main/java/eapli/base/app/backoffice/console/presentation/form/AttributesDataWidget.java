package eapli.base.app.backoffice.console.presentation.form;

import eapli.framework.io.util.Console;

public class AttributesDataWidget {
    private String nome;
    private String desc;
    private String label;
    private String tipo;
    private String regex;
    private int number;

    public void show() {

        System.out.println( "Attribute\t" + number );
        this.nome = Console.readLine("Nome");
        this.desc = Console.readLine("Pergunta");
        this.label = Console.readLine("Label");
        this.tipo = Console.readLine("Tipo");
        this.regex = Console.readLine("Regex");
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public String getLabel() {
        return label;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRegex() {
        return regex;
    }

    public int getNumber () {
        return number;
    }

}
