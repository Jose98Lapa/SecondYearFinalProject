package eapli.base.criticality.application;

import eapli.base.criticality.builder.CriticalityBuilder;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.criticality.dto.CriticalityDTOParser;
import eapli.base.criticality.repository.CriticalityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;

public class SpecifyCriticalityController {

    private final CriticalityRepository criticalityRepository = PersistenceContext.repositories().criticidade();
    private final CriticalityBuilder criticalityBuilder = new CriticalityBuilder();

    public CriticalityDTO method(CriticalityDTO dto){
        return criticalityBuilder.withLabel(dto.label).withValorCriticidade(dto.valorCriticidade).withObjetivoDeAprovacao(dto.tempoMaximoA,dto.tempoMedioA)
                .withObjetivoDeResolucao(dto.tempoMaximoR,dto.tempoMedioR).build().toDTO();
    }

    public Iterable<CriticalityDTO> getNiveisDeCriticidade(){
        Set<CriticalityDTO> niveisCriticidade = new HashSet<>();
        criticalityRepository.findAll().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
        }


    public void save(CriticalityDTO criticalityDTO){
        CriticalityDTOParser criticalityDTOParser = new CriticalityDTOParser();
        criticalityRepository.save(criticalityDTOParser.valueOf(criticalityDTO));}


}
