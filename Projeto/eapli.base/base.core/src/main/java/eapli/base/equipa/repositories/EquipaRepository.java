package eapli.base.equipa.repositories;


import eapli.base.TipoEquipa.Domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.domain.EquipaID;
import eapli.framework.domain.repositories.DomainRepository;

public interface EquipaRepository extends DomainRepository<EquipaID, Equipa> {
    boolean isAcronimoValid(Acronimo acronimo);

    boolean canIAddTheColaborador(Colaborador colaborador, TipoEquipa tipoEquipa);
}
