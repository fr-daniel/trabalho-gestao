package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Beneficio;
import ufc.gestao.scs.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    @Query("SELECT c.id as id, c.titulacao as titulacao, c.area as area, c.unidade as unidade FROM Cargo as c")
    List<Map<String, Object>> findAllCargosView();

    @Query("SELECT c.id as id, c.titulacao as titulacao, c.missao as missao, c.experienciaMinima as experienciaMinima, c.area as area, c.unidade as unidade, c.salarioBaseMinimo as salarioBaseMinimo, c.salarioBaseMaximo as salarioBaseMaximo FROM Cargo as c WHERE c.id = :id")
    Map<String, Object> findCargoById(@Param("id") Integer id);
    
    
    @Query("SELECT c.beneficios FROM Cargo as c WHERE c.id = :id")
    List<Beneficio> findBeneficiosByCargoId(@Param("id") Integer id);
    

}