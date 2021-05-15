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
    private ServiceType type;
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

    public ServiceBuilder withTitle(String title) {
        this.title = ServiceTitle.valueOf(title);
        return this;
    }

    public ServiceBuilder withBriefDescription(String desc) {
        this.briefDesc = BriefDescription.valueOf(desc);
        return this;
    }

    public ServiceBuilder withCompleteDescription(String desc) {
        this.compDesc = CompleteDescription.valueOf(desc);
        return this;
    }

    public ServiceBuilder withScript(String script) {
        this.script = ServiceScript.valueOf(script);
        return this;
    }

    public ServiceBuilder withId(String id) {
        this.id = ServiceID.valueOf(id);
        return this;
    }

    public ServiceBuilder withIcon(String icon) {
        this.icon = IconServico.valueof(icon);
        return this;
    }

    public ServiceBuilder withKeywords(Set<String> keywords) {
        this.keywords = KeyWords.valueOf(keywords);
        return this;
    }

    public ServiceBuilder withStatus(String status) {
        this.status = ServiceStatus.valueOf(status);
        return this;
    }

    public ServiceBuilder withType(String tipo) {
        this.type = ServiceType.valueOf(tipo);
        return this;
    }
    public ServiceBuilder withForm(Form form) {
        this.form = form;
        return this;
    }
    public ServiceBuilder withCatalogue(Catalogue cat) {
        this.catalogue = cat;
        return this;
    }

}
