package eapli.base.app.user.console.presentation.formulario;

import eapli.framework.io.util.Console;

public class AtributosDataWidget {
    private String nome;
    private String desc;
    private String label;
    private String tipo;
    private String regex;

    public void show() {
        this.nome = Console.readLine("Nome");
        this.desc = Console.readLine("Descrição");
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
}
