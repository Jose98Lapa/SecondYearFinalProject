package eapli.base.formulario.domain.atributo;

import eapli.base.formulario.DTO.atributo.AtributoDTO;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Atributo implements DomainEntity, DTOable<AtributoDTO>{
    private AtributoNome nome;
    private AtributoLabel label;
    private AtributoDescricao desc;
    private AtributoRegex regex;
    private AtributoTipo tipo;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Atributo(AtributoNome nome, AtributoLabel label, AtributoDescricao desc, AtributoRegex regex, AtributoTipo tipo) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        Preconditions.noneNull();
    }

    protected Atributo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atributo atributo = (Atributo) o;
        return Objects.equals(nome, atributo.nome) && Objects.equals(label, atributo.label) && Objects.equals(desc, atributo.desc) && Objects.equals(regex, atributo.regex) && Objects.equals(tipo, atributo.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, label, desc, regex, tipo);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "nome=" + nome +
                ", label=" + label +
                ", desc=" + desc +
                ", regex=" + regex +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public AtributoDTO toDTO() {
        return new AtributoDTO(nome.toString(), label.toString(),desc.toString(),regex.toString(),tipo.toString());
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public Object identity() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
