package com.redemob.cadastro.event;

import org.springframework.context.ApplicationEvent;

public class VerificacaoCadastroEvent extends ApplicationEvent{

    public VerificacaoCadastroEvent(Object source) {
        super(source);
    }
    
}
