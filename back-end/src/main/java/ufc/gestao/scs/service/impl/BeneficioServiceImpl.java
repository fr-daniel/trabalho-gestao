package ufc.gestao.scs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.repository.BeneficioRepository;
import ufc.gestao.scs.service.BeneficioService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BeneficioServiceImpl implements BeneficioService {

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Override
    public List<Map<String, Object>> buscarBeneficios() {
        return beneficioRepository.findAllBeneficiosView();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirBeneficio(Integer id) {
        this.beneficioRepository.deleteById(id);
    }

}