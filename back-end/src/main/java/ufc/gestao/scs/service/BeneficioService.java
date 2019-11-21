package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Treinamento;

public interface BeneficioService {

    List<Map<String, Object>> buscarBeneficios();

    void excluirBeneficio(Integer id);

    Beneficio salvarBeneficio(Beneficio b);

    Optional<Beneficio> findById(Integer id);
}