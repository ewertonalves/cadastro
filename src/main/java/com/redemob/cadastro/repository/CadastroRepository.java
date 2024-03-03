package com.redemob.cadastro.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.redemob.cadastro.model.Cadastro;

@Repository
public interface CadastroRepository extends CrudRepository<Cadastro, Long >{

    Boolean         existsByCpf(String cpf);
    String          findByCpf(String cpf);
    List<Cadastro>  findByNomeCompleto(String nome);
    Page<Cadastro>  findAll(Pageable pageable);
}
