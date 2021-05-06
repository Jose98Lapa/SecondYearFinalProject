package eapli.base.servico.Domain;

import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.RepresentationBuilder;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Servico implements AggregateRoot<ServicoID>, DTOable<ServicoDTO>{
    private TituloServico title;
    @EmbeddedId
    private ServicoID id;
    private IconServico icon;
    private KeyWords keywords;
    private StatusServico status;
    private TipoServico tipo;

    public Servico(TituloServico title, ServicoID id, IconServico icon, KeyWords keywords, StatusServico status, TipoServico tipo) {
        this.title = title;
        this.id = id;
        this.icon = icon;
        this.keywords = keywords;
        this.status = status;
        this.tipo = tipo;
        Preconditions.noneNull();
    }

    public Servico(TituloServico title, ServicoID id) {
        this.title=title;
        this.id=id;
        Preconditions.noneNull();
    }

    protected Servico() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(ServicoID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public ServicoID identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(ServicoID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public ServicoDTO toDTO() {
        return new ServicoDTO(this.title,this.id, this.icon, this.keywords, this.status, this.tipo);
    }

    public ServicoDTO toDTOIncomplete() {
        return new ServicoDTO(this.title,this.id);
    }
}
