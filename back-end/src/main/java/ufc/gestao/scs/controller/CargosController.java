package ufc.gestao.scs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.model.Cargo;

public interface CargosController {

    @ApiOperation(value = "Adiciona um cargo", notes = "Este controller é responsável por cadastrar um cargo no sistema")
    ResponseEntity<Cargo> createCargo(Cargo c);

    @ApiOperation(value = "Lista todos os Cargos", notes = "Este controller é responsável por listar todos os cargos cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarCargos();

    @ApiOperation(value = "Exclui um Cargo", notes = "Este controller é responsável por deletar um cargo no sistema")
    ResponseEntity<Void> deletarCargo(Integer cargoId);

}