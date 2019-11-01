package ufc.gestao.scs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import ufc.gestao.scs.controller.UsuarioController;
import ufc.gestao.scs.exception.SCSException;
import ufc.gestao.scs.model.Usuario;
import ufc.gestao.scs.service.UsuarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @PostMapping
    public ResponseEntity<Void> createUsuario(@RequestBody Usuario u) throws SCSException {
        usuarioService.salvarUsuario(u);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<Map<String, Object>>> listarUsuarios() {
        List<Map<String, Object>> usuario = this.usuarioService.buscarUsuarios();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/excluir-usuario/{usuarioId}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable("usuarioId") Integer usuarioId, @AuthenticationPrincipal Usuario auth) throws SCSException {
        usuarioService.excluirUsuario(usuarioId, auth.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.atualizarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/authenticated")
    public ResponseEntity<Map<String, Object>> mostrarDadosUsuarioLogado(@AuthenticationPrincipal Usuario auth) {
        return new ResponseEntity<>(usuarioService.buscarUsuario(auth.getId()), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> mostrarDadosUsuario(@PathVariable Integer id) {
        return new ResponseEntity<>(usuarioService.buscarUsuario(id), HttpStatus.OK);
    }

    @Override
    @PutMapping("/alterarSenha")
    public ResponseEntity<Void> alterarSenha(@AuthenticationPrincipal Usuario auth, @RequestBody Map<String, String> map) throws SCSException {
        usuarioService.alterarSenha(auth, map.get("senhaAtual"), map.get("novaSenha"));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
