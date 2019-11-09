package ufc.gestao.scs.controller.impl;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufc.gestao.scs.config.JwtTokenProvider;
import ufc.gestao.scs.controller.AuthController;
import ufc.gestao.scs.model.enums.Papel;
import ufc.gestao.scs.repository.UsuarioRepository;
import ufc.gestao.scs.util.AuthenticationRequest;

@RestController
@RequestMapping
public class AuthControllerImpl implements AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@PostMapping("/login")
	public ResponseEntity<Map<Object, Object>> signin(@RequestBody AuthenticationRequest data) {

		try {
			System.out.println(data.getCpf());
			System.out.println(data.getPassword());
			String username = data.getCpf();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			List<String> roles = new ArrayList<>();
			for (Papel papel : this.usuarioRepository.findByCpf(username).getPapeis()) {
				roles.add(papel.name());
			}
			String token = jwtTokenProvider.createToken(username, new ArrayList<String>());

			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("papeis", roles);
			model.put("token", "Bearer " + token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}

}
