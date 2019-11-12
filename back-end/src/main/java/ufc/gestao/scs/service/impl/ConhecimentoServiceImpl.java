package ufc.gestao.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Conhecimento;
import ufc.gestao.scs.repository.ConhecimentoRepository;
import ufc.gestao.scs.service.ConhecimentoService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ConhecimentoServiceImpl implements ConhecimentoService {

    @Autowired
    private ConhecimentoRepository conhecimentoRepository;

    @Override
    public Conhecimento salvarConhecimento(Conhecimento c) {
        return conhecimentoRepository.save(c);
    }

}