package eapli.base.collaborator.domain;

import com.sun.beans.decoder.ValueObject;

import java.util.Objects;

public class Nickname implements ValueObject {

    String nickname;

    public Nickname(final String nickname){
        if (nickname==null ||nickname.isEmpty()||!nickname.matches(""))
            throw new IllegalArgumentException("Nickname does not fit the criteria");
        this.nickname = nickname;
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
