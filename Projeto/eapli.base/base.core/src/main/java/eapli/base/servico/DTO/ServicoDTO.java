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
    public String briefDescription;
    public String completeDescription;

    public ServicoDTO( String title,String  id, String icon,Set<String> keywords,String  status,String  tipo,String briefDescription, String  completeDescription) {
        Set<String> keywords2 = new HashSet<>();
        this.title= title;
        this.id= id;
        this.icon= icon;
        this.status= status;
        this.tipo= tipo;
        this.keywords = keywords;
        this.completeDescription = completeDescription.toString();
        this.briefDescription = briefDescription.toString();
    }
    public ServicoDTO(TituloServico title, ServicoID id) {
        this.title= title.toString();
        this.id= id.toString();
    }

}