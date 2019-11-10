package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Treinamento;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Integer> {

    @Query("SELECT t.id as id, t.descricao as descricao, t.classificacao as classificacao FROM Treinamento as t")
    List<Map<String, Object>> findAllTreinamentosView();

}