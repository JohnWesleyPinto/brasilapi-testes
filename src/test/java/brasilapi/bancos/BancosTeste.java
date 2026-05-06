package brasilapi.bancos;

import brasilapi.base.BaseTeste;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static brasilapi.config.Endpoints.BANKS_V1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BancosTeste extends BaseTeste {

    @Test
    @DisplayName("Deve listar bancos brasileiros")
    public void deveListarBancos() {
        given()
                .when()
                .get(BANKS_V1)
                .then()
                .statusCode(200)
                .body("$", not(empty()))
                .body("[0].ispb", notNullValue())
                .body("[0].name", notNullValue())
                .body("[0].code", notNullValue())
                .body("[0].fullName", notNullValue());
    }
}