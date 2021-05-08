package eapli.base.persistence.impl.inmemory;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.Domain.TipoEquipaID;
import eapli.base.TipoEquipa.repository.TipoEquipaRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTipoEquipaRepository extends InMemoryDomainRepository<TipoEquipa, TipoEquipaID> implements TipoEquipaRepository {
    static {
        InMemoryInitializer.init();
    }

}
