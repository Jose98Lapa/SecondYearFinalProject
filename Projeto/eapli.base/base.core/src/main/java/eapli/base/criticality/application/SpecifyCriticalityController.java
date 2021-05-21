package eapli.base.criticality.application;

import eapli.base.criticality.builder.CriticalityBuilder;
import eapli.base.criticality.domain.ApprovalObjective;
import eapli.base.criticality.domain.Criticality;
import eapli.base.criticality.domain.ResolutionObjective;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.criticality.dto.CriticalityDTOParser;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpecifyCriticalityController {

    private final CriticalityRepository criticalityRepository = PersistenceContext.repositories().criticidade();
    private final CriticalityBuilder criticalityBuilder = new CriticalityBuilder();

    public CriticalityDTO method(CriticalityDTO dto) {
        return criticalityBuilder.withLabel(dto.label).withValorCriticidade(dto.valorCriticidade).withObjetivoDeAprovacao(dto.tempoMaximoA, dto.tempoMedioA)
                .withObjetivoDeResolucao(dto.tempoMaximoR, dto.tempoMedioR).isGlobal(true).build().toDTO();
    }

    public Iterable<CriticalityDTO> getNiveisDeCriticidade() {
        Set<CriticalityDTO> niveisCriticidade = new HashSet<>();
        criticalityRepository.findAllGlobal().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
    }


    public Criticality save(CriticalityDTO criticalityDTO) {
        CriticalityDTOParser criticalityDTOParser = new CriticalityDTOParser();
        Criticality criticality = criticalityDTOParser.valueOf(criticalityDTO);
        Optional<ApprovalObjective> aO = criticalityRepository.ofApprovalObjective(criticalityDTO.tempoMaximoA,criticalityDTO.tempoMedioA);
        aO.ifPresent(criticality::changeApprovalObjectiveTo);

        Optional<ResolutionObjective> rO = criticalityRepository.ofResolutionObjective(criticalityDTO.tempoMaximoR,criticalityDTO.tempoMedioR);
        rO.ifPresent(criticality::changeResolutionObjectiveTo);

        return criticalityRepository.save(criticality);
    }


}
