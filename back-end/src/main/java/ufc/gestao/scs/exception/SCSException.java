package ufc.gestao.scs.exception;

import org.springframework.http.HttpStatus;

public class SCSException extends Exception {

	private static final long serialVersionUID = -3079918395256793409L;
	
	private final String message;
	private final HttpStatus status;

	public SCSException(String message) {
		this.message = message;
		this.status = HttpStatus.BAD_REQUEST;
	}

	public SCSException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}