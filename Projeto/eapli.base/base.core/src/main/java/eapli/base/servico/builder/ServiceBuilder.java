package eapli.base.servico.builder;

import eapli.base.servico.Domain.*;

public class ServiceBuilder {
    private TituloServico title;
    private ServicoID id;
    private IconServico icon;
    private KeyWords keywords;
    private StatusServico status;
    private TipoServico tipo;

    Servico servico = new Servico(title,id);

    public Servico build(){
        return  new Servico(title,id,icon,keywords,status,tipo);
    }

    public ServiceBuilder Title(String title) {
        this.title = TituloServico.valueOf(title);
        return this;
    }

    public ServiceBuilder Id(String id) {
        this.id = ServicoID.valueOf(id);
        return this;
    }

    public ServiceBuilder Icon(String icon) {
        this.icon = IconServico.valueof(icon);
        return this;
    }

    public ServiceBuilder Keywords(String keywords) {
        this.keywords = KeyWords.valueOf(keywords);
        return this;
    }

    public ServiceBuilder Status(String status) {
        this.status = StatusServico.valueOf(status);
        return this;
    }

    public ServiceBuilder Tipo(String tipo) {
        this.tipo = TipoServico.valueOf(tipo);
        return this;
    }
}
