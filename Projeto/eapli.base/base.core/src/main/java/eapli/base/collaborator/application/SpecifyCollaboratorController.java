package eapli.base.collaborator.application;

import eapli.base.collaborator.builder.CollaboratorBuilder;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.collaborator.dto.CollaboratorDTOParser;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.function.DTO.FunctionDTO;
import eapli.base.function.DTO.FunctionDTOParser;
import eapli.base.function.repositories.FunctionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;


public class SpecifyCollaboratorController {

    private final FunctionRepository funcRepo = PersistenceContext.repositories().funcao();
    private final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
    private final CollaboratorBuilder colabBuilder = new CollaboratorBuilder();
    private final CollaboratorDTOParser collaboratorDTOParser = new CollaboratorDTOParser();

    public void method(CollaboratorDTO collaboratorDTO){
        colabBuilder.withPlaceOfResidence(collaboratorDTO.placeOfResidence).withContact(collaboratorDTO.contacto).withFullName(collaboratorDTO.nomeCompleto)
                .withInstitutionalEmail(collaboratorDTO.email).withMecanoGraphicNumber(collaboratorDTO.mNumber).withNickname(collaboratorDTO.alcunha).withDateOfBirth(collaboratorDTO.dataDeNascimento);
    }

    public Iterable<FunctionDTO> getFunctionList(){
        Set<FunctionDTO> funcaoSet = new HashSet<>();
        funcRepo.findAll().forEach(funcao -> funcaoSet.add(funcao.toDTO()));
        return funcaoSet;}

    public void defineFunction(FunctionDTO funcao){
        FunctionDTOParser functionDTOParser = new FunctionDTOParser();
        colabBuilder.withFunction(functionDTOParser.valueOf(funcao));}

    public Iterable<CollaboratorDTO> getCollaboratorList(){
        Set<CollaboratorDTO> colaboradorSet = new HashSet<>();
        collabRepo.findAll().forEach(collab -> colaboradorSet.add(collab.toDTO()));
        return colaboradorSet;
    }

    public void defineSupervisor(CollaboratorDTO supervisor){
        colabBuilder.withSupervisor(collaboratorDTOParser.valueOf(supervisor));}

    public CollaboratorDTO registerCollaborator(){return colabBuilder.build().toDTO();}

    public void saveCollaborator(CollaboratorDTO colaborador){collabRepo.save(collaboratorDTOParser.valueOf(colaborador));}
}
