package com.projedata.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projedata.crudspring.model.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
