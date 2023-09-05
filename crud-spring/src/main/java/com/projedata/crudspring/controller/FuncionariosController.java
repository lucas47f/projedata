package com.projedata.crudspring.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projedata.crudspring.DTO.FuncionarioCadastroDTO;
import com.projedata.crudspring.model.Funcionario;
import com.projedata.crudspring.model.Pessoa;
import com.projedata.crudspring.repository.FuncionarioRepository;
import com.projedata.crudspring.repository.PessoaRepository;
import com.projedata.crudspring.service.FuncionarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/funcionarios")
@AllArgsConstructor
public class FuncionariosController {

    private final FuncionarioRepository funcionarioRepository;

    private PessoaRepository pessoaRepository;

    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findbyid(@PathVariable Long id){
        return funcionarioRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluir(id);
    }

    /**
     * @param funcionarioDTO
     * @return
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Funcionario cadastro(@RequestBody FuncionarioCadastroDTO funcionarioDTO) {
        // Criar uma nova Pessoa a partir dos dados do DTO
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(funcionarioDTO.getNome());
        pessoa.setDataNascimento(funcionarioDTO.getDataNascimento());
        LocalDate dataNascimento = funcionarioDTO.getDataNascimento();
        LocalDate hoje = LocalDate.now();
        int idade = Period.between(dataNascimento, hoje).getYears();
        pessoa.setIdade(idade);
        pessoaRepository.save(pessoa);
        funcionarioDTO.setPessoa(pessoa);

        // Criar um novo Funcionario e associá-lo à Pessoa
        Funcionario funcionario = new Funcionario();
        funcionario.setFuncao(funcionarioDTO.getFuncao());
        funcionario.setSalario(funcionarioDTO.getSalario());
        funcionario.setPessoa(funcionarioDTO.getPessoa());

        // Calcular quantos salários mínimos o funcionário ganha e definir o valor na nova coluna
         BigDecimal salarioMinimo = new BigDecimal("1212.00");
         BigDecimal salarioFuncionario = funcionario.getSalario();
         BigDecimal salariosMinimos = salarioFuncionario.divide(salarioMinimo, 2);
         funcionario.setSalariosRecebidos(salariosMinimos.intValue());
        return funcionarioRepository.save(funcionario);
    }

     @PutMapping("/aumentar-salario")
    public ResponseEntity<String> aumentarSalario() {
        try {
            funcionarioService.aumentarSalarioEm10Porcento();
            return ResponseEntity.ok("Salários aumentados com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao aumentar salários: " + e.getMessage());
        }
    }

    @GetMapping("/agruparFuncionariosPorFuncao")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAgrupadosPorFuncao() {
        List<Funcionario> funcionariosAgrupados = funcionarioService.listarFuncionariosAgrupadosPorFuncao();
        return ResponseEntity.ok(funcionariosAgrupados);
    }

    @GetMapping("/agruparFuncionariosPorMes")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAgrupadosPorMes() {
        List<Funcionario> funcionariosAgrupados = funcionarioService.listarFuncionariosAgrupadosPorMes();
        return ResponseEntity.ok(funcionariosAgrupados);
    }

    @GetMapping("/agruparFuncionariosPorOrdemAlfabetica")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAgrupadosPorOrdemAlfabetica() {
        List<Funcionario> funcionariosAgrupados = funcionarioService.listarFuncionariosAgrupadosPorOrdemAlfabetica();
        return ResponseEntity.ok(funcionariosAgrupados);
    }

     @GetMapping("/agruparFuncionariosPorIdade")
    public ResponseEntity<List<Funcionario>> listarFuncionariosAgrupadosPorIdade() {
       List<Funcionario> funcionariosAgrupados = funcionarioService.listarFuncionariosAgrupadosPorIdade();
       return ResponseEntity.ok(funcionariosAgrupados);
    }

    @GetMapping("/salarios")
    public ResponseEntity<Double> getSomaSalarios() {
        Double somaSalarios = funcionarioService.somaSalarios();
        return ResponseEntity.ok(somaSalarios);
    }

    @GetMapping("/calcular-salarios-minimos")
    public List<Object[]> calcularSalariosMinimos() {
        return funcionarioService.calcularSalariosMinimos();
    }



}
