# Roteiro de apresentacao

## Slide 1 - Abertura

Hoje vou apresentar o sistema de agendamentos desenvolvido em Java com Spring Boot.
O projeto foi atualizado para uma versao mais organizada, funcional e pronta para demonstracao.

## Slide 2 - Problema e objetivo

O projeto inicial tinha a base do sistema, mas ainda precisava de melhorias visuais e estruturais.
O objetivo foi transformar essa base em uma aplicacao completa, facil de executar e simples de explicar.

## Slide 3 - Arquitetura

O sistema foi dividido em camadas.
O controller recebe as requisicoes, o service aplica as regras de negocio, o repository acessa o banco e a entity representa os dados.
Ja a parte static entrega a interface visual ao usuario.

## Slide 4 - Fluxo

O usuario entra no sistema, preenche o formulario e envia os dados.
Essas informacoes chegam ao backend, sao validadas e salvas no banco H2.
Depois disso, a agenda do dia e atualizada automaticamente na tela.

## Slide 5 - Melhorias

Foram feitas melhorias importantes no projeto.
Entre elas estao a organizacao do codigo, validacoes obrigatorias, bloqueio de conflito de horario e mensagens de erro mais claras.

## Slide 6 - Tecnologias

Foram utilizadas tecnologias modernas e leves:
Java 17, Spring Boot, Spring Web, Spring Data JPA, Bean Validation, H2, HTML, CSS, JavaScript e Maven.

## Slide 7 - Execucao

Para executar, basta abrir a pasta no IntelliJ, esperar o Maven carregar as dependencias, rodar a classe principal e acessar localhost na porta 8080.

## Slide 8 - Demonstracao

Na demonstracao, o ideal e mostrar a tela inicial, criar um agendamento, atualizar a agenda e depois tentar cadastrar um horario repetido para mostrar a validacao funcionando.

## Slide 9 - Encerramento

Como resultado final, o sistema ficou mais profissional, organizado e pronto para apresentacao academica ou tecnica.
