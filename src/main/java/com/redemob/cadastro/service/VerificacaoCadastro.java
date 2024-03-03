package com.redemob.cadastro.service;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.redemob.cadastro.event.VerificacaoCadastroEvent;
import com.redemob.cadastro.model.dto.CadastroDto;

@Component
public class VerificacaoCadastro {

    private final CadastroService service;

    public VerificacaoCadastro(CadastroService service) {
        this.service = service;
    }

    @EventListener
    public void handleNovoCadastro(VerificacaoCadastroEvent event) {
        CadastroDto cadastroDto         = (CadastroDto) event.getSource();
        LocalDateTime dataVerificacao   = LocalDateTime.now().plusHours(24);
        cadastroDto.setDataVerificacaoCadastro(dataVerificacao);
        service.salvar(cadastroDto);
    }
    
}
