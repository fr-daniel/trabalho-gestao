package ufc.gestao.scs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufc.gestao.scs.controller.CargosController;
import ufc.gestao.scs.model.Cargo;
import ufc.gestao.scs.service.CargoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cargo")
public class CargoControllerImpl implements CargosController {

    @Autowired
    private CargoService cargoService;

    @Override
    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo c) {
        Cargo cargo = cargoService.salvarCargo(c);
        return new ResponseEntity<>(cargo, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<Map<String, Object>>> listarCargos() {
        List<Map<String, Object>> cargos = cargoService.buscarCargos();
        return ResponseEntity.ok(cargos);
    }

    @Override
    @DeleteMapping("/excluir/{cargoId}")
    public ResponseEntity<Void> deletarCargo(@PathVariable("cargoId") Integer cargoId) {
        cargoService.excluirCargo(cargoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @PutMapping
    public ResponseEntity atualizar(@RequestBody Cargo cargo) {
        this.cargoService.atualizarCargo(cargo);
        return new ResponseEntity(cargo.getId(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{cargoId}")
    public ResponseEntity<Map<String, Object>> buscarCargo(@PathVariable("cargoId") Integer id) {
        return new ResponseEntity<>(cargoService.buscarCargo(id), HttpStatus.OK);
    }

}
