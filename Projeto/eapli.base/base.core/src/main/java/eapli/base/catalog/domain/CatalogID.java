package eapli.base.catalog.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogID implements ValueObject, Comparable<CatalogID> {
    private String catalogID;
    private String regex = "^[a-zA-Z0-9-]{1,10}$";

    public CatalogID(final String ID) {
        if (StringPredicates.isNullOrEmpty(ID)) {
            throw new IllegalArgumentException("catalog ID should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ID);

        if (m.matches()) {
            this.catalogID = ID;
        } else {
            throw new IllegalArgumentException("catalog ID does not fit the criteria");
        }

        //check if already exists
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogID catalogoID = (CatalogID) o;
        return catalogID == catalogoID.catalogID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogID);
    }

    @Override
    public String toString() {
        return "catalogoID{" +
                "seviceID=" + catalogID +
                '}';
    }

    @Override
    public int compareTo(CatalogID o) {
        return 0;
    }
}
