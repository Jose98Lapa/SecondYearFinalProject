package eapli.base.equipa.application;

import eapli.base.TipoEquipa.Application.ListTipoEquipa;
import eapli.base.TipoEquipa.DTO.TipoEquipaDTO;
import eapli.base.TipoEquipa.repository.TipoEquipaRepository;
import eapli.base.colaborador.domain.*;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.builder.EquipaBuilder;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class CriarEquipaController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository= PersistenceContext.repositories().teams();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tiposDeEquipa();
    private final EquipaBuilder equipaBuilder = new EquipaBuilder();

    public void registo(EquipaDTO equipaDTO){
        //authz.ensureAuthenticatedUserHasAnyOf();
        Optional<Colaborador> colaborador = collaboratorRepository.ofIdentity(NumeroMecanografico.valueOf(equipaDTO.numeroMecanografico));
        if (colaborador.isPresent()){
            Equipa equipa = equipaBuilder.designacao(equipaDTO.descricao).acronimo(equipaDTO.acronimo).equipaID(equipaDTO.equipaID).colaborador(colaborador.get()).build();
            equipaRepository.save(equipa);
        }else{
            throw new IllegalArgumentException("Numero Mecanografico nao presente em sistema");
        }
    }

    public Iterable<TipoEquipaDTO> getTipoEquipaDTO(){
        ListTipoEquipa listTipoEquipa = new ListTipoEquipa();
        return listTipoEquipa.tipoEquipaDTOS();
    }
}
