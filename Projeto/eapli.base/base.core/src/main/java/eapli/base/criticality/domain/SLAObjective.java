package eapli.base.criticality.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SLAObjective {
    protected SLAObjective(){}
}
