package it.csi.sigit;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testStatusEndpoint() {
        given()
          .when().get("/combustypwabff/restfacade/be/status")
          .then()
             .statusCode(200)
             .body(is("ok"));
    }

}