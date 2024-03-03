package com.redemob.cadastro.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.redemob.cadastro.model.dto.CadastroDto;

@Service
public class LoginService {

    private final CadastroService cadastroService;

    public LoginService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public CadastroDto login(String cpf, String senha) throws Exception{
        
        CadastroDto cadastro = cadastroService.buscarPorCpf(cpf);
        
        if (cadastro == null)
            throw new Exception("Cadastro não encontrado.");
        if (!cadastro.getSenha().equals(senha))
            throw new Exception("Senha incorreta.");
        if (!cadastro.getCadastroAprovado())
            verificarStatusCadastro(cadastro);

        return cadastro;
    }

    private void verificarStatusCadastro(CadastroDto cadastro) throws Exception {
        
        LocalDateTime dataVerificacao = cadastro.GetDataVerificacaoCadastro();
        if (dataVerificacao != null && dataVerificacao.isBefore(LocalDateTime.now())) {
            throw new Exception("Seu cadastro está em análise. Por favor, retorne após 24 horas para verificar se foi aprovado.");
        } else {
            throw new Exception("Seu cadastro está em análise. Por favor, aguarde a aprovação.");
        }
    }
}
