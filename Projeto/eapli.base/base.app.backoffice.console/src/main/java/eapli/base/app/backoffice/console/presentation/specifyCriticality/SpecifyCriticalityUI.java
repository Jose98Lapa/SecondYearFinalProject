package eapli.base.app.backoffice.console.presentation.specifyCriticality;

import eapli.base.app.backoffice.console.presentation.specifyCollaborator.SpecifyCollaboratorUI;
import eapli.base.criticality.application.SpecifyCriticalityController;
import eapli.base.criticality.dto.CriticalityDTO;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class SpecifyCriticalityUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecifyCollaboratorUI.class);
    private final SpecifyCriticalityController controller = new SpecifyCriticalityController();

    @Override
    protected boolean doShow() {
        final CriticalityDataWidget cdw = new CriticalityDataWidget();
        Iterator<CriticalityDTO> iterableCriticidade = controller.getNiveisDeCriticidade().iterator();
        System.out.println("Criticidades Existentes:");
        while (iterableCriticidade.hasNext()) {
            System.out.println(iterableCriticidade.next().toString());
        }

        System.out.println("\nInsira a informação necessária para a Criticidade");
        cdw.show();
        try {
            CriticalityDTO criticalityDTO = new CriticalityDTO(cdw.label(), cdw.valorCriticidade(), cdw.tempoMaximoA(), cdw.tempoMedioA(), cdw.tempoMaximoR(), cdw.tempoMedioR());
            CriticalityDTO criticidade = controller.method(criticalityDTO);

            System.out.println(criticidade);
            boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
            if (answer)
                controller.save(criticidade);
            else
                return false;
        } catch (final IntegrityViolationException | ConcurrencyException | IllegalArgumentException e) {
            System.out.printf("Infelizmente ocorreu um erro na aplicação, por favor tente novamente: %s%n", e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Criticidade";
    }
}
