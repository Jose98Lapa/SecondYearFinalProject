package eapli.base.collaborator.dto;

import eapli.framework.representations.dto.DTO;

@DTO
public class AddressDTO {
    public String rua;
    public String numPorta;
    public String andar;
    public String localizacao;
    public String codPostal;

    public AddressDTO(String rua, String numPorta, String andar, String localizacao, String codPostal) {
        this.rua = rua;
        this.numPorta = numPorta;
        this.andar = andar;
        this.localizacao = localizacao;
        this.codPostal = codPostal;
    }


}
