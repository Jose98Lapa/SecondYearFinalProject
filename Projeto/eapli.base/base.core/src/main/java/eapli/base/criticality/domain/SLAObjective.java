package eapli.base.criticality.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SLAObjective implements Serializable {
    protected SLAObjective(){}
}
