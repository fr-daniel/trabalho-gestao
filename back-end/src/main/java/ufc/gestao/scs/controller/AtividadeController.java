package ufc.gestao.scs.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.model.Atividade;

public interface AtividadeController {

    @ApiOperation(value = "Adiciona uma atividade", notes = "Este controller é responsável por cadastrar uma atividade no sistema")
    ResponseEntity<Atividade> createAtividade(Atividade a);

}