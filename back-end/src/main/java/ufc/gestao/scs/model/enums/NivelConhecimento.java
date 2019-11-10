package ufc.gestao.scs.model.enums;

public enum NivelConhecimento {

    BASICO("Básico"), MEDIO("Médio"), AVANCADO("Avançado");

    private String descricao;

    private NivelConhecimento(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
