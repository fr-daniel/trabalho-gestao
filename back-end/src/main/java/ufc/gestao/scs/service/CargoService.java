package ufc.gestao.scs.service;

import ufc.gestao.scs.model.Cargo;

import java.util.List;
import java.util.Map;

public interface CargoService {

    List<Map<String, Object>> buscarCargos();

    Map<String, Object> buscarCargo(Integer id);

    void excluirCargo(Integer id);

    Cargo salvarCargo(Cargo c);

    Integer atualizarCargo(Cargo c);
}