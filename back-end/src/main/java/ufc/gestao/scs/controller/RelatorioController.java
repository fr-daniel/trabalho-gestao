package ufc.gestao.scs.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;

public interface RelatorioController {

    @ApiOperation(value = "Cria um relatório de cargos", notes = "Este controller é responsável criar um relatório simples")
    ResponseEntity<InputStreamResource> createRelatorioCargos();

    @ApiOperation(value = "Cria um relatório de funcionários", notes = "Este controller é responsável criar um relatório simples")
    ResponseEntity<InputStreamResource> createRelatorioFuncionarios();
}