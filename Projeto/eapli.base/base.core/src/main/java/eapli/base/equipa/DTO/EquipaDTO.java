package eapli.base.equipa.DTO;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.colaborador.dto.ColaboradorDTO;

import java.util.ArrayList;
import java.util.List;

public class EquipaDTO {
    public String descricao;
    public String acronimo;
    public String equipaID;
    public List<ColaboradorDTO> responsaveis = new ArrayList<>();
    public TipoEquipaDTO tipoEquipaDTO;
    public List<ColaboradorDTO> membrosDaEquipa= new ArrayList<>();
    public ColaboradorDTO colaboradorDTO;

    public EquipaDTO(String descricao, String acronimo, String equipaID, List<ColaboradorDTO> responsaveis, TipoEquipaDTO tipoEquipaDTO, List<ColaboradorDTO> membrosDaEquipa) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.responsaveis.addAll(responsaveis);
        this.tipoEquipaDTO = tipoEquipaDTO;
        this.membrosDaEquipa.addAll(membrosDaEquipa);
    }

    public EquipaDTO(String descricao, String acronimo, String equipaID, TipoEquipaDTO tipoEquipaDTO, ColaboradorDTO colaboradorDTO) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.tipoEquipaDTO = tipoEquipaDTO;
        this.colaboradorDTO = colaboradorDTO;
    }

    @Override
    public String toString() {
        return "EquipaDTO{" +
                "descricao='" + descricao + '\'' +
                ", acronimo='" + acronimo + '\'' +
                ", equipaID='" + equipaID + '\'' +
                '}';
    }
}
