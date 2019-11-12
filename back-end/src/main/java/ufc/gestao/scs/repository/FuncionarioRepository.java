package ufc.gestao.scs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ufc.gestao.scs.model.Cargo;
import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f.id as id, f.nome as nome, f.cpf as cpf, f.email as email, f.telefone as telefone, f.formacaoAcademica as formacaoAcademica, f.salario as salario  FROM Funcionario as f")
    List<Map<String, Object>> findAllFuncionariosView();

}
