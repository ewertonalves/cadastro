package com.redemob.cadastro.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.redemob.cadastro.event.VerificacaoCadastroEvent;
import com.redemob.cadastro.exceptions.ValidaCpf;
import com.redemob.cadastro.model.Cadastro;
import com.redemob.cadastro.model.dto.CadastroDto;
import com.redemob.cadastro.model.response.MessageResponse;
import com.redemob.cadastro.repository.CadastroRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CadastroService {
    
    @Autowired
    private CadastroRepository repository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Cacheable(cacheNames = "cadastroUsuario", key = "#Cadastro.dataCadastro")
    public ResponseEntity<MessageResponse> salvar(CadastroDto cadastroDto, MultipartFile file) throws IOException {
        
        byte[] dadosDaImagem    = file.getBytes();
        Boolean validaCpf       = repository.existsByCpf(cadastroDto.getCpf());
        
        if(validaCpf)
            return new ResponseEntity<MessageResponse>(new MessageResponse("O CPF já foi cadastrado!"), HttpStatus.INTERNAL_SERVER_ERROR);
        if(!ValidaCpf.validadoCpf(cadastroDto.getCpf()))
            return new ResponseEntity<MessageResponse>(new MessageResponse("O CPF inválido!"), HttpStatus.INTERNAL_SERVER_ERROR);
        
        cadastroDto.setFotoRosto(dadosDaImagem);
        cadastroDto.setFotoComprovante(dadosDaImagem);
        cadastroDto.setDataCadastro(LocalDateTime.now());

        Cadastro cadastro = new Cadastro(cadastroDto);
        repository.save(cadastro);
        eventPublisher.publishEvent(new VerificacaoCadastroEvent(cadastro));
        return new ResponseEntity<MessageResponse>(new MessageResponse("Usuário cadastrado com sucesso!"), HttpStatus.CREATED);
    }

    @Cacheable(cacheNames = "cadastroUsuario", key = "#cpf")
    public CadastroDto buscarPorCpf(String cpf) throws Exception {
        
        String buscarCpf = repository.findByCpf(cpf);
        if (buscarCpf.isEmpty()) {
            throw new Exception("CPF não encontrado.");
        }
        CadastroDto cadastroDto = new CadastroDto();
        cadastroDto.setCpf(buscarCpf);
        return cadastroDto;
    }
    
    
    public Page<Cadastro> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
