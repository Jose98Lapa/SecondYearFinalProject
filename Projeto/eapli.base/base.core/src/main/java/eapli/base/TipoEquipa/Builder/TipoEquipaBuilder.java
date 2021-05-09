package eapli.base.TipoEquipa.Builder;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.Domain.TipoEquipaID;
import eapli.base.cor.Domain.Cor;
import eapli.framework.domain.model.DomainFactory;

public class TipoEquipaBuilder implements DomainFactory<TipoEquipa> {
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

    @Override
    public TipoEquipa build(){
        return new TipoEquipa(tipoEquipaID,descricao,cor);
    }

}
