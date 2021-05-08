package eapli.base.TipoEquipa.repository;

import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.TipoEquipa.Domain.TipoEquipaID;
import eapli.framework.domain.repositories.DomainRepository;

public interface TipoEquipaRepository extends DomainRepository<TipoEquipaID,TipoEquipa> {
    Iterable<TipoEquipa> findAll();
}
