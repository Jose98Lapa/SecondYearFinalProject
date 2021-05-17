package eapli.base.app.backoffice.console.presentation.specifyCollaborator;

import eapli.framework.io.util.Console;

public class CollaboratorDataWidget {

    private String placeOfResidence;
    private String contacto;
    private String nomeCompleto;
    private String emailInstitucional;
    private String numeroMecanografico;
    private String alcunha;
    private String dataDeNascimento;

    public void show(){
        this.contacto=Console.readLine("Contacto:");
        this.nomeCompleto=Console.readLine("Nome completo:");
        this.emailInstitucional=Console.readLine("Email instuticional:");
        this.numeroMecanografico=Console.readLine("Numero mecanografico:");
        this.alcunha=Console.readLine("Alcunha:");
        this.dataDeNascimento=Console.readLine("Data de nascimento [DD/MM/AAAA]:");
        this.placeOfResidence=Console.readLine("Local De Residência:");
    }


    public String placeOfResidence() {
        return placeOfResidence;
    }

    public String contact() {
        return contacto;
    }

    public String fullName() {
        return nomeCompleto;
    }

    public String institutionalEmail() {
        return emailInstitucional;
    }

    public String mecanographicNumber() {
        return numeroMecanografico;
    }

    public String nickname() {
        return alcunha;
    }

    public String dateOfBirth() {
        return dataDeNascimento;
    }
}
