package ufc.gestao.scs.controller.impl;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.controller.RelatorioController;
import ufc.gestao.scs.model.Cargo;
import ufc.gestao.scs.model.Funcionario;
import ufc.gestao.scs.repository.CargoRepository;
import ufc.gestao.scs.repository.FuncionarioRepository;
import ufc.gestao.scs.service.RelatorioService;
import ufc.gestao.scs.util.relatorios.GenerateRelatorioCargosPdf;
import ufc.gestao.scs.util.relatorios.GenerateRelatorioFuncionariosPdf;

@RestController
@RequestMapping("/relatorio")
public class RelatorioControllerImpl implements RelatorioController {

    @Autowired
    private CargoRepository cargoRepository;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    @GetMapping(value = "/cargos", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> createRelatorioCargos() {
        List<Cargo> cargos = cargoRepository.findAll();

        ByteArrayInputStream bis = GenerateRelatorioCargosPdf.cargosReport(cargos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio-cargos.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @Override
    @GetMapping(value = "/funcionarios", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> createRelatorioFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        ByteArrayInputStream bis = GenerateRelatorioFuncionariosPdf.funcionariosReport(funcionarios);


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}