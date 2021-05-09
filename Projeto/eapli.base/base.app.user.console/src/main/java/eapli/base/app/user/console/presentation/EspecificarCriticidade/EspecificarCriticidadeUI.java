package eapli.base.app.user.console.presentation.EspecificarCriticidade;

import eapli.base.app.user.console.presentation.EspecificarColaborador.EspecificarColaboradorUI;
import eapli.base.criticidade.application.EspecificarCriticidadeController;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.dto.CriticidadeDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class EspecificarCriticidadeUI extends AbstractUI {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecificarColaboradorUI.class);
    private final EspecificarCriticidadeController controller = new EspecificarCriticidadeController();

    @Override
    protected boolean doShow(){
        final CriticidadeDataWidget cdw= new CriticidadeDataWidget();
        Iterator<CriticidadeDTO> iterableCriticidade =controller.getNiveisDeCriticidade().iterator();
        System.out.println("Criticidades Existentes:");
        while (iterableCriticidade.hasNext()){
            System.out.println(iterableCriticidade.next().toString());
        }

        System.out.println("\nInsira a informação necessária para a Criticidade");
        cdw.show();

        CriticidadeDTO criticidadeDTO = new CriticidadeDTO(cdw.label(),cdw.valorCriticidade(), cdw.tempoMaximoA(), cdw.tempoMedioA(), cdw.tempoMaximoR(), cdw.tempoMedioR());
        CriticidadeDTO criticidade = controller.method(criticidadeDTO);

        System.out.println(criticidade);
        boolean answer = Console.readBoolean("A informacao esta correta?(s/n)");
        if (answer)
            controller.save(criticidade);
        else
            return false;
        return true;
    }

    @Override
    public String headline() {
        return "Especificar Criticidade";
    }
}
