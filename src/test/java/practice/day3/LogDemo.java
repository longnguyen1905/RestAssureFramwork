package practice.day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LogDemo {

    @Test(priority = 1)
    void testLogs(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().body();
    }
}
