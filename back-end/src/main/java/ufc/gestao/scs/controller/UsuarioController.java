package ufc.gestao.scs.controller;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.exception.SCSException;
import ufc.gestao.scs.model.Usuario;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsuarioController {
    @ApiOperation(
            value = "Adiciona um usuário",
            notes = "Este controller é responsável por cadastrar um usuário no sistema"
    )
    ResponseEntity<Void> createUsuario(Usuario u) throws SCSException;

    @ApiOperation(
            value = "Lista todos os Usuários",
            notes = "Este controller é responsável por listar todos os usuários do sistema"
    )
    ResponseEntity<List<Map<String, Object>>> listarUsuarios();

    @ApiOperation(
            value = "Exclui um Usuário",
            notes = "Este controller é responsável por deletar um usuário no sistema"
    )
    ResponseEntity<Void> deletarUsuario(Integer usuarioId, Usuario auth) throws SCSException;


    @ApiOperation(
            value = "Atualizar informações do usuário",
            notes = "Este controller é responsável por atualizar as informações de um usuário"
    )
    ResponseEntity<String> atualizarUsuario(Usuario usuario);

    @ApiOperation(
            value = "Mostrar os dados do usuario logado",
            notes = "Este controller é responsável por exibir os dados do usuário que está logado no sistema"
    )
    ResponseEntity<Map<String, Object>> mostrarDadosUsuarioLogado(Usuario auth);

    @ApiOperation(
            value = "Mostrar dados de um usuário",
            notes = "Este controller é responsável por exibir os dados de um usuário a partir de seu id"
    )
    ResponseEntity<Map<String, Object>> mostrarDadosUsuario(Integer id);

    @ApiOperation(
            value = "Alterar a senha",
            notes = "Este controller é responsável por alterar a senha do usuário logado"
    )
    ResponseEntity<Void> alterarSenha(Usuario auth, Map<String, String> map) throws SCSException;


}
