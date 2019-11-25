package ufc.gestao.scs.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Treinamento> createTreinamento(@RequestBody Treinamento t) {
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
    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<Treinamento> buscaTreinamento(@PathVariable(value = "id") Integer id) {
        Optional<Treinamento> treinamento = treinamentoService.findById(id);

        if (treinamento.isPresent()) {
            return new ResponseEntity<>(treinamento.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping("/excluir/{treinamentoId}")
    public ResponseEntity<Void> deletarTreinamento(@PathVariable("treinamentoId") Integer treinamentoId) {
        treinamentoService.excluirTreinamento(treinamentoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PutMapping("/editar")
    public ResponseEntity<Treinamento> editarTreinamento(Treinamento t) {
        this.treinamentoService.editarTreinamento(t);
        return new ResponseEntity(t.getId(), HttpStatus.OK);

    }

}