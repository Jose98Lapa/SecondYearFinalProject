package eapli.base.catalogo.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.Calendars;

import java.util.Calendar;

public class Status implements ValueObject {
    private Calendar dataDisponibilidade;
    private boolean status;

    public Status(){
        status= true;
        dataDisponibilidade = Calendars.now();
    }

    public Status(final Calendar startsOn){
        status = false;
        dataDisponibilidade = startsOn;
    }


}
