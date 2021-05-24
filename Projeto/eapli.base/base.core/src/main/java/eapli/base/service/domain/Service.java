package eapli.base.service.domain;

import eapli.base.catalogue.domain.Catalogue;
import eapli.base.form.domain.Form;
import eapli.base.service.DTO.ServiceDTO;
import eapli.base.task.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service implements AggregateRoot<ServiceID>, DTOable<ServiceDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private ServiceID id;
    private IconServico icon;
    private ServiceTitle title;
    private ServiceStatus status;
    private ServiceType tipo;
    private ServiceScript script;
    private CompleteDescription compDesc;
    private BriefDescription briedDesc;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private Catalogue catalogue;

    @OneToOne
    private Form form;

    @ElementCollection
    private Set<KeyWords> keywords;


    public Service(ServiceTitle title, ServiceID id, IconServico icon, Set<KeyWords> keywords, ServiceStatus status,
                   ServiceType tipo, CompleteDescription compDesc, BriefDescription briedDesc, ServiceScript script,
                   Form form, Catalogue catalogue) {

        this.title = title;
        this.id = id;
        this.icon = icon;
        this.keywords = keywords;
        this.status = status;
        this.tipo = tipo;
        Preconditions.noneNull();
        this.form = form;
        this.script = script;
        this.compDesc = compDesc;
        this.briedDesc = briedDesc;
        this.catalogue = catalogue;
    }

    public void addkeywords(Set<KeyWords> keys) {
        this.keywords.addAll(keys);
    }

    public void setScript(ServiceScript script) {
        this.script = script;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Service(ServiceTitle title, ServiceID id) {
        this.title = title;
        this.id = id;
        Preconditions.noneNull();
    }

    protected Service() {
    }

    public Catalogue catalogo() {
        return this.catalogue;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(ServiceID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public ServiceID identity() {
        return id;
    }

    @Override
    public boolean hasIdentity(ServiceID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public ServiceDTO toDTO() {
        Set<String> key2 = new HashSet<>();
        for (KeyWords key : keywords) {
            key2.add(key.toString());
        }
        if (script == null)
            script = ServiceScript.valueOf(" ");
        return new ServiceDTO(this.title.toString(), this.id.toString(), this.icon.toString(), key2,
                this.status.toString(), this.tipo.toString(), briedDesc.toString(), compDesc.toString(),
                catalogue.toDTO(), script.toString());
    }

    public void activate() {
        this.status = ServiceStatus.valueOf("ATIVO");
    }

    public void deactivate() {
        this.status = ServiceStatus.valueOf("INATIVO");
    }

    public void setIcon(IconServico icon) {
        this.icon = icon;
    }

    public void setTitle(ServiceTitle title) {
        this.title = title;
    }

    public Set<KeyWords> Keywords() {
        return keywords;
    }

    public void setKeywords(Set<KeyWords> keywords) {
        this.keywords = keywords;
    }

    public void setTipo(ServiceType tipo) {
        this.tipo = tipo;
    }

    public void setCompDesc(CompleteDescription compDesc) {
        this.compDesc = compDesc;
    }

    public void setBriedDesc(BriefDescription briedDesc) {
        this.briedDesc = briedDesc;
    }

    public boolean isComplete() {
        if (this.title == null || this.id == null || this.icon == null || this.keywords == null || this.status == null)
            return false;
        if (tipo.equals(ServiceType.valueOf("AUTOMATICO"))) {
            return this.script != null;
        } else {
            return this.form != null;
        }
    }

}
