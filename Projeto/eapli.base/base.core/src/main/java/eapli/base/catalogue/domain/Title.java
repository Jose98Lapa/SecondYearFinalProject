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
public class Title implements ValueObject, Serializable {
    private String catalogTitle;

    @Transient
    private String regex = "^[ a-zA-Z0-9À-ú!?]{1,20}$";

    public Title(String catalogTitle) {
        if (StringPredicates.isNullOrEmpty(catalogTitle) || catalogTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode ser vazio.");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(catalogTitle);

        if (m.matches()) {
            this.catalogTitle = catalogTitle;
        } else {
            throw new IllegalArgumentException("Catalog Title does not fit the criteria");
        }
    }

    public Title() {
        //vazio
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title that = (Title) o;
        return Objects.equals(catalogTitle, that.catalogTitle) && Objects.equals(regex, that.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogTitle, regex);
    }

    @Override
    public String toString() {
        return catalogTitle;
    }

}
