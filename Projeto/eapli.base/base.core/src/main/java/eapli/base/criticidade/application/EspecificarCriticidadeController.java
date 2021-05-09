package eapli.base.criticidade.application;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.builder.CriticidadeBuilder;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.criticidade.repository.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EspecificarCriticidadeController {

    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();
    private final CriticidadeBuilder criticidadeBuilder = new CriticidadeBuilder();

    public Criticidade method(CriticidadeDTO dto){
        return criticidadeBuilder.withLabel(dto.label).withValorCriticidade(dto.valorCriticidade).withObjetivoDeAprovacao(dto.tempoMaximoA,dto.tempoMedioA)
                .withObjetivoDeResolucao(dto.tempoMaximoR,dto.tempoMedioR).build();
    }

    public Iterable<Criticidade> getNiveisDeCriticidade(){return criticidadeRepository.findAll();}

    public void save(Criticidade criticidade){criticidadeRepository.save(criticidade);}
}
