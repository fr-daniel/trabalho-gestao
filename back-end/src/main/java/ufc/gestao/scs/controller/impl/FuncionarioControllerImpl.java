package ufc.gestao.scs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufc.gestao.scs.controller.FuncionarioController;
import ufc.gestao.scs.model.Funcionario;
import ufc.gestao.scs.service.FuncionarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioControllerImpl implements FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario f) {
        Funcionario funcionario = funcionarioService.salvarFuncionario(f);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> listarFuncionarios() {
        List<Map<String, Object>> funcionarios = funcionarioService.buscarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @Override
    @GetMapping("/listar/emails")
    public ResponseEntity<List<Map<String, Object>>> listarEmails() {
        List<Map<String, Object>> funcionarios = funcionarioService.buscarEmails();
        return ResponseEntity.ok(funcionarios);
    }

    @Override
    @DeleteMapping("/excluir/{funcionarioId}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable("funcionarioId") Integer funcionarioId) {
        funcionarioService.excluirFuncionario(funcionarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
