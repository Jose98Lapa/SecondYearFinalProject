package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ObjetivoSLA {
    protected ObjetivoSLA(){}
}
