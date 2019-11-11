package ufc.gestao.scs.controller.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.BeneficioController;
import ufc.gestao.scs.service.BeneficioService;

@RestController
@RequestMapping("/beneficio")
public class BeneficioControllerImpl implements BeneficioController {

    @Autowired
    private BeneficioService beneficioService;

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> listarBeneficios() {
        List<Map<String, Object>> beneficios = beneficioService.buscarBeneficios();
        return ResponseEntity.ok(beneficios);
    }

    @Override
    @DeleteMapping("/excluir/{beneficioId}")
    public ResponseEntity<Void> deletarBeneficio(Integer beneficioId) {
        beneficioService.excluirBeneficio(beneficioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}