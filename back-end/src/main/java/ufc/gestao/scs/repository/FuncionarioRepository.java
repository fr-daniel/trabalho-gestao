package ufc.gestao.scs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufc.gestao.scs.model.Funcionario;

import java.util.List;
import java.util.Map;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f.id as id, f.nome as nome, f.cpf as cpf, f.formacaoAcademica as formacaoAcademica, s.salarioBase as salarioBase  FROM Funcionario as f JOIN Salario as s ON s.id = f.salario")
    List<Map<String, Object>> findAllFuncionariosView();

    @Query("SELECT f.id as id, f.nome as nome, f.telefone as telefone, f.email as email  FROM Funcionario as f")
    List<Map<String, Object>> findAllEmailsView();

    @Query("SELECT f.id as id, f.nome as nome, f.cpf as cpf, f.rg as rg, f.nis as nis, f.email as email, f.telefone as telefone, f.formacaoAcademica as formacaoAcademica, f.dataNascimento as dataNascimento, f.estadoCivil as estadoCivil, f.sexo as sexo, s.salarioBase as salarioBase, s.cargaHoraria as cargaHoraria  FROM Funcionario as f JOIN Salario as s ON s.funcionario.id = f.id WHERE f.id = :id")
    Map<String, Object> findFuncionarioById(@Param("id") Integer id);

}
