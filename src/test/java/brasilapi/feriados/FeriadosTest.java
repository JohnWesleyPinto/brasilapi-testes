package brasilapi.feriados;


import brasilapi.base.BaseTeste;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FeriadosTest extends BaseTeste {

    @Test
    @DisplayName("Deve listar feriados nacionais por ano válido")
    public void deveListarFeriadosPorAnoValido() {
        given()
                .when()
                .get("/api/feriados/v1/2024")
                .then()
                .statusCode(200)
                .body("$", not(empty()))
                .body("[0].date", startsWith("2024"))
                .body("[0].name", notNullValue())
                .body("[0].type", notNullValue());
    }

    @Test
    @DisplayName("Deve retornar erro para ano inválido")
    public void deveRetornarErroParaAnoInvalido() {
        given()
                .when()
                .get("/api/feriados/v1/AAAA")
                .then()
                .statusCode(anyOf(is(400), is(404), is(500)));
    }
}