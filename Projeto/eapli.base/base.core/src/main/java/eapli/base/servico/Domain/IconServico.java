package eapli.base.servico.Domain;

import javax.persistence.Embeddable;

@Embeddable
public class IconServico {
    private int  temp;

    public IconServico(int temp) {
        this.temp = temp;
    }

    protected IconServico() {

    }

    public static IconServico valueof(String icon) {
        return null;
    }

    @Override
    public String toString() {
        return  String.valueOf(temp);
    }
}
