package eapli.base.colaborador.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Alcunha implements ValueObject {

    private String nickname;

    public Alcunha(final String nickname){
        if (nickname==null ||nickname.isEmpty()||!nickname.matches("^\\w{1,15}$"))
            throw new IllegalArgumentException("Alcunha nao cumpre os critérios");
        this.nickname = nickname;
    }

    protected Alcunha() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alcunha alcunha1 = (Alcunha) o;
        return nickname.equals(alcunha1.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public String toString() {
        return this.nickname;
    }

}
