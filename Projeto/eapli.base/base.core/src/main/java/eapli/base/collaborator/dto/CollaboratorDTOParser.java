package eapli.base.collaborator.dto;

import eapli.base.collaborator.domain.Collaborator;
import eapli.base.collaborator.builder.CollaboratorBuilder;
import eapli.base.collaborator.domain.MecanographicNumber;
import eapli.base.collaborator.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.representations.dto.DTOParser;

import java.util.Optional;


public class CollaboratorDTOParser implements DTOParser<CollaboratorDTO, Collaborator> {

    final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();

    @Override
    public Collaborator valueOf(CollaboratorDTO dto) {
        CollaboratorBuilder collaboratorBuilder = new CollaboratorBuilder();
        if (dto.mSupervisor==null)
            return collaboratorBuilder.withAddress(dto.rua,dto.numPorta,dto.andar,dto.localizacao,dto.codPostal).withContact(dto.contacto).withFullName(dto.nomeCompleto)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.alcunha).withDateOfBirth(dto.dataDeNascimento).withFunction(dto.IDfuncao,dto.designacao).build();

        final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
        Optional<Collaborator> supervisor = collabRepo.ofIdentity(new MecanographicNumber(dto.mSupervisor));
        return collaboratorBuilder.withAddress(dto.rua,dto.numPorta,dto.andar,dto.localizacao,dto.codPostal).withContact(dto.contacto).withFullName(dto.nomeCompleto)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.alcunha).withDateOfBirth(dto.dataDeNascimento)
                .withFunction(dto.IDfuncao,dto.designacao).withSupervisor(supervisor.get()).build();
    }





}
