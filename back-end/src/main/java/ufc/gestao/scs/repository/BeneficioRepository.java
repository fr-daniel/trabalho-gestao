package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Treinamento;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Integer> {

    @Query("SELECT b.id as id, b.titulo as titulo, b.valor as valor FROM Beneficio as b")
    List<Map<String, Object>> findAllBeneficiosView();

    Optional<Beneficio> findById(Integer id);

}