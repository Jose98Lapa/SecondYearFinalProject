package eapli.base.form.DTO.attribute;

public class AttributeDTO {
    public String nome;
    public String label;
    public String desc;
    public String regex;
    public String tipo;
    public String id;

    public AttributeDTO(String nome, String label, String desc, String regex, String tipo, String id) {
        this.nome = nome;
        this.label = label;
        this.desc = desc;
        this.regex = regex;
        this.tipo = tipo;
        this.id = id;
    }
}
