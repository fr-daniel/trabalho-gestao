package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;

public interface BeneficioService {

    List<Map<String, Object>> buscarBeneficios();

    void excluirBeneficio(Integer id);

}