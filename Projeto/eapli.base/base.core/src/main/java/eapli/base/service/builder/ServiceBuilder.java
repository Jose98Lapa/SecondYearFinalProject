package eapli.base.service.builder;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.Form;
import eapli.base.service.domain.*;
import java.util.Set;

public class ServiceBuilder {
    private ServiceTitle title;
    private ServiceID id;
    private IconServico icon ;
    private Set<KeyWords> keywords ;
    private ServiceStatus status  ;
    private ServiceType tipo  ;
    private ServiceScript script  ;
    private Form form  ;
    private CompleteDescription compDesc  ;
    private BriefDescription briefDesc ;
    private Catalogue catalogue;

    public Service buildManual() {
        return new Service(title, id, icon, keywords, status, ServiceType.valueOf("MANUAL"),compDesc,briefDesc,script,form, catalogue);
    }

    public Service buildAutomatic() {
        return new Service(title, id, icon, keywords, status, ServiceType.valueOf("AUTOMATICO"),compDesc,briefDesc,script,form, catalogue);

    }

    public ServiceBuilder Title(String title) {
        this.title = ServiceTitle.valueOf(title);
        return this;
    }

    public ServiceBuilder briefDesc(String desc) {
        this.briefDesc = BriefDescription.valueOf(desc);
        return this;
    }

    public ServiceBuilder compDesc(String desc) {
        this.compDesc = CompleteDescription.valueOf(desc);
        return this;
    }

    public ServiceBuilder Script(String script) {
        this.script = ServiceScript.valueOf(script);
        return this;
    }

    public ServiceBuilder Id(String id) {
        this.id = ServiceID.valueOf(id);
        return this;
    }

    public ServiceBuilder Icon(String icon) {
        this.icon = IconServico.valueof(icon);
        return this;
    }

    public ServiceBuilder Keywords(Set<String> keywords) {
        this.keywords = KeyWords.valueOf(keywords);
        return this;
    }

    public ServiceBuilder Status(String status) {
        this.status = ServiceStatus.valueOf(status);
        return this;
    }

    public ServiceBuilder Tipo(String tipo) {
        this.tipo = ServiceType.valueOf(tipo);
        return this;
    }
    public ServiceBuilder Form(Form form) {
        this.form = form;
        return this;
    }
    public ServiceBuilder Catalogo(Catalogue cat) {
        this.catalogue = cat;
        return this;
    }

}
