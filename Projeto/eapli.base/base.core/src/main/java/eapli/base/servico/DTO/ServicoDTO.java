package eapli.base.servico.DTO;

import eapli.base.servico.domain.*;

import java.util.HashSet;
import java.util.Set;

public class ServicoDTO {
    public String title;
    public String id;
    public String icon;
    public Set<String> keywords;
    public String status;
    public String tipo;

    public ServicoDTO(TituloServico title, ServicoID id, IconServico icon, Set<KeyWords> keywords, StatusServico status, TipoServico tipo) {
        Set<String> keywords2 = new HashSet<>();
        this.title= title.toString();
        this.id= id.toString();
        this.icon= icon.toString();
        this.status= status.toString();
        this.tipo= tipo.toString();
        for (KeyWords key : keywords){
            keywords2.add(key.toString());
        }
    }
    public ServicoDTO(TituloServico title, ServicoID id) {
        this.title= title.toString();
        this.id= id.toString();
    }

}