package eapli.base.teamtype.domain;

import eapli.framework.domain.model.AggregateRoot;

public class TeamType implements AggregateRoot<TeamTypeID> {
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(TeamTypeID other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public TeamTypeID identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(TeamTypeID otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }
}
