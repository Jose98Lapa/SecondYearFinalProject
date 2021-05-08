package eapli.base.colaborador.dto;

import eapli.framework.representations.dto.DTO;

@DTO
public class MoradaDTO {
    public String estrada;
    public String numPorta;
    public String andar;
    public String localizacao;
    public String codPostal;

    public MoradaDTO(String estrada, String numPorta, String andar, String localizacao, String codPostal) {
        this.estrada = estrada;
        this.numPorta = numPorta;
        this.andar = andar;
        this.localizacao = localizacao;
        this.codPostal = codPostal;
    }


}
