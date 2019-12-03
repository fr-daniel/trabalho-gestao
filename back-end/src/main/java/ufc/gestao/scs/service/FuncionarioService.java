package ufc.gestao.scs.service;

import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioService {

    List<Map<String, Object>> buscarFuncionarios();


    void excluirFuncionario(Integer id);

    Funcionario salvarFuncionario(Funcionario f);

    Map<String, Object> findFuncionarioById(Integer id);

}
