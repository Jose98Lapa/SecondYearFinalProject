package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.general.domain.model.Money;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {

    @Test
    public void ensureCatalogCriteriaAccessIsNotNull() {
        final Set<Colaborador> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        assertThrows(IllegalArgumentException.class,() -> new Catalogo(new Titulo("Titulo"), new Icon("C:/icon.png"),new DescricaoBreve("descição")
        , new DescricaoCompleta("descição completa"), responsableCollabs ,null, null));
    }

    @Test
    public void ensureCatalogCriteriaAccessIsNotEmpty() {
        final Set<Colaborador> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        final Set<Equipa> accessCriteria = new HashSet<>();
        assertThrows(IllegalArgumentException.class,() -> new Catalogo(new Titulo("Titulo"), new Icon("C:/icon.png"),new DescricaoBreve("descição")
                , new DescricaoCompleta("descição completa"), responsableCollabs ,accessCriteria, null));
    }

}