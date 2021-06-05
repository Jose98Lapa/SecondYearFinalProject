package eapli.base.task.domain;


import eapli.base.form.domain.Form;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Entity
public abstract class ManualTask extends Task implements Serializable {

    @OneToOne
    private Form form;


    public ManualTask(Form form){
        super();
        this.form = form;
    }

    protected ManualTask(){
        // For ORM
    }



    public Form form(){
        return form;
    }



    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public TaskID identity() {
        return super.taskID;
    }


}
