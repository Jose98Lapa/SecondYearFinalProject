package eapli.base.cor.Application;

import eapli.base.cor.Builder.CorBuilder;
import eapli.base.cor.DTO.CorDTO;
import eapli.base.cor.Domain.Cor;
import eapli.base.cor.reposotories.CorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CriarCorController {
    private final CorRepository corRepository = PersistenceContext.repositories().cores();
    private final CorBuilder corBuilder = new CorBuilder();


    public void registo(CorDTO corDTO){
        Cor cor = corBuilder.nome(corDTO.nome).valorHexadecimal(corDTO.valorHexadecimal).builder();
        corRepository.save(cor);
    }



}
