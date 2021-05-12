package eapli.base.app.user.console.presentation.specifyCriticality;


import eapli.framework.io.util.Console;

public class CriticalityDataWidget {

    private String label;
    private String valorCriticidade;
    private String tempoMaximoA;
    private String tempoMedioA;
    private String tempoMaximoR;
    private String tempoMedioR;

    public void show(){
        this.valorCriticidade= Console.readLine("ValorCriticidade:");
        this.label= Console.readLine("Label:");
        System.out.println("\n--Objetivo de Aprovação [HH:MM]--");
        this.tempoMaximoA= Console.readLine("Tempo Maximo:");
        this.tempoMedioA= Console.readLine("Tempo Medio:");
        System.out.println("\n--Objetivo de Resolção [HH:MM]--");
        this.tempoMaximoR= Console.readLine("Tempo Maximo:");
        this.tempoMedioR= Console.readLine("Tempo Maximo:");
    }

    public String label() {return label;}

    public String valorCriticidade() {return valorCriticidade;}

    public String tempoMaximoA() {return tempoMaximoA;}

    public String tempoMedioA() {return tempoMedioA;}

    public String tempoMaximoR() {return tempoMaximoR;}

    public String tempoMedioR() {return tempoMedioR;}

}
