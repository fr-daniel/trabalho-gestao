package ufc.gestao.scs.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.model.Conhecimento;

public interface ConhecimentoController {

    @ApiOperation(value = "Adiciona um conhecimento", notes = "Este controller é responsável por cadastrar um conhecimento no sistema")
    ResponseEntity<Conhecimento> createConhecimento(Conhecimento c);

}