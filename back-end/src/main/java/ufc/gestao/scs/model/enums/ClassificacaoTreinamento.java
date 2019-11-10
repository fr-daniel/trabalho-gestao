package ufc.gestao.scs.model.enums;

public enum ClassificacaoTreinamento {

    DESEJAVEL("Desejável"), REQUERIDO("Requerido");

    private String descricao;

    private ClassificacaoTreinamento(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
