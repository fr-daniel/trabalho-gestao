package ufc.gestao.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Treinamento;
import ufc.gestao.scs.repository.TreinamentoRepository;
import ufc.gestao.scs.service.TreinamentoService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TreinamentoServiceImpl implements TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Override
    public List<Map<String, Object>> buscarTreinamento() {
        return this.treinamentoRepository.findAllTreinamentosView();

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirTreinamento(Integer id) {
        this.treinamentoRepository.deleteById(id);
    }

    @Override
    public Treinamento salvarTreinamento(Treinamento t) {
        return treinamentoRepository.save(t);
    }

}