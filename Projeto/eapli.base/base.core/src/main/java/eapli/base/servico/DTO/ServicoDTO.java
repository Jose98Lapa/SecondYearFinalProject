package eapli.base.servico.DTO;

import eapli.base.servico.domain.*;
public class ServicoDTO {
    public String title;
    public String id;
    public String icon;
    public String keywords;
    public String status;
    public String tipo;

    public ServicoDTO(TituloServico title, ServicoID id, IconServico icon, KeyWords keywords, StatusServico status, TipoServico tipo) {
        this.title= title.toString();
        this.id= id.toString();
        this.icon= icon.toString();
        this.keywords= keywords.toString();
        this.status= status.toString();
        this.tipo= tipo.toString();
    }
    public ServicoDTO(TituloServico title, ServicoID id) {
        this.title= title.toString();
        this.id= id.toString();
    }

}