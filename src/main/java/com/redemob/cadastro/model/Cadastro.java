package com.redemob.cadastro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cache.annotation.Cacheable;

import com.redemob.cadastro.model.dto.CadastroDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_CADASTRO")
@Cacheable(cacheNames = "cadastroUsuario")
public class Cadastro implements Serializable{

	public static String CACHE_NAME = "usuario";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CADASTRO_ID")
    private Long id;

    @Column(name = "CADASTRO_NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "CADASTRO_DT_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CADASTRO_CPF")
    private String cpf;

    @Column(name = "CADASTRO_NOME_MAE")
    private String nomeMae;

    @Column(name = "CADASTRO_FOTO_ROSTO")
    private byte[] fotoRosto;

    @Column(name = "CADASTRO_FOTO_DOCUMENTO")
    private byte[] fotoDocumento;

    @Column(name = "CADASTRO_FOTO_COMPROVATE")
    private byte[] fotoComprovante;

    @Column(name = "CADASTRO_SENHA")
    private String senha;

	@Column(name = "CADASTRO_DT_CADASTRO")
    private LocalDateTime dataCadastro;

	@Column(name = "CADASTRO_APROVADO")
	private Boolean cadastroAprovado;
	
	@Column(name = "CADASTRO_DT_VERIFICACAO_CADASTRO")
	private LocalDateTime dataVerificacaoCadastro;

    public Cadastro(CadastroDto cadastroDto){
		this.id							= cadastroDto.getId();
		this.nomeCompleto				= cadastroDto.getNomeCompleto();
		this.dataNascimento				= cadastroDto.getDataNascimento();
		this.cpf						= cadastroDto.getCpf();
		this.nomeMae					= cadastroDto.getNomeMae();
		this.fotoRosto					= cadastroDto.getFotoRosto();
		this.fotoDocumento				= cadastroDto.getFotoDocumento();
		this.fotoComprovante			= cadastroDto.getFotoComprovante();
		this.senha						= cadastroDto.getSenha();
		this.dataCadastro				= cadastroDto.getDataCadastro();
		this.cadastroAprovado			= cadastroDto.getCadastroAprovado();
		this.dataVerificacaoCadastro	= cadastroDto.GetDataVerificacaoCadastro();
	}

	public Cadastro(){}

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

	public byte[] getFotoRosto() {
		return this.fotoRosto;
	}

	public void setFotoRosto(byte[] fotoRosto) {
		this.fotoRosto = fotoRosto;
	}

	public byte[] getFotoDocumento() {
		return this.fotoDocumento;
	}

	public void setFotoDocumento(byte[] fotoDocumento) {
		this.fotoDocumento = fotoDocumento;
	}

	public byte[] getFotoComprovante() {
		return this.fotoComprovante;
	}

	public void setFotoComprovante(byte[] fotoComprovante) {
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
			", 	dataCadastro			='" + dataCadastro + '\'' +
			", 	cadastroAprovado		='" + cadastroAprovado + '\'' +
			", 	dataVerificacaoCadastro	='" + dataVerificacaoCadastro + '\'' +
			'}';
    }
}
