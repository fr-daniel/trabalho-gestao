package ufc.gestao.scs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Conhecimento;

@Repository
public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Integer> {

}