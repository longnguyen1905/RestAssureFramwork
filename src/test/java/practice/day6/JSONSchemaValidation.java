package practice.day6;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JSONSchemaValidation {


    @Test
    void jsonSchemaValidation(){
        given()
                .when()
                .get("http://localhost:3000/book")
                .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
    }
}
