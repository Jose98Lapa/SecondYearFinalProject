package eapli.base.app.backoffice.console.presentation.form;

import eapli.framework.io.util.Console;

public class FormDataWidget {
    private String nome;
    private String id;


    public void show() {
        System.out.println("Insira informaçao relativa ao Formulário");
        this.nome = Console.readLine("Nome");
    }

    public String nome() {
        return this.nome;
    }

    public String id() {
        return this.id;
    }



}
