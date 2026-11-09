# Avança Tech — Sistema de Agendamentos em Java

Projeto acadêmico para registrar atendimentos por profissional e consultar a agenda. A interface web e a API REST são servidas pela mesma aplicação Spring Boot.

## Funcionalidades

- Criar, editar e excluir agendamentos e consultar a agenda por dia.
- Consultar todos os registros pela API.
- Validar campos obrigatórios, telefone e data futura. O serviço verifica se já existe agendamento para o mesmo profissional na data e hora escolhidas.

## Tecnologias e estrutura

- **Java 17, Spring Boot 3.2.5, Spring Data JPA, Bean Validation, H2 e Maven.**
- [Agendamentos/](Agendamentos/) contém o módulo Maven, a API, a interface em HTML, CSS e JavaScript e os testes.
- [Apresentação](Agendamentos/Apresentacao/) reúne os slides e o roteiro do projeto.

## Como executar

No PowerShell, com o JDK 17, a partir da raiz:

```powershell
Set-Location Agendamentos
.\mvnw.cmd spring-boot:run
```

Abra [http://localhost:8080/](http://localhost:8080/). O [README do módulo](Agendamentos/README.md) detalha as rotas, a configuração do H2 e como executar os testes.

## Status e aprendizados

Protótipo acadêmico com persistência em memória. Os agendamentos são descartados ao encerrar a aplicação. O projeto exercita validação de dados, regras de negócio e integração da interface com uma API REST.
