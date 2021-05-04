package eapli.base.servicecatalog.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TituloCatalogo implements ValueObject {
    private String catalogTitle;
    private String regex = "^[a-zA-Z]{1,50}$";

    public TituloCatalogo(String catalogTitle) {
        if (StringPredicates.isNullOrEmpty(catalogTitle)) {
            throw new IllegalArgumentException("Catalog title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(catalogTitle);

        if (m.matches()) {
            this.catalogTitle = catalogTitle;
        } else {
            throw new IllegalArgumentException("Catalog Title does not fit the criteria");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TituloCatalogo that = (TituloCatalogo) o;
        return Objects.equals(catalogTitle, that.catalogTitle) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogTitle, regex);
    }

    @Override
    public String toString() {
        return "tituloCatalogo{" +
                "catalogTitle='" + catalogTitle + '\'' +
                '}';
    }

}
