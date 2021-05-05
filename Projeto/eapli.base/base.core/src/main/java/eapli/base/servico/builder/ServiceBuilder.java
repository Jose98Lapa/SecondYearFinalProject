package eapli.base.servico.builder;

import eapli.base.servico.Domain.*;
import eapli.framework.validations.Preconditions;

public class ServiceBuilder {
    private TituloServico title;
    private ServicoID id;
    private IconServico icon;
    private KeyWords keywords;
    private StatusServico status;
    private TipoServico tipo;

    Servico servico = new Servico(title,id);

    private Servico build(){
        Preconditions.nonNull(title);
        Preconditions.nonNull(id);
        Preconditions.nonNull(keywords);
        Preconditions.nonNull(status);
        Preconditions.nonNull(tipo);
        return  new Servico(title,id,icon,keywords,status,tipo);
    }

    public ServiceBuilder Title(TituloServico title) {
        this.title = title;
        return this;
    }

    public ServiceBuilder Id(ServicoID id) {
        this.id = id;
        return this;
    }

    public ServiceBuilder Icon(IconServico icon) {
        this.icon = icon;
        return this;
    }

    public ServiceBuilder Keywords(KeyWords keywords) {
        this.keywords = keywords;
        return this;
    }

    public ServiceBuilder Status(StatusServico status) {
        this.status = status;
        return this;
    }

    public ServiceBuilder Tipo(TipoServico tipo) {
        this.tipo = tipo;
        return this;
    }
}
