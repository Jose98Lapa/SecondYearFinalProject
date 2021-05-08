package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Morada implements ValueObject  {

    private Estrada estrada;
    private NumPorta numPorta;
    private Andar andar;
    private Localizacao localizacao;
    private CodPostal codPostal;

    public Morada(final String estrada, final String numPorta, final String andar, final String localizacao, final String codPostal){
        this.estrada = new Estrada(estrada);
        this.numPorta = new NumPorta(numPorta);
        this.andar = new Andar(andar);
        this.localizacao = new Localizacao(localizacao);
        this.codPostal = new CodPostal(codPostal);
    }

    protected Morada() {

    }

    public String getEstrada() {
        return estrada.toString();
    }

    public String getNumPorta() {return numPorta.toString();}

    public String getAndar() {
        return andar.toString();
    }

    public String getLocalizacao() {
        return localizacao.toString();
    }

    public String getCodPostal() {
        return codPostal.toString();
    }

    public void setEstrada(String estrada) {this.estrada = new Estrada(estrada);}

    public void setNumPorta(String numPorta) {this.numPorta = new NumPorta(numPorta);}

    public void setAndar(String andar) {
        this.andar = new Andar(andar);
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = new Localizacao(localizacao);
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = new CodPostal(codPostal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morada morada = (Morada) o;
        return Objects.equals(estrada, morada.estrada) && Objects.equals(numPorta, morada.numPorta) && Objects.equals(andar, morada.andar) && Objects.equals(localizacao, morada.localizacao) && Objects.equals(codPostal, morada.codPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estrada, numPorta, andar, localizacao, codPostal);
    }

    @Override
    public String toString() {
        return "Morada:\n" +
                "Estrada -> " + estrada + "\n" +
                "Numero da Porto -> " + numPorta + "\n" +
                "Andar -> " + andar + "\n" +
                "Localizacao -> " + localizacao + "\n" +
                "Codigo postal -> " + codPostal;
    }
}
