describe('BrasilAPI - Testes de API', () => {

    it('Deve consultar CEP válido', () => {
        cy.request({
            method: 'GET',
            url: '/api/cep/v2/01001000'
        }).then((response) => {

            expect(response.status).to.eq(200)

            expect(response.body).to.have.property('cep')
            expect(response.body).to.have.property('state')
            expect(response.body).to.have.property('city')
            expect(response.body).to.have.property('neighborhood')
            expect(response.body).to.have.property('street')

            expect(response.body.cep).to.eq('01001000')
            expect(response.body.state).to.eq('SP')
        })
    })

    it('Deve listar bancos', () => {
        cy.request({
            method: 'GET',
            url: '/api/banks/v1'
        }).then((response) => {

            expect(response.status).to.eq(200)

            expect(response.body).to.be.an('array')
            expect(response.body.length).to.be.greaterThan(0)

            expect(response.body[0]).to.have.property('ispb')
            expect(response.body[0]).to.have.property('name')
            expect(response.body[0]).to.have.property('code')
            expect(response.body[0]).to.have.property('fullName')
        })
    })

    it('Deve consultar feriados', () => {
        cy.request({
            method: 'GET',
            url: '/api/feriados/v1/2024'
        }).then((response) => {

            expect(response.status).to.eq(200)

            expect(response.body).to.be.an('array')
            expect(response.body.length).to.be.greaterThan(0)

            expect(response.body[0]).to.have.property('date')
            expect(response.body[0]).to.have.property('name')
            expect(response.body[0]).to.have.property('type')
        })
    })

    it('Deve consultar DDD válido', () => {
        cy.request({
            method: 'GET',
            url: '/api/ddd/v1/11'
        }).then((response) => {

            expect(response.status).to.eq(200)

            expect(response.body).to.have.property('state')
            expect(response.body).to.have.property('cities')

            expect(response.body.cities).to.be.an('array')
            expect(response.body.cities.length).to.be.greaterThan(0)
        })
    })
    it('Deve retornar erro para CEP inválido', () => {
        cy.request({
            method: 'GET',
            url: '/api/cep/v2/ABCDE123',
            failOnStatusCode: false
        }).then((response) => {

            expect(response.status).to.be.oneOf([400, 404, 500])
        })
    })

    it('Deve retornar erro para DDD inválido', () => {
        cy.request({
            method: 'GET',
            url: '/api/ddd/v1/00',
            failOnStatusCode: false
        }).then((response) => {

            expect(response.status).to.be.oneOf([400, 404])
        })
    })

})