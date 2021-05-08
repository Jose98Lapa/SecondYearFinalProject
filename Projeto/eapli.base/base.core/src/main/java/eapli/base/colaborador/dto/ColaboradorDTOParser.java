package eapli.base.colaborador.dto;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.ColaboradorBuilder;
import eapli.base.colaborador.domain.NumeroMecanografico;
import eapli.base.colaborador.repositories.CollaboratorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.framework.representations.dto.DTOParser;

import java.util.Optional;


public class ColaboradorDTOParser implements DTOParser<ColaboradorDTO, Colaborador> {

    final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();

    @Override
    public Colaborador valueOf(ColaboradorDTO dto) {
        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        if (dto.mSupervisor.isEmpty())
            return colaboradorBuilder.withAddress(dto.rua,dto.numPorta,dto.andar,dto.localizacao,dto.codPostal).withContact(dto.contacto).withFullName(dto.nomeCompleto)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.alcunha).withDateOfBirth(dto.dataDeNascimento).withFunction(dto.IDfuncao,dto.designacao).build();

        final CollaboratorRepository collabRepo = PersistenceContext.repositories().collaborators();
        Optional<Colaborador> supervisor = collabRepo.ofIdentity(new NumeroMecanografico(dto.mSupervisor));
        return colaboradorBuilder.withAddress(dto.rua,dto.numPorta,dto.andar,dto.localizacao,dto.codPostal).withContact(dto.contacto).withFullName(dto.nomeCompleto)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.alcunha).withDateOfBirth(dto.dataDeNascimento)
                .withFunction(dto.IDfuncao,dto.designacao).withSupervisor(supervisor.get()).build();
    }





}
