package eapli.base.app.user.console.presentation.CriarCatalogo;

import eapli.base.catalogo.application.CreateCatalogController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.base.equipa.domain.Equipa;
import eapli.base.myclientuser.application.SignupController;
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
            this.theController.insertBasicData("1",widget.titulo(),widget.icon(), widget.descBreve(), widget.descCompleta());
            //this.theController.getTeams().iterator();
            List<Equipa> lstEquipas = new ArrayList<>();
            final Set<Equipa> accessCriteria = new HashSet<>();

            int index=1;
            for(Equipa equipa : lstEquipas)
                System.out.printf("#%d - %s\n",index++,equipa.acronimo());

            index = Console.readInteger("Insira o numero da equipa a ter acesso ao catalogo: ");
            accessCriteria.add(lstEquipas.get(index));

            this.theController.defineAccessCriteria(accessCriteria);

            //this.theController.getCollabs();
            List<Colaborador> lstColaboradores = new ArrayList<>();
            final Set<Colaborador> responsaveis = new HashSet<>();

            index=1;
            for(Colaborador collab : lstColaboradores)
                //System.out.printf("#%d - %s - %s - %s\n",index++,collab.mNumber(),collab.alcunha(),collab.nomeCompleto());

            index = Console.readInteger("Escolha um colaborador responsavel pelo catalogo: ");
            responsaveis.add(lstColaboradores.get(index));

            this.theController.defineResponsibleCollaborator(responsaveis);

            //this.theController.getCriticidades();
            List<CriticidadeDTO> lstCriticidade = new ArrayList<>();

            index=1;
            for(CriticidadeDTO criticidade : lstCriticidade)
                System.out.printf("#%d \n",index++);

            index = Console.readInteger("Escolha uma criticidade para o catalogo: ");
            CriticidadeDTO criticidade = lstCriticidade.get(index);

            //this.theController.defineNivelCriticidade(criticidade);

            Catalogo catalogo = this.theController.registerCatalog();

            this.theController.saveCatalog(catalogo);

        } catch (final IntegrityViolationException | ConcurrencyException e) {
            LOGGER.error("Error performing the operation", e);
            System.out.println("Unfortunatelly there was an unexpected error in the application. " +
                    "Please try again and if the problem persists, contact your system admnistrator.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Sign Up";
    }
}
