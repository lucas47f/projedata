package com.projedata.crudspring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projedata.crudspring.DTO.FuncionarioCadastroDTO;
import com.projedata.crudspring.model.Funcionario;
import com.projedata.crudspring.repository.FuncionarioRepository;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

     public void excluir(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            //futuro tratamento
        }
        funcionarioRepository.deleteById(id);
    }

     public void aumentarSalarioEm10Porcento() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        for (Funcionario funcionario : funcionarios) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(new BigDecimal("0.10")); // Aumenta em 10%
            BigDecimal novoSalario = salarioAtual.add(aumento);
            funcionario.setSalario(novoSalario);
            funcionarioRepository.save(funcionario);
        }
    }

    public List<Funcionario> listarFuncionariosAgrupadosPorFuncao() {
        return funcionarioRepository.listarFuncionariosAgrupadosPorFuncao();
    }

    public List<Funcionario> listarFuncionariosAgrupadosPorMes() {
        return funcionarioRepository.listarFuncionariosMesOutubroDezembro();
    }

    public List<Funcionario> listarFuncionariosAgrupadosPorOrdemAlfabetica() {
        return funcionarioRepository.listarFuncionariosOrdemAlfabetica();
    }

    public List<Funcionario> listarFuncionariosAgrupadosPorIdade() {
        return funcionarioRepository.listarFuncionariosPorIdade();
    }

    public Double somaSalarios() {
        return funcionarioRepository.somaSalarios(); 
    }

    public List<Object[]> calcularSalariosMinimos() {
        return funcionarioRepository.calcularSalariosMinimos();
    }
}
