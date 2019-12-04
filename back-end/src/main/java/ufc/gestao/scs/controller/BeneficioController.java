package ufc.gestao.scs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Treinamento;

public interface BeneficioController {

    @ApiOperation(value = "Adiciona um beneficio", notes = "Este controller é responsável por cadastrar um beneficio no sistema")
    ResponseEntity<Beneficio> createBeneficio(Beneficio b);

    @ApiOperation(value = "Lista todos os Benefícios", notes = "Este controller é responsável por listar todos os beneficios cadastrados no sistema")
    ResponseEntity<List<Map<String, Object>>> listarBeneficios();

    @ApiOperation(value = "Lista um benefício", notes = "Este controller é responsável por listar um benefício cadastrado no sistema com base no id")
    ResponseEntity<Map<String, Object>> buscaBeneficio(Integer id);

    @ApiOperation(value = "Exclui um Benefício", notes = "Este controller é responsável por deletar um benefício no sistema")
    ResponseEntity<Void> deletarBeneficio(Integer beneficioId);

}