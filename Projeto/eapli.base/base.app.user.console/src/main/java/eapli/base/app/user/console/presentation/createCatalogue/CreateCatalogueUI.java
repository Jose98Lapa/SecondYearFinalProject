package eapli.base.app.user.console.presentation.createCatalogue;

import eapli.base.catalogue.application.CreateCatalogueController;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.collaborator.dto.CollaboratorDTO;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.base.team.DTO.TeamDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@SuppressWarnings("squid:S106")
public class CreateCatalogueUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCatalogueUI.class);

    private final CreateCatalogueController theController = new CreateCatalogueController();

    @Override
    protected boolean doShow() {
        final CatalogueDataWidget widget = new CatalogueDataWidget();

        widget.show();

        try {
            this.theController.insertBasicData(widget.titulo(), widget.icon(),
                    widget.descBreve(), widget.descCompleta());

            this.theController.defineAccessCriteria(showAccessAndChoose());

            this.theController.defineResponsibleCollaborator(showCollaboratorsAndChoose());



            this.theController.defineCriticidade(showCriticityAndChoose());


            CatalogueDTO catalogo = this.theController.registerCatalog();
            showCatalogDTO(catalogo);

            if(Console.readBoolean("Confirma (s/n)"))
                this.theController.saveCatalog(catalogo);

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("Error performing the operation", e);
            System.out.println("Unfortunatelly there was an unexpected error in the application. " +
                    "Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    protected  void showCatalogDTO(CatalogueDTO dto){
        System.out.println("Dados Catalogo:");
        System.out.printf("Titulo: %s%nDescrição Breve: %s%nDescrição Completa: %s%n",dto.catalogTitle,dto.briefDesc,dto.completeDesc);
        System.out.println("Criterios de acesso:");
        dto.accessCriteria.forEach(eDto -> System.out.printf("  -> %s%n",eDto.acronimo));
        System.out.println("Colaboradores Responsaveis:");
        dto.responsableCollabs.forEach(cDto -> System.out.printf("  -> %s - %s%n",cDto.alcunha,cDto.nomeCompleto));
        System.out.println("Nivel de Criticidade:");
        System.out.printf("  -> %s - %s%n",dto.nivelCriticidade.label,dto.nivelCriticidade.valorCriticidade);
    }

    protected Set<TeamDTO> showAccessAndChoose() {
        List<TeamDTO> lstEquipas = new ArrayList<>();
        this.theController.getTeams().forEach(lstEquipas::add);
        final Set<TeamDTO> accessCriteria = new HashSet<>();
        int index = 1;

        System.out.printf("%n%s%n","Lista Criterios de Acesso:");
        while (index != 0) {
            for (TeamDTO dto : lstEquipas)
                System.out.printf("#%d - %s%n", index++, dto.acronimo);
            index = Console.readInteger("Insira o numero da equipa a ter acesso ao catalogo (0 - fim): ");

            if (index > 0 && index-1 < lstEquipas.size() ) {
                accessCriteria.add(lstEquipas.get(index-1));
                lstEquipas.remove(index-1);
                if(lstEquipas.isEmpty())
                    index = 0;
            }else if (index < 0 && accessCriteria.isEmpty()) {
                System.out.println("Por defeito todas as equipas irão ter acesso ao catalogo.");
                accessCriteria.addAll(lstEquipas);
            }
        }

        return accessCriteria;
    }

    protected Set<CollaboratorDTO> showCollaboratorsAndChoose() {
        List<CollaboratorDTO> lstColaboradores = new ArrayList<>();
        this.theController.getCollabs().forEach(lstColaboradores::add);
        final Set<CollaboratorDTO> responsaveis = new HashSet<>();
        int index = 1;

        System.out.printf("%n%s%n","Lista Colaboradores:");
        while (index != 0) {
            for (CollaboratorDTO dto : lstColaboradores)
                System.out.printf("#%d - %s - %s - %s%n",index++,dto.mNumber,dto.alcunha,dto.nomeCompleto);
            index = Console.readInteger("Escolha um colaborador responsavel pelo catalogo (0 - fim): ");

            if (index > 0 && index-1 < lstColaboradores.size()) {
                responsaveis.add(lstColaboradores.get(index-1));
                lstColaboradores.remove(index-1);
                if(lstColaboradores.isEmpty())
                    index = 0;
            }else if (index < 0 && responsaveis.isEmpty()) {
                System.out.println("Um catalogo precisa de ter pelo menos um colaborador responsavel.");
                index=1;
            }
        }
        return responsaveis;
    }

    protected CriticalityDTO showCriticityAndChoose() {
        List<CriticalityDTO> lstCriticidade = new ArrayList<>();
        this.theController.getCriticidades().forEach(lstCriticidade::add);
        CriticalityDTO criticidade = null;
        int index = 1;

        System.out.printf("%n%s%n","Lista Niveis criticidade:");
        while (index != 0) {
            for (CriticalityDTO dto : lstCriticidade)
                System.out.printf("#%d %s - %s5n", index++,dto.label,dto.valorCriticidade);
            index = Console.readInteger("Escolha uma criticidade para o catalogo: ");

            if (index > 0 && index-1 < lstCriticidade.size()) {
                criticidade = lstCriticidade.get(index-1);
                index = 0;
            }
        }
        return criticidade;
    }


    @Override
    public String headline() {
        return "Criar Catalogo";
    }
}
