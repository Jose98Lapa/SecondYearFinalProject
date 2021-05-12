package eapli.base.colour.DTO;

public class ColourDTO {
    public String valorHexadecimal;
    public String nome;

    public ColourDTO(String valorHexadecimal, String nome) {
        this.valorHexadecimal = valorHexadecimal;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CorDTO{" +
                "valorHexadecimal='" + valorHexadecimal + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
