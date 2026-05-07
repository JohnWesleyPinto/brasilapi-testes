package brasilapi.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String BASE_URI = "https://brasilapi.com.br";

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
