package eapli.base.teamType.DTO;

import eapli.base.colour.DTO.ColourDTO;
import eapli.framework.representations.dto.DTO;

@DTO
public class TeamTypeDTO {
    public String code;
    public String descricao;
    public ColourDTO colourDTO;

    public TeamTypeDTO(String code, String descricao, ColourDTO colourDTO) {
        this.code = code;
        this.descricao = descricao;
        this.colourDTO = colourDTO;
    }

    @Override
    public String toString() {
        return "TipoEquipaDTO{" +
                "code='" + code + '\'' +
                ", descricao='" + descricao + '\'' +
                ", corDTO=" + colourDTO +
                '}';
    }
}
