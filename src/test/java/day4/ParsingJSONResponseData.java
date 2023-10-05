package day4;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.SimpleFormatter;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ParsingJSONResponseData {

    @Test(priority = 1)
    void testJsonResponse(){
        given()
                .contentType("ContentType.JSON")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .log().body()
                .body("data[2].email", equalTo("tobias.funke@reqres.in"));

    }

    @Test(priority = 2)
    void testJsonResponse2(){
        Response response = given()
                .contentType("ContentType.JSON")
                .when()
                .get("https://reqres.in/api/users?page=2");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String email = response.jsonPath().get("data[2].email").toString();
        Assert.assertEquals(email, "tobias.funke@reqres.in");
    }

    @Test(priority = 3)
    void testJsonResponseBodyData(){
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");

        JSONObject jsonObject = new JSONObject(response.asString());
        boolean status = false;
        for (int i = 0 ; i<jsonObject.getJSONArray("data").length(); i++){
            String firstName = jsonObject.getJSONArray("data").getJSONObject(i).get("first_name").toString();
            if (firstName.equals("Mi7chael")){
                status = true;
                break;
            }
        }
        Assert.assertTrue(status);
    }
}
