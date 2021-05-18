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
            return collaboratorBuilder.withPlaceOfResidence(dto.placeOfResidence).withContact(dto.contact).withFullName(dto.fullName)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.nickname).withDateOfBirth(dto.dateOfBirth).withFunction(dto.idFunction,dto.designation).build();

        final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
        Optional<Collaborator> supervisor = collabRepo.ofIdentity(new MecanographicNumber(dto.mSupervisor));
        return collaboratorBuilder.withPlaceOfResidence(dto.placeOfResidence).withContact(dto.contact).withFullName(dto.fullName)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.nickname).withDateOfBirth(dto.dateOfBirth)
                .withFunction(dto.idFunction,dto.designation).withSupervisor(supervisor.get()).build();
    }





}
