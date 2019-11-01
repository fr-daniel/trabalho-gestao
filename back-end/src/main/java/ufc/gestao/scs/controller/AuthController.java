package ufc.gestao.scs.controller;

import io.swagger.annotations.ApiOperation;
import ufc.gestao.scs.util.AuthenticationRequest;

import java.util.Map;

import org.springframework.http.ResponseEntity;


public interface AuthController {
    @ApiOperation(
            value = "Realizar login",
            notes = "Este controller é responsável por realizar o login do usuário no sistema"
    )
    ResponseEntity<Map<Object, Object>> signin(AuthenticationRequest data);
}
