package com.redemob.cadastro.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CadastroDto {

    private Long id;

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String cpf;

    private String nomeMae;

    private String fotoRosto;

    private String fotoDocumento;

    private String fotoComprovante;

    private String senha;

	private LocalDateTime dataCadastro;

	private Boolean cadastroAprovado;

	private LocalDateTime dataVerificacaoCadastro;

    public CadastroDto(){}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getFotoRosto() {
		return this.fotoRosto;
	}

	public void setFotoRosto(String fotoRosto) {
		this.fotoRosto = fotoRosto;
	}

	public String getFotoDocumento() {
		return this.fotoDocumento;
	}

	public void setFotoDocumento(String fotoDocumento) {
		this.fotoDocumento = fotoDocumento;
	}

	public String getFotoComprovante() {
		return this.fotoComprovante;
	}

	public void setFotoComprovante(String fotoComprovante) {
		this.fotoComprovante = fotoComprovante;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDateTime getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getCadastroAprovado() {
		return this.cadastroAprovado;
	}

	public void setCadastroAprovado(Boolean cadastroAprovado) {
		this.cadastroAprovado = cadastroAprovado;
	}

	public void setDataVerificacaoCadastro(LocalDateTime dataVerificaoCadastro) {
		this.dataVerificacaoCadastro = dataVerificaoCadastro;
	}

	public LocalDateTime GetDataVerificacaoCadastro() {
		return this.dataVerificacaoCadastro;
	}
	
    @Override
    public String toString() {
        return "Cadastro{" +
			"	id						=" + id +
			", 	nomeCompleto			='" + nomeCompleto + '\'' +
			", 	dataNascimento			=" + dataNascimento +
			", 	cpf						='" + cpf + '\'' +
			", 	nomeMae					='" + nomeMae + '\'' +
			", 	fotoRosto				='" + fotoRosto + '\'' +
			", 	fotoDocumento			='" + fotoDocumento + '\'' +
			", 	fotoComprovante			='" + fotoComprovante + '\'' +
			", 	senha					='" + senha + '\'' +
			", 	dataCadastro		 	='" + dataCadastro + '\'' +
			", 	cadastroAprovado		='" + cadastroAprovado + '\'' +
			", 	dataVerificacaoCadastro	='" + dataVerificacaoCadastro + '\'' +
			'}';
    }
    
}
