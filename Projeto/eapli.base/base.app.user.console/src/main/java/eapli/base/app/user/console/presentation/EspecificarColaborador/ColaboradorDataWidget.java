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
        this.contacto=Console.readLine("Contacto:");
        this.nomeCompleto=Console.readLine("Nome completo:");
        this.emailInstitucional=Console.readLine("Email instuticional:");
        this.numeroMecanografico=Console.readLine("Numero mecanografico:");
        this.alcunha=Console.readLine("Alcunha:");
        this.dataDeNascimento=Console.readLine("Data de nascimento [DD/MM/AAAA]:");

        this.estrada=Console.readLine("Estrada:");
        this.numPorta=Console.readLine("Numero da Porta:");
        this.andar=Console.readLine("Andar:");
        this.localizacao=Console.readLine("Localizacao:");
        this.codPostal=Console.readLine("Codigo Postal [XXXX-XXX]:");
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
