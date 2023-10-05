package day8;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetUser {


    @Test
    void testGetUser(ITestContext context){


        int id = (int) context.getAttribute("userId");
        String bearerToken = "f0d81fb310bab363b581af72da3d1e2528d1265bef816291490811bfabece65d";
        given()
                .header("Authorization","Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();



    }
}
