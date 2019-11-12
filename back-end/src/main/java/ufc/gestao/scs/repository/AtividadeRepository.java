package ufc.gestao.scs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}