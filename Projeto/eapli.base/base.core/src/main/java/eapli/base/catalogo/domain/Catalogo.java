package eapli.base.catalogo.domain;

import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Catalogo implements AggregateRoot<Long>, DTOable<CatalogoDTO> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long identity;

    private Titulo titulo;
    private Icon icon;
    private DescricaoBreve briefDesc;
    private DescricaoCompleta completeDesc;
    @OneToOne
    private Criticidade nivelCriticidade;

    @OneToMany
    private final Set<Colaborador> responsableCollabs = new HashSet<>();

    @OneToMany
    private final Set<Equipa> accessCriteria = new HashSet<>();

    private boolean status;


    public Catalogo(Titulo titulo, Icon icon, DescricaoBreve briefDesc,
                    DescricaoCompleta completeDesc, final Set<Colaborador> responsableCollabs,
                    final Set<Equipa> accessCriteria,Criticidade nivelCriticidade) {
        Preconditions.nonNull(accessCriteria);
        Preconditions.nonNull(responsableCollabs);
     //   Preconditions.nonNull(nivelCriticidade);
        Preconditions.nonEmpty(accessCriteria);
        Preconditions.nonEmpty(responsableCollabs);
        this.titulo = titulo;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.nivelCriticidade = nivelCriticidade;
        this.status = true;
    }

    protected Catalogo() {
    }

    public Catalogo(String id, Titulo titulo, Icon icon, DescricaoBreve briefDesc,
                    DescricaoCompleta completeDesc, final Set<Colaborador> responsableCollabs,
                    final Set<Equipa> accessCriteria,Criticidade nivelCriticidade) {
        this.titulo = titulo;
        this.icon = icon;
        this.briefDesc = briefDesc;
        this.completeDesc = completeDesc;
        addResponsableCollabs(responsableCollabs);
        addAccessCriteria(accessCriteria);
        this.nivelCriticidade = nivelCriticidade;
        this.status = true;
    }


    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Catalogo)) {
            return false;
        }

        final Catalogo that = (Catalogo) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && titulo.equals(that.titulo)
                && icon.equals(that.icon) && briefDesc.equals(that.briefDesc)
                && completeDesc == that.completeDesc && status == that.status;
    }

    private void addAccessCriteria(final Set<Equipa> accessCriteria) {
        this.accessCriteria.addAll(accessCriteria);
    }

    private void addResponsableCollabs(final Set<Colaborador> responsableCollabs) {
        this.responsableCollabs.addAll(responsableCollabs);
    }

    public boolean isTipoEquipaValido(Set<String> equipaValidas){
        for (Equipa e :accessCriteria){
            if (equipaValidas.contains(e.identity().toString())){
                return true;
            }
        }
        return false;

    }

    public Long identity() {
        return identity;
    }

    public Titulo title() {
        return titulo;
    }

    public Icon icon() {
        return icon;
    }

    public DescricaoBreve briefDesc() {
        return briefDesc;
    }

    public DescricaoCompleta completeDesc() {
        return completeDesc;
    }

    public Criticidade nivelCriticidade() {
        return nivelCriticidade;
    }

    public Set<Colaborador> responsableCollabs() {
        return responsableCollabs;
    }

    public Set<Equipa> accessCriteria() {
        return accessCriteria;
    }

    public boolean isActive() {
        return status;
    }

    public boolean toogleState() {
        this.status = !this.status;
        return isActive();
    }

    @Override
    public CatalogoDTO toDTO() {
        return new CatalogoDTO(identity,
                titulo.toString(),
                icon.toString(),
                briefDesc.toString(),
                completeDesc.toString(),responsableCollabs,accessCriteria);
    }
}
