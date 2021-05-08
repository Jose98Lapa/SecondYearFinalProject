package eapli.base.equipa.DTO;

import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.EquipaID;

public class EquipaDTO {
    public String descricao;
    public String acronimo;
    public String equipaID;
    public String numeroMecanografico;
    public TipoEquipaDTO tipoEquipaDTO;

    public EquipaDTO( String equipaID,String acronimo , String descricao,String numeroMecanografico,TipoEquipaDTO tipoEquipaDTO) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
        this.numeroMecanografico = numeroMecanografico;
        this.tipoEquipaDTO = tipoEquipaDTO;
    }
}
