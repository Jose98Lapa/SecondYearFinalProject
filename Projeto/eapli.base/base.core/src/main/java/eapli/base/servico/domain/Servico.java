package eapli.base.servico.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoID;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Servico implements AggregateRoot<ServicoID>, DTOable<ServicoDTO>{
    @EmbeddedId
    private ServicoID id;
    private IconServico icon;
    private TituloServico title;
    private StatusServico status;
    private TipoServico tipo;
    private ServicoScript script;
    private CompleteDescription compDesc;
    @OneToOne
    private Catalogo catalogo;
    private BriefDescription briedDesc;
    @OneToOne
    private Formulario form ;

    @ElementCollection
    private Set<KeyWords> keywords;


    public Servico(TituloServico title, ServicoID id, IconServico icon, Set<KeyWords> keywords, StatusServico status, TipoServico tipo,CompleteDescription compDesc,BriefDescription briedDesc, ServicoScript script, Formulario form, Catalogo catalogo) {

        this.title = title;
        this.id = id;
        this.icon = icon;
        this.keywords = keywords;
        this.status = status;
        this.tipo = tipo;
        Preconditions.noneNull();
        this.form = form;
        this.script=script;
        this.compDesc = compDesc;
        this.briedDesc = briedDesc;
        this.catalogo=catalogo;
    }

    public void setScript(ServicoScript script) {
        this.script = script;
    }

    public void setForm(Formulario form) {
        this.form = form;
    }

    public Servico(TituloServico title, ServicoID id) {
        this.title=title;
        this.id=id;
        Preconditions.noneNull();
    }

    protected Servico() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(ServicoID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public ServicoID identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(ServicoID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

    @Override
    public ServicoDTO toDTO() {
        Set<String> key2 = new HashSet<>();
        for (KeyWords key:keywords) {
            key2.add(key.toString());
        }
        return new ServicoDTO(this.title.toString(),this.id.toString(), this.icon.toString(), key2, this.status.toString(), this.tipo.toString(),briedDesc.toString(),compDesc.toString(),catalogo.toDTO());
    }

    public ServicoDTO toDTOIncomplete() {
        return new ServicoDTO(this.title,this.id);
    }
}
