package eapli.base.app.backoffice.console.presentation.specifyService;

import eapli.base.app.backoffice.console.presentation.SFTPClient;
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
        SFTPClient sftp = new SFTPClient();
        System.out.println("ICON");
        this.icon = sftp.choseAndUploadImage(id);
        this.briefDesc = Console.readLine("Brief Description");
        this.compDesc = Console.readLine("Complete Description");
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