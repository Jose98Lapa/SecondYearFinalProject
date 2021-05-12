package eapli.base.persistence.impl.inmemory;

import eapli.base.colour.Domain.Colour;
import eapli.base.colour.Domain.Hexadecimal;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryColourRepository extends InMemoryDomainRepository<Colour, Hexadecimal> implements ColourRepository {

    static {
        InMemoryInitializer.init();
    }

}
