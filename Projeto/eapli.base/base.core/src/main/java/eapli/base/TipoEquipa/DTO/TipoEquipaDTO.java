package eapli.base.TipoEquipa.DTO;

import eapli.base.cor.DTO.CorDTO;

public class TipoEquipaDTO {
    public String code;
    public String descricao;
    public CorDTO corDTO;

    public TipoEquipaDTO(String code, String descricao, CorDTO corDTO) {
        this.code = code;
        this.descricao = descricao;
        this.corDTO = corDTO;
    }
}
