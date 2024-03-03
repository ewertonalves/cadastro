package com.redemob.cadastro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redemob.cadastro.model.response.MessageResponse;
import com.redemob.cadastro.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("rocket")
public class LoginController {
    
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping(value = "/login", consumes = "application/json; charset=UTF-8")
    public ResponseEntity<MessageResponse> Login(@RequestParam String cpf, String senha) {
        try {
            service.login(cpf, senha);
            return new ResponseEntity<MessageResponse>(new MessageResponse("Login realizado com sucesso"), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(e.getMessage()));
        }
    }
    
}
