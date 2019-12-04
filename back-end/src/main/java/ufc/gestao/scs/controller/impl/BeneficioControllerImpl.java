package ufc.gestao.scs.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.BeneficioController;
import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.service.BeneficioService;

@RestController
@RequestMapping("/beneficio")
public class BeneficioControllerImpl implements BeneficioController {

    @Autowired
    private BeneficioService beneficioService;

    @Override
    @PostMapping
    public ResponseEntity<Beneficio> createBeneficio(@RequestBody Beneficio b) {
        Beneficio beneficio = beneficioService.salvarBeneficio(b);
        return new ResponseEntity<>(beneficio, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> listarBeneficios() {
        List<Map<String, Object>> beneficios = beneficioService.buscarBeneficios();
        return ResponseEntity.ok(beneficios);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> buscaBeneficio(@PathVariable(value = "id") Integer id) {
    	Map<String, Object> beneficio = beneficioService.findBeneficioById(id);

            return new ResponseEntity<>(beneficio, HttpStatus.OK);
        
    }
    
    @Override
    @GetMapping(value = "/{id}/cargos")
    public ResponseEntity<List<Map<String, Object>>> buscaCargosBeneficio(@PathVariable(value = "id") Integer id) {
    	List<Map<String, Object>> cargos = beneficioService.findAllCargosBeneficios(id);

            return new ResponseEntity<>(cargos, HttpStatus.OK);
        
    }

    @Override
    @DeleteMapping("/excluir/{beneficioId}")
    public ResponseEntity<Void> deletarBeneficio(@PathVariable("beneficioId") Integer beneficioId) {
        beneficioService.excluirBeneficio(beneficioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}