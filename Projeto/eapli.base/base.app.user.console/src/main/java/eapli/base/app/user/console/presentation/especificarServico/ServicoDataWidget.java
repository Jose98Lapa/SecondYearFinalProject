package eapli.base.app.user.console.presentation.especificarServico;

import eapli.framework.io.util.Console;

/**
 * TODO move to console.common to allow reuse from both backoffice and UtenteApp
 *
 * widget for reading user data Jorge Santos ajs@isp.ipp.pt
 */
class ServicoDataWidget {

    private String title;
    private String type;
    private String id;
    private String icon;
    private String briefDesc;
    private String compDesc;

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
