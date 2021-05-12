package eapli.base.collaborator.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Nickname implements ValueObject {

    private String nickname;

    public Nickname(final String nickname){
        if (nickname==null ||nickname.isEmpty()||!nickname.matches("^\\w{1,15}$"))
            throw new IllegalArgumentException("Alcunha nao cumpre os critérios");
        this.nickname = nickname;
    }

    protected Nickname() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nickname nickname1 = (Nickname) o;
        return nickname.equals(nickname1.nickname);
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
