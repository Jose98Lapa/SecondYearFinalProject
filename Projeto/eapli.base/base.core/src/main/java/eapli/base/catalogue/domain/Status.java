package eapli.base.catalogue.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.Calendars;

import javax.persistence.Embeddable;
import java.util.Calendar;

@Embeddable
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
