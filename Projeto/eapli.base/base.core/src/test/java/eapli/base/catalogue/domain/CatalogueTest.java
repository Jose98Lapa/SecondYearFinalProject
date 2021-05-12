package eapli.base.catalogue.domain;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.domain.Team;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogueTest {

    @Test
    public void ensureCatalogCriteriaAccessIsNotNull() {
        final Set<Collaborator> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        assertThrows(IllegalArgumentException.class,() -> new Catalogue(new Title("Titulo"), new Icon("C:/icon.png"),new BriefDescription("descição")
        , new CompleteDescription("descição completa"), responsableCollabs ,null, null));
    }

    @Test
    public void ensureCatalogCriteriaAccessIsNotEmpty() {
        final Set<Collaborator> responsableCollabs = new HashSet<>();
        responsableCollabs.add(null); //add colaborador
        final Set<Team> accessCriteria = new HashSet<>();
        assertThrows(IllegalArgumentException.class,() -> new Catalogue(new Title("Titulo"), new Icon("C:/icon.png"),new BriefDescription("descição")
                , new CompleteDescription("descição completa"), responsableCollabs ,accessCriteria, null));
    }

}