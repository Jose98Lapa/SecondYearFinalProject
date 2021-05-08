package eapli.base.catalogo.application;

import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.application.ListEquipaService;
import eapli.base.servico.DTO.ServicoDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsultarServicosController {
    public List<CatalogoDTO> procuraServico(int parametro, String valor, Colaborador colaborador){
        ListCatalogoService listCatalogoService = new ListCatalogoService();
        ListEquipaService listEquipaService = new ListEquipaService();
        Set<String> equipaDTO = new HashSet<>();
        listEquipaService.getEquipasDumColaborador(colaborador).forEach(equipaDTO1 -> equipaDTO.add(equipaDTO1.equipaID));

        return listCatalogoService.allCompatibleCatalogo(equipaDTO);
    }

}
