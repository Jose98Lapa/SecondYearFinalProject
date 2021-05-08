package eapli.base.TipoEquipa.Builder;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.Domain.TipoEquipaID;
import eapli.base.cor.Domain.Cor;

public class TipoEquipaBuilder {
    private TipoEquipaID tipoEquipaID;
    private String descricao;
    private Cor cor;

    public TipoEquipaBuilder tipoEquipaID(String tipoEquipaID){
        this.tipoEquipaID = TipoEquipaID.valueOf(tipoEquipaID);
        return this;
    }

    public TipoEquipaBuilder descricao (String descricao){
        this.descricao = descricao;
        return this;
    }

    public TipoEquipaBuilder cor (Cor cor){
        this.cor = cor;
        return this;
    }

    public TipoEquipa build(){
        return new TipoEquipa(tipoEquipaID,descricao,cor);
    }

}
