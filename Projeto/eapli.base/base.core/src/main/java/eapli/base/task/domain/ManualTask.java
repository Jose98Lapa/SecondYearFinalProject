package eapli.base.task.domain;


import eapli.base.form.domain.Form;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.OneToOne;

public abstract class ManualTask extends Task {

    @OneToOne
    private Form form;


    public ManualTask(TaskID taskID, Form form){
        super(taskID);
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
