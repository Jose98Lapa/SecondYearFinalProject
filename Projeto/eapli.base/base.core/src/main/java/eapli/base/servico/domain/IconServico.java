package eapli.base.servico.domain;

import javax.persistence.Embeddable;

@Embeddable
public class IconServico {
    private String  temp;

    public IconServico(String temp) {
        this.temp = temp;
    }

    protected IconServico() {

    }

    public static IconServico valueof(String icon) {
        return null;
    }

    @Override
    public String toString() {
        return temp;
    }
}
