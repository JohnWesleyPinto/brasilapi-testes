# Casos de Teste Manuais — BrasilAPI Quality Validation

# Objetivo

Validar os endpoints públicos da BrasilAPI garantindo:
- funcionamento correto da API
- integridade dos dados
- tratamento de erros
- estabilidade das respostas

---

# Endpoint — CEP

## CT001 — Consultar CEP válido

### Requisito relacionado
RF01

### Prioridade
Alta

### Tipo de teste
Positivo

### Endpoint
GET /api/cep/v2/{cep}

### Massa de teste
01001000

### Passos
1. Abrir o Insomnia
2. Realizar requisição GET:
   /api/cep/v2/01001000
3. Enviar requisição

### Resultado esperado
- Status code 200
- Retornar JSON válido
- Retornar:
    - cep
    - state
    - city
    - neighborhood
    - street
- CEP retornado deve ser igual ao pesquisado

---

## CT002 — Consultar CEP inválido

### Requisito relacionado
RF02

### Prioridade
Alta

### Tipo de teste
Negativo

### Massa de teste
99999999

### Passos
1. Realizar GET:
   /api/cep/v2/99999999
2. Enviar requisição

### Resultado esperado
- Retornar erro
- Não retornar endereço válido
- Retornar status 404 ou equivalente

---

## CT003 — Consultar CEP com formato inválido

### Requisito relacionado
RF02

### Prioridade
Alta

### Tipo de teste
Negativo

### Massa de teste
ABCDE123

### Passos
1. Realizar GET:
   /api/cep/v2/ABCDE123
2. Enviar requisição

### Resultado esperado
- API deve rejeitar requisição
- Retornar status de erro
- Retornar mensagem informativa

---

# Endpoint — Bancos

## CT004 — Listar bancos

### Requisito relacionado
RF03

### Prioridade
Média

### Tipo de teste
Positivo

### Endpoint
GET /api/banks/v1

### Passos
1. Realizar GET:
   /api/banks/v1
2. Enviar requisição

### Resultado esperado
- Status code 200
- Retornar lista JSON
- Lista não deve estar vazia
- Cada item deve possuir:
    - ispb
    - name
    - code
    - fullName

---

## CT005 — Validar estrutura do JSON de bancos

### Requisito relacionado
RF03

### Prioridade
Média

### Tipo de teste
Validação estrutural

### Passos
1. Executar endpoint de bancos
2. Validar estrutura da resposta

### Resultado esperado
- Todos os objetos devem possuir o mesmo padrão estrutural
- Campos obrigatórios não devem ser nulos

---

# Endpoint — Feriados

## CT006 — Consultar feriados por ano válido

### Requisito relacionado
RF04

### Prioridade
Média

### Tipo de teste
Positivo

### Massa de teste
2024

### Endpoint
GET /api/feriados/v1/2024

### Passos
1. Realizar GET:
   /api/feriados/v1/2024
2. Enviar requisição

### Resultado esperado
- Status code 200
- Retornar lista de feriados
- Cada item deve conter:
    - date
    - name
    - type

---

## CT007 — Consultar feriados com ano inválido

### Requisito relacionado
RF04

### Prioridade
Baixa

### Tipo de teste
Negativo

### Massa de teste
AAAA

### Passos
1. Realizar GET:
   /api/feriados/v1/AAAA
2. Enviar requisição

### Resultado esperado
- API deve retornar erro
- Não deve retornar lista válida

---

# Endpoint — DDD

## CT008 — Consultar DDD válido

### Requisito relacionado
RF05

### Prioridade
Alta

### Tipo de teste
Positivo

### Massa de teste
11

### Endpoint
GET /api/ddd/v1/11

### Passos
1. Realizar GET:
   /api/ddd/v1/11
2. Enviar requisição

### Resultado esperado
- Status code 200
- Retornar:
    - state
    - cities
- Lista de cidades não deve estar vazia

---

## CT009 — Consultar DDD inexistente

### Requisito relacionado
RF05

### Prioridade
Alta

### Tipo de teste
Negativo

### Massa de teste
00

### Passos
1. Realizar GET:
   /api/ddd/v1/00
2. Enviar requisição

### Resultado esperado
- API deve retornar erro
- Não deve retornar cidades válidas

---

# Estratégia de Priorização

## Alta prioridade
- Validação de CEP
- Validação de DDD
- Cenários negativos principais

## Média prioridade
- Estrutura JSON
- Listagem de bancos
- Consulta de feriados

## Baixa prioridade
- Validações de formato menos críticas

---

# Tipos de validação aplicados

- Status code
- Estrutura JSON
- Campos obrigatórios
- Integridade dos dados
- Cenários positivos
- Cenários negativos
- Tratamento de erro