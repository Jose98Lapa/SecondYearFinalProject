package eapli.base.collaborator.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;

@Entity
public class Collaborator implements AggregateRoot<MecanographicNumber> {


    public Collaborator() {
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(MecanographicNumber other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public MecanographicNumber identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(MecanographicNumber otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }

}
