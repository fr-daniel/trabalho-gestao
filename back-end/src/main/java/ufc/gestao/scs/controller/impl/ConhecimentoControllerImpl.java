package ufc.gestao.scs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.ConhecimentoController;
import ufc.gestao.scs.model.Conhecimento;
import ufc.gestao.scs.service.ConhecimentoService;

@RestController
@RequestMapping("/conhecimento")
public class ConhecimentoControllerImpl implements ConhecimentoController {

    @Autowired
    private ConhecimentoService conhecimentoService;

    @Override
    @PostMapping
    public ResponseEntity<Conhecimento> createConhecimento(@RequestBody Conhecimento c) {
        Conhecimento conhecimento = conhecimentoService.salvarConhecimento(c);
        return new ResponseEntity<>(conhecimento, HttpStatus.CREATED);
    }

}