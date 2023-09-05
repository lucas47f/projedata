package com.projedata.crudspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projedata.crudspring.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    
    @Query("FROM Funcionario f JOIN FETCH f.pessoa")
    List<Funcionario> findAllWithPessoa();
    
    @Query("SELECT f FROM Funcionario f ORDER BY f.funcao")
    List<Funcionario> listarFuncionariosAgrupadosPorFuncao();

    @Query("SELECT f FROM Funcionario f JOIN f.pessoa p WHERE MONTH(p.dataNascimento) IN (10, 12) ORDER BY p.dataNascimento")
    List<Funcionario> listarFuncionariosMesOutubroDezembro();

    @Query("SELECT f FROM Funcionario f JOIN f.pessoa p  ORDER BY p.nome ASC")
    List<Funcionario> listarFuncionariosOrdemAlfabetica();

    @Query("SELECT f, (CURRENT_DATE - p.dataNascimento) AS idade FROM Funcionario f JOIN f.pessoa p ORDER BY idade DESC")
    List<Funcionario> listarFuncionariosPorIdade();

    @Query("SELECT SUM(salario) FROM Funcionario f ")
    Double somaSalarios();

    @Query("SELECT f, f.salario / 1212.00 AS salariosMinimos FROM Funcionario f")
    List<Object[]> calcularSalariosMinimos();

}
