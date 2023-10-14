package practice.day8;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class UpdateUser {

    @Test
    void testUpdateUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name", faker.name().fullName());
        data.put("gender", "Male");
        data.put("email", faker.internet().emailAddress());
        data.put("status", "inactive");

        String bearerToken = "f0d81fb310bab363b581af72da3d1e2528d1265bef816291490811bfabece65d";

        int id = (int) context.getAttribute("userId");
        given()
                .header("Authorization","Bearer " + bearerToken)
                .contentType("application/json")
                .pathParam("id", id)
                .body(data.toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/{id}")
                .then().statusCode(200).log().all();

        System.out.println("General id is: " + id);

    }
}
