package eapli.base.catalogo.application;

import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.application.ListEquipaService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ConsultarServicosController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    public List<CatalogoDTO> procuraServico(int parametro, String valor){
        String email = authz.session().get().authenticatedUser().email().toString();
        Optional<Colaborador> optionalColaborador = collaboratorRepository.getColaboradorByEmail(email);
        if (optionalColaborador.isPresent()){
            Colaborador colaborador = optionalColaborador.get();
            ListCatalogoService listCatalogoService = new ListCatalogoService();
            ListEquipaService listEquipaService = new ListEquipaService();
            Set<String> equipaDTO = new HashSet<>();
            listEquipaService.getEquipasDumColaborador(colaborador).forEach(equipaDTO1 -> equipaDTO.add(equipaDTO1.equipaID));
            return listCatalogoService.allCompatibleCatalogo(equipaDTO);
        }else{
            throw new IllegalArgumentException("Colaborador Inválido");
        }
    }

}
