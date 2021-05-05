package eapli.base.catalog.domain;

public class AccessCriteriaFactory {

    public AccessCriteriaFactory build(AccessCriteriaFormat format) {
        switch (format) {
            case TEAMTYPE:
                //return new AccessCriteriaTeamTypeBuilder();
        }
        throw new IllegalStateException("Unknown format");
    }
}
