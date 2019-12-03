package ufc.gestao.scs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioController {

    @ApiOperation(value = "Adiciona um funcionário", notes = "Este controller é responsável por cadastrar um funcionário no sistema")
    ResponseEntity<Funcionario> createFuncionario(Funcionario f);

    @ApiOperation(value = "Lista todos os Funcionários", notes = "Este controller é responsável por listar todos os funcionários cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarFuncionarios();

    @ApiOperation(value = "Lista um funcinário", notes = "Este controller é responsável por listar um funcionário cadastrado no sistema com base no id")
    ResponseEntity<Map<String, Object>> buscaFuncionario(Integer id);

    @ApiOperation(value = "Exclui um Funcionário", notes = "Este controller é responsável por deletar um funcionário no sistema")
    ResponseEntity<Void> deletarFuncionario(Integer funcionarioId);
}
