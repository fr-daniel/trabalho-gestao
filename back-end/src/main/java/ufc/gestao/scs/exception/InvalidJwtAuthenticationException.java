package ufc.gestao.scs.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    
	private static final long serialVersionUID = 4566253727289127067L;

	public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}
