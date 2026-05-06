# Requisitos Funcionais — BrasilAPI Quality Validation

## RF01 — Consultar endereço por CEP válido

Como usuário da API, quero consultar um CEP válido para obter dados de endereço.

### Endpoint
GET /api/cep/v2/{cep}

### Exemplo
GET /api/cep/v2/01001000

### Critérios de aceite
- Deve retornar status code 200
- Deve retornar um JSON válido
- Deve conter os campos:
    - cep
    - state
    - city
    - neighborhood
    - street
- O campo cep deve corresponder ao CEP pesquisado

### Cenário positivo
Dado que eu possuo um CEP válido  
Quando eu consultar o endpoint de CEP  
Então a API deve retornar os dados do endereço

### Cenário negativo
Dado que eu possuo um CEP inválido  
Quando eu consultar o endpoint de CEP  
Então a API deve retornar uma mensagem de erro

## RF02 — Listar bancos disponíveis

Como usuário da API, quero listar bancos brasileiros disponíveis.

### Endpoint
GET /api/banks/v1

### Critérios de aceite
- Deve retornar status code 200
- Deve retornar uma lista JSON
- A lista não deve estar vazia
- Cada banco deve conter:
    - ispb
    - name
    - code
    - fullName

### Cenário positivo
Dado que a API está disponível  
Quando eu consultar a lista de bancos  
Então a API deve retornar bancos cadastrados

## RF03 — Consultar feriados nacionais por ano

Como usuário da API, quero consultar os feriados nacionais de um ano específico.

### Endpoint
GET /api/feriados/v1/{ano}

### Exemplo
GET /api/feriados/v1/2024

### Critérios de aceite
- Deve retornar status code 200
- Deve retornar uma lista JSON
- Cada item deve conter:
    - date
    - name
    - type
- As datas retornadas devem pertencer ao ano informado

### Cenário positivo
Dado que eu informo um ano válido  
Quando eu consultar os feriados  
Então a API deve retornar os feriados nacionais daquele ano

## RF04 — Consultar cidades por DDD

Como usuário da API, quero consultar as cidades relacionadas a um DDD.

### Endpoint
GET /api/ddd/v1/{ddd}

### Exemplo
GET /api/ddd/v1/11

### Critérios de aceite
- Deve retornar status code 200
- Deve conter o campo state
- Deve conter o campo cities
- A lista de cidades não deve estar vazia

### Cenário positivo
Dado que eu informo um DDD válido  
Quando eu consultar o endpoint de DDD  
Então a API deve retornar o estado e suas cidades

### Cenário negativo
Dado que eu informo um DDD inválido  
Quando eu consultar o endpoint de DDD  
Então a API deve retornar erro