package brasilapi.cep;

import brasilapi.base.BaseTeste;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static brasilapi.config.Endpoints.CEP_V2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class CepTest extends BaseTeste {
    @Test
    @DisplayName("Deve consultar endereço ao informar CEP válido")
    public void deveConsultarCepValido() {
        given()
                .pathParam("cep", "01001000")
                .when()
                .get(CEP_V2)
                .then()
                .statusCode(200)
                .body("cep", equalTo("01001000"))
                .body("state", equalTo("SP"))
                .body("city", notNullValue())
                .body("neighborhood", notNullValue())
                .body("street", notNullValue());
    }

    @Test
    @DisplayName("Deve retornar erro ao informar CEP com letras")
    public void deveRetornarErroParaCepComLetras() {
        given()
                .when()
                .get("/api/cep/v2/ABCDE123")
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }

    @Test
    @DisplayName("Deve retornar erro ao informar CEP incompleto")
    public void deveRetornarErroParaCepIncompleto() {
        given()
                .pathParam("cep","ABCDE123")
                .when()
                .get(CEP_V2)
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }
}
