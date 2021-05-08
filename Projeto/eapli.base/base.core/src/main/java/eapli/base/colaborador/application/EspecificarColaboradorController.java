package eapli.base.colaborador.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.ColaboradorBuilder;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.funcao.domain.Funcao;
import eapli.base.funcao.repositories.FuncaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;


public class EspecificarColaboradorController {

    private final FuncaoRepository funcRepo = PersistenceContext.repositories().funcao();
    private final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
    private final ColaboradorBuilder colabBuilder = new ColaboradorBuilder();

    public void method(String estrada,String numPorta,String andar,String localizacao,String codPostal,String contacto,
                       String nomeCompleto,String email,String mNumero,String alcunha,String dataDeNascimento){
        colabBuilder.withAddress(estrada,numPorta,andar,localizacao,codPostal).withContact(contacto).withFullName(nomeCompleto)
                .withInstitutionalEmail(email).withNickname(alcunha).withDateOfBirth(dataDeNascimento);
    }

    public void method(ColaboradorDTO colaboradorDTO){
        colabBuilder.withAddress(colaboradorDTO.estrada,colaboradorDTO.numPorta,colaboradorDTO.andar,colaboradorDTO.localizacao,colaboradorDTO.codPostal).withContact(colaboradorDTO.contacto).withFullName(colaboradorDTO.nomeCompleto)
                .withInstitutionalEmail(colaboradorDTO.email).withMecanoGraphicNumber(colaboradorDTO.mNumber).withNickname(colaboradorDTO.alcunha).withDateOfBirth(colaboradorDTO.dataDeNascimento);
    }

    public Iterable<Funcao> getFunctionList(){return funcRepo.findAll();}

    public void defineFunction(Funcao funcao){colabBuilder.withFunction(funcao);}

    public Iterable<Colaborador> getCollaboratorList(){return collabRepo.findAll();}

    public void defineSupervisor(Colaborador supervisor){colabBuilder.withSupervisorMecanoGraphicNumber(supervisor);}

    public Colaborador registerCollaborator(){return colabBuilder.build();}

    public void saveCollaborator(Colaborador colaborador){collabRepo.save(colaborador);}
}
