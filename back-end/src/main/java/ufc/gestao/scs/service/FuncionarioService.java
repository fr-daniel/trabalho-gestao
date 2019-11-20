package ufc.gestao.scs.service;

import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioService {

    List<Map<String, Object>> buscarFuncionarios();

    List<Map<String, Object>> buscarEmails();

    void excluirFuncionario(Integer id);

    Funcionario salvarFuncionario(Funcionario f);

}
