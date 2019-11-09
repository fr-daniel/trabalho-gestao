package ufc.gestao.scs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Usuario;

import java.util.List;
import java.util.Map;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    Usuario findByCpf(String cpf);

    @Query("SELECT u.id as id, u.nome as nome, u.email as email, u.cpf as cpf, p AS papel FROM Usuario u JOIN u.papeis p WHERE u.id = :id")
    Map<String, Object> dadosUsuario(@Param("id") Integer id);

    @Query("SELECT u.id as id, u.nome as nome, u.cpf as cpf, p as papeis FROM Usuario u LEFT JOIN u.papeis p")
    List<Map<String, Object>> findAllUsuariosview();
}
