package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class TituloServico implements ValueObject {
    private String serviceTitle;
    private String regex = "^[a-zA-Z]{1,50}$";

    public TituloServico(String serviceTitle) {
        if (StringPredicates.isNullOrEmpty(serviceTitle)) {
            throw new IllegalArgumentException("Service title should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(serviceTitle);

        if (m.matches()) {
            this.serviceTitle = serviceTitle;
        } else {
            throw new IllegalArgumentException("Service Title does not fit the criteria");
        }
    }

    protected TituloServico() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TituloServico that = (TituloServico) o;
        return Objects.equals(serviceTitle, that.serviceTitle) && Objects.equals(regex, that.regex);
    }

    public static TituloServico valueOf(String string) {
        return new TituloServico(string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceTitle, regex);
    }

    @Override
    public String toString() {
        return serviceTitle;
    }

}
