package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;

public interface TreinamentoService {

    List<Map<String, Object>> buscarTreinamento();

    void excluirTreinamento(Integer id);

}