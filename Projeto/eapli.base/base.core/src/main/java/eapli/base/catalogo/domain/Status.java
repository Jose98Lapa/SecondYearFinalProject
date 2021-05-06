package eapli.base.catalogo.domain;

public enum Status {
    ATIVO{
        @Override
        public String toString() {
            return "Ativo";
        }
    },

    INATIVO{
        @Override
        public String toString() {
            return "Inativo";
        }
    },

}
