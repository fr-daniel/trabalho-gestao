package ufc.gestao.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ufc.gestao.scs.model.Funcionario;
import ufc.gestao.scs.repository.FuncionarioRepository;
import ufc.gestao.scs.service.FuncionarioService;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class FuncionarioImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Map<String, Object>> buscarFuncionarios() {
        return funcionarioRepository.findAllFuncionariosView();
    }

    @Override
    public List<Map<String, Object>> buscarEmails() {
        return funcionarioRepository.findAllEmailsView();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirFuncionario(Integer id) {
        this.funcionarioRepository.deleteById(id);
    }

    @Override
    public Funcionario salvarFuncionario(Funcionario f) {
        return funcionarioRepository.save(f);
    }

}
