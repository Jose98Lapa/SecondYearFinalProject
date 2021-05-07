package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Embeddable
public class KeyWords implements ValueObject {
    private String keyword;
    @Transient
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

    public static Set<KeyWords> valueOf(Set<String> string) {
        Set<KeyWords> key = new HashSet<>();
        for (String str:string) {
            key.add(new KeyWords(str));
        }
        return key;
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
