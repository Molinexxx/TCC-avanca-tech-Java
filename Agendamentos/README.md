# Módulo Agendamentos

Aplicação Spring Boot com API REST, interface web e H2 em memória. A interface reúne o formulário de cadastro e a agenda do dia.

## Como executar

Com o JDK 17, abra esta pasta no IntelliJ IDEA como projeto Maven e execute a classe [AgendadorHorariosApplication](src/main/java/com/ProjectMolina/agendador_horarios/AgendadorHorariosApplication.java). No PowerShell, dentro de `Agendamentos/`, o comando equivalente é:

```powershell
.\mvnw.cmd spring-boot:run
```

Abra [http://localhost:8080/](http://localhost:8080/).

## API de agendamentos

| Método e rota | Operação |
| --- | --- |
| `GET /agendamentos?data=2099-12-30` | Lista os agendamentos de uma data no formato `AAAA-MM-DD`. |
| `GET /agendamentos/todos` | Lista todos os agendamentos. |
| `POST /agendamentos` | Cria um agendamento. |
| `PUT /agendamentos` | Atualiza o agendamento identificado pelos parâmetros `cliente` e `dataHoraAgendamento` originais. |
| `DELETE /agendamentos` | Exclui o agendamento identificado pelos mesmos parâmetros. |

Na criação e na edição, envie um JSON com `servico`, `profissional`, `dataHoraAgendamento`, `cliente` e `telefoneCliente`. A data e hora do corpo devem estar no futuro, no formato `AAAA-MM-DDTHH:mm`. Ao montar a URL de edição ou exclusão, codifique os valores dos parâmetros de consulta.

## Estrutura e banco

- `controller/` recebe as requisições e trata erros da API.
- `services/` aplica as regras de agendamento, incluindo a verificação de horário repetido para o profissional.
- `infrastructure/` contém a entidade e o repositório JPA.
- [src/main/resources/static/](src/main/resources/static/) contém a interface web.

O banco `jdbc:h2:mem:agendamentos-db` dura enquanto a aplicação estiver ativa. Durante o desenvolvimento, o [console H2](http://localhost:8080/h2-console) usa as definições do [application.properties](src/main/resources/application.properties).

## Testes

Execute `.\mvnw.cmd test` no PowerShell. A suíte inclui a inicialização do contexto e um teste de integração que cria um agendamento e consulta a agenda do dia.
