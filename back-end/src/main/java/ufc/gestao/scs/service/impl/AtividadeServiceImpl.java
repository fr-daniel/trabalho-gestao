package ufc.gestao.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Atividade;
import ufc.gestao.scs.repository.AtividadeRepository;
import ufc.gestao.scs.service.AtividadeService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Override
    public Atividade salvarAtividade(Atividade a) {
        return atividadeRepository.save(a);
    }

}