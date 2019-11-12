package ufc.gestao.scs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.AtividadeController;
import ufc.gestao.scs.model.Atividade;
import ufc.gestao.scs.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeControllerImpl implements AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @Override
    @PostMapping
    public ResponseEntity<Atividade> createAtividade(@RequestBody Atividade a) {
        Atividade atividade = atividadeService.salvarAtividade(a);
        return new ResponseEntity<>(atividade, HttpStatus.CREATED);
    }

}