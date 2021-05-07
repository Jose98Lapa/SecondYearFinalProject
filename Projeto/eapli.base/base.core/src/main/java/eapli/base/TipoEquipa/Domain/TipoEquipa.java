package eapli.base.TipoEquipa.Domain;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.cor.Domain.Cor;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class TipoEquipa implements AggregateRoot<TipoEquipaID>, DTOable<TipoEquipaDTO> {
    @EmbeddedId
    private TipoEquipaID tipoEquipaID;
    private String descricao;
    @OneToOne
    private Cor cor;

    public TipoEquipa(TipoEquipaID tipoEquipaID, String descricao, Cor cor) {
        this.tipoEquipaID = tipoEquipaID;
        this.descricao = descricao;
        this.cor = cor;
    }

    protected TipoEquipa(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoEquipa that = (TipoEquipa) o;
        return Objects.equals(tipoEquipaID, that.tipoEquipaID) && Objects.equals(descricao, that.descricao) && Objects.equals(cor, that.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoEquipaID, descricao, cor);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public TipoEquipaID identity() {
        return tipoEquipaID;
    }

    @Override
    public TipoEquipaDTO toDTO() {
        return new TipoEquipaDTO(tipoEquipaID.toString(),descricao, cor.toDTO());
    }

    @Override
    public String toString() {
        return "TipoEquipa{" +
                "tipoEquipaID=" + tipoEquipaID +
                ", descricao='" + descricao + '\'' +
                ", cor=" + cor +
                '}';
    }
}
