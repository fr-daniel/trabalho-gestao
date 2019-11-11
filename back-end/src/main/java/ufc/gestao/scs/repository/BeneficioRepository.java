package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Beneficio;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Integer> {

    @Query("SELECT b.id as id, b.titulo as titulo, b.informacoes as informacoes, b.valor as valor FROM Beneficio as b")
    List<Map<String, Object>> findAllBeneficiosView();

}