package ufc.gestao.scs.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;

public interface RelatorioController {

    @ApiOperation(value = "Cria um relatório simples", notes = "Este controller é responsável criar um relatório simples")
    ResponseEntity<Void> createRelatorioSimples();

}