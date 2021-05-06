package eapli.base.catalogo.domain;

public class AccessCriteriaFactory {

    public AccessCriteriaFactory build(AccessCriteriaFormat format) {
        switch (format) {
            case TEAM:
                //return new AccessCriteriaTeamTypeBuilder();
        }
        throw new IllegalStateException("Unknown format");
    }
}
