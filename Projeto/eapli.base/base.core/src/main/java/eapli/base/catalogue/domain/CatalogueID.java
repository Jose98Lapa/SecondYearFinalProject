package eapli.base.catalogue.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CatalogueID implements ValueObject, Comparable<CatalogueID> , Serializable {
    private String catalogID;

    @Transient
    private String regex = "^[a-zA-Z0-9-]{1,10}$";

    public CatalogueID(final String ID) {
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

    public CatalogueID() {
        //vazio
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogueID catalogueID = (CatalogueID) o;
        return catalogID.equals(catalogueID.catalogID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogID);
    }

    @Override
    public String toString() {
        return  catalogID;
    }

    @Override
    public int compareTo(CatalogueID o) {
        return 0;
    }
}
