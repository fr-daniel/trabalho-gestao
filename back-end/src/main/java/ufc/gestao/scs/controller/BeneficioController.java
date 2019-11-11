package ufc.gestao.scs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;

public interface BeneficioController {

    @ApiOperation(value = "Lista todos os Benefícios", notes = "Este controller é responsável por listar todos os beneficios cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarBeneficios();

}