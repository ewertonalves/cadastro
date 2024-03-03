package com.redemob.cadastro.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.redemob.cadastro.model.Cadastro;
import com.redemob.cadastro.model.dto.CadastroDto;
import com.redemob.cadastro.model.response.MessageResponse;
import com.redemob.cadastro.service.CadastroService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("rocket")
public class CadastroController {

    private final CadastroService service;

    public CadastroController(CadastroService service) {
        this.service = service;
    }

    @PostMapping(value = "/save", consumes = "application/json; charset=UTF-8")
    public ResponseEntity<MessageResponse> salvar(@RequestBody CadastroDto CadastroDto, MultipartFile file) {

        try {
            return service.salvar(CadastroDto, file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(e.getMessage()));
        }
    }

    @GetMapping(value = "/consultar/{cpf}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<MessageResponse> buscarPorCpf(@RequestParam String cpf) {

        try {
           CadastroDto cadastroDto =  service.buscarPorCpf(cpf);
           return new ResponseEntity<MessageResponse>(new MessageResponse("CPF encotrado" + cadastroDto), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(e.getMessage()));
        }
    }
    
    @GetMapping(value = "/consulta/all", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Page<Cadastro>> findByAll(Pageable pageable) {
        
        Page<Cadastro> cadastros = service.findAll(pageable);
        return new ResponseEntity<>(cadastros, HttpStatus.OK);
    }

}
