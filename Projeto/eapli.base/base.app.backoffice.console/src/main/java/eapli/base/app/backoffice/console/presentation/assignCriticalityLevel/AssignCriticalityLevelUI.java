package eapli.base.app.backoffice.console.presentation.assignCriticalityLevel;

import eapli.base.catalogue.application.AssignCriticalityLevelController;
import eapli.base.catalogue.dto.CatalogueDTO;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("squid:S106")
public class AssignCriticalityLevelUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssignCriticalityLevelUI.class);

    private final AssignCriticalityLevelController theController = new AssignCriticalityLevelController();

    @Override
    protected boolean doShow() {
        try {
            CatalogueDTO Catalogue = showCatalogueAndChoose();
            CriticalityDTO newCriticidade = showCriticityAndChoose();
            CatalogueDTO updatedCatalogo = this.theController.changeCriticalityLevel(Catalogue,newCriticidade);
            showCatalogDTO(updatedCatalogo);

            if (Console.readBoolean("Confirma (s/n)")) {
                this.theController.updateCatalogue(updatedCatalogo);
            }

        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }

        return true;
    }

    protected void showCatalogDTO(CatalogueDTO dto) {
        System.out.println("Dados Catalogo:");
        System.out.printf("Titulo: %s%nDescrição Breve: %s%nDescrição Completa: %s%n", dto.catalogTitle, dto.briefDesc, dto.completeDesc);
        System.out.println("Criterios de acesso:");
        dto.accessCriteria.forEach(eDto -> System.out.printf("  -> %s%n", eDto.acronimo));
        System.out.println("Colaboradores Responsaveis:");
        dto.responsableCollabs.forEach(cDto -> System.out.printf("  -> %s - %s%n", cDto.nickname, cDto.fullName));
        System.out.println("Nivel de Criticidade:");
        System.out.printf("  -> %s - %s%n", dto.nivelCriticidade.label, dto.nivelCriticidade.valorCriticidade);
    }

    protected CatalogueDTO showCatalogueAndChoose() {
        List<CatalogueDTO> lstCatalogue = new ArrayList<>();
        this.theController.getCatalogueLst().forEach(lstCatalogue::add);
        CatalogueDTO criticidade = null;
        int index = 1;

        System.out.printf("%n%s%n", "Lista Catalogos:");
        while (index != 0) {
            for (CatalogueDTO dto : lstCatalogue)
                System.out.printf("#%d %s - %s - nivel criticidade: %s%n", index++, dto.catalogTitle, dto.briefDesc, dto.nivelCriticidade.label);
            index = Console.readInteger("Escolha um catalogo: ");

            if (index > 0 && index - 1 < lstCatalogue.size()) {
                criticidade = lstCatalogue.get(index - 1);
                index = 0;
            }
        }
        return criticidade;
    }


    protected CriticalityDTO showCriticityAndChoose() {
        List<CriticalityDTO> lstCriticidade = new ArrayList<>();
        this.theController.getCriticalityLst().forEach(lstCriticidade::add);
        CriticalityDTO criticidade = null;
        int index = 1;

        System.out.printf("%n%s%n", "Lista Niveis criticidade:");
        while (index != 0) {
            for (CriticalityDTO dto : lstCriticidade)
                System.out.printf("#%d %s - %s%n", index++, dto.label, dto.valorCriticidade);
            index = Console.readInteger("Escolha uma criticidade para o catalogo (0 para criar): ");

            if (index > 0 && index - 1 < lstCriticidade.size()) {
                criticidade = lstCriticidade.get(index - 1);
                index = 0;
            } else if (index == 0) {
                criticidade = createNonGlobalCriticalityLevel();
            }
        }
        return criticidade;
    }


    protected CriticalityDTO createNonGlobalCriticalityLevel() {
        System.out.println("\nInsira a informação necessária para a Criticidade");
        String valorCriticidade = Console.readLine("ValorCriticidade:");
        String label = Console.readLine("Label:");
        System.out.println("\n--Objetivo de Aprovação [HH:MM]--");
        String tempoMaximoA = Console.readLine("Tempo Maximo:");
        String tempoMedioA = Console.readLine("Tempo Medio:");
        System.out.println("\n--Objetivo de Resolção [HH:MM]--");
        String tempoMaximoR = Console.readLine("Tempo Maximo:");
        String tempoMedioR = Console.readLine("Tempo Maximo:");
        try {
            CriticalityDTO criticalityDTO = new CriticalityDTO((long) 0, label, valorCriticidade, tempoMaximoA, tempoMedioA, tempoMaximoR, tempoMedioR,false);

            CriticalityDTO criticidade = theController.createNonGlobalCriticalityLevel(criticalityDTO);

            System.out.println(criticidade);
            boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
            if (answer)
                return criticidade;
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return null;
    }


    @Override
    public String headline() {
        return "Criar Catalogo";
    }
}
