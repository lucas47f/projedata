# Sistema de Gerenciamento de Funcionários

Este projeto é um sistema simples de gerenciamento de funcionários desenvolvido em Java utilizando Spring Boot. Ele permite a inserção, remoção e listagem de funcionários, além de várias operações adicionais como aumento de salário, agrupamento por função e cálculo de total de salários.

## Funcionalidades

1. Inserir novos funcionários.
2. Remover um funcionário pelo nome.
3. Listar todos os funcionários com detalhes formatados.
4. Aplicar um aumento de 10% no salário de todos os funcionários.
5. Agrupar os funcionários por função.
6. Listar funcionários que fazem aniversário nos meses de outubro e dezembro.
7. Identificar o funcionário com a maior idade.
8. Listar funcionários em ordem alfabética.
9. Calcular o total dos salários dos funcionários.
10. Calcular quantos salários mínimos cada funcionário recebe.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento do backend.
- **Spring Boot**: Framework para simplificação da configuração e inicialização da aplicação.
- **Spring Data JPA**: Framework para persistência de dados com JPA (Java Persistence API).
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento e testes.
- **Maven**: Gerenciador de dependências e automação de build.
- **Lombok**: Biblioteca para reduzir o código boilerplate, como getters, setters e construtores.
- **Swagger**: Documentação interativa da API.

## Estrutura do Projeto

src
└── main
├── java
│ └── com
│ └── suaempresa
│ └── seuprojeto
│ ├── controller
│ │ └── FuncionarioController.java
│ ├── service
│ │ └── FuncionarioService.java
│ ├── model
│ │ └── Funcionario.java
│ ├── repository
│ │ └── FuncionarioRepository.java
│ └── dto
│ └── FuncionarioResponse.java
└── resources
├── application.properties
└── data.sql


## Instalação e Execução

### Pré-requisitos

- Java 11 ou superior
- Maven

### Passos para Execução

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seuusuario/seurepositorio.git
   cd seurepositorio
   mvn clean install
   mvn spring-boot:run
```
## Contato
Para mais informações, entre em contato com lucas47freitas@gmail.com
