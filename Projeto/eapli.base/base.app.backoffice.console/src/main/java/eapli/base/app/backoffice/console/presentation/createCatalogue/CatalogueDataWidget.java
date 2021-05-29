package eapli.base.app.backoffice.console.presentation.createCatalogue;

import eapli.base.app.backoffice.console.presentation.SFTPClient;
import eapli.framework.io.util.Console;
import java.util.UUID;

/**
 * TODO move to console.common to allow reuse from both backoffice and UtenteApp
 *
 * widget for reading user data Jorge Santos ajs@isp.ipp.pt
 */
 class CatalogueDataWidget {
    private String identificadorUnico;
    private String titulo;
    private String icon;
    private String descBreve;
    private String descCompleta;


    public void show() {
        //this.identificadorUnico = Console.readLine("Identificador Unico");
        this.titulo = Console.readLine("Titulo");
        SFTPClient sftp = new SFTPClient();
        System.out.println("Icon");
        this.icon = sftp.choseAndUploadImage(UUID.randomUUID().toString());
        this.descBreve = Console.readLine("Descrição Breve");
        this.descCompleta = Console.readLine("Descrição Completa");
    }


    public String identificadorUnico() {
        return this.identificadorUnico;
    }

    public String titulo() {
        return this.titulo;
    }

    public String icon() {
        return this.icon;
    }

    public String descBreve() {
        return this.descBreve;
    }

    public String descCompleta() {
        return this.descCompleta;
    }
}
