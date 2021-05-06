package eapli.base.equipa.DTO;

import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.EquipaID;

public class EquipaDTO {
    public String descricao;
    public String acronimo;
    public String equipaID;

    public EquipaDTO(String descricao, Acronimo acronimo, EquipaID equipaID) {
        this.descricao = descricao;
        this.acronimo = acronimo.toString();
        this.equipaID = equipaID.toString();
    }
}
