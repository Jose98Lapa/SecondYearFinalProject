package eapli.base.team.repositories;


import eapli.base.teamType.Domain.TeamType;
import eapli.base.collaborator.domain.Collaborator;
import eapli.base.team.domain.Acronym;
import eapli.base.team.domain.Team;
import eapli.base.team.domain.TeamID;
import eapli.framework.domain.repositories.DomainRepository;

public interface TeamRepository extends DomainRepository<TeamID, Team> {
    boolean isAcronimoValid(Acronym acronym);

    boolean canIAddTheColaborador(Collaborator collaborator, TeamType teamType);
}
