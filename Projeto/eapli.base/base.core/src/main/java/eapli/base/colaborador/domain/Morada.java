package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Morada implements ValueObject  {

    private String estrada;
    private String numPorta;
    private String andar;
    private String localizacao;
    private String codPostal;

    public Morada(final String estrada, final String numPorta, final String andar, final String localizacao, final String codPostal){
        if (estrada==null ||estrada.isEmpty()||!estrada.matches("^[A-zÀ-ú\\.\\- ]+$"))
            throw new IllegalArgumentException("Estrada nao cumpre os critérios");
        this.estrada = estrada;

        if (numPorta==null ||numPorta.isEmpty()||!numPorta.matches("^\\d{0,4}$"))
            throw new IllegalArgumentException("Numero de porta nao cumpre os critérios");
        this.numPorta = numPorta;

        if (andar==null ||andar.isEmpty()||!andar.matches("^\\d{0,3}$"))
            throw new IllegalArgumentException("Andar nao cumpre os critérios");
        this.andar = andar;

        if (localizacao==null ||localizacao.isEmpty()||!localizacao.matches("^[a-zA-Z]+(?:[\\s-][A-zÀ-ú]+)*$"))
            throw new IllegalArgumentException("Localizacao nao cumpre os critérios");
        this.localizacao = localizacao;

        if (codPostal==null ||codPostal.isEmpty()||!codPostal.matches("^[0-9]{4}-[0-9]{3}$"))
            throw new IllegalArgumentException("Codigo postal nao cumpre os critérios");
        this.codPostal = codPostal;
    }

    protected Morada() {

    }

    public String getEstrada() {
        return estrada;
    }

    public String getNumPorta() {
        return numPorta;
    }

    public String getAndar() {
        return andar;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setEstrada(String estrada) {
        this.estrada = estrada;
    }

    public void setNumPorta(String numPorta) {
        this.numPorta = numPorta;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
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
