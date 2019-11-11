package ufc.gestao.scs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;

public interface TreinamentoController {

    @ApiOperation(value = "Lista todos os Treinamentos", notes = "Este controller é responsável por listar todos os treinamentos cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarTreinamentos();

    @ApiOperation(value = "Exclui um Treinamento", notes = "Este controller é responsável por deletar um treinamento no sistema")
    ResponseEntity<Void> deletarUsuario(Integer treinamentoId);

}