package ufc.gestao.scs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.gestao.scs.model.Token;
import ufc.gestao.scs.model.Usuario;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    List<Token> findByUsuario(Usuario usuario);

    Token findByHash(String hash);
}
