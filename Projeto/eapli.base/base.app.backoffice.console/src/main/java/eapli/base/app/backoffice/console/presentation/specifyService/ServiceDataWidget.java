package eapli.base.app.backoffice.console.presentation.specifyService;

import eapli.framework.io.util.Console;

public class ServiceDataWidget {

    public String title;
    public String type;
    public String id;
    public String icon;
    public String briefDesc;
    public String compDesc;

    public void show() {
        System.out.println("Insira \"none\" se não pretender preencher ");
        this.title = Console.readLine("Title");
        this.type = Console.readLine("Tipo - » AUTOMATICO / MANUAL");
        this.id = Console.readLine("ID");
        this.icon = Console.readLine("ICON");
        this.briefDesc = Console.readLine("BriefDescription");
        this.compDesc = Console.readLine("completeDesc");
    }

    public String title() {
        return this.title;
    }

    public String type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String icon() {
        return this.icon;
    }

    public String briefDesc() {
        return this.briefDesc;
    }

    public String compDesc() {
        return this.compDesc;
    }
}