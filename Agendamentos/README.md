# Sistema de Agendamentos com Spring Boot

Projeto recriado e atualizado em Java com Spring Boot, interface HTML moderna e banco H2 em memoria.

## O que foi melhorado

- organizacao da API de agendamentos
- validacao dos campos obrigatorios
- verificacao de conflito de horario por profissional
- pagina inicial com formulario e agenda do dia
- tratamento de erros para exibir mensagens amigaveis
- configuracao simples para abrir e executar no IntelliJ

## Como abrir no IntelliJ

1. Abra a pasta `Agendamentos` como projeto Maven.
2. Aguarde o IntelliJ importar as dependencias do `pom.xml`.
3. Execute a classe [`AgendadorHorariosApplication.java`](C:\Users\Administrator\Desktop\TCC-avanca tech-Java\Agendamentos\src\main\java\com\ProjectMolina\agendador_horarios\AgendadorHorariosApplication.java).
4. Abra o navegador em [http://localhost:8080](http://localhost:8080).

## Estrutura principal

- `src/main/java/.../controller`: endpoints REST e tratamento de erros
- `src/main/java/.../services`: regras de negocio
- `src/main/java/.../infrastructure/entity`: entidade JPA
- `src/main/java/.../infrastructure/repository`: acesso ao banco
- `src/main/resources/static`: HTML, CSS e JavaScript da interface

## Endpoints

- `GET /agendamentos?data=2026-03-30`
- `GET /agendamentos/todos`
- `POST /agendamentos`
- `PUT /agendamentos?cliente=...&dataHoraAgendamento=...`
- `DELETE /agendamentos?cliente=...&dataHoraAgendamento=...`

## Banco H2

- console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:agendamentos-db`
- usuario: `sa`
- senha: em branco
