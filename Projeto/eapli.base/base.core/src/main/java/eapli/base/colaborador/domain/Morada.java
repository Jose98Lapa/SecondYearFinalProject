package eapli.base.colaborador.domain;

import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.dto.MoradaDTO;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;
import java.util.Objects;

@Entity
public class Morada implements ValueObject, DTOable<MoradaDTO> {

    private Estrada estrada;
    private NumPorta numPorta;
    private Andar andar;
    private Localizacao localizacao;
    @EmbeddedId
    private CodPostal codPostal;

    @Version
    Long version ;

    public Morada(final String estrada, final String numPorta, final String andar, final String localizacao, final String codPostal){
        this.estrada = new Estrada(estrada);
        this.numPorta = new NumPorta(numPorta);
        this.andar = new Andar(andar);
        this.localizacao = new Localizacao(localizacao);
        this.codPostal = new CodPostal(codPostal);
    }

    protected Morada() {

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

    @Override
    public MoradaDTO toDTO() {
        return new MoradaDTO(estrada.toString(),numPorta.toString(),andar.toString(),localizacao.toString(),codPostal.toString());
    }
}
