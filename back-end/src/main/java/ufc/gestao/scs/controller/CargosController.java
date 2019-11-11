package ufc.gestao.scs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;

public interface CargosController {

    @ApiOperation(value = "Lista todos os Cargos", notes = "Este controller é responsável por listar todos os cargos cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarCargos();

}