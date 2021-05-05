package eapli.base.atributo;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtributoTipo implements ValueObject {
    private String tipo;
    private String regex = "String|int|boolean|char";
    
    public AtributoTipo(String tipo) {
        if (StringPredicates.isNullOrEmpty(tipo)) {
            throw new IllegalArgumentException("Type should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(tipo);

        if (m.matches()) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Type does not fit the criteria");
        }
    }
}
