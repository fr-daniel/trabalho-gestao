package ufc.gestao.scs.controller.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import ufc.gestao.scs.exception.SCSException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = SCSException.class)
    public ResponseEntity<String> handleProficienciaException(SCSException ex, WebRequest request) {
        return new ResponseEntity<String>(ex.getMessage(), new HttpHeaders(), ex.getStatus());
    }
}
