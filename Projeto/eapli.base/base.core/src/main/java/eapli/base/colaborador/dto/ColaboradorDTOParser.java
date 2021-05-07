package eapli.base.colaborador.dto;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.ColaboradorBuilder;
import eapli.base.servico.builder.ServicoBuilder;
import eapli.framework.representations.dto.DTOParser;


public class ColaboradorDTOParser implements DTOParser<ColaboradorDTO, Colaborador> {

    @Override
    public Colaborador valueOf(ColaboradorDTO dto) {
        ColaboradorBuilder colaboradorBuilder = new ColaboradorBuilder();
        return colaboradorBuilder.withAddress(dto.estrada,dto.numPorta,dto.andar,dto.localizacao,dto.codPostal).withContact(dto.contacto).withFullName(dto.nomeCompleto)
                .withInstitutionalEmail(dto.email).withMecanoGraphicNumber(dto.mNumber).withNickname(dto.alcunha).withDateOfBirth(dto.dataDeNascimento).build();
    }

}
