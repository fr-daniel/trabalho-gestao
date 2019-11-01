package ufc.gestao.scs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ufc.gestao.scs.model.Token;
import ufc.gestao.scs.model.Usuario;
import ufc.gestao.scs.repository.TokenRepository;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TokenServiceImpl implements ufc.gestao.scs.service.TokenService {

    @Autowired
    private TokenRepository tokenRepository;


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void salvarToken(Token token) {
        tokenRepository.save(token);
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirToken(Integer id) {
        tokenRepository.deleteById(id);
    }


    @Override
    public List<Token> buscarPorUsuario(Usuario usuario) {
        return tokenRepository.findByUsuario(usuario);
    }


    @Override
    public Token buscarPorHash(String hash) {
        return tokenRepository.findByHash(hash);
    }
}
