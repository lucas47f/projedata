package com.projedata.crudspring.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq_generator")
    @SequenceGenerator(name = "funcionario_seq_generator", sequenceName = "funcionario_seq", allocationSize = 1)
    @Column(name = "id_funcionario")
    @JsonProperty("_id")
    private Long id;
    
    @Column(length = 50, nullable = false, name = "funcao")
    private String funcao;

    @Column(length = 100, nullable = false, name ="salario")
    private BigDecimal salario;

    @Column(name ="salarios_recebidos")
    private int salariosRecebidos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

}
