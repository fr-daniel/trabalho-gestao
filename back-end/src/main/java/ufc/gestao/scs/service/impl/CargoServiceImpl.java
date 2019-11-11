package ufc.gestao.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

}