package eapli.base.form.DTO.attribute;

public class AttributeDTO {
    public String nome;
    public String label;
    public String desc;
    public String regex;
    public String tipo;
    public String id;
    public int number;

    public AttributeDTO(String nome, String label, String desc, String regex, String tipo, String id, int number ) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        this.id = id;
        this.number = number;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome +
                ", label='" + label +
                ", desc='" + desc +
                ", tipo='" + tipo +
                ", number=" + number;
    }
}
