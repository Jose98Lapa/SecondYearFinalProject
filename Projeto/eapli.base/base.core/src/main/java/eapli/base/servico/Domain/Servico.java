package eapli.base.servico.Domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

public class Servico implements AggregateRoot<ServicoID> {
    private TituloServico title;
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
}
