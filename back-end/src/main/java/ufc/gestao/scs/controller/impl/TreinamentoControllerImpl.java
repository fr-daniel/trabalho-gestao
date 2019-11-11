package ufc.gestao.scs.controller.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.TreinamentoController;
import ufc.gestao.scs.model.Treinamento;
import ufc.gestao.scs.service.TreinamentoService;

@RestController
@RequestMapping("/treinamento")
public class TreinamentoControllerImpl implements TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;

    @Override
    @PostMapping
    public ResponseEntity<Treinamento> createTreinamento(Treinamento t) {
        Treinamento treinamento = treinamentoService.salvarTreinamento(t);
        return new ResponseEntity<>(treinamento, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> listarTreinamentos() {
        List<Map<String, Object>> treinamentos = this.treinamentoService.buscarTreinamento();
        return new ResponseEntity<>(treinamentos, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/excluir/{treinamentoId}")
    public ResponseEntity<Void> deletarTreinamento(Integer treinamentoId) {
        treinamentoService.excluirTreinamento(treinamentoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}