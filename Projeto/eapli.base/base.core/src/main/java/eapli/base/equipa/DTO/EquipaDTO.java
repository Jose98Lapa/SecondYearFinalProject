package eapli.base.equipa.DTO;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.colaborador.dto.ColaboradorDTO;

import java.util.List;

public class EquipaDTO {
    public String descricao;
    public String acronimo;
    public String equipaID;
    public List<ColaboradorDTO> responsaveis;
    public TipoEquipaDTO tipoEquipaDTO;

    public EquipaDTO( String equipaID,String acronimo , String descricao,List<ColaboradorDTO> responsaveis,TipoEquipaDTO tipoEquipaDTO) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.responsaveis = responsaveis;
        this.tipoEquipaDTO = tipoEquipaDTO;
    }
}
