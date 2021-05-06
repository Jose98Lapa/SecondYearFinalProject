package eapli.base.equipa.DTO;

import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.EquipaID;

public class EquipaDTO {
    public String descricao;
    public String acronimo;
    public String equipaID;

    public EquipaDTO(String descricao, String acronimo, String equipaID) {
        this.descricao = descricao;
        this.acronimo = acronimo;
        this.equipaID = equipaID;
    }
}
