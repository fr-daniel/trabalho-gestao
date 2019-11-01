package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;

import ufc.gestao.scs.exception.SCSException;
import ufc.gestao.scs.model.Token;
import ufc.gestao.scs.model.Usuario;

public interface UsuarioService {
	
    Usuario buscaUsuarioPorEmail(String email);

    Map<String, Object> buscarUsuario(Integer id);

    List<Map<String, Object>> buscarUsuarios();

    void salvarUsuario(Usuario usuario) throws SCSException;

    void atualizarUsuario(Usuario usuario);

    void excluirUsuario(Integer id, Integer userId) throws SCSException;

    boolean recuperarSenha(String email);

    void constructResetTokenMail(Token token, Usuario usuario);

    void criarToken(Usuario usuario);

    boolean mudarSenha(Token token);

    Integer tokenInvalido(String hash);

    void alterarSenha(Usuario usuario, String senhaAtual, String novaSenha) throws SCSException;

}