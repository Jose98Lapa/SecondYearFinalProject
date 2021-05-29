package eapli.base.service.DTO;

import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.form.domain.Form;

import java.util.Set;

public class ServiceDTO {
    public String title;
    public String id;
    public String icon;
    public Set<String> keywords;
    public String status;
    public String tipo;
    public String briefDescription;
    public String completeDescription;
    public String script;
    public CatalogueDTO catalogo;
    public Form form;

    public ServiceDTO(String title, String  id, String icon, Set<String> keywords, String  status,
                      String  tipo, String briefDescription, String  completeDescription,
                      CatalogueDTO cat, String script, Form form ) {
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
        this.form = form;
    }

    @Override
    public String toString() {
        return "Servico \n" + title +
                ",  \nID:" + id +
                ",  \nicon:" + icon +
                ",  \nkeywords:" + keywords +
                ",  \nstatus:" + status  +
                ",  \ntipo:" + tipo + '\'' +
                ",  \nbriefDescription:" + briefDescription +
                ",  \ncompleteDescription:" + completeDescription +
                ",  \nscript:" + script +
                ",  \ncatalogo:\n " + catalogo +
                ", \nform:";
    }
}