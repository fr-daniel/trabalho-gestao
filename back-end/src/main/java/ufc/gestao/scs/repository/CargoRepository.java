package ufc.gestao.scs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    @Query("SELECT c.id as id, c.titulacao as titulacao, c.area as area, c.unidade as unidade FROM Cargo as c")
    List<Map<String, Object>> findAllCargosView();

}