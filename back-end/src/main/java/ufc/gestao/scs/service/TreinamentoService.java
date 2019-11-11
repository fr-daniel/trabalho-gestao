package ufc.gestao.scs.service;

import java.util.List;
import java.util.Map;

import ufc.gestao.scs.model.Treinamento;

public interface TreinamentoService {

    List<Map<String, Object>> buscarTreinamento();

    void excluirTreinamento(Integer id);

    Treinamento salvarTreinamento(Treinamento t);

}