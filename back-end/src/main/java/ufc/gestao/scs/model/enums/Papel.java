package ufc.gestao.scs.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Papel implements GrantedAuthority {
    
	FUNCIONARIO("FUNCIONARIO"), RECURSOS_HUMANOS("RECURSOS_HUMANOS"), ADMINISTRADOR("ADMINISTRADOR");
   
	private String descricao;

    Papel(String valor) {
        descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getAuthority() {
        return this.toString();
    }

}
