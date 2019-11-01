package ufc.gestao.scs.model.enums;

public enum Sexo {
    MASCULINO("Masculino"), FEMININO("Feminino");
    private String descricao;

    private Sexo(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
