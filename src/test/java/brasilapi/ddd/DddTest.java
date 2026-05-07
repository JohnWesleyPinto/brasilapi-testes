package brasilapi.ddd;

import brasilapi.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static brasilapi.config.Endpoints.DDD_V1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DddTest extends BaseTest {

    @Test
    @DisplayName("Deve consultar cidades por DDD válido")
    public void deveConsultarDddValido() {
        given()
                .pathParam("ddd","83")
                .when()
                .get(DDD_V1)
                .then()
                .statusCode(200)
                .body("state", equalTo("PB"))
                .body("cities", not(empty()));
    }

    @Test
    @DisplayName("Deve retornar erro para DDD inválido")
    public void deveRetornarErroParaDddInvalido() {
        given()
                .pathParam("ddd","00")
                .when()
                .get(DDD_V1)
                .then()
                .statusCode(anyOf(is(400), is(404)));
    }
}