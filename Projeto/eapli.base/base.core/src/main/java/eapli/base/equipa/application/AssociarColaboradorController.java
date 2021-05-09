package eapli.base.equipa.application;

import eapli.base.colaborador.application.ListColaboradorService;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class AssociarColaboradorController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().teams();

    public Iterable<EquipaDTO> getEquipas() {
        ListEquipaService servicoListarEquipas = new ListEquipaService();
        return servicoListarEquipas.allTeams();
    }

    public Iterable<ColaboradorDTO> getColaboradores() {
        ListColaboradorService servicoListarColaboradores = new ListColaboradorService();
        return servicoListarColaboradores.colaboradores();
    }

    public void save( EquipaDTO equipaDTO ) {
        Colaborador colaborador = new ColaboradorDTOParser().valueOf(equipaDTO.colaboradorDTO);
        TipoEquipa tipoEquipa = new TipoEquipaDTOParser().valueOf(equipaDTO.tipoEquipaDTO);

        if (equipaRepository.canIAddTheColaborador(colaborador, tipoEquipa)) {
            List<Colaborador> colaboradorList = new ArrayList<>();
            colaboradorList.add(colaborador);

            Equipa equipa = equipaBuilder
                    .designacao(equipaDTO.descricao)
                    .acronimo(equipaDTO.acronimo)
                    .equipaID(equipaDTO.equipaID)
                    .responsaveis(colaboradorList)
                    .tipoDeEquipa(tipoEquipa)
                    .build();

            equipaRepository.save(equipa);

        } else {
            throw new IllegalArgumentException("Este colaborador já gere uma equipa deste tipo");
        }
    }

}
