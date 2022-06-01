package yontaku.rest;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MinserRankingResourceTest {
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/minderranking")
          .then()
             .statusCode(200);
            //  .body(is("hello"));
    }
}
