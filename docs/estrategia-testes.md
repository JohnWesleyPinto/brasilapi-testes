### Estratégias de Testes

1. **Testes Manuais**: Realizados no Postman para explorar os endpoints da API.
2. **Testes Automatizados**:
    - **RestAssured**: Para testar a API com Java, validando status code, estrutura de dados e contratos JSON.
    - **Cypress**: Para testes complementares de API, automatizando o processo de validação.
3. **Testes de Regressão**: Garantir que novas funcionalidades não quebrem as funcionalidades existentes.
4. **Testes de Integração**: Validar a integração entre o sistema de geração de relatórios Allure e o upload para o S3.
5. **Testes Parametrizados**: Usados para aumentar a cobertura de teste de diferentes entradas de dados.