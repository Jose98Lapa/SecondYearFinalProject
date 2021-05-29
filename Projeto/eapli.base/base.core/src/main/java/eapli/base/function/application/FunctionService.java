package eapli.base.function.application;

import eapli.base.function.DTO.FunctionDTO;
import eapli.base.function.domain.Function;
import eapli.base.function.domain.IdFunction;
import eapli.base.function.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FunctionService {
    private final FunctionRepository functionRepository = PersistenceContext.repositories().function();
    public Function getFunctionByID(String functionID){
        Optional<Function> functionOptional = functionRepository.ofIdentity(IdFunction.valueOf(functionID));
        if (functionOptional.isEmpty())
            throw new IllegalArgumentException("Função inválida");
        return functionOptional.get();
    }

    public List<FunctionDTO> getFunctionDTOList(){
        List<FunctionDTO> functionDTOList = new ArrayList<>();
        functionRepository.findAll().forEach(function -> functionDTOList.add(function.toDTO()));
        return functionDTOList;
    }

}
