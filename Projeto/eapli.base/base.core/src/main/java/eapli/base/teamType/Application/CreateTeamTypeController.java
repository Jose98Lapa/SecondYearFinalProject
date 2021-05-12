package eapli.base.teamType.Application;

import eapli.base.teamType.Builder.TeamTypeBuilder;
import eapli.base.teamType.DTO.TeamTypeDTO;
import eapli.base.teamType.Domain.TeamType;
import eapli.base.teamType.repository.TeamTypeRepository;
import eapli.base.colour.Application.ColourList;
import eapli.base.colour.DTO.ColourDTO;
import eapli.base.colour.Domain.Colour;
import eapli.base.colour.Domain.Hexadecimal;
import eapli.base.colour.reposotories.ColourRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class CreateTeamTypeController {
    private final TeamTypeRepository teamTypeRepository = PersistenceContext.repositories().tiposDeEquipa();
    private final TeamTypeBuilder teamTypeBuilder = new TeamTypeBuilder();
    private final ColourList coresList = new ColourList();
    private final ColourRepository colourRepository = PersistenceContext.repositories().cores();

    public void registo(TeamTypeDTO teamTypeDTO){
        Optional<Colour> corOptional = colourRepository.ofIdentity(Hexadecimal.valueOf(teamTypeDTO.colourDTO.valorHexadecimal));
        if (corOptional.isPresent()){
            TeamType teamType = teamTypeBuilder.tipoEquipaID(teamTypeDTO.code).descricao(teamTypeDTO.descricao).cor(corOptional.get()).build();
            teamTypeRepository.save(teamType);
        }

    }

    public Iterable<ColourDTO> getCores(){
        return coresList.corDTOIterable();
    }


}
