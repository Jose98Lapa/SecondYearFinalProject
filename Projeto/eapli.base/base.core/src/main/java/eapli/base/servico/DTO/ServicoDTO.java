package eapli.base.servico.DTO;

import eapli.base.catalogo.dto.CatalogoDTO;
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
    public String briefDescription;
    public String completeDescription;
    public String script;
    public CatalogoDTO catalogo;

    public ServicoDTO( String title,String  id, String icon,Set<String> keywords,String  status,String  tipo,String briefDescription, String  completeDescription, CatalogoDTO cat,String script) {
        this.title= title;
        this.id= id;
        this.icon= icon;
        this.status= status;
        this.tipo= tipo;
        this.keywords = keywords;
        this.completeDescription = completeDescription.toString();
        this.briefDescription = briefDescription.toString();
        this.catalogo = cat;
        this.script = script;
    }

    @Override
    public String toString() {
        return "ServicoDTO{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", keywords=" + keywords +
                ", status='" + status + '\'' +
                ", tipo='" + tipo + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", completeDescription='" + completeDescription + '\'' +
                ", script='" + script + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }
}