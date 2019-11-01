package ufc.gestao.scs.service;

import java.util.List;

import ufc.gestao.scs.model.Token;
import ufc.gestao.scs.model.Usuario;

public interface TokenService {
	
	void salvarToken(Token token);

	void excluirToken(Integer id);

	List<Token> buscarPorUsuario(Usuario usuario);

	Token buscarPorHash(String hash);

}
