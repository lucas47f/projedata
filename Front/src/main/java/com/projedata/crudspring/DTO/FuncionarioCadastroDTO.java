package com.projedata.crudspring.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.projedata.crudspring.model.Funcionario;
import com.projedata.crudspring.model.Pessoa;
import lombok.Data;

@Data
public class FuncionarioCadastroDTO {
    private String funcao;
    private BigDecimal salario;
    private String nome;
    private LocalDate dataNascimento;
    private Pessoa pessoa;
    private List<Funcionario> funcionarios;
    private int idade;
      private int salariosRecebidos;
}
