package eapli.base.app.user.console.presentation.criarCatalogo;

import eapli.base.catalogo.application.CreateCatalogController;
import eapli.base.catalogo.dto.CatalogoDTO;
import eapli.base.colaborador.dto.ColaboradorDTO;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.equipa.DTO.EquipaDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@SuppressWarnings("squid:S106")
public class CriarCatalogoUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(CriarCatalogoUI.class);

    private final CreateCatalogController theController = new CreateCatalogController();

    @Override
    protected boolean doShow() {
        final CatalogoDataWidget widget = new CatalogoDataWidget();

        widget.show();

        try {
            this.theController.insertBasicData("1", widget.titulo(), widget.icon(),
                    widget.descBreve(), widget.descCompleta());

            this.theController.defineAccessCriteria(showAccessAndChoose());

            this.theController.defineResponsibleCollaborator(showCollaboratorsAndChoose());



            //this.theController.defineNivelCriticidade(criticidade);

            CatalogoDTO catalogo = this.theController.registerCatalog();

            this.theController.saveCatalog(catalogo);

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("Error performing the operation", e);
            System.out.println("Unfortunatelly there was an unexpected error in the application. " +
                    "Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    protected Set<EquipaDTO> showAccessAndChoose() {
        List<EquipaDTO> lstEquipas = new ArrayList<>();
        this.theController.getTeams().forEach(lstEquipas::add);
        final Set<EquipaDTO> accessCriteria = new HashSet<>();
        int index = 1;

        while (index != 0) {
            for (EquipaDTO dto : lstEquipas)
                System.out.printf("#%d - %s%n", index++, dto.acronimo);
            index = Console.readInteger("Insira o numero da equipa a ter acesso ao catalogo (0 - fim): ");

            if (index > 0 && index-1 < accessCriteria.size() ) {
                accessCriteria.add(lstEquipas.get(index));
                lstEquipas.remove(index);
            }else if (index < 0 && accessCriteria.isEmpty()) {
                System.out.println("Por defeito todas as equipas irão ter acesso ao catalogo.");
                accessCriteria.addAll(lstEquipas);
            }
        }

        return accessCriteria;
    }

    protected Set<ColaboradorDTO> showCollaboratorsAndChoose() {
        List<ColaboradorDTO> lstColaboradores = new ArrayList<>();
        this.theController.getCollabs().forEach(lstColaboradores::add);
        final Set<ColaboradorDTO> responsaveis = new HashSet<>();
        int index = 1;

        while (index != 0) {
            for (ColaboradorDTO dto : lstColaboradores)
                System.out.printf("#%d - %s - %s - %s\n",index++,dto.mNumber,dto.alcunha,dto.nomeCompleto);
            index = Console.readInteger("Escolha um colaborador responsavel pelo catalogo (0 - fim): ");

            if (index > 0 && index-1 < lstColaboradores.size()) {
                responsaveis.add(lstColaboradores.get(index));
                lstColaboradores.remove(index);
            }else if (index < 0 && responsaveis.isEmpty()) {
                System.out.println("Um catalogo precisa de ter pelo menos um colaborador responsavel.");
                index=1;
            }
        }
        return responsaveis;
    }

    protected CriticidadeDTO showCriticityAndChoose() {
        List<CriticidadeDTO> lstCriticidade = new ArrayList<>();
        this.theController.getCriticidades().forEach(lstCriticidade::add);
        CriticidadeDTO criticidade = null;
        int index = 1;

        while (index != 0) {
            for (CriticidadeDTO dto : lstCriticidade)
                System.out.printf("#%d %n", index++);
            index = Console.readInteger("Escolha uma criticidade para o catalogo: ");

            if (index > 0 && index-1 < lstCriticidade.size()) {
                criticidade = lstCriticidade.get(index);
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
