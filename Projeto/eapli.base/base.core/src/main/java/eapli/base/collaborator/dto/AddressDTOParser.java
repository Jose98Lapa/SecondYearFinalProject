package eapli.base.collaborator.dto;

import eapli.base.collaborator.domain.Address;
import eapli.framework.representations.dto.DTOParser;

public class AddressDTOParser implements DTOParser<AddressDTO, Address> {

    @Override
    public Address valueOf(AddressDTO dto) {
        return new Address(dto.rua, dto.numPorta, dto.andar, dto.localizacao, dto.codPostal);
    }
}
