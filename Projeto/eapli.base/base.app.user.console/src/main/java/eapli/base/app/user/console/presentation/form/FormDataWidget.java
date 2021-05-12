package eapli.base.app.user.console.presentation.form;

import eapli.framework.io.util.Console;

public class FormDataWidget {
    private String nome;
    private String id;
    private String script;

    public void show() {
        System.out.println("Insira informaçao relativa ao Formulário");
        this.nome = Console.readLine("Nome");
        this.id = Console.readLine("ID");
        this.script = Console.readLine("Script");
    }

    public String nome() {
        return this.nome;
    }

    public String id() {
        return this.id;
    }

    public String script() {
        return this.script;
    }

}
