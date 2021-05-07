package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class Morada implements ValueObject {

    String estrada;
    String numPorta;
    String andar;
    String localizacao;
    CodPostal codPostal;

    public Morada(final String estrada, final String numPorta, final String andar, final String localizacao, final String postalCode){
        if (estrada==null ||estrada.isEmpty()||!estrada.matches("^[\\w\\.]+(\\s\\w+){2,}$"))
            throw new IllegalArgumentException("Street does not fit the criteria");
        this.estrada = estrada;

        if (numPorta==null ||numPorta.isEmpty()||!numPorta.matches("^\\d{0,4}$"))
            throw new IllegalArgumentException("Door Number does not fit the criteria");
        this.numPorta = numPorta;

        if (andar==null ||andar.isEmpty()||!andar.matches("^\\d{0,3}$"))
            throw new IllegalArgumentException("Floor does not fit the criteria");
        this.andar = andar;

        if (localizacao==null ||localizacao.isEmpty()||!localizacao.matches("^[a-zA-Z]+(?:[\\s-][A-zÀ-ú]+)*$"))
            throw new IllegalArgumentException("Location does not fit the criteria");
        this.localizacao = localizacao;

        this.codPostal = new CodPostal(postalCode);
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

    public CodPostal getCodPostal() {
        return codPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morada morada = (Morada) o;
        return estrada.equals(morada.estrada) && numPorta.equals(morada.numPorta) && andar.equals(morada.andar) && localizacao.equals(morada.localizacao) && codPostal.equals(morada.codPostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estrada, numPorta, andar, localizacao, codPostal);
    }

    @Override
    public String toString() {
        return "Address:\n" +
                "Street -> " + estrada + "\n" +
                "DoorNumber -> " + numPorta + "\n" +
                "Floor -> " + andar + "\n" +
                "Localization -> " + localizacao + "\n" +
                "PostalCode -> " + codPostal;
    }
}
