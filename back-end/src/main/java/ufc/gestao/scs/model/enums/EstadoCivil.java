package ufc.gestao.scs.model.enums;

public enum EstadoCivil {
	
    SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viúvo");
    
	private String descricao;

    private EstadoCivil(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
