package ufc.gestao.scs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioController {

    @ApiOperation(value = "Adiciona um funcionário", notes = "Este controller é responsável por cadastrar um funcionário no sistema")
    ResponseEntity<Funcionario> createFuncionario(Funcionario f);

    @ApiOperation(value = "Lista todos os Funcionários", notes = "Este controller é responsável por listar todos os funcionários cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarFuncionarios();

    @ApiOperation(value = "Exclui um Funcionário", notes = "Este controller é responsável por deletar um funcionário no sistema")
    ResponseEntity<Void> deletarFuncionario(Integer funcionarioId);
}
