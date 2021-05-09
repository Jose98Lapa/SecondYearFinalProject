package eapli.base.criticidade.application;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.builder.CriticidadeBuilder;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.criticidade.dto.CriticidadeDTOParser;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EspecificarCriticidadeController {

    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();
    private final CriticidadeBuilder criticidadeBuilder = new CriticidadeBuilder();

    public CriticidadeDTO method(CriticidadeDTO dto){
        return criticidadeBuilder.withLabel(dto.label).withValorCriticidade(dto.valorCriticidade).withObjetivoDeAprovacao(dto.tempoMaximoA,dto.tempoMedioA)
                .withObjetivoDeResolucao(dto.tempoMaximoR,dto.tempoMedioR).build().toDTO();
    }

    public Iterable<CriticidadeDTO> getNiveisDeCriticidade(){
        Set<CriticidadeDTO> niveisCriticidade = new HashSet<>();
        criticidadeRepository.findAll().forEach(nivel -> niveisCriticidade.add(nivel.toDTO()));
        return niveisCriticidade;
        }


    public void save(CriticidadeDTO criticidadeDTO){
        CriticidadeDTOParser criticidadeDTOParser = new CriticidadeDTOParser();
        criticidadeRepository.save(criticidadeDTOParser.valueOf(criticidadeDTO));}


}
