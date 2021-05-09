package eapli.base.catalogo.application;

import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.catalogo.dto.CatalogoDTOParser;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.EmailInstitucional;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.equipa.application.ListEquipaService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.Application.ListServicoService;
import eapli.base.servico.DTO.ServicoDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.*;

public class ConsultarServicosController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CollaboratorRepository collaboratorRepository = PersistenceContext.repositories().collaborators();
    public List<ServicoDTO> procuraServico(int parametro, String valor){
        String email = authz.session().get().authenticatedUser().email().toString();
        Optional<Colaborador> optionalColaborador = collaboratorRepository.getColaboradorByEmail(EmailInstitucional.valueOf(email));
        if (optionalColaborador.isPresent()){
            Colaborador colaborador = optionalColaborador.get();
            ListCatalogoService listCatalogoService = new ListCatalogoService();
            ListEquipaService listEquipaService = new ListEquipaService();
            ListServicoService listServicoService = new ListServicoService();
            Set<String> equipaDTO = new HashSet<>();
            listEquipaService.getEquipasDumColaborador(colaborador).forEach(equipaDTO1 -> equipaDTO.add(equipaDTO1.equipaID));
            List<ServicoDTO> servicoDTOList = new ArrayList<>();
            for (CatalogoDTO catalogoDTO : listCatalogoService.allCompatibleCatalogo(equipaDTO)){
                servicoDTOList.addAll(listServicoService.getServicoDTOByCatalogo(new CatalogoDTOParser().valueOf(catalogoDTO)));
            }
            return servicoDTOList;
        }else{
            throw new IllegalArgumentException("Colaborador Inválido");
        }
    }

}
