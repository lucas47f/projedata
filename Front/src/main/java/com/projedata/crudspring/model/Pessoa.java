package com.projedata.crudspring.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq_generator")
    @SequenceGenerator(name = "pessoa_seq_generator", sequenceName = "pessoa_seq", allocationSize = 1)
    @Column(name = "id_pessoa")
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "idade")
    private int idade;

}
