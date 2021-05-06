package eapli.base.servico.Domain;

import eapli.base.atributo.domain.AtributoNome;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class KeyWords implements ValueObject {
    private String keyword;
    private String regex = "^[a-zA-Z]{1,10}$";

    public KeyWords(String keyword) {
        if (StringPredicates.isNullOrEmpty(keyword)) {
            throw new IllegalArgumentException("Keyword "+keyword+" should neither be null nor empty");
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(keyword);

        if (m.matches()) {
            this.keyword = keyword;
        } else {
            throw new IllegalArgumentException("Keyword "+keyword+" does not fit the criteria");
        }
    }

    protected KeyWords() {

    }

    public static KeyWords valueOf(String string) {
        return new KeyWords(string);
    }

    @Override
    public String toString() {
        return keyword ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyWords keyWords = (KeyWords) o;
        return Objects.equals(keyword, keyWords.keyword) && Objects.equals(regex, keyWords.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword, regex);
    }
}
