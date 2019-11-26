package ufc.gestao.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Cargo;
import ufc.gestao.scs.repository.CargoRepository;
import ufc.gestao.scs.service.CargoService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Map<String, Object>> buscarCargos() {
        return cargoRepository.findAllCargosView();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirCargo(Integer id) {
        this.cargoRepository.deleteById(id);
    }

    @Override
    public Cargo salvarCargo(Cargo c) {
        return cargoRepository.save(c);
    }

    @Override
    public Integer atualizarCargo(Cargo c) {
        Cargo cargo = cargoRepository.save(c);
        return cargo.getId();
    }

    @Override
    public Map<String, Object> buscarCargo(Integer id) {
        return cargoRepository.findCargoById(id);
    }

}