package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Treinamento;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Integer> {

    @Query("SELECT b.id as id, b.titulo as titulo, b.valor as valor FROM Beneficio as b")
    List<Map<String, Object>> findAllBeneficiosView();
    
    @Query("SELECT b.id as id, b.titulo as titulo, b.valor as valor FROM Beneficio as b WHERE b.id = :id")
    Map<String, Object> findBeneficioInfoById(@Param("id") Integer id);
    
    @Query("SELECT c.id as id, c.titulacao as titulacao FROM Beneficio as b JOIN b.cargos c WHERE b.id = :id")
    List<Map<String, Object>> findAllCargosBeneficios(@Param("id") Integer id);

    Optional<Beneficio> findById(Integer id);

}