const { defineConfig } = require("cypress");

module.exports = defineConfig({
    e2e: {
        baseUrl: "https://brasilapi.com.br",
        specPattern: "cypress/e2e/**/*.cy.js",
    }
});