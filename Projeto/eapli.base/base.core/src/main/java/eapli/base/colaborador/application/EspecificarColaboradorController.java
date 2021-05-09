package eapli.base.colaborador.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.builder.ColaboradorBuilder;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.dto.ColaboradorDTOParser;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.funcao.DTO.FuncaoDTO;
import eapli.base.funcao.DTO.FuncaoDTOParser;
import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.HashSet;
import java.util.Set;


public class EspecificarColaboradorController {

    private final FuncaoRepository funcRepo = PersistenceContext.repositories().funcao();
    private final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
    private final ColaboradorBuilder colabBuilder = new ColaboradorBuilder();
    private final ColaboradorDTOParser colaboradorDTOParser = new ColaboradorDTOParser();

    public void method(ColaboradorDTO colaboradorDTO){
        colabBuilder.withAddress(colaboradorDTO.rua,colaboradorDTO.numPorta,colaboradorDTO.andar,colaboradorDTO.localizacao,colaboradorDTO.codPostal).withContact(colaboradorDTO.contacto).withFullName(colaboradorDTO.nomeCompleto)
                .withInstitutionalEmail(colaboradorDTO.email).withMecanoGraphicNumber(colaboradorDTO.mNumber).withNickname(colaboradorDTO.alcunha).withDateOfBirth(colaboradorDTO.dataDeNascimento);
    }

    public Iterable<FuncaoDTO> getFunctionList(){
        Set<FuncaoDTO> funcaoSet = new HashSet<>();
        funcRepo.findAll().forEach(funcao -> funcaoSet.add(funcao.toDTO()));
        return funcaoSet;}

    public void defineFunction(FuncaoDTO funcao){
        FuncaoDTOParser funcaoDTOParser = new FuncaoDTOParser();
        colabBuilder.withFunction(funcaoDTOParser.valueOf(funcao));}

    public Iterable<ColaboradorDTO> getCollaboratorList(){
        Set<ColaboradorDTO> colaboradorSet = new HashSet<>();
        collabRepo.findAll().forEach(collab -> colaboradorSet.add(collab.toDTO()));
        return colaboradorSet;
    }

    public void defineSupervisor(ColaboradorDTO supervisor){
        colabBuilder.withSupervisor(colaboradorDTOParser.valueOf(supervisor));}

    public ColaboradorDTO registerCollaborator(){return colabBuilder.build().toDTO();}

    public void saveCollaborator(ColaboradorDTO colaborador){collabRepo.save(colaboradorDTOParser.valueOf(colaborador));}
}
