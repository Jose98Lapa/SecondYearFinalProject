package eapli.base.app.backoffice.console.presentation.SLAObjective;

import eapli.base.ticketTask.application.SLAObjectivesController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class SLAObjectiveUI extends AbstractUI {

    private final SLAObjectivesController slaObjectivesController= new SLAObjectivesController();

    @Override
    protected boolean doShow() {
        List<List<String>> listSLA=slaObjectivesController.SLAObjective();
        for (List<String> ticketSLA :listSLA){
            System.out.println(ticketSLA);
        }
        return true;
    }

    @Override
    public String headline() {
        return "SLA Objectives Completion";
    }
}
