package eapli.base.app.user.console.presentation.EspecificarColaborador;

import eapli.framework.io.util.Console;

public class ColaboradorDataWidget {

    private String estrada;
    private String numPorta;
    private String andar;
    private String localizacao;
    private String codPostal;
    private String contacto;
    private String nomeCompleto;
    private String emailInstitucional;
    private String numeroMecanografico;
    private String alcunha;
    private String dataDeNascimento;

    public void show(){
        this.contacto=Console.readLine("Contact:");
        this.nomeCompleto=Console.readLine("Full Name:");
        this.emailInstitucional=Console.readLine("Institutional Email:");
        this.numeroMecanografico=Console.readLine("Mecanographic Number:");
        this.alcunha=Console.readLine("Nickname:");
        this.dataDeNascimento=Console.readLine("Date Of Birth:");

        this.estrada=Console.readLine("Street:");
        this.numPorta=Console.readLine("Door number:");
        this.andar=Console.readLine("Floor:");
        this.localizacao=Console.readLine("Location:");
        this.codPostal=Console.readLine("Postal Code:");
    }

    public String street() {
        return estrada;
    }

    public String doorNumber() {
        return numPorta;
    }

    public String floor() {
        return andar;
    }

    public String location() {
        return localizacao;
    }

    public String postalCod() {
        return codPostal;
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
