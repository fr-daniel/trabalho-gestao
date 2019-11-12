package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;

import ufc.gestao.scs.model.Beneficio;

public interface BeneficioService {

    List<Map<String, Object>> buscarBeneficios();

    void excluirBeneficio(Integer id);

    Beneficio salvarBeneficio(Beneficio b);
}