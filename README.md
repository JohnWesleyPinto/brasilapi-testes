![Automated Tests](https://github.com/JohnWesleyPinto/brasilapi-testes/actions/workflows/tests.yml/badge.svg)
# BrasilAPI testes

Projeto de validação de qualidade da BrasilAPI, com foco em testes manuais e automatizados de APIs REST.

## Objetivo

Validar endpoints públicos da BrasilAPI aplicando boas práticas de QA, incluindo:

- análise de requisitos
- criação de casos de teste
- testes manuais com Postman
- automação de testes com Java, JUnit e RestAssured
- automação de testes de API com Cypress
- validação de status code
- validação de contrato JSON
- validação de cenários positivos e negativos

## Sistema sob teste

BrasilAPI  
https://brasilapi.com.br

## Endpoints testados

| Módulo | Endpoint | Objetivo |
|---|---|---|
| CEP | `/api/cep/v2/{cep}` | Consultar endereço por CEP |
| Bancos | `/api/banks/v1` | Listar bancos brasileiros |
| Feriados | `/api/feriados/v1/{ano}` | Consultar feriados nacionais |
| DDD | `/api/ddd/v1/{ddd}` | Consultar cidades por DDD |

## Tecnologias utilizadas

- Java 17
- Maven
- JUnit 5
- RestAssured
- Cypress
- Postman

## Estrutura do projeto

```text
brasilapi-quality-validation/
│
├── docs/
│   ├── requisitos.md
│   └── casos-teste-manuais.md
│
├── postman/
│   ├── BrasilAPI.postman_collection.json
│   └── BrasilAPI.postman_environment.json
│
├── src/test/java/
│   └── br/com/brasilapi/
│       ├── base/
│       ├── config/
│       ├── cep/
│       ├── bancos/
│       ├── feriados/
│       └── ddd/
│
├── cypress/
│   ├── e2e/
│   │   └── brasilapi.cy.js
│   └── support/
│
├── pom.xml
├── package.json
├── cypress.config.js
└── README.md
```
## Estratégia de testes

Os testes foram organizados em três camadas:

### Testes manuais

Executados no Postman para:
- exploração da API
- validação inicial dos endpoints
- conferência dos retornos

### Testes automatizados com RestAssured

Usados para validar endpoints REST com Java, verificando:
- status code
- campos obrigatórios
- estrutura JSON
- cenários de erro

### Testes automatizados com Cypress

Usados como validação complementar de API com JavaScript, demonstrando:
- flexibilidade em diferentes ferramentas
- validações REST
- execução via interface e terminal

---

## Cenários cobertos

- Consulta de CEP válido
- Consulta de CEP inválido
- Listagem de bancos
- Consulta de feriados por ano
- Consulta de DDD válido
- Consulta de DDD inválido
- Validação de campos obrigatórios
- Validação de listas não vazias
- Validação de status code
- Validação de estrutura JSON

---

## Boas práticas aplicadas

- Separação por domínio da API
- Reutilização de configuração base
- Centralização de endpoints
- Nomes de testes descritivos
- Uso de critérios de aceite
- Rastreabilidade entre requisitos e casos de teste
- Cenários positivos e negativos
- Logs automáticos em falhas no RestAssured

---

## Melhorias futuras


- Adicionar testes parametrizados
- Adicionar validação de schema JSON
- Aumentar cobertura de endpoints
- Executar regressão automática