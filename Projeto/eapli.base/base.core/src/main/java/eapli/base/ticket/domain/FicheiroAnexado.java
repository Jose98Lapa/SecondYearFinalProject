package eapli.base.ticket.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class FicheiroAnexado  implements ValueObject {
    private String file;

    public FicheiroAnexado(String file) {
        if (StringPredicates.isNullOrEmpty(file)) {
            throw new IllegalArgumentException("Ficheiro should neither be null nor empty");
        }
        this.file = file;
    }

    protected FicheiroAnexado() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheiroAnexado that = (FicheiroAnexado) o;
        return Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }

    public static FicheiroAnexado valueOf(String string) {
        return new FicheiroAnexado(string);
    }

    @Override
    public String toString() {
        return  file ;
    }
}