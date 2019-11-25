package ufc.gestao.scs.service;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FuncionarioService {

    List<Map<String, Object>> buscarFuncionarios();

    List<Map<String, Object>> buscarEmails();

    void excluirFuncionario(Integer id);

    Funcionario salvarFuncionario(Funcionario f);

    Map<String, Object> findFuncionarioById(Integer id);

}
